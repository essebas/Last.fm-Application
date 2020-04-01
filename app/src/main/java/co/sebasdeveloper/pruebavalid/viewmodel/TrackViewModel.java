package co.sebasdeveloper.pruebavalid.viewmodel;

import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import co.sebasdeveloper.pruebavalid.R;
import co.sebasdeveloper.pruebavalid.model.TopArtistResponseModel;
import co.sebasdeveloper.pruebavalid.model.TopTrackResponseModel;
import co.sebasdeveloper.pruebavalid.repository.TrackRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class TrackViewModel extends ViewModel {
    private TrackRepository trackRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<TopTrackResponseModel> modelMutableLiveData = new MutableLiveData<>();
    private static final String TAG = "TrackViewModel";

    @Inject
    public TrackViewModel(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public MutableLiveData<TopTrackResponseModel> getModelMutableData(){
        loadData();
        return modelMutableLiveData;
    }

    private void loadData(){
        disposable.add(trackRepository.modelSingleTopTrack()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<TopTrackResponseModel>(){
            @Override
            public void onSuccess(TopTrackResponseModel topTrackResponseModel) {
                getModelMutableData().setValue(topTrackResponseModel);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error caused by: " + e.getMessage());
            }
        })
        );
    }

    @BindingAdapter({"tackImageURL"})
    public static void loadImage(ImageView imageView, String imageURL){
        Log.d(TAG, "URL image: " +imageURL);
        Picasso.get().load(imageURL).placeholder(R.drawable.default_user_image).into(imageView);
    }

}
