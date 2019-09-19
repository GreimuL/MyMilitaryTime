package com.greimul.mymilitarytime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val handler = Handler()
        val format = SimpleDateFormat("yyyy-MM-dd mm:ss")
        val 전역일 = format.parse("2020-10-23 00:00")
        var 현재시간 = Date()
        val task = object:Runnable{
            override fun run() {
                textView.text = "D-"+((전역일.time-현재시간.time)/(24*60*60*1000)+1)
                handler.postDelayed(this,1000)
            }
        }
        handler.post(task)
    }
}
