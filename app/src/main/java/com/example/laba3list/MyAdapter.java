package com.example.laba3list;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    //Здесь хранятся объекты с информацией о группах
    private List<MusicGroup> data;
    //Дерево c View элементами
    private LayoutInflater inflater;
    //Для открытия нового окна по нажатию кнопки
    private Context context;

    public MyAdapter(List<MusicGroup> data, Context context) {
        this.data = data;
        this.context = context;
        this.inflater = LayoutInflater.from(context);;
    }

    //Метод хранит количество наших элементов в списке
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Проверяем, есть ли у нас пункт списка для повторного использования
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list, parent, false);

        // Получаем доступ к виджетам дерева объектов
        TextView groupName = convertView.findViewById(R.id.groupName);
        TextView groupGenre = convertView.findViewById(R.id.groupGenre);
        TextView groupYear = convertView.findViewById(R.id.groupYear);
        TextView groupDescription = convertView.findViewById(R.id.groupDescription);
        ImageView groupImage = convertView.findViewById(R.id.image);
        Button button = convertView.findViewById(R.id.button);

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

        //Меняем содержимое виджетов,заполняя их информацией о группе
        groupName.setText(data.get(position).getGroupName());
        groupGenre.setText(data.get(position).getGroupGenre());
        groupYear.setText(data.get(position).getGroupYearOfFoundation());
        groupDescription.setText(data.get(position).getGroupDescription());
        groupImage.setImageResource(data.get(position).getGroupIcon());
        //Возвращаем модифицированное дерево объектов
        return convertView;
    }
}