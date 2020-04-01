package co.sebasdeveloper.pruebavalid.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import co.sebasdeveloper.pruebavalid.di.ViewModelKey;
import co.sebasdeveloper.pruebavalid.viewmodel.ArtistViewModel;
import co.sebasdeveloper.pruebavalid.viewmodel.TrackViewModel;
import co.sebasdeveloper.pruebavalid.viewmodel.ViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ArtistViewModel.class)
    abstract ViewModel bViewModel(ArtistViewModel artistViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TrackViewModel.class)
    abstract ViewModel bTrackViewModel(TrackViewModel trackViewModel);

    @Binds
    abstract ViewModelProvider.Factory binFactory(ViewModelFactory factory);
}
