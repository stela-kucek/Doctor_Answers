package at.ac.univie.team8.doctoranswers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DoctorHandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_handler);
    }

    public void backButton(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void doctorListButton(View view) {
        Intent intent = new Intent(this, DoctorListActivity.class);
        startActivity(intent);
    }

    public void addDoctorButton(View view) {
        Intent intent = new Intent(this, AddDoctorActivity.class);
        startActivity(intent);
    }

    public void askQuestButton(View view) {
        Intent intent = new Intent(this, ChooseDocActivity.class);
        startActivity(intent);
    }
}
