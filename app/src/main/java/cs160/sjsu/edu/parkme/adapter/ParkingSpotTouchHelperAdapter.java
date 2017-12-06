package cs160.sjsu.edu.parkme.adapter;

/**
 * Created by joyyan on 11/2/17.
 */
public interface ParkingSpotTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
