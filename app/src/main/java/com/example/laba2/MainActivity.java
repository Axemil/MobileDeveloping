package com.example.laba2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Переменная которая помогает определить с нужной ли активности мы получили результат
    private static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openCalcOnClick();
        openBrowserOnClick();
    }

    //Обработка нажатия на первую кнопку
    private void openCalcOnClick() {
        Button button = findViewById(R.id.openCalc);
        button.setOnClickListener(v -> {
            openCalculatorActivity();
        });
    }

    //Открытие активности с помощью явного намерения
    private void openCalculatorActivity() {
        Intent intent = new Intent(this, CalculatorActivity.class);
        //Открытие активности для получения результата
        startActivityForResult(intent, REQUEST_CODE);
    }

    //Обработка нажатия на вторую кнопку
    private void openBrowserOnClick() {
        Button button = findViewById(R.id.openOther);
        button.setOnClickListener(v -> {
           openBrowser();
        });
    }

    //Открытие активности с не явным намерением
    public void openBrowser() {
        Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
        // Получаем Package Manager
        PackageManager manager = this.getPackageManager();
        // Получаем список обработчиков намерения
        List<ResolveInfo> list = manager.queryIntentActivities(i, 0);
        //Проверка на то что есть приложение которое может открытся через не явный вызов
        if (list.size() > 0) {
            startActivity(i);
        } else {
            Toast.makeText(this,"Невозможно обработать намерение!",Toast.LENGTH_LONG).show();
        }
    }

    //Метод для отображения полученного результата из активности калькулятор
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //Отображение результат в всплывающем сообщении
            Toast.makeText(this,"Результат: " + data.getStringExtra("result"),Toast.LENGTH_LONG).show();
        }
    }

}
