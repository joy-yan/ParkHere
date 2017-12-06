package cs160.sjsu.edu.parkme.ui.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
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
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;
import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.adapter.AdsHolder;
import cs160.sjsu.edu.parkme.adapter.AdsHolder;
import cs160.sjsu.edu.parkme.adapter.ParkingSpotListRecyclerAdapter;
import cs160.sjsu.edu.parkme.adapter.ParkingSpotListViewHolder;
import cs160.sjsu.edu.parkme.model.ParkingSpot;
import cs160.sjsu.edu.parkme.ui.BaseActivity;
import cs160.sjsu.edu.parkme.utils.Constants;
import cs160.sjsu.edu.parkme.utils.Utils;

/**
 * Created by joyyan on 11/2/17.
 */

public class MarketFragment extends BaseFragment {

    private FirebaseRecyclerAdapter<ParkingSpot, AdsHolder> mAdapter;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @BindView(R.id.recycler_view_market)
    RecyclerView marketListView;

    public MarketFragment() {}


    public static MarketFragment newInstance() {
        MarketFragment fragment = new MarketFragment();
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


    @Override
    protected void initVariables() {

    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_market, container, false);
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

//    private void initializeAdapter() {
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//
//        Query query = FirebaseDatabase.getInstance().getReference().child("market");
//        //.orderByChild(Constants.FIREBASE_QUERY_RATING);
//
//
//        FirebaseListOptions<ParkingSpot> options = new FirebaseListOptions.Builder<ParkingSpot>()
//                .setLayout(R.layout.parking_spot_item_view)//Note: The guide doesn't mention this method, without it an exception is thrown that the layout has to be set.
//                .setQuery(query, ParkingSpot.class)
//                .build();
//
//
//        mAdapter = new FirebaseListAdapter<ParkingSpot>(options) {
//            @Override
//            protected void populateView(View v, ParkingSpot model, int position) {
//
//                TextView tvAddress = v.findViewById(R.id.parkSpotAddress);
//                tvAddress.setText(model.getAddress());
//
//                TextView tvDesc = v.findViewById(R.id.parkSpotAddress);
//                tvDesc.setText(model.getDescription());
//
//                ImageView imageView = v.findViewById(R.id.parkSpotImageView);
//                imageView.setImageResource(R.drawable.ic_parking_spot_24);
//
//            }
//        };
//
//        marketListView.setAdapter(mAdapter);
//        marketListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                FragmentManager fm = getActivity().getSupportFragmentManager();
////                FragmentTransaction fragmentTransaction = fm.beginTransaction();
//                Utils.showToast(getActivity(), "You select an ad");
//            }
//        });



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
   // }

    private void initializeAdapter() {

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("market")
                .limitToLast(50);


        FirebaseRecyclerOptions<ParkingSpot> options =
                new FirebaseRecyclerOptions.Builder<ParkingSpot>()
                        .setQuery(query, ParkingSpot.class)
                        .build();


//        mAdapter = new FirebaseRecyclerAdapter<ParkingSpot, AdsHolder>(options) {
//            @Override
//            public AdsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//                return new AdsHolder(LayoutInflater.from(parent.getContext())
//                        .inflate(R.layout.parking_spot_item_view, parent, false));
//            }
//
//            @Override
//            protected void onBindViewHolder(AdsHolder holder,
//                                            int position, ParkingSpot model) {
//                holder.bind(model);
//            }
//
//            @Override
//            public void onDataChanged() {
//                // If there are no chat messages, show a view that invites the user to add a message.
//                //mEmptyListMessage.setVisibility(getItemCount() == 0 ? View.VISIBLE : View.GONE);
//            }
//        };

        mAdapter = new FirebaseRecyclerAdapter<ParkingSpot, AdsHolder>(options) {
            @Override
            public AdsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.parking_spot_item_view, parent, false);

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


        marketListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(marketListView.getContext(),
                LinearLayoutManager.VERTICAL);
        marketListView.addItemDecoration(dividerItemDecoration);
        marketListView.setAdapter(mAdapter);

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


