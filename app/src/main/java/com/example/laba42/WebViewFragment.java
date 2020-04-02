package com.example.laba42;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WebViewFragment extends Fragment {

    //Ключ по которому получаем сообщение из другого фрагмента
    private static final String ARG_KEY = "key";

    //Здесь хранится ссылка на веб-сайт, полученная из другого фрагмента
    private String webLink;
    private WebView webView;

    public WebViewFragment() {}

    public static WebViewFragment newInstance (String param1) {
        WebViewFragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_KEY, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Если получены данные, отображаем страницу веб-сайта
        if (getArguments() != null) {
            webLink = getArguments().getString(ARG_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_webview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webView = view.findViewById(R.id.webView);
        //Открываем веб-сайт
        webView.loadUrl(webLink);
    }
}
