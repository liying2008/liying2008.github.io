package cc.duduhuo.fragmentattachdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cc.duduhuo.fragmentattachdemo.fragment.FirstFragment;
import cc.duduhuo.fragmentattachdemo.fragment.SecondFragment;

public class MainActivity extends FragmentActivity {
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) this.findViewById(R.id.pager);
        initial();
    }

    private void initial() {
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        fragmentList.add(new FirstFragment());
        fragmentList.add(new SecondFragment());
        titleList.add("First");
        titleList.add("Second");

        MyFragmentPageAdapter adapter = new MyFragmentPageAdapter(getSupportFragmentManager(), fragmentList, titleList);
        mViewPager.setAdapter(adapter);
    }

    private class MyFragmentPageAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList;
        private List<String> titleList;

        public MyFragmentPageAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList) {
            super(fm);
            this.fragmentList = fragmentList;
            this.titleList = titleList;
        }

        @Override
        public Fragment getItem(int position) {
            return (fragmentList == null || fragmentList.size() == 0) ? null : fragmentList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return (titleList.size() > position) ? titleList.get(position) : "";
        }

        @Override
        public int getCount() {
            return fragmentList == null ? 0 : fragmentList.size();
        }
    }
}
