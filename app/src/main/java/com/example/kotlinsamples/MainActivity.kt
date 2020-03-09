package com.example.kotlinsamples

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent = intent
    }

    fun foo1(intent: Intent) {
        var value = intent.getStringExtra("key") ?: ""
    }

    fun foo2(intent: Intent?) {
        var value = intent?.getStringExtra("key") ?: ""
    }
}
