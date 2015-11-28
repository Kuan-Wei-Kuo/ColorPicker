package com.kuo.colorpickerdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView colorText;
    private ImageView colorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        findButton();
    }

    private void findView() {
        colorText = (TextView) findViewById(R.id.colorText);
        colorView = (ImageView) findViewById(R.id.colorView);
    }

    private void findButton() {
        Button openColorPicker = (Button) findViewById(R.id.openColorPicker);
        openColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
                colorPickerDialog.setOnEnterListener(new ColorPickerDialog.OnEnterListener() {
                    @Override
                    public void onEnter(String colorString) {
                        colorText.setText(colorString);
                        colorView.setBackgroundColor(Color.parseColor(colorString));
                    }
                });
                colorPickerDialog.show(getSupportFragmentManager(), "dialog");
            }
        });
    }
}
