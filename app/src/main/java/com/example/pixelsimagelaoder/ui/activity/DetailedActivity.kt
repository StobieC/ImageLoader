package com.example.pixelsimagelaoder.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.pixelsimagelaoder.R
import com.example.pixelsimagelaoder.URL_EXTRA
import kotlinx.android.synthetic.main.activity_full_screen_image.*

class DetailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_image)

        val imageUrl = intent.getStringExtra(URL_EXTRA)
        full_screen_image.load(imageUrl)

    }
}