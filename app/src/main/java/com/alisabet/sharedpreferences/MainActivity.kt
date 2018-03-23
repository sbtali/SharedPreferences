package com.alisabet.sharedpreferences

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.R.id.edit
import android.content.Context
import android.content.SharedPreferences.Editor
import android.content.SharedPreferences



class MainActivity : AppCompatActivity() {

    //1.Shared Preferences allow you to save and retrieve data in the form of key,value pair.
    //3.---getPreferences() : used from within your Activity, to access activity-specific preferences
    //---getSharedPreferences() : used from within your Activity (or other application Context), to access application-level preferences
    //---getDefaultSharedPreferences() : used on the PreferenceManager,
    // to get the shared preferences that work in concert with Android’s overall preference framework
    //3.Preferences are app data and you can see storage of them in app info
    //4.if we clear our app data, Preferences will be clear
    //5.write code below

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //MODE_PRIVATE cause just this app can access pref file
        val pref = applicationContext.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putBoolean("key_bool", true); // Storing boolean - true/false
        editor.putString("key_string", "string value"); // Storing string
        editor.putInt("key_int", 1); // Storing integer
        editor.putFloat("key_float", 1.5F); // Storing float
        editor.putLong("key_long", 2); // Storing long
        editor.commit(); // commit changes

        //second argument is default value, if can't access key
        val string = pref.getString("key_name", null); // getting String
        val integer = pref.getInt("key_name", 0); // getting Integer
        val float = pref.getFloat("key_name", 0F); // getting Float
        val long = pref.getLong("key_name", 0); // getting Long
        val bool = pref.getBoolean("key_name", false); // getting boolean

        editor.remove("name"); // will delete key name
        editor.remove("email"); // will delete key email
        editor.commit(); // commit changes

        editor.clear();
        editor.commit(); // commit changes

    }
}
