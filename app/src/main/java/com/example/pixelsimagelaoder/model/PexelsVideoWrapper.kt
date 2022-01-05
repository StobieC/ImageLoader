package com.example.pixelsimagelaoder.model

data class PexelsWrapper(val videos: List<VideoResponse>,val page: Int)

data class VideoResponse(
    val image: String,
    val url: String,
    val video_files: ArrayList<VideoFilesModel>,
    val user: User
)

data class VideoFilesModel(
    val quality: String,
    val link: String
)

data class User(val id: String, val name: String)