package co.sebasdeveloper.pruebavalid.repository;

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

    public Single<TopTrackResponseModel> modelSingleTopTrack(){
        return trackService.getTopTrackResponseModel("geo.gettoptracks","spain", BuildConfig.LastFM_API_Key,"json");
    }
}
