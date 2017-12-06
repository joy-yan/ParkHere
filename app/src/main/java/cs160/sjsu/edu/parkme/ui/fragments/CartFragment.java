package cs160.sjsu.edu.parkme.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.adapter.AdsHolder;
import cs160.sjsu.edu.parkme.model.ParkingSpot;
import cs160.sjsu.edu.parkme.ui.PayActivity;
import cs160.sjsu.edu.parkme.utils.Utils;

/**
 * Created by joyyan on 11/2/17.
 */

public class CartFragment extends BaseFragment {

    private FirebaseRecyclerAdapter<ParkingSpot, AdsHolder> mAdapter;
    @BindView(R.id.recycler_view_order)
    RecyclerView orderRecyclerView;


    public static CartFragment newInstance() {
        CartFragment fragment = new CartFragment();
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
    protected void initVariables() {

    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_cart, container, false);
        ButterKnife.bind(this, rootview);
        initializeAdapter();

        return rootview;
    }

    @Override
    protected void loadData() {

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



    private void initializeAdapter() {

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("users")
                .child(Utils.getUid())
                .child("orders")
                .limitToLast(50);


        FirebaseRecyclerOptions<ParkingSpot> options =
                new FirebaseRecyclerOptions.Builder<ParkingSpot>()
                        .setQuery(query, ParkingSpot.class)
                        .build();


        mAdapter = new FirebaseRecyclerAdapter<ParkingSpot, AdsHolder>(options) {

            @Override
            public AdsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.parking_spot_item_view, parent, false);

                view.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        int itemPosition = orderRecyclerView.getChildAdapterPosition(v);
                        ParkingSpot item = mAdapter.getItem(itemPosition);
                        Intent intent = new Intent(getActivity(), PayActivity.class);
                        intent.putExtra("PARKING_SPOT_DETAIL", Parcels.wrap(mAdapter.getItem(itemPosition)));
                        getActivity().startActivity(intent);
                    }
                });

                return new AdsHolder(view, getActivity());
            }

            @Override
            protected void onBindViewHolder(AdsHolder holder, int position,
                                            ParkingSpot model) {
                holder.bind(model);

            }

            @Override
            public void onDataChanged() {
                // Called each time there is a new data snapshot. You may want to use this method
                // to hide a loading spinner or check for the "no documents" state and update your UI.
                // ...
            }

            @Override
            public void onError(DatabaseError e) {
                // Called when there is an error getting data. You may want to update
                // your UI to display an error message to the user.
                // ...
            }
        };


        orderRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(orderRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        orderRecyclerView.addItemDecoration(dividerItemDecoration);
        orderRecyclerView.setAdapter(mAdapter);

    }


    @Override
    public void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}


