package cs160.sjsu.edu.parkme.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.ui.fragments.BuyerFragment;
import cs160.sjsu.edu.parkme.ui.fragments.MarketFragment;
import cs160.sjsu.edu.parkme.ui.fragments.OwnerFragment;
import cs160.sjsu.edu.parkme.ui.fragments.ProfileFragment;
import cs160.sjsu.edu.parkme.utils.Utils;


public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    @BindView(R.id.viewPager)
    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(this);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            viewPager.setCurrentItem(item.getOrder());
            return true;
        }
    };


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    Utils.showToast(getApplicationContext(), "market");
                    return MarketFragment.newInstance();
                case 1:
                    Utils.showToast(getApplicationContext(), "buyer");
                    return BuyerFragment.newInstance();
                case 2:
                    Utils.showToast(getApplicationContext(), "owner");
                    return OwnerFragment.newInstance();
                case 3:
                    Utils.showToast(getApplicationContext(), "settings");
                    return ProfileFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.title_market);
                case 1:
                    return getString(R.string.title_buyer);
                case 2:
                    return getString(R.string.title_owner);
                case 3:
                    return getString(R.string.title_settings);
            }
            return null;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        navigation.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}