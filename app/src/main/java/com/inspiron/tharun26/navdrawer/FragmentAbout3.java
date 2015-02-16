package com.inspiron.tharun26.navdrawer;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tharun26 on 9/2/15.
 */
public class FragmentAbout3 extends Fragment{
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageButton fb=(ImageButton)getActivity().findViewById(R.id.facebook);
        ImageButton call=(ImageButton)getActivity().findViewById(R.id.call);
        ImageButton gmail=(ImageButton)getActivity().findViewById(R.id.gmail);
        fb.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String urlFb = "fb://page/"+"9gag";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlFb));



                final String urlBrowser = "https://www.facebook.com/tharun26";
                intent.setData(Uri.parse(urlBrowser));


                startActivity(intent);

            }
        });
        call.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:8056097997"));
                startActivity(intent);

            }
        });
        gmail.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gmail = new Intent(Intent.ACTION_VIEW);
                gmail.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");
                gmail.putExtra(Intent.EXTRA_EMAIL, new String[] { "tharun26@gmail.com" });
                gmail.setData(Uri.parse("tharun26@gmail.com"));
                gmail.putExtra(Intent.EXTRA_SUBJECT, "Dev:Manusys");
                gmail.setType("plain/text");
                gmail.putExtra(Intent.EXTRA_TEXT, "Hi Tharun");
                startActivity(gmail);

            }
        });
    }

    public static FragmentAbout3 newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FragmentAbout3 fragment = new FragmentAbout3();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);







    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_3, container, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.about_title3);
        //  tvTitle.setText("Fragment #" + mPage);
        return view;
    }
}
