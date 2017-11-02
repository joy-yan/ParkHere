package cs160.sjsu.edu.parkme.utils;


/**
 * Created by joyyan on 4/1/17.
 */
public final class Constants {

    /**
     * Constants related to locations in Firebase, such as the name of the node
     * where user lists are stored (ie "userLists")
     */
    public static final String FIREBASE_LOCATION_PARKINGSPOTS = "parkingspot_list";
    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_LOCATION_USER_LISTS = "userLists";
    public static final String FIREBASE_LOCATION_USER_FRIENDS = "userFriends";
    public static final String FIREBASE_LOCATION_LISTS_SHARED_WITH = "sharedWith";
    public static final String FIREBASE_LOCATION_UID_MAPPINGS = "uidMappings";
    public static final String FIREBASE_LOCATION_OWNER_MAPPINGS = "ownerMappings";




    /**
     * Constants for Cloud Storage URL
     */

    public static final String FIREBASE_STORAGE_PARKINGSPOT_PHOTOS = "parkingspots/";
    public static final String FIREBASE_STORAGE_USER_PHOTOS = "user_photos/";
    public static final String FIREBASE_STORAGE_URL = "gs://exceed-f8ec6.appspot.com";


    /**
     * Constants for bundles, extras and shared preferences keys
     */
    public static final String KEY_LIST_NAME = "LIST_NAME";
    public static final String KEY_LAYOUT_RESOURCE = "LAYOUT_RESOURCE";
    public static final String KEY_LIST_ID = "LIST_ID";
    public static final String KEY_SIGNUP_EMAIL = "SIGNUP_EMAIL";
    public static final String KEY_LIST_ITEM_NAME = "ITEM_NAME";
    public static final String KEY_LIST_ITEM_ID = "LIST_ITEM_ID";
    public static final String KEY_PROVIDER = "PROVIDER";
    public static final String KEY_ENCODED_EMAIL = "ENCODED_EMAIL";
    public static final String KEY_LIST_OWNER = "LIST_OWNER";
    public static final String KEY_GOOGLE_EMAIL = "GOOGLE_EMAIL";
    public static final String KEY_PREF_SORT_ORDER_LISTS = "PERF_SORT_ORDER_LISTS";
    public static final String KEY_SHARED_WITH_USERS = "SHARED_WITH_USERS";


    /**
     * Constants for Firebase login
     */
    public static final String PASSWORD_PROVIDER = "password";
    public static final String GOOGLE_PROVIDER = "google.com";
    public static final String PROVIDER_DATA_DISPLAY_NAME = "displayName";



    /**
     * Constant for sorting
     */
    public static final String ORDER_BY_KEY = "orderByPushKey";
    public static final String ORDER_BY_OWNER_EMAIL = "orderByOwnerEmail";
    public static final String ORDER_BY_OWNER_RATING = "orderByItemRating";


    public static final int SUCCESS_RESULT = 0;
    public static final int FAILURE_RESULT = 1;
    public static final String PACKAGE_NAME =
            "com.google.android.gms.location.sample.locationaddress";
    public static final String RECEIVER = PACKAGE_NAME + ".RECEIVER";
    public static final String RESULT_DATA_KEY = PACKAGE_NAME +
            ".RESULT_DATA_KEY";
    public static final String LOCATION_DATA_EXTRA = PACKAGE_NAME +
            ".LOCATION_DATA_EXTRA";

    public static final int ACTION_CODE_CREATE_ITEM = 0;
    public static final int ACTION_CODE_DELETE_ITEM = 2;
    public static final int ACTION_CODE_UPDATE_ITEM = 1;

    /**
     * Constnt for photo taking
     */

    public static final int TAKE_PHOTO_FROM_CAMERA = 0;
    public static final int TAKE_PHOTO_FROM_GALLARY = 1;
    public static final int PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;


    public static final String EXTRA_KEY_USER_UID = "uid";

    public static final String EXTRA_KEY_ITEM = "item";
    public static final String EXTRA_KEY_APP_FIELDS = "app_fileds";
    public static final String EXTRA_KEY_ITEM_LIST = "item_list";
    public static final String EXTRA_KEY_POSITION = "position";
    public static final String KEY_SOURCE = "source";
    public static final String SOURCE_SAVED = "saved";
    public static final String PREFERENCES_LOCATION_KEY = "location";

    /**
     * Query for items
     */
    public static final String FIREBASE_QUERY_INDEX = "index";
    public static final String FIREBASE_QUERY_RATING = "rating";
    public static final String FIREBASE_QUERY_OWNER_UID = "ownerUid";

    /**
     * Webview
     */

    public static final String GOOGLE_CONTACT_FORM =
            "https://docs.google.com/a/sjsu.edu/forms/d/e/1FAIpQLSenOHoinnBP3lUM_eOybZ6JmqavpEx04Dy31WSbB4vaOBzifg/viewform?c=0&w=1";

    public static final String GOOGLE_ORDER_FORM =
            "https://docs.google.com/a/sjsu.edu/forms/d/e/1FAIpQLSd-_R6-duyn-U7OC1Gqjs0wjP6zlN5L8bcmWbUhcz6ZYYkZqQ/viewform?c=0&w=1";
}


