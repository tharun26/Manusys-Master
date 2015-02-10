package com.inspiron.tharun26.navdrawer;

//import android..Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tharun26 on 10/2/15.
 */
public class Fragment_Event1 extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static Fragment_Event1 newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Fragment_Event1 fragment = new Fragment_Event1();
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

       if(mPage==1) {
           View view = inflater.inflate(R.layout.fragment_event1_intro, container, false);
           TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
           //tvTitle.setText("Fragment #" + mPage);
           return view;
       }
        else if(mPage==2)
       {
           View view = inflater.inflate(R.layout.fragment_event1_rules, container, false);
           TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
           //tvTitle.setText("Fragment #" + mPage);
           return view;

       }
       else if(mPage==3)
       {
           View view = inflater.inflate(R.layout.fragment_event1_venue, container, false);
           TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
           //tvTitle.setText("Fragment #" + mPage);
           return view;

       }
       else if(mPage==4)
       {
           View view = inflater.inflate(R.layout.fragment_event1_contact, container, false);
           TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
           //tvTitle.setText("Fragment #" + mPage);
           return view;

       }
        return null;
    }
}
