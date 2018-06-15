package com.ehanoc.kotleth.dagger.components

import com.ehanoc.kotleth.dagger.modules.Web3Module
import com.ehanoc.kotleth.ui.Web3ViewModel
import dagger.Subcomponent
import javax.inject.Singleton

/**
 * Created by bruno.
 */
@Singleton
@Subcomponent(modules = arrayOf(Web3Module::class))
interface Web3Component {
    fun inject(vm: Web3ViewModel)
}