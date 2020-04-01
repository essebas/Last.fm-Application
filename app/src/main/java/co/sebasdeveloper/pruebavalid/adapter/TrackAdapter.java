package co.sebasdeveloper.pruebavalid.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import co.sebasdeveloper.pruebavalid.R;
import co.sebasdeveloper.pruebavalid.databinding.TrackBinding;
import co.sebasdeveloper.pruebavalid.model.ArtistModel;
import co.sebasdeveloper.pruebavalid.model.TopTrackModel;
import co.sebasdeveloper.pruebavalid.model.TrackModel;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackView>{

    private Context context;
    private LayoutInflater layoutInflater;
    private TopTrackModel topTrackModel;
    private ArrayList<TrackModel> arrayList;

    public TrackAdapter(Context context) {
        this.context = context;
        this.arrayList = new ArrayList<>();
    }

    public TrackAdapter(Context context, TopTrackModel topTrackModel) {
        this.context = context;
        this.topTrackModel = topTrackModel;
        this.arrayList = topTrackModel.getTrack();
    }

    @NonNull
    @Override
    public TrackView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        TrackBinding trackBinding = DataBindingUtil.inflate(layoutInflater, R.layout.tracklayout, parent, false);
        return new TrackView(trackBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackView holder, int position) {
        TrackModel trackModel = arrayList.get(position);
        holder.materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(trackModel.getUrl()));
                context.startActivity(intent);
            }
        });
        holder.bind(trackModel);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setTracks(ArrayList<TrackModel> arrayList){
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    class TrackView extends RecyclerView.ViewHolder{

        private TrackBinding trackBinding;
        private MaterialButton materialButton;

        public TrackView(TrackBinding trackBinding) {
            super(trackBinding.getRoot());
            this.trackBinding = trackBinding;
            iniatializeComponents();
        }

        public void bind(TrackModel trackModel){
            this.trackBinding.setTrack(trackModel);
            trackBinding.executePendingBindings();
        }

        public TrackBinding getTrackBinding() {
            return trackBinding;
        }

        private void iniatializeComponents(){
            this.materialButton = trackBinding.getRoot().findViewById(R.id.btn_website);
        }
    }

}
