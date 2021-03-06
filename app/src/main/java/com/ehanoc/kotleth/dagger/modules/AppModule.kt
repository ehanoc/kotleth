package com.ehanoc.kotleth.dagger.modules

import android.content.Context
import android.content.SharedPreferences
import com.ehanoc.kotleth.App
import com.ehanoc.kotleth.R
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