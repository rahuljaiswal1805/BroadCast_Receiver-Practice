package com.example.staticbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AirplaneModeChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            Log.d("Check Result" , "Airplane mode change")
        }

        if(intent?.action == "com.example.broadcastsenderapp.TEST_ACTION") {
            Log.d("Check Result", "Test Action Received")
            Log.d("Check", intent.getStringExtra("abc").toString())
        }

        Log.d("Check Result", "abcdmsdkjn")
        if(intent?.action == "com.example.broadcastsenderapp.TEST_ACTION") {
            Log.d("check Result Test" , "Test Action Receive")
        }
    }
}