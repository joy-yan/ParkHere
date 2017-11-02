package cs160.sjsu.edu.parkme.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;


import org.parceler.Parcels;

import cs160.sjsu.edu.parkme.model.ParkingSpot;
import cs160.sjsu.edu.parkme.utils.Constants;

/**
 * Created by joyyan on 4/6/17.
 */
public class ParkingSpotListRecyclerAdapter extends 
        FirebaseRecyclerAdapter<ParkingSpot, ParkingSpotListViewHolder>
        implements ParkingSpotTouchHelperAdapter {
    private DatabaseReference mRef;
    private ChildEventListener mChildEventListener;
    private Context mContext;
    private int mOrientation;

    private static final String Tag = "ParkingSpotListRecyclerAdapter";

//    public ParkingSpotListRecyclerAdapter {
//
//        //super(modelClass, modelLayout, viewHolderClass, ref);
////        mRef = ref.getRef();
////        mContext = context;
//
//        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {
//
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }

    /**
     * Initialize a {@linke that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ParkingSpotListRecyclerAdapter(FirebaseRecyclerOptions<ParkingSpot> options) {
        super(options);
    }

//
//    @Override
//    protected void populateViewHolder(final ParkingSpotListViewHolder viewHolder,
//                                      final ParkingSpot item, final int position) {
//        viewHolder.bindView(item);
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(mContext, ParkingSpotDetailActivity.class);
////                intent.putExtra(Constants.EXTRA_KEY_ITEM, Parcels.wrap(item));
////                mContext.startActivity(intent);
//            }
//        });
//    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
    }





    public void cleanup() {
        mRef.removeEventListener(mChildEventListener);
    }

    @Override
    protected void onBindViewHolder(ParkingSpotListViewHolder holder, int position, ParkingSpot model) {

    }

    @Override
    public ParkingSpotListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }
}

