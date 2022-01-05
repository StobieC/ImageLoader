package com.example.pixelsimagelaoder.model

data class PexelsImageWrapper(val photos: List<PhotoResponse>)
data class PhotoResponse(val url: String,val src: ImageFile, val photographer: String)
data class ImageFile(val medium: String, val original: String)
