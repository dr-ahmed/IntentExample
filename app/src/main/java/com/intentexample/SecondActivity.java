package com.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView firstTxt, secondTxt, resultTxt;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initViews();
        getDataFromFirstActivityIntent();
    }

    private void initViews() {
        firstTxt = findViewById(R.id.firstTxt);
        secondTxt = findViewById(R.id.secondTxt);
        resultTxt = findViewById(R.id.resultTxt);
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
    }

    private void getDataFromFirstActivityIntent() {

        firstTxt.setText(getIntent().getStringExtra("first_number"));
        secondTxt.setText(getIntent().getStringExtra("second_number"));

        /*
        Bundle bundle = getIntent().getBundleExtra("data");
        firstTxt.setText(bundle.getString("first_number"));
        secondTxt.setText(bundle.getString("second_number"));
        */

        int result = Integer.parseInt(firstTxt.getText().toString()) + Integer.parseInt(secondTxt.getText().toString());
        resultTxt.setText(String.valueOf(result));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backBtn) {
            Intent intent = new Intent(getBaseContext(), FirstActivity.class);
            intent.putExtra("sum", resultTxt.getText().toString());
            startActivity(intent);
        }
    }
}
