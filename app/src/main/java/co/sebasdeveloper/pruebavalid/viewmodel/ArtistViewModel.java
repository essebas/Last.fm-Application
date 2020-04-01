package co.sebasdeveloper.pruebavalid.viewmodel;

import android.nfc.TagLostException;
import android.util.Log;
import android.widget.ImageView;

import com.mukesh.countrypicker.Country;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import co.sebasdeveloper.pruebavalid.R;
import co.sebasdeveloper.pruebavalid.model.ArtistModel;
import co.sebasdeveloper.pruebavalid.model.ArtistResponseModel;
import co.sebasdeveloper.pruebavalid.model.ImageModel;
import co.sebasdeveloper.pruebavalid.model.TopArtistResponseModel;
import co.sebasdeveloper.pruebavalid.repository.ArtistRepository;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class ArtistViewModel extends ViewModel {
    private ArtistRepository artistRepository;
    private CompositeDisposable disposable=new CompositeDisposable();
    //private MutableLiveData<ArtistResponseModel> modelMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<TopArtistResponseModel> modelMutableLiveData = new MutableLiveData<>();
    private static final String TAG = "ArtistViewModel";

    @Inject
    public ArtistViewModel(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public MutableLiveData<TopArtistResponseModel> getModelMutableLiveData(Country country, String items) {
        loadData(country, items);
        return modelMutableLiveData;
    }

    private void loadData(Country country, String items){
        disposable.add(artistRepository.modelSingleTopArtist(country, items)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<TopArtistResponseModel>(){
                    @Override
                    public void onSuccess(TopArtistResponseModel topArtistResponseModel) {
                        getModelMutableLiveData(country, items).setValue(topArtistResponseModel);
                        //Test
                        ImageModel[] imageModel = topArtistResponseModel.getTopartists().getArtist().get(0).getImage();
                        Log.d("Artist", String.valueOf(topArtistResponseModel.getTopartists().getArtist().size()));
                        Log.d("Artist", "Url image for artist 1: url:" + imageModel[0].getText() + " size:" + imageModel[0].getSize());
                        Log.d("Artist", "Url image for artist 1: url:" + imageModel[2].getText() + " size:" + imageModel[2].getSize());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Artist", "Error caused by: " + e.getMessage());
                    }
                })
        );
    }

    @BindingAdapter({"imageURL"})
    public static void loadImage(ImageView imageView, String imageURL){
        Log.d(TAG, "URL image: " +imageURL);
        Picasso.get().load(imageURL).placeholder(R.drawable.default_user_image).into(imageView);
    }

}
