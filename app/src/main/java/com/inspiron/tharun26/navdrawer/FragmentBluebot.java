package com.inspiron.tharun26.navdrawer;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tharun26 on 9/2/15.
 */
public class FragmentBluebot extends Fragment{
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        ImageButton call=(ImageButton)getActivity().findViewById(R.id.bluebotcall);
        call.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9677109794"));
                startActivity(intent);


            }
        });
        ImageButton gmail=(ImageButton)getActivity().findViewById(R.id.bluebotmail);
        gmail.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gmail = new Intent(Intent.ACTION_VIEW);
                gmail.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                gmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"bluetoothrobotics@gmail.com"});
                //gmail.setData(Uri.parse("tharun26@gmail.com"));
                gmail.putExtra(Intent.EXTRA_SUBJECT, "Query");
                gmail.setType("plain/text");
                gmail.putExtra(Intent.EXTRA_TEXT, "Hi,");
                startActivity(gmail);
            }
        });
    }
    public static FragmentBluebot newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FragmentBluebot fragment = new FragmentBluebot();
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
        View view = inflater.inflate(R.layout.fragment_bluebot, container, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.about_title);
        //tvTitle.setText("Fragment #" + mPage);
        return view;
    }
}
