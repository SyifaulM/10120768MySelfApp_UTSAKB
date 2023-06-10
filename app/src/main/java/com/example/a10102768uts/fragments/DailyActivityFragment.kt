package com.example.a10102768uts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10102768uts.R
import com.example.a10102768uts.adapter.DailyActivityAdapter
import com.example.a10102768uts.adapter.FriendListAdapter
import com.example.a10102768uts.model.DailyActivityModel
import com.example.a10102768uts.model.FriendListModel

/**
 * A simple [Fragment] subclass.
 * Use the [DailyActivityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DailyActivityFragment : Fragment() {

    private lateinit var daily_rv: RecyclerView
    private lateinit var friend_rv: RecyclerView
    private lateinit var daily_adapter: DailyActivityAdapter
    private lateinit var friend_adapter: FriendListAdapter
    private lateinit var daily_model: DailyActivityModel
    private lateinit var friendlest_model: FriendListModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_daily_activity, container, false)

        daily_rv = view.findViewById(R.id.daily_recview)
        friend_rv = view.findViewById(R.id.friendlist_recview)
        daily_rv.layoutManager = LinearLayoutManager(context)
        friend_rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL ,false)

        daily_model = DailyActivityModel()
        friendlest_model = FriendListModel()

        daily_adapter = DailyActivityAdapter()
        friend_adapter = FriendListAdapter()

        daily_rv.adapter = daily_adapter
        friend_rv.adapter = friend_adapter

        daily_model.addActivity("Eat", R.drawable.baseline_fastfood_white_24, "Eat is a human needs")
        daily_model.addActivity("Pray", R.drawable.baseline_mosque_24, "As a Muslim, we should pray 5x per day")
        daily_model.addActivity("Sleep", R.drawable.baseline_bed_24, "Sleep is also a human needs")
        daily_model.addActivity("Check Social Media", R.drawable.baseline_phone_iphone_24, "To prevent myself from FOMO")
        daily_model.addActivity("Listening to Music", R.drawable.baseline_queue_music_24, "I sometimes listen to music while doing something")
        friendlest_model.addFriend("Naila", R.drawable.fl2)
        friendlest_model.addFriend("Rannie", R.drawable.fl3)
        friendlest_model.addFriend("Denisa", R.drawable.fl1)
        friendlest_model.addFriend("Rifa", R.drawable.fl4)

        daily_adapter.setData(daily_model.getActivities())
        friend_adapter.setData(friendlest_model.getFriends())

        return view
    }
}