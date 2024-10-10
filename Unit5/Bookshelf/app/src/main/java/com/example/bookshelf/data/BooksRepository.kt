package com.example.bookshelf.data

interface BooksRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/books/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(GoogleBooksApiService::class.java)

    fun searchBooks(query: String): Call<BookResponse> {
        return service.searchBooks(query)
    }
}