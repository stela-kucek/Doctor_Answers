package at.ac.univie.team8.doctoranswers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TippsActivity extends AppCompatActivity {

    ListView tippsListView;
    ArrayList<String> tippsList;
    ArrayAdapter<String> adapter;


    public void initialize() {
        tippsListView = (ListView) findViewById(R.id.tippsList);

        tippsList = new ArrayList<>();
        tippsList.add("Tipp 1: Brush your teeth after every meal!");
        tippsList.add("Tipp 2: Avoid touching your face with dirty hands!");
        tippsList.add("Tipp 3: Drink 8 glasses of water every day, stay hydrated!");
        tippsList.add("Tipp 4: Spend more time outside on a sunny day, Vitamin D will do you good!");
        tippsList.add("Tipp 5: Take a break from studying every hour - go for a walk or stretch!");

        adapter = new ArrayAdapter<String>(this, R.layout.mylistitem, tippsList);

        tippsListView.setAdapter(adapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipps);

        initialize();
    }

    public void backButton(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
