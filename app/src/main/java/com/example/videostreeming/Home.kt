package com.example.videostreeming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        video1.setOnClickListener {
            var i = Intent(this,MainActivity::class.java)
            i.putExtra("vedio1","https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4")
            startActivity(i)
        }
        video2.setOnClickListener {
            var i = Intent(this,MainActivity::class.java)
            i.putExtra("vedio1","https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4")
            startActivity(i)
        }
        video3.setOnClickListener {
            var i = Intent(this,MainActivity::class.java)
             i.putExtra("vedio1","https://cdn.videvo.net/videvo_files/video/free/2018-11/small_watermarked/181015_06_FourLevel_05_preview.webm")
            startActivity(i)
        }
        video4.setOnClickListener {
            var i = Intent(this,MainActivity::class.java)
            i.putExtra("vedio1","https://cdn.videvo.net/videvo_files/video/free/2019-03/small_watermarked/181015_05a_Griffith%20Observatory%20Drone_10_preview.webm")
            startActivity(i)
        }
    }
}