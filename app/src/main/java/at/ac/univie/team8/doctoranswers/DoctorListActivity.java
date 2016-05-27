package at.ac.univie.team8.doctoranswers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

public class DoctorListActivity extends AppCompatActivity {

    int userID;


    private void tToast(String s) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, s, duration);
        toast.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        getUsersDoctors();

    }

    private void getUsersDoctors() {
        SharedPreferences sp = getSharedPreferences(MainActivity.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        userID = Integer.parseInt(sp.getString("userID", ""));

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                TextView respT = (TextView) findViewById(R.id.textViewResponse);
                respT.setTextSize(25);
                respT.setText(response);
                respT.setMovementMethod(new ScrollingMovementMethod());

            }

        };

        GetUsersDoctorsRequest getUsersDocs = new GetUsersDoctorsRequest(userID, responseListener);
        RequestQueue loginQueue = Volley.newRequestQueue(this);
        loginQueue.add(getUsersDocs);

    }

    public void backButton(View view) {
        Intent intent = new Intent(this, DoctorHandlerActivity.class);
        startActivity(intent);
    }

    public void addDoctorButton(View view) {
        Intent intent = new Intent(this, AddDoctorActivity.class);
        startActivity(intent);
    }
}
