package com.example.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        main_dynamic_fragment_btn.setOnClickListener {

        }
        main_static_fragment_btn.setOnClickListener {
            startActivity(Intent(this, StaticFragmentActivity::class.java))
        }
        main_having_fun_btn.setOnClickListener {

        }
    }
}
