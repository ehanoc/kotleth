package com.ehanoc.deth.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ehanoc.deth.repositories.Web3Repository
import javax.inject.Inject

/**
 * Created by bruno.
 */
class Web3ViewModel : ViewModel() {

    @Inject
    lateinit var _web3Repo: Web3Repository

    private val _clientVersion: MutableLiveData<String> = MutableLiveData()

    fun getClientVersion(): LiveData<String> {
        _web3Repo.getVersion()?.subscribe({ x -> _clientVersion.setValue(x.web3ClientVersion) }, Throwable::printStackTrace )
        return _clientVersion
    }
}