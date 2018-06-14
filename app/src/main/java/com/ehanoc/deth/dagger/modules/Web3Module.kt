package com.ehanoc.deth.dagger.modules

import android.content.Context
import com.ehanoc.deth.R
import com.ehanoc.deth.repositories.Web3Repository
import dagger.Module
import dagger.Provides
import org.web3j.protocol.Web3j
import org.web3j.protocol.Web3jFactory
import org.web3j.protocol.http.HttpService
import javax.inject.Singleton

/**
 * Created by bruno.
 */
@Module
class Web3Module(val context: Context) {

    @Provides
    @Singleton
    fun provideWeb3Repo(): Web3Repository {
        return Web3Repository(provideWebj())
    }

    @Provides
    @Singleton
    fun provideWebj(): Web3j {
        return Web3jFactory.build(HttpService(context.getString(R.string.infura_url)))
    }
}