package com.example.a10102768uts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10102768uts.R
import com.example.a10102768uts.adapter.DailyActivityAdapter
import com.example.a10102768uts.adapter.FriendListAdapter
import com.example.a10102768uts.adapter.GalleryAdapter
import com.example.a10102768uts.model.DailyActivityModel
import com.example.a10102768uts.model.FriendListModel
import com.example.a10102768uts.model.GalleryModel

/**
 * A simple [Fragment] subclass.
 * Use the [GalleryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GalleryFragment : Fragment() {
    private lateinit var gallery_rv: RecyclerView
    private lateinit var gallery_adapter: GalleryAdapter
    private lateinit var gallery_model: GalleryModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        gallery_rv = view.findViewById(R.id.gallery_recview)
        gallery_rv.layoutManager = GridLayoutManager(context,2)
        //gallery_rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL ,false)

        gallery_model = GalleryModel()
        gallery_adapter = GalleryAdapter()
        gallery_rv.adapter = gallery_adapter

        gallery_model.addPhoto(R.drawable.f1)
        gallery_model.addPhoto(R.drawable.f2)
        gallery_model.addPhoto(R.drawable.f4)
        gallery_model.addPhoto(R.drawable.f5)
        gallery_model.addPhoto(R.drawable.f7)
        gallery_model.addPhoto(R.drawable.f6)

        gallery_adapter.setData(gallery_model.getGallery())

        return view
    }

}