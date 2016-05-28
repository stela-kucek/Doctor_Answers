package at.ac.univie.team8.doctoranswers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AfterQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_question);

        String question = getIntent().getStringExtra("question");


        SharedPreferences sp = getSharedPreferences(MainActivity.SHARED_PREF_NAME_2, Context.MODE_PRIVATE);
        String doc = sp.getString("doctor", "");

        TextView text = (TextView) findViewById(R.id.text1);
        text.setText("You asked your " + doc + " the following question: ");
        text.setTextSize(30);

        TextView text2 = (TextView) findViewById(R.id.text2);
        text2.setText(question);
        text2.setTextSize(30);

    }

    public void gotItButton(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
