package co.sebasdeveloper.pruebavalid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mukesh.countrypicker.Country;
import com.mukesh.countrypicker.CountryPicker;
import com.mukesh.countrypicker.listeners.OnCountryPickerListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ConfigDialog extends AppCompatDialogFragment {

    private static final String TAG = "ConfigDialog";
    private EditText editText;
    private Activity activity;
    private TextInputLayout items_textview;
    private TextInputEditText items_edittext;
    private CustomDialogListener customDialogListener;
    private Country countrySelected;
    private String itemsSelected;

    public ConfigDialog(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.filterlayout, null);
        editText = (EditText) view.findViewById(R.id.input_country);
        items_textview = (TextInputLayout) view.findViewById(R.id.inputlayout_items);
        items_edittext = (TextInputEditText) view.findViewById(R.id.input_items);

        items_edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int number = 0;
                if(s.toString() != null && s.toString() != ""){
                    try{
                        number = Integer.valueOf(s.toString());
                        if(number <= 0){
                            items_textview.setError("El valor debe ser mayor a 0");
                        }else if(number > 150){
                            items_textview.setError("El valor debe ser menor a 150");
                        }else {
                            items_textview.setErrorEnabled(false);
                        }
                    }catch (NumberFormatException e){
                        items_textview.setError("Solo se permiten valores numericos");
                    }catch (Exception e){
                        items_textview.setError("Solo se permiten valores numericos");
                    }
                }
            }
        });

        CountryPicker builderPicker = new CountryPicker.Builder().with(view.getContext())
                .listener(new OnCountryPickerListener() {
                    @Override
                    public void onSelectCountry(Country country) {
                        editText.setText(country.getName());
                        countrySelected = country;
                    }
                }).build();

        editText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                builderPicker.showBottomSheet((AppCompatActivity) getActivity());
            }
        });
        builder.setView(view)
            .setTitle(R.string.dialog_title)
            .setNegativeButton(R.string.btn_negative, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
    
                }
            })
            .setPositiveButton(R.string.btn_confirm, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    itemsSelected = items_edittext.getText().toString();
                    customDialogListener.applyText(countrySelected, itemsSelected);
                }
            })
        ;
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            customDialogListener = (CustomDialogListener) context;
        }catch (ClassCastException e){
            e.printStackTrace();
            throw new ClassCastException(context.toString() + "implement CustomDialogListener");
        }
    }

    public interface CustomDialogListener{
        void applyText(Country country, String items);
    }

}
