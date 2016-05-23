package at.ac.univie.team8.doctoranswers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class UserDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        final TextView usernameText = (TextView) findViewById(R.id.name);
        final TextView emailText = (TextView) findViewById(R.id.email);
        final TextView ageText = (TextView) findViewById(R.id.age);
        final TextView welcomeText = (TextView) findViewById((R.id.welcome));

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String username = getIntent().getStringExtra("username");
        int age = getIntent().getIntExtra("age", -1);

        String welcome = name + ", welcome to your user area!";

        usernameText.setText(username);
        emailText.setText(email);
        ageText.setText(age + "");

        welcomeText.setText(welcome);

    }
}
