package at.ac.univie.team8.doctoranswers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success){
                        String name = jsonResponse.getString("name");
                        String email = jsonResponse.getString("email");
                        int age = jsonResponse.getInt("age");


                        Intent intent = new Intent(MainActivity.this, UserDataActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("username", usernameStr);
                        intent.putExtra("email", email);
                        intent.putExtra("age", age);

                        startActivity(intent);

                    }
                    else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Login Failed").setNegativeButton("Retry", null).create().show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        LoginRequest loginRequest = new LoginRequest(usernameStr, psswdStr, responseListener);
        RequestQueue loginQueue = Volley.newRequestQueue(this);
        loginQueue.add(loginRequest);

    }


    public void registerButton(View view) {

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }


}
