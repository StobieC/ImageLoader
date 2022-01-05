package com.example.pixelsimagelaoder.ui.adapter

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pixelsimagelaoder.R
import kotlinx.android.synthetic.main.pexels_video_itemview.view.*
import com.example.pixelsimagelaoder.model.VideoFilesModel
import com.example.pixelsimagelaoder.model.VideoResponse

class PexelsVideoViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {

    lateinit var parent: View
    lateinit var mediaContainer: FrameLayout
    lateinit var thumbnailImageView: ImageView
    lateinit var volumeControlImageView: ImageView
    lateinit var itemViewProgressBar: ProgressBar
    lateinit var dataSource: ArrayList<VideoFilesModel>

    fun onBind(videoResponse: VideoResponse) {
        this.thumbnailImageView = itemView.thumbnailImageView

        this.volumeControlImageView = itemView.volumeControlImageView
        this.itemViewProgressBar = itemView.itemViewVideoProgressBar
        this.parent = itemView

        dataSource = videoResponse.video_files
        mediaContainer = itemView.media_actions
        parent.tag = this

        thumbnailImageView.load(videoResponse.image)

        itemView.itemViewPhotohrapherTextView.setText(context.getString(R.string.video_by_text, videoResponse.user.name))
    }
}