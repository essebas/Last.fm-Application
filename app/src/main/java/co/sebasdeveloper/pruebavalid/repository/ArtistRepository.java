package co.sebasdeveloper.pruebavalid.repository;

import com.mukesh.countrypicker.Country;

import javax.inject.Inject;

import co.sebasdeveloper.pruebavalid.BuildConfig;
import co.sebasdeveloper.pruebavalid.model.ArtistResponseModel;
import co.sebasdeveloper.pruebavalid.model.TopArtistResponseModel;
import co.sebasdeveloper.pruebavalid.remote.ArtistService;
import io.reactivex.Single;

public class ArtistRepository {

    private ArtistService artistService;

    @Inject
    public ArtistRepository(ArtistService artistService) {
        this.artistService = artistService;
    }

    public Single<ArtistResponseModel> modelSingle(){
        return artistService.getArtistResponseModel("artist.getinfo","Cher","bfcc6d75-a6a5-4bc6-8282-47aec8531818", BuildConfig.LastFM_API_Key, "json");
    }

    public Single<TopArtistResponseModel> modelSingleTopArtist(Country country, String items){
        return artistService.getTopArtistResponseModel("geo.gettopartists",country.getName(), BuildConfig.LastFM_API_Key,"json", items);
    }

}
