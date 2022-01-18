package com.example.pixelsimagelaoder.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pixelsimagelaoder.R

import kotlinx.android.synthetic.main.activity_main.*

import com.example.pixelsimagelaoder.ui.adapter.PexelsAdapter
import com.example.pixelsimagelaoder.ui.custom.VideoPlayerRecyclerView
import com.example.pixelsimagelaoder.viewmodel.PexelsViewModel
import com.example.pixelsimagelaoder.viewmodel.State

class MainActivity : AppCompatActivity() {
    private lateinit var pexelsAdapter: PexelsAdapter
    private lateinit var videoPlayerRecyclerView: VideoPlayerRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoPlayerRecyclerView = findViewById(R.id.mixedItemRecyclerView)
        val pexelsViewModel = instantiateViewModel()
        searchButton.setOnClickListener {
            takeInputAndRenderViews(pexelsViewModel)
        }
    }

    private fun takeInputAndRenderViews(pexelsViewModel: PexelsViewModel) {
        val input = inputEditText.text.toString()
        pexelsViewModel.getRemoteData(input)
            .observe(this@MainActivity,Observer { state ->
                state?.let(::render)
            })
    }

    private fun render(state: State) {
        when (state) {
            is State.Loading -> renderLoading()
            is State.Success -> renderSuccess(state.mixedDataType)
            is State.Error -> renderError()
        }
    }

    private fun renderError() {
        Log.e("SEARCH", "renderError")
        Toast.makeText(this.context, "Render Error", Toast.LENGTH_LONG).show()
    }

    private fun renderSuccess(mixedDataType: List<Any>) {
        setRecyclerView(mixedDataType)
    }

    private fun renderLoading() {
        Log.d("SEARCH", "renderLoading")
        Toast.makeText(this.context, "Loading", Toast.LENGTH_LONG).show()
    }

    private fun setRecyclerView(multipleData: List<Any>) {
        pexelsAdapter = PexelsAdapter(
            multipleData.toMutableList(), this
        )
        videoPlayerRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = pexelsAdapter
        }
    }

    private fun instantiateViewModel(): PexelsViewModel {
        return ViewModelProviders.of(this@MainActivity)[PexelsViewModel::class.java]
    }

}
