package com.dicoding.bangkit2023.githubuserapp.ui.favorite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dicoding.bangkit2023.githubuserapp.data.local.FavoriteUser
import com.dicoding.bangkit2023.githubuserapp.data.local.FavoriteUserDao
import com.dicoding.bangkit2023.githubuserapp.data.local.UserDatabase

class FavoriteViewModel(application: Application):AndroidViewModel(application) {

    private var userDao: FavoriteUserDao?
    private var userDb: UserDatabase?

    init {
        userDb = UserDatabase.getDatabase(application)
        userDao = userDb?.favoriteUserDao()
    }

    fun getFavoriteUser(): LiveData<List<FavoriteUser>>? {
        return userDao?.getFavoriteUser()
    }
}