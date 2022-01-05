package com.example.pixelsimagelaoder.repository

import io.reactivex.Single
import com.example.pixelsimagelaoder.model.PexelsImageWrapper
import com.example.pixelsimagelaoder.model.PexelsWrapper
import com.example.pixelsimagelaoder.model.PhotoResponse
import com.example.pixelsimagelaoder.model.VideoResponse
import com.example.pixelsimagelaoder.retrofit.PexelsApi
import com.example.pixelsimagelaoder.retrofit.RetrofitSingleton

class PexelsRepositoryImpl : PexelsRepository {
    private val retrofitSingleton = RetrofitSingleton.instance.create(PexelsApi::class.java)

    override fun makeRequests(userInput: String): Single<List<Any>> {
        return Single.zip(
            retrofitSingleton
                .getPexels(userInput)
                .map(PexelsWrapper::videos),
            retrofitSingleton.getPexelsImage(userInput)
                .map(PexelsImageWrapper::photos),
            { type1: List<VideoResponse>,type2: List<PhotoResponse> ->
                type1.union(type2).toList().shuffled()
            })
    }

}