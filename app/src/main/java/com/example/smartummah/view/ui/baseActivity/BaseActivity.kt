package com.example.smartummah.view.ui.baseActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smartummah.R

open class BaseActivity : AppCompatActivity() {
    public var contentValue = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

}