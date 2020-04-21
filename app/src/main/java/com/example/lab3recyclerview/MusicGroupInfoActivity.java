package com.example.lab3recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicGroupInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_group_info);
        ImageView image = findViewById(R.id.image);
        TextView groupName = findViewById(R.id.groupName);
        TextView groupYear = findViewById(R.id.groupYear);
        TextView groupGenre = findViewById(R.id.groupGenre);
        TextView groupInfo = findViewById(R.id.groupInfo);
        //Устанавливаем информацию о группе полученную из предыдущего окна
        image.setImageResource(getIntent().getExtras().getInt("groupIcon"));
        groupName.setText(getIntent().getExtras().getInt("groupName"));
        groupYear.setText(getIntent().getExtras().getInt("groupYear"));
        groupGenre.setText(getIntent().getExtras().getInt("groupGenre"));
        groupInfo.setText(getIntent().getExtras().getInt("groupInfo"));
    }

    //По нажатию на кнопку назад,открывается главное окно со списком
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}