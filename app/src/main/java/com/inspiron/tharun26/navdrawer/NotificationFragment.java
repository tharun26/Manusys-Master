package com.inspiron.tharun26.navdrawer;

/**
 * Created by tharun26 on 16/2/15.
 */
import android.support.v4.app.Fragment;

        import android.content.res.TypedArray;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ListView;

        import com.inspiron.tharun26.navdrawer.NotificationListAdapter;

        import java.util.ArrayList;
        import java.util.List;

        import com.inspiron.tharun26.navdrawer.NotificationItem;

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

public class NotificationFragment extends Fragment {




    private ListView notification_list;
    public static String[] notification_title=new String[50] ;
    private TypedArray notification_icons;
    private  ArrayList<NotificationItem> notification_Items;
    private NotificationListAdapter notification_adapter;

    public NotificationFragment(){}

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        notification_title = getResources().getStringArray(R.array.designation);

        notification_Items = new ArrayList<NotificationItem>();

        DatabaseHandler db = new DatabaseHandler(getActivity());
        //Log.d("Insert: ", "Inserting ..");
        //db.addNotification(new NotificationDb(newMessage));
        Log.d("Reading: ", "Notification Reading all contacts..");
        List<NotificationDb> notificationDbs = db.getAllContacts();

        int x=0;
        for (NotificationDb cn : notificationDbs) {
            //      db.deleteContact(cn);
            notification_title[x++]=cn.getNotification();
            String log = "Id: "+cn.getId()+" ,Name: " + cn.getNotification()  ;
            //  Writing Contacts to log
            Log.d("Name: ", log+"**"+x);

        }




        int i;
        for(i=x-1;i>=0;i--) {
            notification_Items.add(new NotificationItem(notification_title[i]));
            // notification_Items.add(new NotificationItem("Welcome to Manusys!!"));
        }



        notification_adapter = new NotificationListAdapter(getActivity(),notification_Items);
        notification_list= (ListView) getActivity().findViewById(R.id.list_notification);
        notification_list.setAdapter(notification_adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_notification, container, false);

        return rootView;
    }
}