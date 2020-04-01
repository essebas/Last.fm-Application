package co.sebasdeveloper.pruebavalid.adapter;


import com.mukesh.countrypicker.Country;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import co.sebasdeveloper.pruebavalid.ui.fragment.TopArtistFragment;
import co.sebasdeveloper.pruebavalid.ui.fragment.TopTraksFragment;
import co.sebasdeveloper.pruebavalid.viewmodel.ArtistViewModel;
import co.sebasdeveloper.pruebavalid.viewmodel.TrackViewModel;
import co.sebasdeveloper.pruebavalid.viewmodel.ViewModelFactory;

public class PageAdapter extends FragmentStateAdapter {

    private ArtistViewModel artistViewModel;
    private TrackViewModel trackViewModel;
    private Country country;

    public PageAdapter(@NonNull FragmentActivity fragmentActivity, ArtistViewModel artistViewModel, TrackViewModel trackViewModel, Country country) {
        super(fragmentActivity);
        this.artistViewModel = artistViewModel;
        this.trackViewModel = trackViewModel;
        this.country = country;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new TopArtistFragment(artistViewModel, country);
            default:
                return new TopTraksFragment(trackViewModel, country);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
