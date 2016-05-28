package at.ac.univie.team8.doctoranswers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ChooseDocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_doc);
    }

    public void pediatrician(View view){
        Intent intent = new Intent(this, PediatricianGeneralPractitionerActivity.class);
        startActivity(intent);

        SharedPreferences sp = getSharedPreferences(MainActivity.SHARED_PREF_NAME_2, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("doctor", "pediatrician");
        editor.commit();
    }

    public void dermatologist(View view){
        Intent intent = new Intent(this, DermatologistActivity.class);
        startActivity(intent);

        SharedPreferences sp = getSharedPreferences(MainActivity.SHARED_PREF_NAME_2, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("doctor", "dermatologist");
        editor.commit();
    }

    public void dentist(View view){
        Intent intent = new Intent(this, DentistActivity.class);
        startActivity(intent);

        SharedPreferences sp = getSharedPreferences(MainActivity.SHARED_PREF_NAME_2, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("doctor", "dentist");
        editor.commit();
    }

    public void generalPractitioner(View view){
        Intent intent = new Intent(this, PediatricianGeneralPractitionerActivity.class);
        startActivity(intent);
        SharedPreferences sp = getSharedPreferences(MainActivity.SHARED_PREF_NAME_2, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("doctor", "general practitioner");
        editor.commit();
    }

    public void backButton(View view){
        Intent intent = new Intent(this, DoctorHandlerActivity.class);
        startActivity(intent);
    }
}
