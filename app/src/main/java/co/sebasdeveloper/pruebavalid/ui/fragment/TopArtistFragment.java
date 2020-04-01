package co.sebasdeveloper.pruebavalid.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mukesh.countrypicker.Country;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import co.sebasdeveloper.pruebavalid.ConfigDialog;
import co.sebasdeveloper.pruebavalid.R;
import co.sebasdeveloper.pruebavalid.adapter.CustomAdapter;
import co.sebasdeveloper.pruebavalid.model.TopArtistResponseModel;
import co.sebasdeveloper.pruebavalid.viewmodel.ArtistViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopArtistFragment extends Fragment implements ConfigDialog.CustomDialogListener {

    private View view;
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    private ArtistViewModel artistViewModel;
    private Country selectedCountry;
    private String selectedItems;

    public TopArtistFragment(ArtistViewModel artistViewModel, Country country) {
        this.artistViewModel = artistViewModel;
        this.selectedCountry = country;
        this.selectedItems = "50";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_top_artist, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_topartist);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setHasFixedSize(true);
        customAdapter = new CustomAdapter(getContext());
        recyclerView.setAdapter(customAdapter);
        artistViewModel.getModelMutableLiveData(selectedCountry, selectedItems).observe(this, new Observer<TopArtistResponseModel>() {
            @Override
            public void onChanged(TopArtistResponseModel topArtistResponseModel) {
                customAdapter.setArtists(topArtistResponseModel.getTopartists().getArtist());
            }
        });
        return view;
    }

    @Override
    public void applyText(Country country, String items) {
        this.selectedCountry = country;
        this.selectedItems = items;
    }
}
