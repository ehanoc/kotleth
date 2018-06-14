package com.ehanoc.deth.dagger.components

import com.ehanoc.deth.App
import com.ehanoc.deth.dagger.modules.AppModule
import com.ehanoc.deth.dagger.modules.Web3Module
import dagger.Component

/**
 * Created by bruno.
 */
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)

    fun plus(web3SubModule: Web3Module): Web3Component
}