package com.example.pixelsimagelaoder.retrofit

import com.example.pixelsimagelaoder.AUTH_KEY
import io.reactivex.Single
import com.example.pixelsimagelaoder.model.PexelsImageWrapper
import com.example.pixelsimagelaoder.model.PexelsVideoWrapper
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface PexelsApi {
    @Headers(AUTH_KEY)
    @GET("videos/search")
    fun getPexelsVideo(@Query("query") queryParam: String): Single<PexelsVideoWrapper>

    @Headers(AUTH_KEY)
    @GET("v1/search")
    fun getPexelsImage(@Query("query") queryParam: String): Single<PexelsImageWrapper>

}