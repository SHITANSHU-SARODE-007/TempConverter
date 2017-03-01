package com.example.shitanshu.tempconverter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText)findViewById(R.id.editText);
    }
    /* this method is called when user clicks the button and is handled
    because we assigned the name to the "OnClick property" of the
    button */
    public void operation(View view) {
        ImageView iv; //create iv object to manipulate image view
        switch (view.getId()) {
            case R.id.button:
                RadioButton celsiusButton = (RadioButton)
                        findViewById(R.id.radioButton);
                RadioButton fahrenheitButton = (RadioButton)
                        findViewById(R.id.radioButton2);
                if (text.getText().length() == 0){
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue = Float.parseFloat(text.getText().toString());
                if (celsiusButton.isChecked()) {
                    text.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    celsiusButton.setChecked(false);
                    fahrenheitButton.setChecked(true);
                } else {
                    text.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    fahrenheitButton.setChecked(false);
                    celsiusButton.setChecked(true);
                }
                inputValue = Float.parseFloat(text.getText().toString());
                view = findViewById(R.id.activity_main);
                iv=(ImageView) findViewById(R.id.imageView);
                if (inputValue>90){
                    view.setBackgroundColor(Color.parseColor("#87ceff"));  //set hex color to skyblue
                    iv.setVisibility(View.VISIBLE);
                    //clear any prior image
                    ((ImageView) iv.findViewById(R.id.imageView)).setImageResource(0);
                    iv.setImageResource(R.drawable.sun);  //show sun on image

                }
                else if (inputValue<0){
                    view.setBackgroundColor(Color.RED);
                    iv.setVisibility(View.VISIBLE);
                    ((ImageView) iv.findViewById(R.id.imageView)).setImageResource(0);
                    iv.setImageResource(R.drawable.snowflake);  //show snowflake on image

                }
                else {

                    view.setBackgroundColor(Color.YELLOW);
                    iv.setVisibility(View.INVISIBLE);
                };
                break;
        }
    }
}
