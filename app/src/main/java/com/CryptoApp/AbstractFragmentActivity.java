package com.CryptoApp;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by khaled on 3/10/2018.
 */

public abstract class AbstractFragmentActivity extends AppCompatActivity {
    protected abstract Fragment creatFragment();
    @LayoutRes
    protected int getLayoutResID(){
        return R.layout.activity_crypto_list;
        //alias resource

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.CryptoListContainer);
        if (fragment==null){
             fragment = creatFragment();
             fm.beginTransaction()
                     .add(R.id.CryptoListContainer, fragment)
                     .commit();
        }
    }



}
