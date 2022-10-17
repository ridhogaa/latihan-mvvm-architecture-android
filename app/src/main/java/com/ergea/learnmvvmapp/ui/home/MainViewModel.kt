package com.ergea.learnmvvmapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ergea.learnmvvmapp.model.Word

class MainViewModel : ViewModel() {
    var list = MutableLiveData<ArrayList<Word>>()
    private var newlist = arrayListOf<Word>()

    fun add(blog: Word) {
        newlist.add(blog)
        list.value = newlist
    }

    fun remove(blog: Word) {
        newlist.remove(blog)
        list.value = newlist
    }

}