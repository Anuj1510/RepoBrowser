package com.example.repo_browser.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.repo_browser.api.RetrofitInstance
import com.example.repo_browser.models.RepoData
import com.example.repo_browser.models.SearchRepoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoViewModel:ViewModel() {

    val listRepo = MutableLiveData<ArrayList<RepoData>>()

    fun setSearchRepo(searchQuery: String){
        RetrofitInstance.api
            .searchRepo(searchQuery)
            .enqueue(object :Callback<SearchRepoData>{
                override fun onResponse(
                    call: Call<SearchRepoData>,
                    response: Response<SearchRepoData>
                ) {
                    if (response.isSuccessful) {
                        listRepo.postValue(response.body()?.items)
                    }
                }

                override fun onFailure(call: Call<SearchRepoData>, t: Throwable) {
                    Log.d("Failure", t.message!!)
                }

            })
    }

    fun searchRepo():LiveData<ArrayList<RepoData>>{
        return listRepo
    }

}