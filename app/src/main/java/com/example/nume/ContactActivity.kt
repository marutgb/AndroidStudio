package com.example.nume

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class ContactActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_activity)
    }
    fun goBack(view: View) {
        onBackPressed()
    }
}