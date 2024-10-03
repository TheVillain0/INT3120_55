import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                LemonadeApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Lemonade", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            LemonScreen(
                currentStep = currentStep,
                squeezeCount = squeezeCount,
                onStepChange = { step, count ->
                    currentStep = step
                    squeezeCount = count
                }
            )
        }
    }
}

@Composable
fun LemonScreen(
    currentStep: Int,
    squeezeCount: Int,
    onStepChange: (step: Int, count: Int) -> Unit
) {
    val (textId, imageId, contentDescId) = when (currentStep) {
        1 -> Triple(R.string.lemon_select, R.drawable.lemon_tree, R.string.lemon_tree_content_description)
        2 -> Triple(R.string.lemon_squeeze, R.drawable.lemon_squeeze, R.string.lemon_content_description)
        3 -> Triple(R.string.lemon_drink, R.drawable.lemon_drink, R.string.lemonade_content_description)
        else -> Triple(R.string.lemon_empty_glass, R.drawable.lemon_restart, R.string.empty_glass_content_description)
    }

    LemonTextAndImage(
        textLabelResourceId = textId,
        drawableResourceId = imageId,
        contentDescriptionResourceId = contentDescId,
        onImageClick = {
            when (currentStep) {
                1 -> onStepChange(2, (2..4).random())
                2 -> if (squeezeCount > 1) onStepChange(2, squeezeCount - 1) else onStepChange(3, 0)
                3 -> onStepChange(4, 0)
                4 -> onStepChange(1, 0)
            }
        }
    )
}

@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Button(
            onClick = onImageClick,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
        ) {
            Image(
                painter = painterResource(drawableResourceId),
                contentDescription = stringResource(contentDescriptionResourceId),
                modifier = Modifier.size(128.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(textLabelResourceId),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun LemonPreview() {
    MaterialTheme {
        LemonadeApp()
    }
}
