package com.mrhi2020.ex49appbartablayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    TabLayout tabLayout;

    ViewPager pager;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tabLayout= findViewById(R.id.layout_tab);

        //탭버튼(Tab) 객체 생성
//        TabLayout.Tab tab1= tabLayout.newTab();
//        tab1.setText("Home");
//        tab1.setIcon(R.mipmap.ic_launcher);
//        tab1.setTag("tab1"); //탭버튼의 식별글씨(id같은 역할)
//        tabLayout.addTab(tab1);
//
//        TabLayout.Tab tab2= tabLayout.newTab().setText("Theme").setIcon(R.mipmap.ic_launcher).setTag("tab2");
//        tabLayout.addTab(tab2);
//
//        tabLayout.addTab( tabLayout.newTab().setText("Talk").setIcon(R.mipmap.ic_launcher).setTag("tab3") );

        //뷰페이저에 아답터 설정

        adapter= new MyAdapter( getSupportFragmentManager() );
        pager= findViewById(R.id.pager);
        pager.setAdapter(adapter);

        //TabLayout과 ViewPager를 연동하기!!
        //연동하면 Tab버튼의 글씨를 뷰페이저의 아답터에서 결정함.(즉, 위 Tab객체 추가는 의미없어짐)
        tabLayout.setupWithViewPager(pager);

        //연동을 시키면 기본적으로 탭버튼에 아이콘이 없음.
        //만약 하고싶다면...
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);

        //제목줄관리자(ActionBar)에게 서브제목 설정
        getSupportActionBar().setSubtitle("Home");

        //탭이 변경되는 것을 듣는 리스너 객체 추가
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getSupportActionBar().setSubtitle(  tab.getText() );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        drawerLayout= findViewById(R.id.layout_drawer);
        navigationView= findViewById(R.id.nav);

        drawerToggle= new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

    }
}
