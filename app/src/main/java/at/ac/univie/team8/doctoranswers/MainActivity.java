package at.ac.univie.team8.doctoranswers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText usernameText;
    String usernameStr;

    EditText psswdText;
    String psswdStr;

    public void initialize(){
        usernameText = (EditText) findViewById(R.id.editText);
        usernameStr = "";

        psswdText = (EditText) findViewById(R.id.editText2);
        psswdStr = "";

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    public void loginButton(View view) {

        usernameStr = usernameText.getText().toString();
        psswdStr = psswdText.getText().toString();

        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("username", usernameStr);
        intent.putExtra("password", psswdStr);
        startActivity(intent);

    }

    public void registerButton(View view) {

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }


}
