package com.example.taskforpclhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kevalpatel2106.rulerpicker.RulerValuePicker;
import com.kevalpatel2106.rulerpicker.RulerValuePickerListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] finalValue = {170};


        RulerValuePicker rulerValuePicker=findViewById(R.id.rulerPicker);
        TextView textView=findViewById(R.id.valueTV);

        rulerValuePicker.selectValue(finalValue[0]);//initial value



        rulerValuePicker.setValuePickerListener(new RulerValuePickerListener() {
            @Override
            public void onValueChange(int selectedValue) {
                //scrolling is stopped
                finalValue[0] =rulerValuePicker.getCurrentValue();
                textView.setText(finalValue[0]+"");


            }

            @Override
            public void onIntermediateValueChange(int selectedValue) {
                //scrolling is continue
                int currentValue=rulerValuePicker.getCurrentValue();
                textView.setText(currentValue+"");

            }
        });
    }
}