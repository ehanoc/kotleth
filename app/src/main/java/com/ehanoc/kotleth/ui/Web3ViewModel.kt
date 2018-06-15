package com.ehanoc.kotleth.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ehanoc.kotleth.repositories.Web3Repository
import org.web3j.crypto.Credentials
import java.math.BigInteger
import javax.inject.Inject

/**
 * Created by bruno.
 */
class Web3ViewModel : ViewModel() {

    @Inject
    lateinit var _web3Repo: Web3Repository

    private val _clientVersion: MutableLiveData<String> = MutableLiveData()
    private val _ethHashRate: MutableLiveData<BigInteger> = MutableLiveData()
    private val _ethBalance: MutableLiveData<String> = MutableLiveData()

    fun getWallet(password:String): Credentials {
        return _web3Repo.openWallet(password)
    }

    fun getClientVersion(): LiveData<String> {
        _web3Repo.getVersion()
                .subscribe({ result -> _clientVersion.value = result.web3ClientVersion }, Throwable::printStackTrace )
        return _clientVersion
    }

    fun getEthHashRate(): LiveData<BigInteger> {
        _web3Repo.getHashRate()
                .subscribe ({ result -> _ethHashRate.value = result.hashrate }, Throwable::printStackTrace)
        return _ethHashRate
    }

    fun getEthBalance(address:String): LiveData<String> {
        _web3Repo.getBalance(address)
                .subscribe ({ balance -> _ethBalance.value = balance.balance.toString()}, Throwable::printStackTrace)

        return _ethBalance
    }
}