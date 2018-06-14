package com.ehanoc.deth.repositories

import org.web3j.protocol.Web3j
import org.web3j.protocol.core.methods.response.Web3ClientVersion
import rx.Observable
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by bruno.
 */
class Web3Repository @Inject constructor(val web3: Web3j) {

   // private var _web3: Web3j = Web3jFactory.build(HttpService (url))

    private var _web3: Web3j = web3

    fun getVersion(): Observable<Web3ClientVersion>? {

        return _web3.web3ClientVersion()
                .observable()
                .observeOn(Schedulers.trampoline())
                .subscribeOn(Schedulers.io())

//        println("bih!")
//
//        _web3.web3ClientVersion().observable()
//                .observeOn(Schedulers.trampoline())
//                .subscribeOn(Schedulers.io())
//                .subscribe({ x -> println("Version v : ${x.web3ClientVersion}") }, Throwable::printStackTrace)
    }
}