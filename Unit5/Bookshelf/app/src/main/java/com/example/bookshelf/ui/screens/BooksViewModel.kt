package com.example.bookshelf.ui.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val books = MutableLiveData<List<BookItem>>()

    private val repository = BooksRepository()

    fun searchBooks(query: String) {
        repository.searchBooks(query).enqueue(object : Callback<BookResponse> {
            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                if (response.isSuccessful) {
                    books.value = response.body()?.items
                }
            }

            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
            }
        })
    }
}
