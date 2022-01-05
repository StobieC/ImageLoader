package com.example.pixelsimagelaoder.repository

import io.reactivex.Single

interface PexelsRepository {
    fun makeRequests(userInput: String): Single<List<Any>>
}