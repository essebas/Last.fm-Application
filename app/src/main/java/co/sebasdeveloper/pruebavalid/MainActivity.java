package co.sebasdeveloper.pruebavalid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import co.sebasdeveloper.pruebavalid.adapter.PageAdapter;
import co.sebasdeveloper.pruebavalid.databinding.ActivityMainBinding;
import co.sebasdeveloper.pruebavalid.viewmodel.ArtistViewModel;
import co.sebasdeveloper.pruebavalid.viewmodel.TrackViewModel;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mukesh.countrypicker.Country;
import com.mukesh.countrypicker.CountryPicker;
import com.mukesh.countrypicker.listeners.OnCountryPickerListener;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ConfigDialog.CustomDialogListener {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding activityMainBinding;
    private FloatingActionButton fab;

    @Inject
    ViewModelProvider.Factory viewFactory;

    private ArtistViewModel artistViewModel;
    private TrackViewModel trackViewModel;

    private Country country;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        fab = (FloatingActionButton) findViewById(R.id.btnfab_options);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        artistViewModel = new ViewModelProvider(this, viewFactory).get(ArtistViewModel.class);
        trackViewModel = new ViewModelProvider(this, viewFactory).get(TrackViewModel.class);
        getDefaultCountry();
        viewPager2.setAdapter(new PageAdapter(this, artistViewModel, trackViewModel, country));
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Top Artistas");
                        tab.setIcon(R.drawable.ic_topartists);
                        break;
                    case 1:
                        tab.setText("Top Canciones");
                        tab.setIcon(R.drawable.ic_toptraks);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.colorAccent)
                        );
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(50);
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
            }
        });

    }

    private void openDialog(){
        ConfigDialog configDialog = new ConfigDialog(getParent());
        configDialog.show(getSupportFragmentManager(), "config dialog");
    }

    @Override
    public void applyText(Country country, String items) {
        Log.d(TAG, "Pais: " + country.getName() + " Items: " + items);
    }

    public void getDefaultCountry(){
        CountryPicker.Builder builder = new CountryPicker.Builder().with(getApplicationContext());
        CountryPicker picker = builder.build();
        this.country = picker.getCountryByName("colombia");
    }
}
