package com.inspiron.tharun26.navdrawer;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.BaseAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tharun26 on 10/2/15.
 */
public class FlipAdapterEvent7 extends BaseAdapter implements ImageView.OnClickListener {

    public interface Callback{
        public void onPageRequested(int page);
    }

   /* static class Item {
        static long id = 0;

        long mId;

        public Item() {
            mId = id++;
        }

        long getId(){
            return mId;
        }
    }*/

    private LayoutInflater inflater;
    private Callback callback;
    private List<EventInformation> eventInformation ;
    private Context context;

    public FlipAdapterEvent7(Context context,ArrayList<EventInformation> eventInformation) {

        this.context=context;
        this.eventInformation=eventInformation;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public int getCount() {
        return eventInformation.size();
    }

    @Override
    public Object getItem(int position) {
        return eventInformation.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(position==0)
        {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.page_event7_intro, null);
        }
        else if(position==1 ) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.page_event7_rules, null);
           /* ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imageView);
            TextView txtTitle = (TextView) convertView.findViewById(R.id.text_event_1);
            txtTitle.setText(eventInformation.get(position).getEvent_info_title());
            imgIcon.setImageResource(eventInformation.get(position).getIcon());*/
        }
        else if(position==2 ) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.page_event7_venue, null);
            ImageView event1_venue=(ImageView)convertView.findViewById(R.id.venue_event7);
            event1_venue.setOnClickListener(this);
         /*   ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imageView);
            TextView txtTitle = (TextView) convertView.findViewById(R.id.text_event_1);
            txtTitle.setText(eventInformation.get(position).getEvent_info_title());
            imgIcon.setImageResource(eventInformation.get(position).getIcon());
            */


        }
        else if(position==3 ) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.page_event7_contact, null);
            ImageView contact1_event_1=(ImageView)convertView.findViewById(R.id.contact1_event_7);
            contact1_event_1.setOnClickListener(this);
          /*  ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imageView);
            TextView txtTitle = (TextView) convertView.findViewById(R.id.text_event_1);
            txtTitle.setText(eventInformation.get(position).getEvent_info_title());
            imgIcon.setImageResource(eventInformation.get(position).getIcon());
            */
        }




        return convertView;

       /*
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.page_event_1, parent, false);

            holder.text = (TextView) convertView.findViewById(R.id.text_event_1);
            holder.firstPage = (Button) convertView.findViewById(R.id.first_page_event_1);
            holder.lastPage = (Button) convertView.findViewById(R.id.last_page_event_1);

            holder.firstPage.setOnClickListener(this);
            holder.lastPage.setOnClickListener(this);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        //TODO set a text with the id as well
        holder.text.setText(items.get(position).getId()+":"+position);

        return convertView;
        */

    }

    static class ViewHolder{
        TextView text;
        Button firstPage;
        Button lastPage;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.first_page_event_1:
                if(callback != null){
                    callback.onPageRequested(0);
                }
                break;
            case R.id.last_page_event_1:
                if(callback != null){
                    callback.onPageRequested(getCount()-1);
                }
                break;
            case R.id.venue_event7:
                double lat=13.011859,lng=80.234472;
                String strUri = "http://maps.google.com/maps?q=loc:" + lat + "," + lng + " (" + "Label which you want" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));

                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                context.startActivity(intent);
                break;
            case R.id.contact1_event_7:
                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:9789027099"));
                context.startActivity(intent1);
                break;

        }

    }

    /*
    public void addItems(int amount) {
        for(int i = 0 ; i<amount ; i++){
            items.add(new Item());
        }
        notifyDataSetChanged();
    }

    public void addItemsBefore(int amount) {
        for(int i = 0 ; i<amount ; i++){
            items.add(0, new Item());
        }
        notifyDataSetChanged();
    }
    */

}