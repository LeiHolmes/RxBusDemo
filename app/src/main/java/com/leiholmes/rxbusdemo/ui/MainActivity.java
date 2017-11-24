package com.leiholmes.rxbusdemo.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.leiholmes.rxbusdemo.R;
/**
 * Description:   入口Activity
 * author         xulei
 * Date           2017/11/24 15:17
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        PostFragment postFragment = new PostFragment();
        ReceiveFragment receiveFragment = new ReceiveFragment();
        fragmentManager.beginTransaction().add(R.id.fl_post_container, postFragment).commit();
        fragmentManager.beginTransaction().add(R.id.fl_reveive_container, receiveFragment).commit();
    }
}
