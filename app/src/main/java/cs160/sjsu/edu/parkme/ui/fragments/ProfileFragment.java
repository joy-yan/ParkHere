package cs160.sjsu.edu.parkme.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import cs160.sjsu.edu.parkme.ui.login.LoginActivity;
import cs160.sjsu.edu.parkme.utils.Utils;
import cs160.sjsu.edu.parkme.R;

/**
 * Created by joyyan on 4/8/17.
 */

public class ProfileFragment extends Fragment{


    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
//        mEditor = mSharedPreferences.edit();

        setHasOptionsMenu(false);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_profile, container, false);
        FloatingActionButton buttonLogout =
                (FloatingActionButton) rootview.findViewById(R.id.fab_profile_logout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.showToast(getActivity(), getString(R.string.msg_logout));
                signOut();
            }
        });


        return rootview;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
//        inflater.inflate(R.menu.menu_search, menu);
//
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//            @Override
//            public boolean onQueryTextSubmit(String query) {
////                addToSharedPreferences(query);
////                getItems(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
    }



    private void signOut() {
//        // Firebase sign out
//        FirebaseAuth.getInstance().signOut();
//
//        // Google sign out
//        Auth.GoogleSignInApi.signOut(MyApplication.getInstance().getmGoogleApiClient()).setResultCallback(
//                new ResultCallback<Status>() {
//                    @Override
//                    public void onResult(@NonNull Status status) {
//                        gotoLoginActivity();
//                    }
//                });


        AuthUI.getInstance()
                .signOut(getActivity())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            gotoLoginActivity();
                        } else {
                            Utils.showToast(getActivity(), "Logout failed");
                        }
                    }
                });
    }


    private void gotoLoginActivity() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        getActivity().finish();
    }



    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}


