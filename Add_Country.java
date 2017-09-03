package a2dv606_aa223de.assignment_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * Created by Abeer on 2015-08-20.
 */

public class Add_Country extends Activity {
    private EditText country_editText, year_editText;
    private Button addButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__country);

        year_editText = (EditText) findViewById(R.id.entery_year);
        country_editText = (EditText) findViewById(R.id.enter_country);
        addButton = (Button) findViewById(R.id.add_country_button);


        addButton.setOnClickListener(new View.OnClickListener() {
            String enteredCountry;

            @Override
            public void onClick(View v) {
                String country = country_editText.getText().toString().trim();
                String year = year_editText.getText().toString().trim();

                if (TextUtils.isEmpty(country) || TextUtils.isEmpty(year)) {
                    Toast.makeText(Add_Country.this,R.string.input_msg, Toast.LENGTH_SHORT).show();}
                else {
                    enteredCountry = country + " " + year;
                    Intent reply = new Intent();
                    reply.putExtra("result", enteredCountry);
                    setResult(RESULT_OK, reply);
                    finish();   // Close this activity

                }
            }
        });
    }


}
