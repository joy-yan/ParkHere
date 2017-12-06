package cs160.sjsu.edu.parkme.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.ui.fragments.BookingFragment;
import cs160.sjsu.edu.parkme.ui.fragments.CartFragment;
import cs160.sjsu.edu.parkme.ui.fragments.DetailFragment;
import cs160.sjsu.edu.parkme.ui.fragments.MarketFragment;
import cs160.sjsu.edu.parkme.ui.fragments.OwnerFragment;
import cs160.sjsu.edu.parkme.ui.fragments.ProfileFragment;

/**
 * Created by joyyan on 12/5/17.
 */

public class PayActivity extends BaseActivity{



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_pay);
        ButterKnife.bind(this);

        DetailFragment fragment = new DetailFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.pay_fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void loadData() {

    }


}
