package com.ehanoc.deth.dagger.modules

import android.content.Context
import android.content.SharedPreferences
import com.ehanoc.deth.App
import com.ehanoc.deth.R
import dagger.Module
import dagger.Provides


/**
 * Created by bruno.
 */
@Module
class AppModule(private val mApplication: App) {

    @Provides
    fun provideSharedPreferences(): SharedPreferences {
        return mApplication.getSharedPreferences(mApplication.getString(R.string.pref_file), Context.MODE_PRIVATE)
    }
}