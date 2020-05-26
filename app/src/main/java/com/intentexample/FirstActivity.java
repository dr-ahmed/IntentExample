package com.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    EditText firstEdt, secondEdt;
    Button calculateBtn;
    TextView sumTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        getDataFromSecondActivityIntent();
    }

    private void initViews() {
        firstEdt = findViewById(R.id.firstEdt);
        secondEdt = findViewById(R.id.secondEdt);
        calculateBtn = findViewById(R.id.calculateBtn);
        calculateBtn.setOnClickListener(this);
        sumTxt = findViewById(R.id.sumTxt);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.calculateBtn) {
            if (isEditTextEmpty(firstEdt) || isEditTextEmpty(secondEdt))
                return;

            Intent intent = new Intent(getBaseContext(), SecondActivity.class);

            /*
            Bundle bundle = new Bundle();
            bundle.putString("first_number", firstEdt.getText().toString());
            bundle.putString("second_number", secondEdt.getText().toString());
            intent.putExtra("data", bundle);
            */

            intent.putExtra("first_number", firstEdt.getText().toString());
            intent.putExtra("second_number", secondEdt.getText().toString());
            startActivity(intent);
        }
    }

    private boolean isEditTextEmpty(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.requestFocus();
            editText.setError("Champ obligatoire!");
            return true;
        }
        return false;
    }

    private void getDataFromSecondActivityIntent() {
        if (getIntent().hasExtra("sum")) {
            sumTxt.setText("Somme = " + getIntent().getStringExtra("sum"));
        }
    }
}
