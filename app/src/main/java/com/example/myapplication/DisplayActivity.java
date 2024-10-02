package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private TextView displaySubjectName, displaySubjectCode, displaySubjectCredits;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        // Пошук TextView елементів
        displaySubjectName = findViewById(R.id.display_subject_name);
        displaySubjectCode = findViewById(R.id.display_subject_code);
        displaySubjectCredits = findViewById(R.id.display_subject_credits);

        // Пошук кнопки "Назад"
        backButton = findViewById(R.id.back_button);

        // Отримання даних з наміру
        Intent intent = getIntent();
        Subject subject = (Subject) intent.getSerializableExtra("subject_data");

        // Виведення отриманих даних
        if (subject != null) {
            displaySubjectName.setText("Subject Name: " + subject.getSubjectName());
            displaySubjectCode.setText("Subject Code: " + subject.getSubjectCode());
            displaySubjectCredits.setText("Credits: " + subject.getCredits());
        }

        // Обробка натискання на кнопку "Назад"
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Повернення на MainActivity
                finish(); // Це закриває DisplayActivity і повертає до MainActivity
            }
        });
    }
}
