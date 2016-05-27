package at.ac.univie.team8.doctoranswers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UserDataActivity extends AppCompatActivity {

    ArrayAdapter<String> userDataAdapter;
    ArrayList<String> userData;
    ListView listview;

    public void initialize(){
        userData = new ArrayList<String>();
        listview = (ListView) findViewById(R.id.userData);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        initialize();

        SharedPreferences sp = this.getSharedPreferences(MainActivity.SHARED_PREF_NAME, Context.MODE_PRIVATE);

        String name = sp.getString("name", "");
        String username = sp.getString("username", "");
        String email = sp.getString("email", "");
        String age = sp.getString("age","");

        userData.add("Full name: " + name);
        userData.add("Username: " + username);
        userData.add("E-mail: " + email);
        userData.add("Age: " + age);

        userDataAdapter = new ArrayAdapter<String>(this, R.layout.mylistitem, userData);
        listview.setAdapter(userDataAdapter);

    }

    public void backButton(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
