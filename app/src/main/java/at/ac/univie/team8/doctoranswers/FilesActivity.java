package at.ac.univie.team8.doctoranswers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilesActivity extends AppCompatActivity {

    MyExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.expFilesView);

        // preparing list data
        prepareListData();

        listAdapter = new MyExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("For Dentist");
        listDataHeader.add("For Dermatologist");
        listDataHeader.add("For General Practitioner");
        listDataHeader.add("For Pediatrician");

        // Adding child data
        List<String> forDentist = new ArrayList<String>();
        forDentist.add("Tooth1.jpg");
        forDentist.add("Tooth2.jpg");
        forDentist.add("Broken_tooth.jpg");
        forDentist.add("File_from_dentist.docx");


        List<String> forDermat = new ArrayList<String>();
        forDermat.add("Skin_issue1.jpg");
        forDermat.add("New_issue2.jpg");
        forDermat.add("Dermat_advice.docx");

        List<String> forGP = new ArrayList<String>();
        forGP.add("Joint_twist.jpg");
        forGP.add("Bleeding_knee.jpg");
        forGP.add("Nutrition_plan.docx");

        List<String> forPed = new ArrayList<String>();


        listDataChild.put(listDataHeader.get(0), forDentist); // Header, Child data
        listDataChild.put(listDataHeader.get(1), forDermat);
        listDataChild.put(listDataHeader.get(2),  forGP);
        listDataChild.put(listDataHeader.get(3), forPed);
    }

    public void backButton(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
