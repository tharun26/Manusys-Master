package com.inspiron.tharun26.navdrawer;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by tharun on 9/2/15
 */
public class FragmentIndex extends Fragment {

    private ListView event_list;
    private String[] event_titles;
    private TypedArray event_icons;
    private ArrayList<EventItem> event_Items;
    private  EventListAdapter adapter;


    public FragmentIndex(){}

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);



        event_titles = getResources().getStringArray(R.array.events);

        // nav drawer icons from resources
        event_icons = getResources()
                .obtainTypedArray(R.array.events_images);


        // mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        event_Items = new ArrayList<EventItem>();

        // adding nav drawer items to array
        // Home
        event_Items.add(new EventItem(event_titles[0], event_icons.getResourceId(0, -1)));
        // Find People
        event_Items.add(new EventItem(event_titles[1], event_icons.getResourceId(1, -1)));
        // Photos
        event_Items.add(new EventItem(event_titles[2],  event_icons.getResourceId(2, -1)));
        // Communities, Will add a counter here
        event_Items.add(new EventItem(event_titles[3],  event_icons.getResourceId(3, -1)));
        // Pages
        event_Items.add(new EventItem(event_titles[4],  event_icons.getResourceId(4, -1)));

        event_Items.add(new EventItem(event_titles[5],  event_icons.getResourceId(5, -1)));
        event_Items.add(new EventItem(event_titles[6],  event_icons.getResourceId(6, -1)));
        event_Items.add(new EventItem(event_titles[7],  event_icons.getResourceId(7, -1)));
        event_Items.add(new EventItem(event_titles[8],  event_icons.getResourceId(8, -1)));
        event_Items.add(new EventItem(event_titles[9],  event_icons.getResourceId(9, -1)));
        event_Items.add(new EventItem(event_titles[10],  event_icons.getResourceId(10, -1)));
        // What's hot, We  will add a counter here
      /*
        event_Items.add(new EventItem(event_titles[5],  event_icons.getResourceId(5, -1)));

        event_Items.add(new  EventItem(event_titles[6],  event_icons.getResourceId(6, -1)));

        event_Items.add(new EventItem(event_titles[7],  event_icons.getResourceId(7, -1)));
    */


        adapter = new EventListAdapter(getActivity(),event_Items);
        event_list= (ListView) getActivity().findViewById(R.id.list123);
        event_list.setAdapter(adapter);






        /*

        // Recycle the typed array
        event_icons.recycle();

        // setting the nav drawer list adapter
        adapter = new EventListAdapter(getActivity(),event_Items);
        setListAdapter(adapter);
        */
        // ListView list = getListView();
        event_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               /* Toast.makeText(getActivity(),
                        "Item in position " + position + " clicked",
                        Toast.LENGTH_LONG).show();
                */
                displayView(position);
            }
        });










       /* String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
        */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_events, container, false);




        return rootView;
    }


    private void displayView(int position) {
        // update the main content by replacing fragments

        switch (position) {
            case 0:
               /*
                Toast.makeText(getActivity(),
                        "Item in position " + position + " clicked",
                        Toast.LENGTH_LONG).show();
               */
                Intent intent1=new Intent(getActivity(),Event1.class);
                startActivity(intent1);

                //  fragment = new HomeFragment();
                break;
            case 1:
                Intent intent2=new Intent(getActivity(),Event2.class);
                startActivity(intent2);

                //  fragment = new EventsFragment();

                break;
            case 2:
                Intent intent3=new Intent(getActivity(),Event3.class);
                startActivity(intent3);
                //     fragment = new PhotosFragment();
                break;
            case 3:
                Intent intent4=new Intent(getActivity(),Event4.class);
                startActivity(intent4);
                //     fragment = new CommunityFragment();
                break;
            case 4:
                Intent intent5=new Intent(getActivity(),Event5.class);
                startActivity(intent5);
                //     fragment = new PagesFragment();
                break;
            case 5:
                Intent intent6=new Intent(getActivity(),Event6.class);
                startActivity(intent6);
                //     fragment = new WhatsHotFragment();
                break;
            case 6:
                Intent intent7=new Intent(getActivity(),Event7.class);
                startActivity(intent7);
                //     fragment = new WhatsHotFragment();
                break;
            case 7:
                Intent intent8=new Intent(getActivity(),Event8.class);
                startActivity(intent8);
                //     fragment = new WhatsHotFragment();
                break;
            case 8:
                Intent intent9=new Intent(getActivity(),Event9.class);
                startActivity(intent9);
                //     fragment = new WhatsHotFragment();
                break;
            case 9:
                Intent intent10=new Intent(getActivity(),Event10.class);
                startActivity(intent10);
                //     fragment = new WhatsHotFragment();
                break;
            case 10:
                Intent intent11=new Intent(getActivity(),Event11.class);
                startActivity(intent11);
                //     fragment = new WhatsHotFragment();
                break;
            case 11:
              //  Intent intent12=new Intent(getActivity(),Event12.class);
              //  startActivity(intent12);
                //     fragment = new WhatsHotFragment();
                break;


            default:
                break;
        }
    }




}