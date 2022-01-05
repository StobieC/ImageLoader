package com.example.pixelsimagelaoder.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pixelsimagelaoder.R

import com.example.pixelsimagelaoder.model.PhotoResponse
import com.example.pixelsimagelaoder.model.VideoResponse

class PexelsAdapter(
    private val multipleTypeList: MutableList<Any>,
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VIDEO = 0
    private val IMAGE = 1

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): RecyclerView.ViewHolder {
        lateinit var viewHolder: RecyclerView.ViewHolder
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        viewHolder = when (viewType) {
            VIDEO -> {
                val viewVideo: View = inflater.inflate(R.layout.pexels_video_itemview,parent,false)
                PexelsVideoViewHolder(viewVideo, context)
            }
            IMAGE -> {
                val viewImage: View = inflater.inflate(R.layout.pexels_image_itemview,parent,false)
                PexelsImageViewHolder(viewImage, context)
            }
            else -> {
                val viewDefault: View =
                    inflater.inflate(android.R.layout.simple_list_item_1,parent,false)
                PexelsImageViewHolder(viewDefault, context)
            }
        }
        return viewHolder
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder,position: Int) {
        if (holder.itemViewType == VIDEO) {
            (holder as PexelsVideoViewHolder).onBind(
                multipleTypeList[position] as VideoResponse,
            )
        } else if (holder.itemViewType == IMAGE) {
            (holder as PexelsImageViewHolder).onBind(
                multipleTypeList[position] as PhotoResponse
            )
        }

    }

    override fun getItemCount(): Int {
        return multipleTypeList.size
    }

    override fun getItemViewType(position: Int): Int {
        if (multipleTypeList[position] is VideoResponse) {
            return VIDEO
        } else if (multipleTypeList[position] is PhotoResponse) {
            return IMAGE
        }
        return IMAGE
    }
}