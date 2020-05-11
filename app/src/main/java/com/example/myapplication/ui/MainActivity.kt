package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.di.obtainViewModel
import com.example.myapplication.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewmodel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewmodel =   viewModelFactory.obtainViewModel(this)
        button?.setOnClickListener {
            viewmodel.getShareData()
        }
        viewmodel.shareLiveData.observe(this, Observer {
            it?.let {
                Toast.makeText(this,"Data fetched ${it.shareMessage}",Toast.LENGTH_LONG).show()
            }
        })
    }
}