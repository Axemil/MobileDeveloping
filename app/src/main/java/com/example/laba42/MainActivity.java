package com.example.laba42;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener{
    private FragmentManager manager;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Заставляем приложение открываться в ландшафтной ориентации
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        //Устанавливаем фрагмент менеджер
        manager = getSupportFragmentManager();
        //Запуск транзакции для открытия фрагмента
        manager.beginTransaction()
                .add(R.id.frame1,new MenuFragment(),"frag1")
                .commit();
    }

    //Метод для передачи данных между фрагментами
    @Override
    public void onFragmentInteraction(String result) {
        //Запуск транзакции для открытия фрагмента
        manager.beginTransaction()
                .add(R.id.frame2,WebViewFragment.newInstance(result),"frag2")
                .commit();
    }
}
