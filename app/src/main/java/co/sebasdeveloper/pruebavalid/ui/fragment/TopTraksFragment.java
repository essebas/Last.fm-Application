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
import co.sebasdeveloper.pruebavalid.R;
import co.sebasdeveloper.pruebavalid.adapter.TrackAdapter;
import co.sebasdeveloper.pruebavalid.model.TopTrackResponseModel;
import co.sebasdeveloper.pruebavalid.viewmodel.TrackViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopTraksFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private TrackAdapter trackAdapter;
    private TrackViewModel trackViewModel;
    private Country selectedCountry;
    private String selectedItems;

    public TopTraksFragment(TrackViewModel trackViewModel, Country country) {
        this.trackViewModel = trackViewModel;
        this.selectedCountry = country;
        this.selectedItems = "50";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_top_traks, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_toptrack);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setHasFixedSize(true);
        trackAdapter = new TrackAdapter(getContext());
        recyclerView.setAdapter(trackAdapter);
        trackViewModel.getModelMutableData().observe(this, new Observer<TopTrackResponseModel>() {
            @Override
            public void onChanged(TopTrackResponseModel topTrackResponseModel) {
                trackAdapter.setTracks(topTrackResponseModel.getTracks().getTrack());
            }
        });
        return view;
    }

}
