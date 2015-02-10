package com.inspiron.tharun26.navdrawer;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.List;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;


public class MainActivity extends MaterialNavigationDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ImageView fabIconNew = new ImageView(this);
        fabIconNew.setImageDrawable(getResources().getDrawable(R.drawable.swatches));
        final FloatingActionButton rightLowerButton = new FloatingActionButton.Builder(this)
                .setContentView(fabIconNew)
                .build();

        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this);
        final ImageView rlIcon1 = new ImageView(this);
        final ImageView rlIcon2 = new ImageView(this);
        final ImageView rlIcon3 = new ImageView(this);
       // ImageView rlIcon4 = new ImageView(this);


        rlIcon1.setImageDrawable(getResources().getDrawable(R.drawable.whatsapp));
        rlIcon2.setImageDrawable(getResources().getDrawable(R.drawable.fb));
        rlIcon3.setImageDrawable(getResources().getDrawable(R.drawable.chrome));
        //rlIcon4.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));

        // Build the menu with default options: light theme, 90 degrees, 72dp radius.
        // Set 4 default SubActionButtons
        final FloatingActionMenu rightLowerMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(rLSubBuilder.setContentView(rlIcon1).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon2).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon3).build())

                .attachTo(rightLowerButton)
                .build();

        // Listen menu open and close events to animate the button content view
        rightLowerMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees clockwise
                fabIconNew.setRotation(0);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconNew, pvhR);
                animation.start();

                rlIcon1.setOnClickListener(new ImageView.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Log.d("Debug", "floating1");
                        Uri uri = Uri.parse("smsto:" +"9677109794");
                        Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                        i.setPackage("com.whatsapp");
                        startActivity(Intent.createChooser(i, ""));

                    }
                });

                rlIcon2.setOnClickListener(new ImageView.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final String urlFb = "fb://page/"+"9gag";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(urlFb));

                        // If a Facebook app is installed, use it. Otherwise, launch
                        // a browser
                        final PackageManager packageManager = getPackageManager();
                        List<ResolveInfo> list =
                                packageManager.queryIntentActivities(intent,
                                        PackageManager.MATCH_DEFAULT_ONLY);
                        if (list.size() == 0) {
                            final String urlBrowser = "https://www.facebook.com/pages/"+"9gag";
                            intent.setData(Uri.parse(urlBrowser));
                        }

                        startActivity(intent);

                    }
                });

                rlIcon3.setOnClickListener(new ImageView.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        final String urlBrowser = "https://www.google.com";
                        intent.setData(Uri.parse(urlBrowser));
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onMenuClosed(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees counter-clockwise
                fabIconNew.setRotation(45);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconNew, pvhR);
                animation.start();
            }
        });


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
        this.addSection(newSection("Contacts",R.drawable.contacts,new FragmentContacts()).setSectionColor(Color.parseColor("#03a9f4")));
        this.addSection(newSection("About",R.drawable.about,new FragmentButton()).setSectionColor(Color.parseColor("#03a9f4")));

        // create bottom section
        this.addBottomSection(newSection("Bottom Section",R.drawable.ic_settings_black_24dp,new Intent(this,Settings.class)));


    }
}
