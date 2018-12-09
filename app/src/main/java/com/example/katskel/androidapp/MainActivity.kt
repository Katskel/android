package com.example.katskel.androidapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.telephony.TelephonyManager
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_PERMISSION_PHONE_STATE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createLayout()
    }

    private fun createLayout() {
        val versionName = BuildConfig.VERSION_NAME
        var viewVersion = findViewById<TextView>(R.id.version_name)
        viewVersion.text = versionName

        var viewImei = findViewById<TextView>(R.id.phone_imei)
        viewImei.text = getImei().toString()

    }

    @SuppressLint("MissingPermission", "HardwareIds")
    fun getImei() : String {
        var imei = "no info"
        val permission = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_PHONE_STATE)

        //If the permission was denied show the dialog window to ask the permission
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.READ_PHONE_STATE),
                    MainActivity.REQUEST_PERMISSION_PHONE_STATE)
        }

        else {
            val telephonyManager = this.getSystemService(Context.TELEPHONY_SERVICE)
                    as TelephonyManager
            imei = telephonyManager.getDeviceId()
        }

        return imei
    }

}
