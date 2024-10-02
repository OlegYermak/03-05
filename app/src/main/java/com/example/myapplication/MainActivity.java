package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSubjectName, editTextSubjectCode, editTextSubjectCredits;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Пошук EditText елементів
        editTextSubjectName = findViewById(R.id.editText_subject_name);
        editTextSubjectCode = findViewById(R.id.editText_subject_code);
        editTextSubjectCredits = findViewById(R.id.editText_subject_credits);

        // Пошук кнопки "Submit"
        buttonSubmit = findViewById(R.id.button_submit);

        // Обробка натискання на кнопку "Submit"
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Отримуємо введений текст
                String subjectName = editTextSubjectName.getText().toString().trim();
                String subjectCode = editTextSubjectCode.getText().toString().trim();
                String subjectCredits = editTextSubjectCredits.getText().toString().trim();

                // Перевірка на порожні поля
                if (TextUtils.isEmpty(subjectName)) {
                    editTextSubjectName.setError("Поле 'Назва предмета' потрібно заповнити");
                    return;
                }

                if (TextUtils.isEmpty(subjectCode)) {
                    editTextSubjectCode.setError("Поле 'Код предмета' потрібно заповнити");
                    return;
                }

                if (TextUtils.isEmpty(subjectCredits)) {
                    editTextSubjectCredits.setError("Поле 'Кредити' потрібно заповнити");
                    return;
                }

                try {
                    // Конвертуємо subjectCode і subjectCredits у відповідні типи
                    Subject subject = new Subject(subjectName, Integer.parseInt(subjectCode), Float.parseFloat(subjectCredits));

                    // Запускаємо другу активність
                    Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                    intent.putExtra("subject_data", subject);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Невірний формат для коду предмета або кредитів", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
