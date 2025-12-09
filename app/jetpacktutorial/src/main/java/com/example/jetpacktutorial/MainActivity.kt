package com.example.jetpacktutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacktutorial.ui.theme.Lab4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TutorialImage(
                        titleText = getString(R.string.title_text),
                        introduceText = getString(R.string.introduce_text),
                        descriptionText = getString(R.string.description_text)
                    )
                }
            }
        }
    }
}

@Composable
fun TutorialText(
    titleText: String,
    introduceText: String,
    descriptionText: String,
    modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(
            text = titleText,
            fontSize = 24.sp,
            lineHeight = 20.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = introduceText,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = descriptionText,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun TutorialImage(
    titleText: String,
    introduceText: String,
    descriptionText: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource((R.drawable.bg_compose_background))
    Column(modifier) {
        Image(
            painter = image,
            contentDescription = null,

        )
        TutorialText(
            titleText = titleText,
            introduceText = introduceText,
            descriptionText = descriptionText,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JetpackTutorialPreview() {
    Lab4Theme {
        TutorialImage(
            titleText = stringResource(R.string.title_text),
            introduceText = stringResource(R.string.introduce_text),
            descriptionText = stringResource(R.string.description_text),
            modifier = Modifier.padding(8.dp)
        )
    }
}