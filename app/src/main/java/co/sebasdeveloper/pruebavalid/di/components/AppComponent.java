package co.sebasdeveloper.pruebavalid.di.components;

import javax.inject.Singleton;

import co.sebasdeveloper.pruebavalid.MainActivity;
import co.sebasdeveloper.pruebavalid.di.modules.ContextModule;
import co.sebasdeveloper.pruebavalid.di.modules.NetworkModule;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
