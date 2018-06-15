package com.ehanoc.kotleth.dagger.components

import com.ehanoc.kotleth.App
import com.ehanoc.kotleth.dagger.modules.AppModule
import com.ehanoc.kotleth.dagger.modules.Web3Module
import dagger.Component

/**
 * Created by bruno.
 */
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)

    fun plus(web3SubModule: Web3Module): Web3Component
}