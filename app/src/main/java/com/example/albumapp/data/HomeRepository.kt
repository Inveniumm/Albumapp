package com.example.albumapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.albumapp.network.ApiClient
import com.example.albumapp.network.ApiInterface
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeRepository {
    private var apiInterface: ApiInterface? = null

    init {
        apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
    }

    fun fetchAllPosts(): Single<List<PostModel>> {
        return Single.defer{
            return@defer apiInterface?.fetchAllPosts()
        }
    }
}