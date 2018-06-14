package com.ehanoc.deth

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.ehanoc.deth.repositories.Web3Repository
import com.ehanoc.deth.ui.Web3ViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var _web3: Web3Repository

    private var _clientVersionTxt: TextView? = null

    private val _vm by lazy {
        ViewModelProviders.of(this).get(Web3ViewModel::class.java)
    }

    /**
     *
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // _web3 = Web3jFactory.build(HttpService ("https://ropsten.infura.io/z4SkAPwmdcd4VosBOQy3"))

        //(application as App).getWeb3Component().inject(this)

        _clientVersionTxt = findViewById(R.id.web3_client_version)
        (application as App).getWeb3Component().inject(_vm)
    }

    /**
     *
     */
    override fun onResume() {
        super.onResume()

        _vm.getClientVersion()
                .observe(this, Observer { result -> _clientVersionTxt?.text = result })

//        _web3.web3ClientVersion().observable()
//                .observeOn(Schedulers.trampoline())
//                .subscribeOn(Schedulers.io())
//                .subscribe({ x -> println("Version v : ${x.web3ClientVersion}") }, Throwable::printStackTrace)
    }


}
