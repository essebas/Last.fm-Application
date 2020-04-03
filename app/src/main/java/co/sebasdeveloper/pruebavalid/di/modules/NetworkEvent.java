package co.sebasdeveloper.pruebavalid.di.modules;

import android.os.Handler;
import android.os.Looper;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

public class NetworkEvent {

    private static volatile NetworkEvent sSoleInstance;
    private PublishSubject<NetworkState> subject;
    private Map<Object, CompositeDisposable> compositeDisposableMap = new HashMap<>();

    public NetworkEvent() {
        if(sSoleInstance != null){
            throw new RuntimeException("Usar el metodo getInstance() para obtener la unica istancia de la clase");
        }
    }

    public static NetworkEvent getsSoleInstance() {
        if (sSoleInstance == null) {
            synchronized (NetworkEvent.class) {
                if (sSoleInstance == null) sSoleInstance = new NetworkEvent();
            }
        }
        return sSoleInstance;
    }

    public PublishSubject<NetworkState> getSubject() {
        if (subject == null) {
            subject = PublishSubject.create();
            subject.subscribeOn(AndroidSchedulers.mainThread());
        }
        return subject;
    }

    public void publish(@NonNull NetworkState networkState) {
        new Handler(Looper.getMainLooper())
                .post(() -> getSubject().onNext(networkState));
    }

    public CompositeDisposable getCompositeSubscription(@NonNull Object object) {
        CompositeDisposable compositeDisposable = compositeDisposableMap.get(object);
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
            compositeDisposableMap.put(object, compositeDisposable);
        }
        return compositeDisposable;
    }

    public void register(@NonNull Object lifecycle, @NonNull Consumer<NetworkState> action) {
        Disposable disposable = getSubject().subscribe(action);
        getCompositeSubscription(lifecycle).add(disposable);
    }

    public void unregister(@NonNull Object lifecycle) {
        //We have to remove the composition from the map, because once you unsubscribe it can't be used anymore
        CompositeDisposable compositeSubscription = compositeDisposableMap.remove(lifecycle);
        if (compositeSubscription != null) {
            compositeSubscription.dispose();
        }
    }

}
