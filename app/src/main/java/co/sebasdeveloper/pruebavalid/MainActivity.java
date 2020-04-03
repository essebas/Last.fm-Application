package co.sebasdeveloper.pruebavalid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import co.sebasdeveloper.pruebavalid.adapter.PageAdapter;
import co.sebasdeveloper.pruebavalid.ui.fragment.ITopFragments;
import co.sebasdeveloper.pruebavalid.ui.fragment.TopArtistFragment;
import co.sebasdeveloper.pruebavalid.ui.fragment.TopTraksFragment;
import co.sebasdeveloper.pruebavalid.viewmodel.ArtistViewModel;
import co.sebasdeveloper.pruebavalid.viewmodel.TrackViewModel;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mukesh.countrypicker.Country;
import com.mukesh.countrypicker.CountryPicker;
import com.mukesh.countrypicker.listeners.OnCountryPickerListener;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity
        implements ConfigDialog.CustomDialogListener{

    private static final String TAG = "MainActivity";
    private FloatingActionButton fab;

    @Inject
    ViewModelProvider.Factory viewFactory;

    private ArtistViewModel artistViewModel;
    private TrackViewModel trackViewModel;
    private TabLayout tabLayout;
    private Country country;
    private String items;
    private ViewPager2 viewPager2;
    private PageAdapter pageAdapter;
    private CollapsingToolbarLayout collapsing_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
        viewPager2 = findViewById(R.id.viewPager);
        fab = (FloatingActionButton) findViewById(R.id.btnfab_options);
        collapsing_title = (CollapsingToolbarLayout) findViewById(R.id.collapsing_title);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.rubik_medium);
        collapsing_title.setExpandedTitleTypeface(typeface);
        getDefaultConfig();
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        artistViewModel = new ViewModelProvider(this, viewFactory).get(ArtistViewModel.class);
        trackViewModel = new ViewModelProvider(this, viewFactory).get(TrackViewModel.class);
        pageAdapter = new PageAdapter(this, artistViewModel, trackViewModel, country, items);
        viewPager2.setAdapter(pageAdapter);
        tabLayout = findViewById(R.id.tabLayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText(R.string.tab_topartist);
                        tab.setIcon(R.drawable.ic_topartists);
                        break;
                    case 1:
                        tab.setText(R.string.tab_toptracks);
                        tab.setIcon(R.drawable.ic_toptraks);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.colorAccent)
                        );
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(Integer.valueOf(items));
                        badgeDrawable.setMaxCharacterCount(3);
                        break;
                }
            }
        }
        );
        tabLayoutMediator.attach();
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BadgeDrawable badgeDrawable = tabLayout.getTabAt(position).getOrCreateBadge();
                badgeDrawable.setVisible(false);
                Log.d(TAG, "La pagina ha cambiado a: " + position);
                ITopFragments visibleFragment = (ITopFragments)pageAdapter.getFragment(position);
                visibleFragment.updateLiveData(country, items);
            }
        });

    }

    private void openDialog(){
        ConfigDialog configDialog = new ConfigDialog(getParent());
        //configDialog.getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        Bundle args = new Bundle();
        args.putString("country", this.country.getName());
        args.putString("items", this.items);
        configDialog.setArguments(args);
        configDialog.show(getSupportFragmentManager(), "config dialog");
    }

    @Override
    public void applyText(Country country, String items) {
        this.country = country;
        this.items = items;
        collapsing_title.setTitle("Top " + items + " " + country.getName());
        pageAdapter.setOptions(this.country, this.items);
        ITopFragments fragment;
        fragment = (ITopFragments)pageAdapter.getFragment(viewPager2.getCurrentItem());
        if(fragment != null){
            fragment.updateLiveData(country, items);
        }else{
            Log.d(TAG, "Error en la instancia del fragmento");
        }
    }

    public void getDefaultConfig(){
        CountryPicker.Builder builder = new CountryPicker.Builder().with(getApplicationContext());
        CountryPicker picker = builder.build();
        this.country = picker.getCountryByName(getString(R.string.default_country));
        this.items = getString(R.string.default_items);
        collapsing_title.setTitle("Top " + items + " " + country.getName());
    }

}
