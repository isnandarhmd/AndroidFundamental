package com.dicoding.bangkit2023.githubuserapp.api
import com.dicoding.bangkit2023.githubuserapp.BuildConfig
import com.dicoding.bangkit2023.githubuserapp.data.model.DetailUserResponse
import com.dicoding.bangkit2023.githubuserapp.data.model.User
import com.dicoding.bangkit2023.githubuserapp.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


private const val mySuperScretKey = BuildConfig.GITHUB_PAT

interface Api {

    @GET("search/users")
    @Headers("Authorization: token $mySuperScretKey")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token $mySuperScretKey")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token $mySuperScretKey")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token $mySuperScretKey")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}