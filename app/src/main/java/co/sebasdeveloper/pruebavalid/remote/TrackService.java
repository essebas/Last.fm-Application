package co.sebasdeveloper.pruebavalid.remote;

import co.sebasdeveloper.pruebavalid.model.TopTrackResponseModel;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TrackService {

    @GET("/2.0/")
    Single<TopTrackResponseModel> getTopTrackResponseModel(
            @Query("method") String method,
            @Query("country") String country,
            @Query("api_key") String api_key,
            @Query("format") String format,
            @Query("limit") String limit
    );
}
