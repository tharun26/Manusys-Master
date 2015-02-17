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
public class FragmentAccomodation extends Fragment{

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        // getActivity().setContentView(R.layout.fragment_contacts);

        GridView gridView = (GridView)getActivity().findViewById(R.id.gridview1);
        gridView.setAdapter(new MyAdapter1(getActivity().getApplicationContext()));



    }
    private class MyAdapter1 extends BaseAdapter {
        private List<Item1> items1 = new ArrayList<Item1>();
        private LayoutInflater inflater;

        public MyAdapter1(Context context) {
            inflater = LayoutInflater.from(context);

            items1.add(new Item1("Image 1", R.drawable.default_male));
            items1.add(new Item1("Image 2", R.drawable.default_male));
            items1.add(new Item1("Image 3", R.drawable.defaultfemale));
            /*items.add(new Item("Image 4", R.drawable.default_male,"President"));
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
            return items1.size();
        }

        @Override
        public Object getItem(int i) {
            return items1.get(i);
        }

        @Override
        public long getItemId(int i) {
            return items1.get(i).drawableId;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = view;
            ImageView picture;
            TextView name;
           // TextView position;

            if (v == null) {
                v = inflater.inflate(R.layout.gridview1_item, viewGroup, false);
                v.setTag(R.id.picture, v.findViewById(R.id.picture1));
                v.setTag(R.id.text, v.findViewById(R.id.text1));
//                v.setTag(R.id.text1,v.findViewById(R.id.text1));
            }

            picture = (ImageView) v.getTag(R.id.picture);
            name = (TextView) v.getTag(R.id.text);
  //          position=(TextView)v.getTag(R.id.text1);
            Item1 item1 = (Item1) getItem(i);

            picture.setImageResource(item1.drawableId);
            name.setText(item1.name);
           // position.setText(item.position);


            return v;
        }
    }
    private class Item1
    {
        final String name;
        final int drawableId;

        Item1(String name, int drawableId)
        {
            this.name = name;
            this.drawableId = drawableId;
            //this.position=position;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_accomodation, container, false);
    }




}
