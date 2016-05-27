package at.ac.univie.team8.doctoranswers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AddDoctorActivity extends AppCompatActivity {
    EditText docNameText;
    EditText docAddressText;
    EditText docContactText;
    Spinner categorySpinner;
    ArrayList<String> categoryList;
    ArrayAdapter<String> adapter;
    String chosenCategory;

    private void tToast(String s) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, s, duration);
        toast.show();
    }

    public void initialize() {
        docNameText = (EditText) findViewById(R.id.docName);
        docAddressText = (EditText) findViewById(R.id.docAddress);
        docContactText = (EditText) findViewById(R.id.docContact);
        categorySpinner = (Spinner) findViewById(R.id.spinnerCategories);

        categoryList = new ArrayList<String>();
        categoryList.add("General practitioner");
        categoryList.add("Dentist");
        categoryList.add("Dermatologist");
        categoryList.add("Pediatrician");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, categoryList);

        categorySpinner.setAdapter(adapter);

        chosenCategory = "";

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chosenCategory =String.valueOf(categorySpinner.getSelectedItem());
                tToast(chosenCategory);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);

        initialize();

    }

    public void saveButton(View view){

        String name = docNameText.getText().toString();
        String address = docAddressText.getText().toString();
        String contact = docContactText.getText().toString();
        SharedPreferences sp = getSharedPreferences(MainActivity.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        int userID = Integer.parseInt(sp.getString("userID", ""));

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        tToast("Saved successfully!");
                        Intent intent = new Intent(AddDoctorActivity.this, DoctorListActivity.class);
                        startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(AddDoctorActivity.this);
                        builder.setMessage("Save failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        DoctorRequest doctorRequest = new DoctorRequest(name, address, contact, chosenCategory, userID, responseListener);
        RequestQueue queue = Volley.newRequestQueue(AddDoctorActivity.this);
        queue.add(doctorRequest);
    }


    public void backButton(View view) {
        Intent intent = new Intent(this, DoctorListActivity.class);
        startActivity(intent);
    }


}
