package at.ac.univie.team8.doctoranswers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PediatricianGeneralPractitionerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pediatrician_genprac);
    }

    public void acuteButton(View view){
        setContentView(R.layout.acute_diseases);
        Button next = (Button) findViewById(R.id.nextButton);
       next.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(PediatricianGeneralPractitionerActivity.this, AskDoctorActivity.class);
               startActivity(intent);
           }
       });
    }

    public void chronicButton(View view){
        setContentView(R.layout.chronic_diseases);
        Button next = (Button) findViewById(R.id.nextButtonC);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PediatricianGeneralPractitionerActivity.this, AskDoctorActivity.class);
                startActivity(intent);
            }
        });
    }

    public void accidentButton(View view){
        setContentView(R.layout.accidental_injuries);
        Button next = (Button) findViewById(R.id.nextButtonA);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PediatricianGeneralPractitionerActivity.this, AskDoctorActivity.class);
                startActivity(intent);
            }
        });
    }
    public void otherButton(View view) {
        Intent intent = new Intent(this, AskDoctorActivity.class);
        startActivity(intent);
    }

    public void backButton(View view){
        Intent intent = new Intent(this, ChooseDocActivity.class);
        startActivity(intent);
    }
}
