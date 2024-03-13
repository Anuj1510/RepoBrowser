package com.example.repo_browser.api

import com.example.repo_browser.models.Item
import com.example.repo_browser.models.SearchRepoData
import com.example.repo_browser.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("search/repositories")
    fun searchRepo(
        @Query("q")
        searchQuery: String
    ):Call<SearchRepoData>

    @GET("search/repositories")
    fun searchRepoDesc(
        @Query("q")
        searchQuery: String
    ):Call<User>

}