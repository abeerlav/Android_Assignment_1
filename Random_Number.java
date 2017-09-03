package a2dv606_aa223de.assignment_1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/**
 * Created by Abeer on 2015-08-20.
 */

public class Random_Number extends Activity {

    TextView textView;
    Button randomNumButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random__number);
        textView  = (TextView) findViewById(R.id.display);
        randomNumButton = (Button)findViewById(R.id.random_num_button);

        randomNumButton.setOnClickListener(new showRandomNumber());

    }
    private class showRandomNumber implements View.OnClickListener {
        public void onClick(View v) {
            textView.setText(Integer.toString((int)(Math.random() * 100 + 1)));
        }
    }

}

