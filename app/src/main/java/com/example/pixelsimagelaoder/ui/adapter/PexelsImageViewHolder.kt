package com.example.pixelsimagelaoder.ui.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pixelsimagelaoder.R
import com.example.pixelsimagelaoder.URL_EXTRA
import kotlinx.android.synthetic.main.pexels_image_itemview.view.*

import com.example.pixelsimagelaoder.model.PhotoResponse
import com.example.pixelsimagelaoder.ui.activity.DetailedActivity

class PexelsImageViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {
    fun onBind(photoResponse: PhotoResponse) {
        itemView.pexelsImageView.load(photoResponse.src.medium)

        itemView.pexelsImageView.setOnClickListener {
            Log.d("IMAGE", photoResponse.src.original)
            val intent = Intent(context, DetailedActivity::class.java).apply {
                putExtra(URL_EXTRA, photoResponse.src.original)
            }
            context.startActivity(intent)
        }

        itemView.photographerNameTextView.text = (context.getString(R.string.photo_by_text, photoResponse.photographer))
    }
}