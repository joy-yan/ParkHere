package cs160.sjsu.edu.parkme.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cs160.sjsu.edu.parkme.R;

/**
 * Created by joyyan on 11/2/17.
 */

public class OwnerFragment extends Fragment{


    public static OwnerFragment newInstance() {
        OwnerFragment fragment = new OwnerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_market, container, false);

        return rootview;
    }
}
