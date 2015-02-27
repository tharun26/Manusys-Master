package com.inspiron.tharun26.navdrawer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neokree on 31/12/14.
 */
public class FragmentContacts extends Fragment{
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
     // getActivity().setContentView(R.layout.fragment_contacts);

        GridView gridView = (GridView)getActivity().findViewById(R.id.gridview);
        gridView.setAdapter(new MyAdapter(getActivity().getApplicationContext()));

        gridView.setOnItemClickListener(new GridView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // this 'mActivity' parameter is Activity object, you can send the current activity.
                if(position==0) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:9003833066"));
                    startActivity(intent);
                }
                else if(position==1)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:9952011991"));
                    startActivity(intent);
                }
                else if(position==2)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:9894317232"));
                    startActivity(intent);
                }
                else if(position==3)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:96771097994"));
                    startActivity(intent);
                }else if(position==4)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:96771097994"));
                    startActivity(intent);
                }else if(position==5)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:96771097994"));
                    startActivity(intent);
                }else if(position==6)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:96771097994"));
                    startActivity(intent);
                }
                else if(position==7)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:96771097994"));
                    startActivity(intent);
                }





            }
        });

    }
    private class MyAdapter extends BaseAdapter {
        private List<Item> items = new ArrayList<Item>();
        private LayoutInflater inflater;

        public MyAdapter(Context context) {
            inflater = LayoutInflater.from(context);

            items.add(new Item("Indarajith J.S", R.drawable.gensec1,"General Secretary"));
            items.add(new Item("Athithyan K", R.drawable.pub1,"Public Relations"));
            items.add(new Item("Karupasamy S", R.drawable.jointsec,"Joint Secretary"));

            /*items.add(new Item("Image 4", R.drawable.default_male,"Presi"));
            items.add(new Item("Image 5", R.drawable.default_male,"Chairman"));
            items.add(new Item("Image 3", R.drawable.defaultfemale,"Chairman"));
            items.add(new Item("Image 4", R.drawable.default_male,"President"));
            items.add(new Item("Image 3", R.drawable.defaultfemale,"Chairman"));
            items.add(new Item("Image 4", R.drawable.default_male,"President"));
            */
        //    items.add(new Item("Image 3", R.drawable.tree1));
         //   items.add(new Item("Image 4", R.drawable.nature3));
          //  items.add(new Item("Image 5", R.drawable.tree2));
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return items.get(i).drawableId;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = view;
            ImageView picture;
            TextView name;
            TextView position;

            if (v == null) {
                v = inflater.inflate(R.layout.gridview_item, viewGroup, false);
                v.setTag(R.id.picture, v.findViewById(R.id.picture));
                v.setTag(R.id.text, v.findViewById(R.id.text));
                v.setTag(R.id.text1,v.findViewById(R.id.text1));
            }

            picture = (ImageView) v.getTag(R.id.picture);
            name = (TextView) v.getTag(R.id.text);
            position=(TextView)v.getTag(R.id.text1);
            Item item = (Item) getItem(i);

            picture.setImageResource(item.drawableId);
            name.setText(item.name);
            position.setText(item.position);


            return v;
        }
    }
        private class Item
        {
            final String name;
            final int drawableId;
            final String position;
            Item(String name, int drawableId,String position)
            {
                this.name = name;
                this.drawableId = drawableId;
                this.position=position;
            }
        }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }




}
