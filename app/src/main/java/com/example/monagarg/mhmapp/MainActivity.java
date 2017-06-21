package com.example.monagarg.mhmapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;
import java.util.List;

import static com.example.monagarg.mhmapp.R.id.gridview;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private SliderLayout mDemoSlider;
    GridView gridView1;
    String []list={"Gallary","Contact Us","Events","Register","Sugesstion","Broadcast Message"};

    int[] mThumbIds = {
            R.drawable.gallery, R.drawable.contact,
            R.drawable.evnt, R.drawable.register,
            R.drawable.sug,R.drawable.broadcast};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDemoSlider = (SliderLayout)findViewById(R.id.slider);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gridView1=(GridView)findViewById(R.id.gridview1);
        gridView1.setAdapter(new AdapterGrid(this,list,mThumbIds));


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1",R.drawable.one);
        file_maps.put("2",R.drawable.two);
        file_maps.put("3",R.drawable.three);
        file_maps.put("4",R.drawable.four);
        file_maps.put("5",R.drawable.five);
        file_maps.put("6",R.drawable.six);
        file_maps.put("7",R.drawable.seven);
        file_maps.put("8",R.drawable.eight);
        file_maps.put("9",R.drawable.nine);
        file_maps.put("10",R.drawable.ten);
        file_maps.put("11",R.drawable.eleven);
        file_maps.put("12",R.drawable.tweleve);
        file_maps.put("13",R.drawable.icon);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    //.description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            //.setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);





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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.register){
            Intent i=new Intent(MainActivity.this,Register.class);
            startActivity(i);
        }
        else if (id == R.id.login) {
            Intent inti=new Intent(MainActivity.this,Login.class);
            {
                startActivity(inti);
            }

        } else if (id == R.id.gallary) {

            Intent inte=new Intent(MainActivity.this,Gallary.class);
            {
                startActivity(inte);
            }

        } else if (id == R.id.events) {
            Intent inten=new Intent(MainActivity.this,Events.class);
            startActivity(inten);

        } else if (id == R.id.contact) {
            Intent in=new Intent(MainActivity.this,ContactUs.class);
            {
                startActivity(in);
            }

        } else if (id == R.id.sugesstion) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
