package cs160.sjsu.edu.parkme.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by joyyan on 11/5/17.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initVariables();
        View rootview = initViews(inflater, container, savedInstanceState);
        loadData();

        return rootview;
    }

    protected abstract void initVariables();
    protected abstract View initViews(LayoutInflater inflater, ViewGroup container,
                                      Bundle savedInstanceState);
    protected abstract void loadData();

}
