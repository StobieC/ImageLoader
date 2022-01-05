package com.example.pixelsimagelaoder.retrofit

import io.reactivex.Single
import com.example.pixelsimagelaoder.model.PexelsImageWrapper
import com.example.pixelsimagelaoder.model.PexelsWrapper
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface PexelsApi {
    @Headers("Authorization: 563492ad6f917000010000016a6f880a6d404aa7acec67afda29fbe6")
    @GET("videos/search")
    fun getPexels(@Query("query") queryParam: String): Single<PexelsWrapper>

    @Headers("Authorization: 563492ad6f917000010000016a6f880a6d404aa7acec67afda29fbe6")
    @GET("v1/search")
    fun getPexelsImage(@Query("query") queryParam: String): Single<PexelsImageWrapper>

}