package com.infosystem.worldcup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

//        //Tab Specific Match Initialize
//        TabLayout tabBarSpecificMatch = findViewById(R.id.tabBarSpecificMatch);
//        TabItem tabSpecificGroup = findViewById(R.id.tabGroupSpecificMatch);
//        TabItem tabSpecificInfo = findViewById(R.id.tabInfoSpecificMatch);
//        final ViewPager viewPagerSpecificMatch = findViewById(R.id.viewPagerSpecificMatch);
//
//        PagerAdapterSpecificMatch pagerAdapterSpecificMatch = new PagerAdapterSpecificMatch(getCallingActivity());
//        viewPagerSpecificMatch.setAdapter(pagerAdapterSpecificMatch);
//
//        tabBarSpecificMatch.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPagerSpecificMatch.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }
}