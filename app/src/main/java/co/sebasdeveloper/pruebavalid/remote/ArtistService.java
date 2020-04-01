package co.sebasdeveloper.pruebavalid.remote;
import co.sebasdeveloper.pruebavalid.model.ArtistResponseModel;
import co.sebasdeveloper.pruebavalid.model.TopArtistResponseModel;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArtistService {

    @GET("/2.0/")
    Single<ArtistResponseModel> getArtistResponseModel(@Query("method") String method,
                                                       @Query("artist") String artist,
                                                       @Query("mbid") String mbid,
                                                       @Query("api_key") String api_key,
                                                       @Query("format") String format);

    @GET("/2.0/")
    Single<TopArtistResponseModel> getTopArtistResponseModel(@Query("method") String method,
                                                             @Query("country") String country,
                                                             @Query("api_key") String api_key,
                                                             @Query("format") String format,
                                                             @Query("limit") String limit);


}
