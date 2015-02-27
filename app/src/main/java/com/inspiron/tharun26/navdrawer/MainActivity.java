package com.inspiron.tharun26.navdrawer;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.List;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;



import com.google.android.gcm.GCMRegistrar;
//import com.inspiron.tharun26.navdrawer.NavDrawerListAdapter;

import java.util.ArrayList;
import java.util.List;


import static com.inspiron.tharun26.navdrawer.CommonUtilities.DISPLAY_MESSAGE_ACTION;
import static com.inspiron.tharun26.navdrawer.CommonUtilities.SENDER_ID;
import static com.inspiron.tharun26.navdrawer.CommonUtilities.EXTRA_MESSAGE;

public class MainActivity extends MaterialNavigationDrawer {

    BroadcastReceiver mHandleMessageReceiver = null;
    ConnectionDetector cd;
    public static String name;
    public static String email;
    AsyncTask<Void, Void, Void> mRegisterTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cd = new ConnectionDetector(getApplicationContext());
        // Check if Internet present
        if (!cd.isConnectingToInternet()) {
            // Internet Connection is not present
          //  Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
            // stop executing code by return
            //  return;
        }

        name = "ManusysID";
        email = "ManusysEmail";

        // Make sure the device has the proper dependencies.
        GCMRegistrar.checkDevice(this);

        // Make sure the manifest was properly set - comment out this line
        // while developing the app, then uncomment it when it's ready.
        GCMRegistrar.checkManifest(this);


        registerReceiver(mHandleMessageReceiver, new IntentFilter(
                DISPLAY_MESSAGE_ACTION));

        // Get GCM registration id
        final String regId = GCMRegistrar.getRegistrationId(this);

        // Check if regid already presents
        if (regId.equals("")) {
            // Registration is not present, register now with GCM
            GCMRegistrar.register(this, SENDER_ID);
        } else {
            // Device is already registered on GCM
            if (GCMRegistrar.isRegisteredOnServer(this)) {
                // Skips registration.
            //    Toast.makeText(getApplicationContext(), "Already registered with GCM", Toast.LENGTH_LONG).show();
            } else {
                // Try to register again, but not in the UI thread.
                // It's also necessary to cancel the thread onDestroy(),
                // hence the use of AsyncTask instead of a raw thread.
                final Context context = this;
                mRegisterTask = new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... params) {
                        // Register on our server
                        // On server creates a new user
                        ServerUtilities.register(context, name, email, regId);
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        mRegisterTask = null;
                    }

                };
                mRegisterTask.execute(null, null, null);
            }
        }

        mHandleMessageReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String newMessage = intent.getExtras().getString(EXTRA_MESSAGE);
                // Waking up mobile if it is sleeping
                WakeLocker.acquire(getApplicationContext());

/*
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                Log.d("Insert: ", "Inserting ..");
                db.addNotification(new NotificationDb(newMessage));
                Log.d("Reading: ", "Reading all contacts..");
                List<NotificationDb> notificationDbs = db.getAllContacts();

                int i=0;
                for (NotificationDb cn : notificationDbs) {
                  //      db.deleteContact(cn);
                   String log = "Id: "+cn.getId()+" ,Name: " + cn.getNotification()  ;
                    //  Writing Contacts to log
                    Log.d("Name: ", log);
                }
*/



                /**
                 * Take appropriate action on this message
                 * depending upon yrour app requirement
                 * For now i am just displaying it on the screen
                 * */

                // Showing received message
                // lblMessage.append(newMessage + "\n");
                Toast.makeText(getApplicationContext(), "New Message: " + newMessage, Toast.LENGTH_SHORT).show();


                // TextView tv = (TextView)findViewById(R.id.mywidget);
                //tv.append("                                        "+newMessage);




            /*
                int size=NotificationFragment.notification_title.length;
                if(newMessage!="")
                {
                    NotificationFragment.notification_title[size+1]="Message";

                }
             */
                //
                //   NotificationFragment.notification_title[20]=newMessage;


                // Releasing wake lock
                WakeLocker.release();
            }
        };




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


        rlIcon1.setImageDrawable(getResources().getDrawable(R.drawable.gmail));
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
                        Intent gmail = new Intent(Intent.ACTION_VIEW);
                        gmail.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                        gmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"manusys15@gmail.com"});
                        //  gmail.setData(Uri.parse("tharun26@gmail.com"));
                        gmail.putExtra(Intent.EXTRA_SUBJECT, "Query");
                        gmail.setType("plain/text");
                        gmail.putExtra(Intent.EXTRA_TEXT, "Hi,");
                        startActivity(gmail);

                    }
                });

                rlIcon2.setOnClickListener(new ImageView.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent intent = new Intent(Intent.ACTION_VIEW);


                            final String urlBrowser = "https://www.facebook.com/manusys.in";
                            intent.setData(Uri.parse(urlBrowser));


                        startActivity(intent);

                    }
                });

                rlIcon3.setOnClickListener(new ImageView.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        final String urlBrowser = "http://www.manusys.in";
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
        MaterialAccount account = new MaterialAccount(this.getResources(),"Manusys15","CEG,Manufacturing Department", R.drawable.manusys_logo_bw, R.drawable.cover);
        this.addAccount(account);

        //MaterialAccount account2 = new MaterialAccount(this.getResources(),"Hatsune Miky","hatsune.miku@example.com",R.drawable.photo2,R.drawable.mat2);
        //this.addAccount(account2);

        //MaterialAccount account3 = new MaterialAccount(this.getResources(),"Example","example@example.com",R.drawable.photo,R.drawable.mat3);
        //this.addAccount(account3);

        // create sections
        this.addSection(newSection("Home",R.drawable.home ,new FragmentHome()).setSectionColor(Color.parseColor("#3a86ff")));
        //Green:#008744"
        this.addSection(newSection("Events",R.drawable.events,new FragmentIndex()).setSectionColor(Color.parseColor("#03a9f4")));
      //  this.addSection(newSection("Workshops",R.drawable.workshops,new FragmentIndex()).setSectionColor(Color.parseColor("#9c27b0")));
        this.addSection(newSection("Workshops",R.drawable.workshops,new Intent(this,workshops.class)));



        this.addSection( newSection("Accommodation",R.drawable.ic_hotel_grey600_24dp,new FragmentSponsors()).setSectionColor(Color.parseColor("#03a9f4")));
        this.addSection(newSection("Sponsors",R.drawable.sponsors,new FragmentAccomodation()).setSectionColor(Color.parseColor("#03a9f4")));
        this.addSection(newSection("Contacts",R.drawable.contacts,new FragmentContacts()).setSectionColor(Color.parseColor("#03a9f4")));
        this.addSection(newSection("Updates",R.drawable.updates ,new NotificationFragment()).setSectionColor(Color.parseColor("#008744")));

        this.addSection(newSection("About",R.drawable.about,new Intent(this,about.class)).setSectionColor(Color.parseColor("#008744")));

        // create bottom section
      //  this.addBottomSection(newSection("Bottom Section",R.drawable.ic_settings_black_24dp,new Intent(this,Settings.class)));


    }
    protected void onDestroy(){
        super.onDestroy();
        if (mRegisterTask != null) {
            mRegisterTask.cancel(true);
        }
        try {
            unregisterReceiver(mHandleMessageReceiver);
            GCMRegistrar.onDestroy(this);
        } catch (Exception e) {
            Log.e("UnRegister Receiver Error", "> " + e.getMessage());
        }

    }


}
