package com.dntest.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (InitApplication.instance.isNightModeEnabled()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        setContentView(R.layout.activity_main)
        val switchCompat = findViewById<SwitchCompat>(R.id.switchCompat)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            AlertDialog.Builder(this@MainActivity, R.style.MyDialog)
                .setTitle("Title")
                .setMessage("Message")
                .show()
        }
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) switchCompat.isChecked =
            true
        switchCompat.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                InitApplication.instance.setIsNightModeEnabled(this,true)
                val intent = intent
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                finish()
                startActivity(intent)
            } else {
                InitApplication.instance.setIsNightModeEnabled(this,false)
                val intent = intent
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                finish()
                startActivity(intent)
            }
        }
    }
}
