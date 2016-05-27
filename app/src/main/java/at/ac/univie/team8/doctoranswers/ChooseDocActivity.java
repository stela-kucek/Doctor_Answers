package at.ac.univie.team8.doctoranswers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseDocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_doc);
    }

    public void pediatrician(View view){

    }

    public void dermatologist(View view){

    }

    public void dentist(View view){

    }

    public void generalPractitioner(View view){

    }

    public void backButton(View view){
        Intent intent = new Intent(this, DoctorHandlerActivity.class);
        startActivity(intent);
    }
}
