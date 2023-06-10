package com.example.a10102768uts.model

class GalleryModel {
    private val gallery = mutableListOf<Photo>()

    fun addPhoto(imageRes: Int) {
        gallery.add(Photo(imageRes))
    }

    fun getGallery(): List<Photo> {
        return gallery
    }
}
data class Photo(val imageResId: Int)