package com.example.composearticle


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composearticle.ui.theme.ComposeArticleTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingPreview()
                }
            }
        }
    }
}

@Composable
fun HeaderImage(modifier: Modifier=Modifier){
    val image= painterResource(R.drawable.bg_compose)
    Image(
        painter = image,
        contentDescription = null
    )
}

@Composable
fun HeaderTopic(heading:String,modifier: Modifier=Modifier){
    Text(
        text = heading,
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
}
@Composable
fun InfoData(para1: String,para2:String, modifier: Modifier = Modifier) {
    Text(
        text = para1,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Justify
    )
    Text(
        text = para2,
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Justify
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        Box(modifier = Modifier)
        {
            Column(modifier = Modifier) {
                HeaderImage(modifier = Modifier)
                HeaderTopic(heading = stringResource(R.string.heading), modifier = Modifier)
                InfoData(para1 = stringResource(R.string.para1), para2 = stringResource(R.string.para2), modifier = Modifier )
            }
        }
    }
}