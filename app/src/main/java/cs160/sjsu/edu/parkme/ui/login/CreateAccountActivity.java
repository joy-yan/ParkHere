package cs160.sjsu.edu.parkme.ui.login;


/**
 * Created by joyyan on 4/2/17.
 */

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.text.TextUtils;
        import android.util.Log;
        import android.view.Menu;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnFailureListener;
        import com.google.android.gms.tasks.OnSuccessListener;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;


        import java.security.SecureRandom;

        import butterknife.BindView;
        import butterknife.ButterKnife;
        import cs160.sjsu.edu.parkme.R;
        import cs160.sjsu.edu.parkme.ui.BaseActivity;
        import cs160.sjsu.edu.parkme.ui.MainActivity;
        import cs160.sjsu.edu.parkme.utils.Constants;
        import cs160.sjsu.edu.parkme.utils.Utils;


public class CreateAccountActivity extends BaseActivity {
    private static final String TAG = CreateAccountActivity.class.getSimpleName();
    private FirebaseAuth mAuth;
    private String mUserName, mUserEmail, mPassword;
    private SecureRandom mRandom = new SecureRandom();


    @BindView(R.id.edit_email_create)
    EditText mEmailField;

    @BindView(R.id.edit_password_create)
    EditText mPasswordField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);
        /**
         * Create Firebase references
         */
        mAuth = FirebaseAuth.getInstance();

        /**
         * Link layout elements from XML and setup the progress dialog
         */
        initializeScreen();
    }

    /**
     * Override onCreateOptionsMenu to inflate nothing
     *
     * @param menu The menu with which nothing will happen
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


    /**
     * Link layout elements from XML and setup the progress dialog
     */
    public void initializeScreen() {

    }

    /**
     * Open LoginActivity when user taps on "Sign in" textView
     */
    public void onSignInPressed(View view) {
        mUserEmail = mEmailField.getText().toString().toLowerCase();
        mPassword = mPasswordField.getText().toString();
        signInWithEmail(mUserEmail, mPassword);

    }

    /**
     * Create new account using Firebase email/password provider
     */
    public void onCreateAccountPressed(View view) {
        mUserEmail = mEmailField.getText().toString().toLowerCase();
        mPassword = mPasswordField.getText().toString();

        /**
         * Check that email and user name are okay
         */

        if(!validateForm())
            return;

        /**
         * If everything was valid show the progress dialog to indicate that
         * account creation has started
         */
        //mAuthProgressDialog.show();

        /**
         * Create new user with specified email and password
         */
        mAuth.createUserWithEmailAndPassword(mUserEmail, mPassword)
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Utils.showToast(CreateAccountActivity.this,
                                getString(R.string.email_account_creation_error));
                    }
                })
                .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        updateUI(authResult.getUser());
                    }
                });

    }



    private void signInWithEmail(String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }

        showProgressDialog();

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        hideProgressDialog();
                        if (null != authResult.getUser()) {
                            updateUI(authResult.getUser());
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        hideProgressDialog();
                        Toast.makeText(CreateAccountActivity.this, R.string.auth_failed
                                        + e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });


        // [END sign_in_with_email]
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = mEmailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required.");
            valid = false;
        } else {
            mEmailField.setError(null);
        }

        String password = mPasswordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Required.");
            valid = false;
        } else {
            mPasswordField.setError(null);
        }

        return valid;
    }

    public void gotoMainActivity() {

        Intent intent = new Intent(CreateAccountActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void updateUI(FirebaseUser user) {
        hideProgressDialog();
        if (null != user) {

            Utils.putPref(Constants.EXTRA_KEY_USER_UID, user.getUid(), CreateAccountActivity.this);
            gotoMainActivity();
        }

    }
}

