package co.sebasdeveloper.pruebavalid.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
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
public class TopTraksFragment extends Fragment implements ITopFragments{

    private View view;
    private RecyclerView recyclerView;
    private TrackAdapter trackAdapter;
    private TrackViewModel trackViewModel;
    private Country selectedCountry;
    private String selectedItems;

    private static final String TAG = "TopTraksFragment";
    
    public TopTraksFragment(TrackViewModel trackViewModel, Country country, String items) {
        this.trackViewModel = trackViewModel;
        this.selectedCountry = country;
        this.selectedItems = items;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "Ha entrado en onCreateView: Pais: " + this.selectedCountry.getName() + "/ Items: " + selectedItems);
        view = inflater.inflate(R.layout.fragment_top_traks, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_toptrack);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setHasFixedSize(true);
        trackAdapter = new TrackAdapter(getContext());
        recyclerView.setAdapter(trackAdapter);
        trackViewModel.getModelMutableData(selectedCountry, selectedItems).observe(this, new Observer<TopTrackResponseModel>() {
            @Override
            public void onChanged(TopTrackResponseModel topTrackResponseModel) {
                trackAdapter.setTracks(topTrackResponseModel.getTracks().getTrack());
            }
        });
        return view;
    }

    @Override
    public void updateLiveData(Country country, String items) {
        if(this.selectedCountry != country || this.selectedItems != items){
            Log.d(TAG,"Se van aactualizar los datos");
            this.selectedCountry = country;
            this.selectedItems = items;
            trackViewModel.loadData(country, items);
        }
        Log.d(TAG,"No se actualizaron los datos porwue no habia cambios");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Ha entrado en on Resume: Pais: " + this.selectedCountry.getName() + "/ Items: " + selectedItems);
    }
}
