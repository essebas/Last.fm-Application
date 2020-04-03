package co.sebasdeveloper.pruebavalid.adapter;


import android.util.Log;

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

    private static final String TAG = "PageAdapter";
    private ArtistViewModel artistViewModel;
    private TrackViewModel trackViewModel;
    private Country country;
    private String items;
    private TopArtistFragment topArtistFragment;
    private TopTraksFragment topTraksFragment;

    public PageAdapter(@NonNull FragmentActivity fragmentActivity, ArtistViewModel artistViewModel, TrackViewModel trackViewModel, Country country, String items) {
        super(fragmentActivity);
        this.artistViewModel = artistViewModel;
        this.trackViewModel = trackViewModel;
        this.country = country;
        this.items = items;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return getFragment(position);
    }

    public Fragment getFragment(int position){
        switch (position){
            case 0:
                if(topArtistFragment == null){
                    Log.d(TAG, "Se creo el fragmento Top Artistas desde 0");
                    topArtistFragment = new TopArtistFragment(artistViewModel, country, items);
                }
                Log.d(TAG, "Se envio el fragmento Top Artistas");
                return topArtistFragment;
            default:
                if(topTraksFragment == null){
                    Log.d(TAG, "Se creo el fragmento Top Canciones desde 0");
                    topTraksFragment = new TopTraksFragment(trackViewModel, country, items);
                }
                Log.d(TAG, "Se envio el fragmento Top Canciones");
                return topTraksFragment;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public void setOptions(Country country, String items){
        this.country = country;
        this.items = items;
    }

    public Country getCountry() {
        return country;
    }

    public String getItems() {
        return items;
    }
}
