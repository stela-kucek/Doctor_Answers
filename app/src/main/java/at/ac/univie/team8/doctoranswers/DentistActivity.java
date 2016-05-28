package at.ac.univie.team8.doctoranswers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DentistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist);
    }

    public void swellingsButton(View view) {
        setContentView(R.layout.swellings);
        Button next = (Button) findViewById(R.id.nextButtonSw);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DentistActivity.this, AskDoctorActivity.class);
                startActivity(intent);
            }
        });
    }

    public void painButton(View view) {
        setContentView(R.layout.pain);
        Button next = (Button) findViewById(R.id.nextButtonPain);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DentistActivity.this, AskDoctorActivity.class);
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
