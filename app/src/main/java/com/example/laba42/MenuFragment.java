package com.example.laba42;

import androidx.fragment.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MenuFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    //Метод срабатывает когда фрагмент прикрепляется к активити
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    //Метод срабатывает когда фрагмент убирается из активити
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    //Интерфейс который позволяет передавать данные из этого фрагмента в другой
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String result);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button googleButton = view.findViewById(R.id.googleButton);
        Button facebookButton = view.findViewById(R.id.facebookButton);
        Button instagramButton = view.findViewById(R.id.instagramButton);
        Button twitterButton = view.findViewById(R.id.twitterButton);

        //Обработчики нажатий на кнопки
        googleButton.setOnClickListener(v -> {
            // Вызов метода из Activity и отправка данных
            String link = "https://www.google.com/";
            //Передача ссылки на сайт в фрагмент WebView
            mListener.onFragmentInteraction(link);
        });

        facebookButton.setOnClickListener(v -> {
            String link = "https://uk-ua.facebook.com/";
            mListener.onFragmentInteraction(link);
        });

        instagramButton.setOnClickListener(v -> {
            String link = "https://www.instagram.com/";
            mListener.onFragmentInteraction(link);
        });

        twitterButton.setOnClickListener(v -> {
            String link = "https://twitter.com/explore";
            mListener.onFragmentInteraction(link);
        });
    }
}

