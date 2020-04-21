package com.example.lab3recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.PersonViewHolder> {

    //Здесь хранятся объекты с информацией о группах
    private static List<MusicGroup> data;
    //Для открытия нового окна по нажатию кнопки
    private static Context context;

    MyAdapter(List<MusicGroup> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Дерево элементов
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout, viewGroup, false);
        PersonViewHolder holder = new PersonViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder personViewHolder, int i) {
        //Заполнение элементов view данными из списка обьектов
        personViewHolder.groupName.setText(data.get(i).getGroupName());
        personViewHolder.groupGenre.setText(data.get(i).getGroupGenre());
        personViewHolder.groupYear.setText(data.get(i).getGroupYearOfFoundation());
        personViewHolder.groupDescription.setText(data.get(i).getGroupDescription());
        personViewHolder.groupImage.setImageResource(data.get(i).getGroupIcon());
        personViewHolder.position = i;
    }

    //Размер списка
    @Override
    public int getItemCount() {
        return data.size();
    }

    static class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView groupName;
        TextView groupGenre;
        TextView groupYear;
        TextView groupDescription;
        ImageView groupImage;
        Button button;
        int position;
        PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            //Устанавливаем элементы view на странице
            groupName = itemView.findViewById(R.id.groupName);
            groupGenre = itemView.findViewById(R.id.groupGenre);
            groupYear = itemView.findViewById(R.id.groupYear);
            groupDescription = itemView.findViewById(R.id.groupDescription);
            groupImage = itemView.findViewById(R.id.image);
            button = itemView.findViewById(R.id.button);
            //Обработчик нажатия на кнопку
            button.setOnClickListener(v -> {
                Intent intent = new Intent(context, MusicGroupInfoActivity.class);
                //Передаем данные о группе для отображения в новом окне
                intent.putExtra("groupIcon",data.get(position).getGroupIcon());
                intent.putExtra("groupName",data.get(position).getGroupName());
                intent.putExtra("groupYear",data.get(position).getGroupYearOfFoundation());
                intent.putExtra("groupGenre",data.get(position).getGroupGenre());
                intent.putExtra("groupInfo",data.get(position).getGroupInfo());
                //Открываем новую активность
                context.startActivity(intent);
            });
        }
    }
}