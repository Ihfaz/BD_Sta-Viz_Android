package com.example.bdsta_viz.ui.aboutUs;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bdsta_viz.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/********************************************************************************
 *  AboutUs class:    This class displays contact information of the developers *
 *                    who created this app.                                     *
 *                                                                              *
 * @author Md Rakeen Murtaza (rakeen.murtaza.12@gmail.com)                      *
 ********************************************************************************/

public class AboutUsFragment extends Fragment {

    private AboutUsViewModel aboutUsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_about_us, container, false);

        // Open Professor's website
        TextView profWeb = (TextView) root.findViewById(R.id.professor_website);
        profWeb.setMovementMethod(LinkMovementMethod.getInstance());

        // Open Professor's email
        TextView profEmail = (TextView) root.findViewById(R.id.professor_email);
        profEmail.setMovementMethod(LinkMovementMethod.getInstance());

        // Open Rakeen's Website
        TextView rakWeb = (TextView) root.findViewById(R.id.dev1_website);
        rakWeb.setMovementMethod(LinkMovementMethod.getInstance());

        // Open Rakeen's Email
        TextView rakEmail = (TextView) root.findViewById(R.id.dev1_email);
        rakEmail.setMovementMethod(LinkMovementMethod.getInstance());

        return root;
    }
}