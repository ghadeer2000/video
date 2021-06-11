package com.example.videostreeming

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var player: SimpleExoPlayer? = null
    var playwhenReady = true
    var playbackPostion = 0
    var currentkindew = 0
    var vedioURl: String? = ""

    //    var vedioURl = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"
//    var vedioURl = "https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4"
//    var vedioURl =  "https://cdn.videvo.net/videvo_files/video/free/2018-11/small_watermarked/181015_06_FourLevel_05_preview.webm"
//    var vedioURl =  "https://cdn.videvo.net/videvo_files/video/free/2019-03/small_watermarked/181015_05a_Griffith%20Observatory%20Drone_10_preview.webm"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vedioURl = intent.getStringExtra("vedio1")
        var value = intent.getStringExtra("vedio1")

    }

    fun initVideo() {
        player = ExoPlayerFactory.newSimpleInstance(this)
        video_view.setPlayer(player)
        var uri = Uri.parse(vedioURl)
        val dataSourcefactory: DataSource.Factory =
            DefaultDataSourceFactory(this, "exoplayer-codelab")
        var MediaSource = ProgressiveMediaSource.Factory(dataSourcefactory).createMediaSource(uri)
//        player.playWhenReady(playwhenReady)
        //        new ProgressiveMediaSource.Factory(dataSourcefactory).createMediaSource(uri)
        player!!.setPlayWhenReady(playwhenReady)
        player!!.seekTo(currentkindew, playbackPostion.toLong())
        player!!.prepare(MediaSource, false, false)
    }

    fun releaseVideo() {
        if (player != null) {
            playwhenReady = player!!.getPlayWhenReady()
            playbackPostion = player!!.currentPosition.toInt()
            currentkindew = player!!.currentWindowIndex.toInt()
            player!!.release()
            player = null
        }
    }

    override fun onStart() {
        super.onStart()
        initVideo()
    }

    override fun onStop() {
        super.onStop()
        releaseVideo()
    }

    override fun onPause() {
        super.onPause()
        releaseVideo()
    }

    override fun onResume() {
        super.onResume()
        if (player != null) {
            initVideo()
        }
    }

}