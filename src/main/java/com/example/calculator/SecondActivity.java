package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);
        try {
            TextView textView = findViewById(R.id.output);
            Integer firstTerm = getIntent().getExtras().getInt("firstTerm");
            Integer secondTerm = getIntent().getExtras().getInt("secondTerm");
            textView.setText(firstTerm.toString() + " + " + secNeg(secondTerm) + " = " + (firstTerm + secondTerm));
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public String secNeg(Integer num) {
        if (num < 0) {
            return "(" + num.toString() + ")";
        }
        return num.toString();
    }
}