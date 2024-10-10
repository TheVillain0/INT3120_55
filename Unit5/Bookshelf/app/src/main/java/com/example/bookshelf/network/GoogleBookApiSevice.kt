package com.example.bookshelf.network

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface GoogleBooksApiService {
    @GET("volumes")
    fun searchBooks(@Query("q") query: String): Call<BookResponse>
}
