package com.example.a10102768uts.model

class MusicModel {
    private val musics = mutableListOf<Music>()

    fun addMusic(title: String, description: String) {
        musics.add(Music(title, description))
    }

    fun getMusics(): List<Music> {
        return musics
    }
}
data class Music(val title: String, val description: String)