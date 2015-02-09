package com.inspiron.tharun26.navdrawer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;


public class MainActivity extends MaterialNavigationDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void init(Bundle bundle) {

        // add accounts
        MaterialAccount account = new MaterialAccount(this.getResources(),"Manusys","CEG,Manufacturing Department", R.drawable.manusys_logo_bw, R.drawable.cover);
        this.addAccount(account);

        //MaterialAccount account2 = new MaterialAccount(this.getResources(),"Hatsune Miky","hatsune.miku@example.com",R.drawable.photo2,R.drawable.mat2);
        //this.addAccount(account2);

        //MaterialAccount account3 = new MaterialAccount(this.getResources(),"Example","example@example.com",R.drawable.photo,R.drawable.mat3);
        //this.addAccount(account3);

        // create sections
        this.addSection(newSection("Home",R.drawable.home ,new FragmentIndex()).setSectionColor(Color.parseColor("#9c27b0")));
        this.addSection(newSection("Events",R.drawable.events,new FragmentIndex()).setSectionColor(Color.parseColor("#03a9f4")));
      //  this.addSection(newSection("Workshops",R.drawable.workshops,new FragmentIndex()).setSectionColor(Color.parseColor("#9c27b0")));
        this.addSection(newSection("Workshops",R.drawable.workshops,new Intent(this,workshops.class)));


        this.addSection(newSection("Sponsors",R.drawable.sponsors,new FragmentButton()).setSectionColor(Color.parseColor("#9c27b0")));
        this.addSection(newSection("Accomodation",R.drawable.ic_hotel_grey600_24dp,new FragmentButton()).setSectionColor(Color.parseColor("#03a9f4")));
        this.addSection(newSection("Contacts",R.drawable.contacts,new FragmentButton()).setSectionColor(Color.parseColor("#03a9f4")));
        this.addSection(newSection("About",R.drawable.about,new FragmentButton()).setSectionColor(Color.parseColor("#03a9f4")));

        // create bottom section
        this.addBottomSection(newSection("Bottom Section",R.drawable.ic_settings_black_24dp,new Intent(this,Settings.class)));


    }
}
