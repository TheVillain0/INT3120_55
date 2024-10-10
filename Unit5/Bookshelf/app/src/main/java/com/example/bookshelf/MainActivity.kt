package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

class MainActivity : ComponentActivity() {
    private val booksViewModel: BooksViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BookshelfScreen(viewModel = booksViewModel)
            }
        }
        booksViewModel.searchBooks("jazz history")
    }
}

@Composable
fun BookshelfScreen(viewModel: BooksViewModel) {
    val books by viewModel.books.observeAsState()

    Column {
        Text(
            text = "Bookshelf",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(16.dp)
        )

        books?.let {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(it) { book ->
                    BookItem(book)
                }
            }
        }
    }
}

@Composable
fun BookItem(book: BookItem) {
    Column(modifier = Modifier.padding(8.dp)) {
        val imageUrl = book.volumeInfo.imageLinks?.thumbnail?.replace("http", "https")
        if (imageUrl != null) {
            Image(
                painter = rememberImagePainter(data = imageUrl),
                contentDescription = book.volumeInfo.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
        }
        Text(
            text = book.volumeInfo.title,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
