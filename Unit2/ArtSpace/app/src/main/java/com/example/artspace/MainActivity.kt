package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

// Data của tác phẩm
data class ArtPiece(val imageResource: Int, val title: String, val artist: String, val year: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    // List tác phẩm
    val artPieces = listOf(
        ArtPiece(R.drawable.artwork1, "Starry Night", "Vincent van Gogh", "1889"),
        ArtPiece(R.drawable.artwork2, "Mona Lisa", "Leonardo da Vinci", "1503"),
        ArtPiece(R.drawable.artwork3, "The Scream", "Edvard Munch", "1893")
    )

    // Trạng thái theo dõi tác phẩm hiện tại
    var currentIndex by remember { mutableStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Phần hiển thị hình ảnh tác phẩm nghệ thuật
            ArtWorkDisplay(
                imageResource = artPieces[currentIndex].imageResource,
                contentDescription = artPieces[currentIndex].title
            )

            // Phần mô tả info tác phẩm nghệ thuật
            ArtDescription(
                title = artPieces[currentIndex].title,
                artist = artPieces[currentIndex].artist,
                year = artPieces[currentIndex].year
            )

            // Bộ điều khiển với các nút Previous và Next
            ArtControlButtons(
                onPreviousClick = {
                    currentIndex = if (currentIndex > 0) currentIndex - 1 else artPieces.size - 1
                },
                onNextClick = {
                    currentIndex = if (currentIndex < artPieces.size - 1) currentIndex + 1 else 0
                }
            )
        }
    }
}

@Composable
fun ArtWorkDisplay(imageResource: Int, contentDescription: String?) {
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = contentDescription,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    )
}

@Composable
fun ArtDescription(title: String, artist: String, year: String) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, style = MaterialTheme.typography.bodyLarge)
        Text(text = artist, style = MaterialTheme.typography.bodyMedium)
        Text(text = year, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun ArtControlButtons(onPreviousClick: () -> Unit, onNextClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = onPreviousClick) {
            Text(text = "Previous")
        }
        Button(onClick = onNextClick) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}

