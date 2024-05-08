package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.IconCompat.IconType
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.material3.MaterialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FinalLayout()
                }
            }
        }
    }
}

@Composable
fun PersonLogo(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidlogo)
    val imagemodifier = Modifier.size(65.dp)
    Image(painter = image, contentDescription = null, modifier = imagemodifier)
}

@Composable
fun PersonPreview(name: String, designation: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PersonLogo()
        Text(
            text = name,
            fontSize = 24.sp,
            modifier = modifier.padding(top=10.dp)
        )
        Text(
            text = designation,
            color = Color(0xFF3ddc84),
            modifier = Modifier.padding(top=10.dp
            )
        )
    }
}

@Composable
fun PersonDetails(phone: String, social: String, mail: String, modifier: Modifier = Modifier) {
    Column() {
        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier.padding(bottom = 12.dp)) {
//            Icon(Icons.Rounded.Call, contentDescription = "null",tint = Color(0xFF3ddc84))
            Icon(
                imageVector = Icons.Rounded.Call,
                contentDescription = "Phone Icon",
                tint = Color(0xFF3ddc84)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = phone, modifier = Modifier)
        }
        Row(modifier = Modifier.padding(bottom = 12.dp)) {
            Icon(
                imageVector = Icons.Rounded.Share,
                contentDescription = "Share Icon",
                tint = Color(0xFF3ddc84)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = social, modifier = Modifier)
        }
        Row(modifier = Modifier.padding(bottom = 12.dp)) {
            Icon(
                imageVector = Icons.Rounded.Email,
                contentDescription = "Email Icon",
                tint = Color(0xFF3ddc84)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = mail, modifier = Modifier)
        }
    }
}

@Composable
fun FinalLayout() {
        Column(
            modifier = Modifier.fillMaxWidth().padding(top=250.dp, bottom = 40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PersonPreview(
                name = stringResource(R.string.name),
                designation = stringResource(R.string.designation),
                modifier = Modifier
            )
            PersonDetails(
                phone = stringResource(R.string.phone),
                social = stringResource(R.string.social),
                mail = stringResource(R.string.mail),
                modifier = Modifier
            )
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        FinalLayout()
    }
}
