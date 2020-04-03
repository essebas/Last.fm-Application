package co.sebasdeveloper.pruebavalid.di.modules;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import co.sebasdeveloper.pruebavalid.remote.ArtistService;
import co.sebasdeveloper.pruebavalid.remote.TrackService;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public abstract class NetworkModule {

    private static final String BASE_URL = "http://ws.audioscrobbler.com";

    @Provides
    @Singleton
    static Retrofit prRetrofit(){

        Gson gson = new GsonBuilder().setLenient().create();

        OkHttpClient.Builder okHttp = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        //httpClient.addInterceptor(new NetworkInterceptor());
        httpClient.addInterceptor(logging);
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
    }


    @Provides
    @Singleton
    static ArtistService prArtistService(Retrofit retrofit){
        return retrofit.create(ArtistService.class);
    }

    @Provides
    @Singleton
    static TrackService prTrackService(Retrofit retrofit){
        return retrofit.create(TrackService.class);
    }

}
