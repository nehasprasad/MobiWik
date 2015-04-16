package com.example.android.mobiwik;

import android.app.Application;

import com.parse.Parse;

public class MobiWik extends Application {
    public void onCreate(){
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "uNpu0m0FuDDjogF3e1WuXC3vTlmgSCL7CwXY9buO", "CSTKMyRZAvtXotvjlYSS52ph4veifrwxPS5s6JdY");

    }
}
