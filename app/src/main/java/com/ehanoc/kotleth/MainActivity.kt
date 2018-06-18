package com.ehanoc.kotleth

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.ehanoc.kotleth.ui.Web3ViewModel

class MainActivity : AppCompatActivity() {

    private var _clientVersionTxt: TextView? = null
    private var _hashRateTxt: TextView? = null
    private var _ethBalance: TextView? = null
    private var _walletAddress:TextView? = null

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

        _clientVersionTxt = findViewById(R.id.web3_client_version)
        _hashRateTxt = findViewById(R.id.web3_hash_rate_field)
        _ethBalance = findViewById(R.id.web3_balance_field)
        _walletAddress = findViewById(R.id.web3_address_field)

        (application as App).getWeb3Component().inject(_vm)
    }

    /**
     *
     */
    override fun onResume() {
        super.onResume()

        _vm.getClientVersion()
                .observe(this, Observer { version -> _clientVersionTxt?.text = version })

        _vm.getEthHashRate()
                .observe(this, Observer { hashRate -> _hashRateTxt?.text = hashRate.toString() })

        _vm.getEthBalance("0xcD426A761e3a25e2045BE211552627cf623DaD09")
                .observe(this, Observer { balance -> _ethBalance?.text = balance })

//        val addr:String = _vm.getWallet("testPasswd").address
//        _walletAddress?.text = addr
    }


}
