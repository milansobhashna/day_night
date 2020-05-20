package com.dntest.myapplication

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
/**
 * Created by anupamchugh on 01/03/18.
 */
class InitApplication : Application() {
    private var isNightModeEnabled = false

    override fun onCreate() {
        super.onCreate()
        InitApplication.Companion.singleton = this
        val mPrefs = PreferenceManager.getDefaultSharedPreferences(this)
        isNightModeEnabled = mPrefs.getBoolean(InitApplication.Companion.NIGHT_MODE, false)
    }

    fun isNightModeEnabled(): Boolean {
        return isNightModeEnabled
    }

    fun setIsNightModeEnabled(c : Context,isNightModeEnabled: Boolean) {
        this.isNightModeEnabled = isNightModeEnabled
        val mPrefs = PreferenceManager.getDefaultSharedPreferences(c)
        val editor = mPrefs.edit()
        editor.putBoolean(InitApplication.Companion.NIGHT_MODE, isNightModeEnabled)
        editor.apply()
    }

    companion object {
        const val NIGHT_MODE = "NIGHT_MODE"
        private var singleton: InitApplication? = null
        val instance: InitApplication
            get() {
                if (InitApplication.Companion.singleton == null) {
                    InitApplication.Companion.singleton = InitApplication()
                }
                return InitApplication.Companion.singleton!!
            }
    }
}
