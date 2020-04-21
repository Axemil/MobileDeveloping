package com.example.laba3list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = findViewById(R.id.listView);
        //Лист в котором будут храниться объект с информацией о группе
        List<MusicGroup> musicGroupList = setDataToList();
        //Адаптер для отображения элементов списка
        MyAdapter adapter = new MyAdapter(musicGroupList,this);
        // Устанавливаем наш адаптер для ListView
        list.setAdapter(adapter);
    }

    //В методе создается 6 объектов MusicGroup,заполняются данными и добавляются в List
    private List<MusicGroup> setDataToList() {
        List<MusicGroup> list = new ArrayList<>();
        //Данные о группах беруться из ресурсов в файле strings
        MusicGroup metalicaGroup = new MusicGroup(
                R.string.metalica_name,R.string.metalica_genre,R.string.metalica_year,
                R.drawable.metalica, R.string.metalica_description,
                R.string.metalica_info);

        MusicGroup queenGroup = new MusicGroup(
                R.string.queen_name,R.string.queen_genre,R.string.queen_year,
                R.drawable.queen, R.string.queen_description,
                R.string.queen_info);

        MusicGroup beatlesGroup = new MusicGroup(
                R.string.beatles_name,R.string.beatles_genre,R.string.beatles_year,
                R.drawable.beatles, R.string.beatles_description,
                R.string.beatles_info);

        MusicGroup rollingStonesGroup = new MusicGroup(
                R.string.rollingStones_name,R.string.rollingStones_genre,R.string.rollingStones_year,
                R.drawable.stones, R.string.rollingStones_description,
                R.string.rollingStones_info);

        MusicGroup acdcGroup = new MusicGroup(
                R.string.acdc_name,R.string.acdc_genre,R.string.acdc_year,
                R.drawable.acdc, R.string.acdc_description,
                R.string.acdc_info);

        MusicGroup gunsNrosesGroup = new MusicGroup(
                R.string.gunsNroses_name,R.string.gunsNroses_genre,R.string.gunsNroses_year,
                R.drawable.guns, R.string.gunsNroses_description,
                R.string.gunsNroses_info);

        //Создаем наш список с объектами
        list.add(metalicaGroup);
        list.add(queenGroup);
        list.add(beatlesGroup);
        list.add(rollingStonesGroup);
        list.add(acdcGroup);
        list.add(gunsNrosesGroup);
        return list;
    }
}
