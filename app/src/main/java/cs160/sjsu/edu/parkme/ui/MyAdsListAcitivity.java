package cs160.sjsu.edu.parkme.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import cs160.sjsu.edu.parkme.R;
import cs160.sjsu.edu.parkme.adapter.AdsHolder;
import cs160.sjsu.edu.parkme.model.ParkingSpot;
import cs160.sjsu.edu.parkme.utils.Utils;

/**
 * Created by joyyan on 12/5/17.
 */

public class MyAdsListAcitivity extends BaseActivity{
    private FirebaseRecyclerAdapter<ParkingSpot, AdsHolder> mAdapter;
    @BindView(R.id.recycler_view_owner_ads_list)
    RecyclerView myAdsRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_owner_ads_list);
        ButterKnife.bind(this);
        initializeAdapter();
    }

    @Override
    protected void loadData() {

    }
    private void initializeAdapter() {

        String uid = Utils.getUid();
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("users")
                .child(uid)
                .child("ads")
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
//                        int itemPosition = myAdsRecyclerView.getChildAdapterPosition(v);
//                        ParkingSpot item = mAdapter.getItem(itemPosition);
//                        Intent intent = new Intent(getActivity(), DetailActivity.class);
//                        intent.putExtra("PARKING_SPOT_DETAIL", Parcels.wrap(mAdapter.getItem(itemPosition)));
//                        startActivity(intent);
                    }

                });

                view.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int itemPosition = myAdsRecyclerView.getChildAdapterPosition(v);
                        ParkingSpot item= mAdapter.getItem(itemPosition);
                        String pid = item.getParkingSpotId();
                        String uid = item.getUid();

                        DatabaseReference dbRef = FirebaseDatabase.getInstance()
                                .getReference();

                        dbRef.child("users").child(uid)
                                .child("ads").child(pid).setValue(null);

                        dbRef.child("market").child(pid).setValue(null);

                        return false;
                    }
                });

                return new AdsHolder(view, MyAdsListAcitivity.this);
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


        myAdsRecyclerView.setLayoutManager(new LinearLayoutManager(MyAdsListAcitivity.this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(myAdsRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        myAdsRecyclerView.addItemDecoration(dividerItemDecoration);
        myAdsRecyclerView.setAdapter(mAdapter);

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


