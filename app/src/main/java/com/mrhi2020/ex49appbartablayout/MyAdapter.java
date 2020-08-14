package com.mrhi2020.ex49appbartablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    Fragment[] fragments= new Fragment[3];
    String[] tabTexts= new String[]{"Home", "Theme", "Talk"};

    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragments[0]= new Tab1Fragment();
        fragments[1]= new Tab2Fragment();
        fragments[2]= new Tab3Fragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    //탭레이아웃과 연동한다면 탭버튼에 보여질 글씨를 리턴해주는 메소드
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTexts[position];
    }
}
