package com.inspiron.tharun26.navdrawer;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

import se.emilsjolander.flipview.FlipView;
import se.emilsjolander.flipview.OverFlipMode;


public class Event1 extends ActionBarActivity  implements FlipAdapterEvent1.Callback, FlipView.OnFlipListener, FlipView.OnOverFlipListener {

    private FlipView mFlipView;
    private FlipAdapterEvent1 mAdapter;

    private String[] event_titles;
    private TypedArray event_icons;
    private ArrayList<EventInformation> eventInformations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event1);
        event_titles = getResources().getStringArray(R.array.events_info);
        event_icons = getResources().obtainTypedArray(R.array.events_info_images);

        eventInformations = new ArrayList<EventInformation>();

        eventInformations.add(new EventInformation(event_titles[0], event_icons.getResourceId(0, -1)));
        eventInformations.add(new EventInformation(event_titles[1], event_icons.getResourceId(1, -1)));
        eventInformations.add(new EventInformation(event_titles[2], event_icons.getResourceId(2, -1)));
        eventInformations.add(new EventInformation(event_titles[3], event_icons.getResourceId(3, -1)));
//        eventInformations.add(new EventInformation(event_titles[4], event_icons.getResourceId(4, -1)));

        // Log.i("DEbug"," "+event_titles[0]+event_titles[1]+event_titles[2]+event_titles[3]+event_titles[4]);
        event_icons.recycle();

        mFlipView = (FlipView) findViewById(R.id.flip_view);
        mAdapter = new FlipAdapterEvent1(this,eventInformations);
        mAdapter.setCallback(this);
        mFlipView.setAdapter(mAdapter);

        mFlipView.setOnFlipListener(this);
        mFlipView.peakNext(false);
        mFlipView.setOverFlipMode(OverFlipMode.RUBBER_BAND);
        mFlipView.setEmptyView(findViewById(R.id.empty_view));
        mFlipView.setOnOverFlipListener(this);






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageRequested(int page) {
        mFlipView.smoothFlipTo(page);
    }

    @Override
    public void onFlippedToPage(FlipView flipView, int i, long l) {
        Log.i("pageflip", "Page: " + i);
        if (i>0) {

            mFlipView.peakPrevious(false);
        }

        }

    @Override
    public void onOverFlip(FlipView flipView, OverFlipMode overFlipMode, boolean b, float v, float v2) {

        Log.i("overflip", "overFlipDistance = "+v);
    }
}
