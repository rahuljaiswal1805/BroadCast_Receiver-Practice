package com.example.staticbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class TestActionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == "com.example.broadcastsenderapp.TEST_ACTION") {
            Log.d("check Result Test" , "Test Action Receive")
        }
    }
}