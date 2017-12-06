package cs160.sjsu.edu.parkme.ui.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;
import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.adapter.FirebaseParkingAdsViewHolder;
import cs160.sjsu.edu.parkme.adapter.ParkingSpotTouchHelperViewHolder;
import cs160.sjsu.edu.parkme.model.ParkingSpot;
import cs160.sjsu.edu.parkme.utils.Utils;

/**
 * Created by joyyan on 12/2/17.
 */

public class OwnerAdsListFragment extends Fragment {

    private FirebaseRecyclerAdapter<ParkingSpot, FirebaseParkingAdsViewHolder> mAdapter;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @BindView(R.id.recycler_view_owner_ads_list)
    RecyclerView ownerAdsRecyclerView;

    public OwnerAdsListFragment() {
    }


    public static OwnerAdsListFragment newInstance() {
        OwnerAdsListFragment fragment = new OwnerAdsListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mEditor = mSharedPreferences.edit();

        setHasOptionsMenu(false);

    }

//
//    @Override
//    protected void initVariables() {
//
//    }
//
//    @Override
//    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View rootview = inflater.inflate(R.layout.fragment_owner_ads_list, container, false);
//        ButterKnife.bind(this, rootview);
//        initializeAdapter();
//
//        return rootview;
//    }
//
//    @Override
//    protected void loadData() {
//
//    }

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
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();

        Query query = FirebaseDatabase.getInstance().getReference().child("market");
        //.orderByChild(Constants.FIREBASE_QUERY_RATING);

        DatabaseReference mAdsIndicesRef = FirebaseDatabase.getInstance()
                .getReference()
                .child("chatIndices")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid());

//        FirebaseListOptions<ParkingSpot> options = new FirebaseListOptions.Builder<ParkingSpot>()
//                .setLayout(R.layout.parking_spot_item_view)//Note: The guide doesn't mention this method, without it an exception is thrown that the layout has to be set.
//                .setQuery(query, ParkingSpot.class)
//                .setLifecycleOwner(this)
//                .build();

        FirebaseRecyclerOptions<ParkingSpot> options =
                new FirebaseRecyclerOptions.Builder<ParkingSpot>()
                        .setIndexedQuery(
                                mAdsIndicesRef.limitToFirst(50), query.getRef(), ParkingSpot.class)
                        .setLifecycleOwner(this)
                        .build();


        mAdapter = new FirebaseRecyclerAdapter<ParkingSpot, FirebaseParkingAdsViewHolder>(options) {
            @Override
            public FirebaseParkingAdsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new FirebaseParkingAdsViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.parking_spot_item_view, parent, false));
            }

            @Override
            protected void onBindViewHolder(FirebaseParkingAdsViewHolder holder, int position, ParkingSpot model) {
                holder.bind(model);
            }

            @Override
            public void onDataChanged() {
                // If there are no chat messages, show a view that invites the user to add a message.
                //mEmptyListMessage.setVisibility(getItemCount() == 0 ? View.VISIBLE : View.GONE);
            }
        };



}


//
//        mAdapter = new ParkingSpotListRecyclerAdapter(ParkingSpot.class,
//                R.layout.parking_spot_item_view, ParkingSpotListViewHolder.class,
//                query, getActivity());
//
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRecyclerView.setAdapter(mAdapter);
//
//        mAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
//            @Override
//            public void onItemRangeInserted(int positionStart, int itemCount) {
//                super.onItemRangeInserted(positionStart, itemCount);
//                mAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onItemRangeChanged(int positionStart, int itemCount) {
//                super.onItemRangeChanged(positionStart, itemCount);
//                mAdapter.notifyDataSetChanged();
//            }
//        });

    @Override
    public void onStart() {
        super.onStart();
        // mAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        // mAdapter.stopListening();
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