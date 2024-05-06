package com.example.taskmanagerscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagerscreen.ui.theme.TaskManagerScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerScreenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskScreen()
                }
            }
        }
    }
}

@Composable
fun CompletedImage(){
    val image= painterResource(R.drawable.task_completed)
    Image(painter = image, contentDescription = null, alignment = Alignment.Center)
}

@Composable
fun CompletedTexts(finish: String,comment: String, modifier: Modifier = Modifier) {
    Text(
        text = finish,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
        textAlign = TextAlign.Center
    )
    Text(
        text = comment,
        fontSize = 16.sp,
        modifier = Modifier,
        textAlign = TextAlign.Center
    )
}
@Composable
fun TaskScreen(){
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier) {
            CompletedImage()
            CompletedTexts(finish = stringResource(R.string.status), comment = stringResource(R.string.comment), modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(modifier: Modifier=Modifier) {
    TaskManagerScreenTheme {
        TaskScreen()
    }
}