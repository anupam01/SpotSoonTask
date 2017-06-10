package com.anupam.spotsoontask.UI;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.anupam.spotsoontask.R;
import com.anupam.spotsoontask.Utils.CubeOutTransformer;
import com.anupam.spotsoontask.Utils.ViewPagerAdapder;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Timer timer;
    int count = 0;

    ViewPager myPager;

    private int[] image = {R.drawable.ic_banner, R.drawable.ic_banner, R.drawable.ic_banner, R.drawable.ic_banner, R.drawable.ic_banner};
    private int[] videoTitle = {R.string.title1, R.string.title2, R.string.title3, R.string.title4, R.string.title5};
    private int[] artists = {R.string.artist1, R.string.artist2, R.string.artist3, R.string.artist4, R.string.artist5};

    CheckBox radioButton, radioButton2, radioButton3, radioButton4, radioButton5;

    GestureDetector tapGestureDetector;

    int ViewPage = 0;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private TextView tabOne, tabTwo, tabThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This is Snackbar !!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        myPager = (ViewPager) findViewById(R.id.viewpager);

        radioButton = (CheckBox) findViewById(R.id.radioButton);
        radioButton2 = (CheckBox) findViewById(R.id.radioButton2);
        radioButton3 = (CheckBox) findViewById(R.id.radioButton3);
        radioButton4 = (CheckBox) findViewById(R.id.radioButton4);
        radioButton5 = (CheckBox) findViewById(R.id.radioButton5);
        myPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioButton.setChecked(true);
                        radioButton2.setChecked(false);
                        radioButton3.setChecked(false);
                        radioButton4.setChecked(false);
                        radioButton5.setChecked(false);

                        ViewPage = position;
                        break;
                    case 1:
                        radioButton2.setChecked(true);
                        radioButton.setChecked(false);
                        radioButton3.setChecked(false);
                        radioButton4.setChecked(false);
                        radioButton5.setChecked(false);

                        ViewPage = position;
                        break;
                    case 2:
                        radioButton3.setChecked(true);
                        radioButton.setChecked(false);
                        radioButton2.setChecked(false);
                        radioButton4.setChecked(false);
                        radioButton5.setChecked(false);

                        ViewPage = position;
                        break;
                    case 3:
                        radioButton4.setChecked(true);
                        radioButton.setChecked(false);
                        radioButton2.setChecked(false);
                        radioButton3.setChecked(false);
                        radioButton5.setChecked(false);

                        ViewPage = position;
                        break;
                    case 4:
                        radioButton5.setChecked(true);
                        radioButton.setChecked(false);
                        radioButton2.setChecked(false);
                        radioButton3.setChecked(false);
                        radioButton4.setChecked(false);

                        ViewPage = position;
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        new AsyncTaskToLoadCard().execute();

        tapGestureDetector = new GestureDetector(this, new TapGestureListener());

        myPager.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                tapGestureDetector.onTouchEvent(event);
                return false;
            }
        });

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {

        tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_text, null);
        tabOne.setText("VIDEOS");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.selector_video, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_text, null);
        tabTwo.setText("IMAGES");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.selector_image, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_text, null);
        tabThree.setText("MILESTONE");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.selector_milestone, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    private void setupViewPager(ViewPager viewPager) {
        TabPagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new VideoFragment(), "VIDEOS");
        adapter.addFrag(new ImageFragment(), "IMAGES");
        adapter.addFrag(new MilestoneFragment(), "MILESTONE");
        viewPager.setAdapter(adapter);
    }

    class TabPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public TabPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    protected class TapGestureListener extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (ViewPage == 0) {
               // Intent intent = new Intent(this, OneKOneSkillActivity.class);
              //  startActivity(intent);
                Toast.makeText(MainActivity.this, "Video One !!",
                        Toast.LENGTH_SHORT).show();
            }else if (ViewPage == 1) {
                Toast.makeText(MainActivity.this, "Video Two !!",
                        Toast.LENGTH_SHORT).show();
            }else if (ViewPage == 2) {
                Toast.makeText(MainActivity.this, "Video Three !!",
                        Toast.LENGTH_SHORT).show();
            }else if (ViewPage == 3) {
                Toast.makeText(MainActivity.this, "Video Four !!",
                        Toast.LENGTH_SHORT).show();
            }else if (ViewPage == 4) {
                Toast.makeText(MainActivity.this, "Video Five !!",
                        Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    }

    public class AsyncTaskToLoadCard extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
        }
        @Override
        protected String doInBackground(String... url) {
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // Timer for auto sliding
            timer  = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if(MainActivity.this == null)
                        return;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (count <= 3) {
                                myPager.setCurrentItem(count);
                                count++;
                            } else {
                                count = 0;
                                myPager.setCurrentItem(count);
                            }
                        }
                    });
                }
            }, 100,5000);

            ViewPagerAdapder adapter = new ViewPagerAdapder(MainActivity.this, image, videoTitle, artists);
            myPager.setPageTransformer(true, new CubeOutTransformer());
            myPager.setAdapter(adapter);
            myPager.setCurrentItem(0);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_fab1) {
            // Handle the camera action
        } else if (id == R.id.nav_fab2) {

        } else if (id == R.id.nav_fab3) {

        } else if (id == R.id.nav_fab4) {

        } else if (id == R.id.nav_fab5) {

        } else if (id == R.id.nav_fab6) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
