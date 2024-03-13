package com.example.repo_browser.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.repo_browser.api.RetrofitInstance
import com.example.repo_browser.models.Item
import com.example.repo_browser.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DescViewModel:ViewModel() {
    val user = MutableLiveData<ArrayList<Item>>()
    fun RepoDescription(searchQuery: String) {
        RetrofitInstance.api
            .searchRepoDesc(searchQuery)
            .enqueue(object : Callback<User>{
                override fun onResponse(
                    call: Call<User>,
                    response: Response<User>
                ) {
                    if (response.isSuccessful) {
                        user.postValue(response.body()?.items)
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.d("Failure", t.message!!)
                }

            })
    }
    fun getUserDesc():LiveData<ArrayList<Item>>{
        return user
    }
}