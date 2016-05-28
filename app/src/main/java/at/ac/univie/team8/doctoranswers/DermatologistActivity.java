package at.ac.univie.team8.doctoranswers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DermatologistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dermatologist);
    }

    public void allergiesButton(View view) {
        setContentView(R.layout.allergies);
        Button next = (Button) findViewById(R.id.nextButtonAllerg);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DermatologistActivity.this, AskDoctorActivity.class);
                startActivity(intent);
            }
        });
    }

    public void infectionsButton(View view) {
        setContentView(R.layout.infections);
        Button next = (Button) findViewById(R.id.nextButtonInf);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DermatologistActivity.this, AskDoctorActivity.class);
                startActivity(intent);
            }
        });
    }

    public void rashesButton(View view) {
        setContentView(R.layout.rashes);
        Button next = (Button) findViewById(R.id.nextButtonRash);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DermatologistActivity.this, AskDoctorActivity.class);
                startActivity(intent);
            }
        });
    }

    public void otherButton(View view) {
        Intent intent = new Intent(this, AskDoctorActivity.class);
        startActivity(intent);
    }

    public void backButton(View view){
        finish();
    }
}
