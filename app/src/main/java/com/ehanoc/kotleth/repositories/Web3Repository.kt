package com.ehanoc.kotleth.repositories

import android.os.Handler
import android.os.Looper
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.core.methods.response.EthGetBalance
import org.web3j.protocol.core.methods.response.EthHashrate
import org.web3j.protocol.core.methods.response.Web3ClientVersion
import rx.Observable
import rx.Scheduler
import rx.schedulers.Schedulers
import java.util.concurrent.Executor
import javax.inject.Inject

/**
 * Created by bruno.
 */
class Web3Repository @Inject constructor(web3: Web3j) {

    private var _web3: Web3j = web3

    fun getVersion(): Observable<Web3ClientVersion> {
        return _web3.web3ClientVersion()
                .observable()
                .observeOn(MainScheduler())
                .subscribeOn(Schedulers.io())
    }

    fun getHashRate(): Observable<EthHashrate> {
        return _web3.ethHashrate()
                .observable()
                .observeOn(MainScheduler())
                .subscribeOn(Schedulers.io())
    }

    fun getBalance(address:String): Observable<EthGetBalance> {
        val future = _web3.ethGetBalance(address, DefaultBlockParameterName.LATEST).sendAsync()
        return Observable.from(future)
                .observeOn(MainScheduler())
                .subscribeOn(Schedulers.io())
    }

    /**
     *  RXJava1 Doesn't support AndroidSchedulers,
     * so we can our own
     */
    class MainScheduler : Scheduler() {
        override fun createWorker(): Worker {
            return Schedulers.from(MyExecutor(Handler(Looper.getMainLooper()))).createWorker()
        }

    }

    class MyExecutor constructor(private val handler: Handler) : Executor {
        override fun execute(command: Runnable?) {
            handler.post(command)
        }
    }
}
