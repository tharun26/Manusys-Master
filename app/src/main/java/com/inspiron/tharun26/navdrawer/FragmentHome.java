package com.inspiron.tharun26.navdrawer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.Transition;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

/**
 * Created by tharun26 on 11/2/15.
 */
//public class FragmentHome extends Fragment implements KenBurnsView.TransitionListener
public class FragmentHome extends Fragment {

    private FeatureCoverFlow mCoverFlow;
    private CoverFlowAdapter mAdapter;
    private ArrayList<GameEntity> mData = new ArrayList<>(0);
    private TextSwitcher mTitle;


    LinearLayout imageGallery;
    private static final int TRANSITIONS_TO_SWITCH = 1;

    private ViewFlipper mViewSwitcher;

    private int mTransitionsCount =0;

    public Context context=null;

    public FragmentHome()
    {

    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //ImageView demoImage = (ImageView) getActivity().findViewById(R.id.home_title);
       // int imagesToShow[] = { R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,  R.drawable.ic_launcher};


        //animate(demoImage, imagesToShow, 0,true);
     /*   imageGallery=(LinearLayout)getActivity().findViewById(R.id.linearImage);

        for(int i=0; i<imagesToShow.length; i++){
            ImageView image=new ImageView(getActivity());
            image.setBackgroundResource(imagesToShow[i]);
            imageGallery.addView(image);
        }
*/
        ShimmerTextView tv;
        Shimmer shimmer;
        tv = (ShimmerTextView) getActivity().findViewById(R.id.shim1);
        shimmer = new Shimmer();
        shimmer.setDuration(2000);
        shimmer.start(tv);

        ShimmerTextView tv1;
        Shimmer shimmer1;
        tv1 = (ShimmerTextView) getActivity().findViewById(R.id.shim2);
        shimmer1 = new Shimmer();
        shimmer1.setDuration(2000).setDirection(Shimmer.ANIMATION_DIRECTION_RTL).setStartDelay(5000);
        shimmer1.start(tv1);

        ShimmerTextView tv2;
        Shimmer shimmer2;
        tv2 = (ShimmerTextView) getActivity().findViewById(R.id.shim3);
        shimmer2 = new Shimmer();
        shimmer2.setDuration(2000);
        shimmer2.start(tv2);



        mData.add(new GameEntity(R.drawable.ceg, R.string.title1));
        mData.add(new GameEntity(R.drawable.dept, R.string.title2));
        mData.add(new GameEntity(R.drawable.flower, R.string.title3));
        mData.add(new GameEntity(R.drawable.crowd1, R.string.title4));
        mData.add(new GameEntity(R.drawable.nitrocar, R.string.title4));
        mData.add(new GameEntity(R.drawable.rumblerace, R.string.title4));
        mData.add(new GameEntity(R.drawable.crowd2, R.string.title4));

        mTitle = (TextSwitcher) getActivity().findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                TextView textView = (TextView) inflater.inflate(R.layout.item_title, null);
                return textView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        mAdapter = new CoverFlowAdapter(getActivity());
        mAdapter.setData(mData);
        mCoverFlow = (FeatureCoverFlow) getActivity().findViewById(R.id.coverflow);
        mCoverFlow.setAdapter(mAdapter);

        mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(),
                  //      getResources().getString(mData.get(position).titleResId),
                   //     Toast.LENGTH_SHORT).show();
            }
        });

        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(getResources().getString(mData.get(position).titleResId));
            }

            @Override
            public void onScrolling() {
                mTitle.setText("");
            }
        });


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);





        return rootView;
    }
    /*
    private void animate(final ImageView imageView, final int images[], final int imageIndex, final boolean forever) {

        //imageView <-- The View which displays the images
        //images[] <-- Holds R references to the images to display
        //imageIndex <-- index of the first image to show in images[]
        //forever <-- If equals true then after the last image it starts all over again with the first image resulting in an infinite loop. You have been warned.

        int fadeInDuration = 100; // Configure time values here
        int timeBetween = 1000;
        int fadeOutDuration = 1000;

        imageView.setVisibility(View.INVISIBLE);    //Visible or invisible by default - this will apply when the animation ends
        imageView.setImageResource(images[imageIndex]);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); // add this
        fadeIn.setDuration(fadeInDuration);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); // and this
        fadeOut.setStartOffset(fadeInDuration + timeBetween);
        fadeOut.setDuration(fadeOutDuration);

        AnimationSet animation = new AnimationSet(false); // change to false
        animation.addAnimation(fadeIn);
        animation.addAnimation(fadeOut);
        animation.setRepeatCount(1);
        imageView.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (images.length - 1 > imageIndex) {
                    animate(imageView, images, imageIndex + 1,forever); //Calls itself until it gets to the end of the array
                }
                else {
                    if (forever == true){
                        animate(imageView, images, 0,forever);  //Calls itself to start the animation all over again in a loop if forever = true
                    }
                }
            }
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }
        });
    }
*/


    /*public void onStart() {
        super.onStart();
        //TextView tv = (TextView)getActivity().findViewById(R.id.mywidget);
        // tv.setSelected(true);
        mViewSwitcher = (ViewFlipper) getActivity().findViewById(R.id.viewSwitcher);

        KenBurnsView img1 = (KenBurnsView) getActivity(). findViewById(R.id.img1);
        img1.setTransitionListener(this);

        KenBurnsView img2 = (KenBurnsView) getActivity(). findViewById(R.id.img2);
        img2.setTransitionListener(this);

        KenBurnsView img3 = (KenBurnsView) getActivity(). findViewById(R.id.img3);
        img3.setTransitionListener(this);

        KenBurnsView img4 = (KenBurnsView) getActivity(). findViewById(R.id.img4);
        img4.setTransitionListener(this);





    }

    public void onTransitionStart(Transition transition) {

    }


    public void onTransitionEnd(Transition transition) {
        mTransitionsCount++;
        if (mTransitionsCount == TRANSITIONS_TO_SWITCH) {
            mViewSwitcher.showNext();
            mTransitionsCount = 0;
        }

    }
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        context=activity.getBaseContext();
    }
*/
 }
