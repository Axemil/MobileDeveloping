package com.example.laba43;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 pager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.table);

        //Создаем наш адаптер для ViewPager
        MyAdapter adapter = new MyAdapter(this);
        //Передаем ему три фрагмента
        adapter.addFragment(new FirstFragment());
        adapter.addFragment(new SecondFragment());
        adapter.addFragment(new ThirdFragment());
        //Устанавливаем адаптер
        pager.setAdapter(adapter);

        //Прикрепляем TabLayout и передаем ему индекс фрагмента для отображения названий
        new TabLayoutMediator(tabLayout,pager, (tab, position) -> {
            tab.setText("Tab" + (position + 1));
        }).attach();
    }
}
