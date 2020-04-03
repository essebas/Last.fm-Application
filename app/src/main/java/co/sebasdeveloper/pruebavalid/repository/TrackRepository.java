package co.sebasdeveloper.pruebavalid.repository;

import com.mukesh.countrypicker.Country;

import javax.inject.Inject;

import co.sebasdeveloper.pruebavalid.BuildConfig;
import co.sebasdeveloper.pruebavalid.model.TopTrackResponseModel;
import co.sebasdeveloper.pruebavalid.remote.TrackService;
import io.reactivex.Single;

public class TrackRepository {

    private TrackService trackService;

    @Inject
    public TrackRepository(TrackService trackService) {
        this.trackService = trackService;
    }

    public Single<TopTrackResponseModel> modelSingleTopTrack(Country country, String items){
        return trackService.getTopTrackResponseModel("geo.gettoptracks",country.getName(), BuildConfig.LastFM_API_Key,"json", items);
    }
}
