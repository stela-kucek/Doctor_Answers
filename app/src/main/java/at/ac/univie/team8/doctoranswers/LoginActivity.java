package at.ac.univie.team8.doctoranswers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Stela on 18.05.2016.
 */
public class LoginActivity extends AppCompatActivity {

    String username;
    String password;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        username = getIntent().getStringExtra("username");
        password = getIntent().getStringExtra("password");

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


                        Intent intent = new Intent(LoginActivity.this, UserDataActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("username", username);
                        intent.putExtra("email", email);
                        intent.putExtra("age", age);

                        LoginActivity.this.startActivity(intent);

                    }
                    else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setMessage("Login Failed").setNegativeButton("Retry", null).create().show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
        RequestQueue loginQueue = Volley.newRequestQueue(LoginActivity.this);
        loginQueue.add(loginRequest);

    }


}
