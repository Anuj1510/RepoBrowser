package com.example.repo_browser.api

import com.example.repo_browser.models.RepoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("users/{owner}/repos")
    fun getAllRepoDetails(
        @Path("owner") owner:String,
        @Query("units") units:String
    ): ArrayList<Call<RepoData>>

}