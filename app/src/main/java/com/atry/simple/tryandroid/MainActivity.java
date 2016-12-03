package com.atry.simple.tryandroid;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {


    private RadioGroup myTabRg;

    private Fragment contentFragment;
    private FragmentHome chat;
    private FragmentAddress address;
    private FragmentFind find;
    private FragmentMe me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        initView();
    }

    //内容区的滑动我们用的是fragment！！！！！
    //掌握这种使用！！！
    private void initView() {
        chat = new FragmentHome();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, chat).commit();
        myTabRg = (RadioGroup) findViewById(R.id.tab_menu);
        myTabRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.rbChat:
                        chat = new FragmentHome();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, chat)
                                .commit();
                        break;
                    case R.id.rbAddress:
                        if (address==null) {
                            address =new FragmentAddress();
                        }
                        Log.i("MyFragment", "FragmentAddress");
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, address).commit();
                        break;
                    case R.id.rbFind:
                        find = new FragmentFind();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, find)
                                .commit();
                        break;
                    case R.id.rbMe:
                        me = new FragmentMe();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, me)
                                .commit();
                        break;
                    default:
                        break;
                }

            }
        });

    }
}
