package com.ehanoc.deth.dagger.components

import android.arch.lifecycle.ViewModel
import com.ehanoc.deth.MainActivity
import com.ehanoc.deth.dagger.modules.Web3Module
import com.ehanoc.deth.ui.Web3ViewModel
import dagger.Subcomponent
import javax.inject.Singleton

/**
 * Created by bruno.
 */
@Singleton
@Subcomponent(modules = arrayOf(Web3Module::class))
interface Web3Component {
    fun inject(act: MainActivity)
    fun inject(vm: Web3ViewModel)
}