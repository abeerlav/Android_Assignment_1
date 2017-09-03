package a2dv606_aa223de.assignment_1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.text.DecimalFormat;

/**
 * Created by Abeer on 2015-08-20.
 */

public class BMI extends Activity {

    private TextView display,label;
    private EditText length_editText, width_editText;
    private Button computeButton, resetButton;
    private AlertDialog.Builder builder;
    private AlertDialog noneEmpty_alert, number_alert,positiveNum_alert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        initComponents();
        setupAlerts();


    }
    private void initComponents(){
        display = (TextView) findViewById(R.id.display);
        length_editText = (EditText) findViewById(R.id.enterLength);
        width_editText = (EditText) findViewById(R.id.enterWidth);
        computeButton = (Button) findViewById(R.id.compute_button);
        resetButton = (Button) findViewById(R.id.reset_button);
        computeButton.setOnClickListener(new ButtonClick());
        resetButton.setOnClickListener(new ButtonClick());

    }
    private void setupAlerts(){
        noneEmpty_alert = setup_alert(R.string.alert_mag_noneEmptyInput);
        number_alert= setup_alert(R.string.alert_mag_numberInput);
        positiveNum_alert= setup_alert(R.string.alert_mag_positiveInput);
    }
    private class ButtonClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            if (v == computeButton) {
                String weight = width_editText.getText().toString().trim();
                String length = length_editText.getText().toString().trim();

                if( validateInput(weight, length)) {
                    displayBMI(Float.parseFloat(weight),Float.parseFloat(length));
                }
            }
            else if (v == resetButton) {

                length_editText.setText(null);
                width_editText.setText(null);
                display.setText(R.string.display_bmi);
                if(label!=null)
                  label.setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }

    private boolean validateInput(String weight, String length) {
        // check if it is not empty input
        if (TextUtils.isEmpty(weight) || TextUtils.isEmpty(length)) {
            noneEmpty_alert.show();
            return false;
        } else // check if it is a positive Number
            try {

                if(Double.valueOf(weight)<=0|| Double.valueOf(length)<=0){
                    positiveNum_alert.show();
                    return false;
                }
                return true;
            } catch (NumberFormatException e) {
                number_alert.show();
                return false;
            }
    }

    private void displayBMI(float weight, float length) {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        float bmi = weight / (length * length)*10000;
        if(label!=null){
            label.setBackgroundColor(Color.TRANSPARENT);
        }

        if(bmi<18.5){
            display.setText(getText(R.string.calculated_bmi)+ numberFormat.format(bmi));
                  label= (TextView) findViewById(R.id.underW_view);
                   label.setBackgroundColor(Color.parseColor("#ffb3b3"));

        }else
        if(bmi>=18.5&&bmi<25){
            display.setText(getText(R.string.calculated_bmi)+ numberFormat.format(bmi));
            label= (TextView) findViewById(R.id.normal_view);
            label.setBackgroundColor(Color.parseColor("#ffb3b3"));

                    //       "Selected page position: " + position, Toast.LENGTH_SHORT).show();
        }
        else
        if(bmi>=25&&bmi<30){
            display.setText(getText(R.string.calculated_bmi)+ numberFormat.format(bmi));
            label= (TextView) findViewById(R.id.overw_view);
            label.setBackgroundColor(Color.parseColor("#ffb3b3"));
        }else
        {  display.setText(getText(R.string.calculated_bmi)+ numberFormat.format(bmi));
            label= (TextView) findViewById(R.id.obese_view);
        label.setBackgroundColor(Color.parseColor("#ffb3b3"));}

    }

    private AlertDialog setup_alert(int id) {
        builder = new AlertDialog.Builder(this);
        builder.setMessage(id); // Configure Alert
        builder.setTitle(R.string.alert_title);
        builder.setPositiveButton("Done", new DialogDone()); // Add button action
        return builder.create(); // Generate Alert
    }
    /* Done button handling ==> close dialog */
    private class DialogDone implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int id) {
            dialog.dismiss(); // Close down dialog
        }
    }

}