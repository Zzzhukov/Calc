package com.example.calculator;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void fold(View view) {
        EditText TermFirst = findViewById(R.id.term1);
        EditText TermSecond = findViewById(R.id.term2);
        try {
            String stringTerm1 = TermFirst.getText().toString();
            String stringTerm2 = TermSecond.getText().toString();
            if (examination(stringTerm1) && examination(stringTerm2)) {
                int firstTerm = Integer.parseInt(stringTerm1);
                int secondTerm = Integer.parseInt(stringTerm2);
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("firstTerm", firstTerm);
                intent.putExtra("secondTerm", secondTerm);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Вы ввели неверные данные", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public boolean examination(String bool) {
        try {
            Integer.parseInt(bool);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}