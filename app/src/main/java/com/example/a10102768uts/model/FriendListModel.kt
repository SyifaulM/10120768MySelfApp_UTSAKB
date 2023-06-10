package com.example.a10102768uts.model

class FriendListModel {
    private val friends = mutableListOf<Friend>()

    fun addFriend(name: String, imageRes: Int) {
        friends.add(Friend(name, imageRes))
    }

    fun getFriends(): List<Friend> {
        return friends
    }
}
data class Friend(val name: String, val imageResId: Int)