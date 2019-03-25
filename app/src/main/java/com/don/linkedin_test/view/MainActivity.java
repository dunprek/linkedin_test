package com.don.linkedin_test.view;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.don.linkedin_test.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getKeyHash();
    }


    private void getKeyHash(){
        // Add code to print out the key hash
        try {
            PackageInfo info = this.getPackageManager().getPackageInfo(this.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }


    //step 1 get the authorization code from this link
    //https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=81w4vjx68dhplv&redirect_uri=https://deskqoe.id/&scope=r_basicprofile

    //step 2 show ui for user to insert email and password




    /*
    step 3 get User FirstName and LastName
    https://api.linkedin.com/v1/people/~?format=json
    with Header -  - - - - - Authorization Bearer (token)
    example response
    {
    "firstName": "Gideon Steven",
    "headline": "Android Developer at Astragraphia",
    "id": "yUBFTicr8h",
    "lastName": "Tobing",
    "siteStandardProfileRequest": {
        "url": "https://www.linkedin.com/profile/view?id=AAoAAB2apDAB-Sn4P4lxrcSxS-bRHt6Z1OxJDVY&authType=name&authToken=UFgn&trk=api*a5373625*s5690235*"

                                  }
    }
     */

    /*
    step 4
    get user email
    https://api.linkedin.com/v2/emailAddress?q=members&projection=(elements*(handle~)) =======>>>>
    with Header -  - - - - - Authorization Bearer (token)
     */


}
