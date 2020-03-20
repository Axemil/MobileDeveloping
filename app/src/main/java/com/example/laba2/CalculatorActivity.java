package com.example.laba2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    //Переменная в которой будет храниться результат вычислений для отправки в главную активность
     private double resultInMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        plusButtonOnClick();
        minusButtonOnClick();
    }

    //Обработка нажатия на кнопку 1 способом
    public void multiplicationButtonOnClick(View view) {
        multiplyNumbers();
    }

    //Обработка нажатия на кнопку 1 способом
    public void divisionButtonOnClick(View view) {
        divideNumbers();
    }

    //Обработка нажатия на кнопку 2 способом
    private void plusButtonOnClick() {
        Button button = findViewById(R.id.plusButton);
        button.setOnClickListener(v -> {
            addNumbers();
        });
    }

    //Обработка нажатия на кнопку 2 способом
    private void  minusButtonOnClick() {
        Button button = findViewById(R.id.minusButton);
        button.setOnClickListener(v -> {
            subtractNumbers();
        });
    }

    //Метод который перемножает числа
    private void multiplyNumbers() {
        //Находим формы куда были вписаны числа
        EditText firstString = findViewById(R.id.firstNumberInput);
        EditText secondString = findViewById(R.id.secondNumberInput);
        //Проверка на то что указано два числа
        if (firstString.getText().toString().trim().isEmpty()  || secondString.getText().toString().trim().isEmpty()) {
            //Вывод всплывающего сообщения
            displayErrorMessage("Укажите два числа!");
        } else {
            //Получаем из строки числа
            double firstNumber = convertStringToDouble(firstString);
            double secondNumber = convertStringToDouble(secondString);
            //Отображение результата операции
            displayResult(firstNumber * secondNumber);
        }
    }

    //Метод для деления чисел
    private void divideNumbers() {
        //Находим формы куда были вписаны числа
        EditText firstString = findViewById(R.id.firstNumberInput);
        EditText secondString = findViewById(R.id.secondNumberInput);
        //Проверка на то что указано два числа
        if(firstString.getText().toString().trim().isEmpty()  ||secondString.getText().toString().trim().isEmpty()  ) {
            //Вывод всплывающего сообщения
            displayErrorMessage("Укажите два числа!");
        } else {
            //Получаем из строки числа
            double firstNumber = convertStringToDouble(firstString);
            double secondNumber = convertStringToDouble(secondString );
            //Проверка деления на ноль,если второе число не 0,выполняем операцию
            if(!checkIfDivisionByZero(secondNumber))
                //Отображение результата операции
                displayResult(firstNumber / secondNumber);
        }
    }

    //Метод для сложения чисел
    private void addNumbers() {
        //Находим формы куда были вписаны числа
        EditText firstString = findViewById(R.id.firstNumberInput);
        EditText secondString = findViewById(R.id.secondNumberInput);
        //Проверка на то что указано два числа
        if(firstString.getText().toString().trim().isEmpty()  ||secondString.getText().toString().trim().isEmpty()  ) {
            //Вывод всплывающего сообщения
            displayErrorMessage("Укажите два числа!");
        } else {
            //Получаем из строки числа
            double firstNumber = convertStringToDouble(firstString);
            double secondNumber = convertStringToDouble(secondString);
            //Отображение результата операции
            displayResult(firstNumber + secondNumber);
        }
    }

    //Метод для вычитания чисел
    private void subtractNumbers() {
        //Находим формы куда были вписаны числа
        EditText firstString = findViewById(R.id.firstNumberInput);
        EditText secondString = findViewById(R.id.secondNumberInput);
        //Проверка на то что указано два числа
        if(firstString.getText().toString().trim().isEmpty()  ||secondString.getText().toString().trim().isEmpty()  ) {
            //Вывод всплывающего сообщения
            displayErrorMessage("Укажите два числа!");
        } else {
            //Получаем из строки числа
            double firstNumber = convertStringToDouble(firstString);
            double secondNumber = convertStringToDouble(secondString);
            //Отображение результата операции
            displayResult(firstNumber - secondNumber);
        }
    }

    //Метод который отображает результат операций
    private void displayResult(double result) {
        TextView textView = findViewById(R.id.resultView);
        textView.setText(Double.toString(result));
        resultInMessage = result;
    }

    //Метод который создает и показывает всплывающее окно
    private void displayErrorMessage(String string) {
        Toast toast = Toast.makeText(this,string,Toast.LENGTH_LONG);
        toast.show();
    }

    //Метод который конвертирует текст из формы в дабл значение
    private double convertStringToDouble(EditText str) {
        return Double.parseDouble(str.getText().toString());
    }

    //Проверка на то является ли второе число нулем
    private boolean checkIfDivisionByZero (double secondNumber) {
        if (secondNumber == 0) {
            displayErrorMessage("На ноль делить нельзя!");
            return  true;
        }
        return false;
    }

    //Обработка нажатия кнопки назад на устройстве
    @Override
    public void onBackPressed() {
        sendMessage();
    }

    //Отправка результата в главную активность
    private void sendMessage() {
        // Формируем "пустое" намерение
        Intent intent = new Intent();
        // Добавляем в намерение данные
        intent.putExtra("result",Double.toString(resultInMessage));
        // Устанавливаем результат
        setResult(RESULT_OK,intent);
        //Закрываем текущую активность
        finish();
    }

}