package com.inspiron.tharun26.navdrawer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tharun26 on 9/2/15.
 */
public class FragmentAbout1 extends Fragment{
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static FragmentAbout1 newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FragmentAbout1 fragment = new FragmentAbout1();
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
        View view = inflater.inflate(R.layout.fragment_about_1, container, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.about_title);
        //tvTitle.setText("Fragment #" + mPage);
        return view;
    }
}
