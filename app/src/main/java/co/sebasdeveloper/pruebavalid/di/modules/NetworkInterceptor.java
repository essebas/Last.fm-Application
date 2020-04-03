package co.sebasdeveloper.pruebavalid.di.modules;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkInterceptor implements Interceptor {

    private Context context;
    private NetworkEvent networkEvent;

    public NetworkInterceptor(Context context) {
        this.context = context;
        this.networkEvent = NetworkEvent.getsSoleInstance();
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        if (!ConnectivityStatus.isConnected(context)) {
            networkEvent.publish(NetworkState.NO_INTERNET);

        }else {
            try {
                /*
                 * Step 3: Get the response code from the
                 * request. In this scenario we are only handling
                 * unauthorised and server unavailable error
                 * scenario
                 * */
                Response response = chain.proceed(request);
                switch (response.code()) {
                    case 401:
                        networkEvent.publish(NetworkState.UNAUTHORISED);
                        break;

                    case 503:
                        networkEvent.publish(NetworkState.NO_RESPONSE);
                        break;
                }
                return response;

            } catch (IOException e) {
                networkEvent.publish(NetworkState.NO_RESPONSE);
            }
        }
        return null;
    }
}
