package com.example.bdsta_viz.ui.aboutApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.bdsta_viz.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/********************************************************************************
 *  AboutApp class:   This class uses WebView to display the project website    *
 *                    when the user clicks on 'About the App' in the Navigation *
 *                    Drawer.                                                   *
 *                                                                              *
 * @author Md Rakeen Murtaza (rakeen.murtaza.12@gmail.com)                      *
 ********************************************************************************/

public class AboutAppFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_about_app, container, false);

        WebView webView = (WebView)root.findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        webView.setWebViewClient(new WebViewClient()); // To open URL within app
        webView.loadUrl("https://www.lrkhan.com/bd-sta-viz?fbclid=IwAR1e6BFwMr-F-tkfv3FtYg5J13WZ4afNoQJL6KPv-2_IzRlvZkSYP3CmsCo");

        return root;
    }
}