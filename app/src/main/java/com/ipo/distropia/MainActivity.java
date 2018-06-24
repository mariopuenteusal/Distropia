package com.ipo.distropia;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ipo.distropia.fragments.AddUserFragment;
import com.ipo.distropia.fragments.HomeFragment;
import com.ipo.distropia.fragments.UserDetail;
import com.ipo.distropia.model.User;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created on 21/06/2018.
 */
public class MainActivity extends AppCompatActivity {

    private BottomBar bottomBar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_references:
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                        Fragment myFragment = HomeFragment.newInstance( new HomeFragment.MyActivityListener(){
                            @Override
                            public void goUserDetail(User u) {
                                FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                                ft2.replace(R.id.main_container,UserDetail.newInstance(u));
                                ft2.commit();
                            }
                        });
                        ft.replace(R.id.main_container,myFragment);
                        ft.commit();

                        /*HomeFragment.newInstance( new HomeFragment.MyActivityListener(){
                            @Override
                            public void goUserDetail(User u) {
                                UserDetail.newInstance(u);
                            }
                        });*/

                        break;
                    case R.id.tab_statistics:

                        FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                        ft3.replace(R.id.main_container, AddUserFragment.newInstance(new User("","","","")));
                        ft3.commit();
//                        if(u.getTeams().size()>0) {
                        //NavController.getInstance().switchStack(NavController.INDEX_TEAM);
//                        }else{
//                            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//                            builder.setMessage("Debes de estar suscrito a un equipo para acceder a esta sección!")
//                                    .setCancelable(false)
//                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                                        public void onClick(DialogInterface dialog, int id) {
//                                            //do things
//                                        }
//                                    });
//                            AlertDialog alert = builder.create();
//                            alert.show();
//                        }
                        break;
                }
            }
        });
    }
}