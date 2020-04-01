package co.sebasdeveloper.pruebavalid.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import co.sebasdeveloper.pruebavalid.R;
import co.sebasdeveloper.pruebavalid.databinding.ArtistBinding;
import co.sebasdeveloper.pruebavalid.model.ArtistModel;
import co.sebasdeveloper.pruebavalid.model.TopArtistModel;
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomView>{


    private Context context;
    private LayoutInflater layoutInflater;
    private TopArtistModel topArtistModel;
    private ArrayList<ArtistModel> arrayList2;

    public CustomAdapter(Context context) {
        this.context = context;
        this.arrayList2 = new ArrayList<>();
    }

    public CustomAdapter(Context context, TopArtistModel topArtistModel) {
        this.context = context;
        this.topArtistModel = topArtistModel;
        this.arrayList2 = (ArrayList<ArtistModel>) topArtistModel.getArtist();
    }


    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ArtistBinding artistBinding = DataBindingUtil.inflate(layoutInflater, R.layout.innerlayout, parent, false);
        return new CustomView(artistBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {
            ArtistModel artistModel = arrayList2.get(position);
            artistModel.setPostition_atr(String.valueOf(position+1));
            holder.materialButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(artistModel.getUrl()));
                    context.startActivity(intent);
                }
            });
            holder.bind(artistModel);
    }

    @Override
    public int getItemCount() {
        return arrayList2.size();
    }

    public void setArtists(List<ArtistModel> arrayList2) {
        this.arrayList2 = (ArrayList<ArtistModel>) arrayList2;
        notifyDataSetChanged();
    }

    class CustomView extends RecyclerView.ViewHolder{

        private ArtistBinding artistBinding;
        private MaterialButton materialButton;

        public CustomView(ArtistBinding artistBinding) {
            super(artistBinding.getRoot());
            this.artistBinding = artistBinding;
            initializeComponentes();
        }

        public void bind(ArtistModel artistModel){
            this.artistBinding.setArtist(artistModel);
            artistBinding.executePendingBindings();
        }

        public ArtistBinding getArtistBinding() {
            return artistBinding;
        }

        private void initializeComponentes(){
            this.materialButton = artistBinding.getRoot().findViewById(R.id.btn_website);
        }
    }

}
