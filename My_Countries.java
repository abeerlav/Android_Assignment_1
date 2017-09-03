package a2dv606_aa223de.assignment_1;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
/**
 * Created by Abeer on 2015-08-20.
 */
public class My_Countries extends Activity {

    protected static ArrayList<String> countriesList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__countries);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        ListView listView = (ListView) findViewById(R.id.listview_contries);
        adapter = new ArrayAdapter<String>(this, R.layout.country_row_view, R.id.country, countriesList);
        listView.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_country_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_country:
                Intent intent = new Intent(this, Add_Country.class);
                startActivityForResult(intent, 0);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent result) {
        if (resultCode == RESULT_OK) {
            String newCountry = result.getStringExtra("result");
            //   Toast.makeText(MyCountries.this, newCountry, Toast.LENGTH_SHORT).show();
            adapter.add(newCountry);
            adapter.notifyDataSetChanged();
        }
    }


}