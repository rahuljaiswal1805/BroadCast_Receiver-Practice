package com.example.staticbroadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val airplaneModeChangeReceiver = AirplaneModeChangeReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val img = findViewById<ImageView>(R.id.imageView)

        val intent = intent
        val action = intent.action
        val type = intent.type

        if(Intent.ACTION_SEND.equals(action) && type != null) {
            img.setImageURI(intent.getParcelableExtra(Intent.EXTRA_STREAM))
        }

        registerReceiver(airplaneModeChangeReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        registerReceiver(airplaneModeChangeReceiver, IntentFilter("com.example.broadcastsenderapp.TEST_ACTION"))

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airplaneModeChangeReceiver)
    }
}