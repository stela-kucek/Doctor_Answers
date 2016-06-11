package at.ac.univie.team8.doctoranswers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AskDoctorActivity extends AppCompatActivity {

    EditText question;

    private void tToast(String s) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, s, duration);
        toast.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_doctor);
        question = (EditText) findViewById(R.id.editTextQuestion);
    }

    public void backButton(View view){
        finish();
    }

    public void attachButton(View view){
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

    public void askButton(View view){
        tToast("Your question has been sent!");
        String q = question.getText().toString();
        Intent intent = new Intent(this, AfterQuestionActivity.class);
        intent.putExtra("question", q);
        startActivity(intent);
    }

}
