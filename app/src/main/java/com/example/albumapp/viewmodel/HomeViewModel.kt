package com.example.albumapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.albumapp.data.HomeRepository
import com.example.albumapp.data.PostModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class HomeViewModel : ViewModel() {

    private var homeRepository:HomeRepository?=null

    private val _postModelListLiveData = MutableLiveData<List<PostModel>>()
    val postModelListLiveData: MutableLiveData<List<PostModel>> = _postModelListLiveData

    init {
        homeRepository = HomeRepository()
    }

    fun fetchAllPosts(){
        println("reached one")
        homeRepository?.fetchAllPosts()
                ?.subscribeOn(Schedulers.io())

                ?.observeOn(AndroidSchedulers.mainThread())?.let {
                    CompositeDisposable().add(
                            it
                                    .subscribe({
                                        postModelListLiveData.value = it
                                        println("reached two")

                                    },{
                                        //handle error
                                        println("reached three")
                                        println(it.toString())
                                    })
                    )
                }
    }


}