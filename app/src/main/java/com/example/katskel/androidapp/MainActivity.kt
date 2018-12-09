package com.example.katskel.androidapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createLayout()
    }

    private fun createLayout() {
        val versionName = BuildConfig.VERSION_NAME
        var view = findViewById<TextView>(R.id.version_name)
        view.text = versionName
    }
}
