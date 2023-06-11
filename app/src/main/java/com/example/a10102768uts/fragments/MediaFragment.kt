package com.example.a10102768uts.fragments

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10102768uts.R
import com.example.a10102768uts.adapter.GalleryAdapter
import com.example.a10102768uts.adapter.MusicAdapter
import com.example.a10102768uts.model.GalleryModel
import com.example.a10102768uts.model.MusicModel

class MediaFragment : Fragment() {
    private lateinit var music_rv: RecyclerView
    private lateinit var music_adapter: MusicAdapter
    private lateinit var music_model: MusicModel
    private lateinit var videoView: VideoView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_media, container, false)

        music_rv = view.findViewById(R.id.music_recview)
        music_rv.layoutManager = LinearLayoutManager(context)
        //gallery_rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL ,false)

        music_model = MusicModel()
        music_adapter = MusicAdapter()
        music_rv.adapter = music_adapter

        music_model.addMusic("Hymn For The Weekend", "Coldplay")
        music_model.addMusic("Interaksi", "Tulus")
        music_model.addMusic("Happiness", "Rex Orange County")
        music_model.addMusic("In My Mind", "Lyn Lapid")
        music_model.addMusic("her", "mj japanay")
        music_model.addMusic("Waves", "Dean Lewis")
        music_model.addMusic("A Thousand Eye", "Sarah Kang")
        music_model.addMusic("Neon Signs", "Sunshine bvld")
        music_model.addMusic("Happier Than Ever", "Billie Eilish")
        music_model.addMusic("Let Me Down Slowly", "Alec Benjamin")

        music_adapter.setData(music_model.getMusics())

        //video
        videoView = view.findViewById(R.id.video)

        val videoPath = "android.resource://" + requireContext().packageName + "/" + R.raw.video
        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.setVideoPath(videoPath)
        videoView.start()

    return view
    }

}