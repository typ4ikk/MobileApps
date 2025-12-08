package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.Lab4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4Theme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0xFF3ddc84))
                ) {
                    BusinessCard(
                        fullName = "Aleksandr Oralov",
                        title = "МГТУ им Г.И.Носова",
                        phoneNumber = "+7 717 777 1717",
                        firstEmail = "Burmaldushka1@gmail.com",
                        secondEmail = "Burmaldyshka2@max.ru")
                }
            }
        }
    }
}

@Composable
fun PersonInformationText(
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
    ) {
    Column(modifier) {
        Text(
            text = fullName,
            fontSize = 24.sp,
            lineHeight = 20.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = title,
            fontSize = 24.sp,
            lineHeight = 20.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}
@Composable
fun PersonInformation(
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.android_logo)
    Column(modifier) {
        Image(
            painter = image,
            contentDescription = null
        )
        PersonInformationText(fullName, title)
    }
}

@Composable
fun ContactInformation(
    phoneNumber: String,
    firstEmail: String,
    secondEmail: String,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Row(modifier) {
            Icon(
                painter = painterResource(R.drawable.contact_phone_24dp_e3e3e3),
                contentDescription = null)
            Text(
                text = phoneNumber,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(8.dp)
            )
            Row(modifier) {
                Icon(
                    painter = painterResource(R.drawable.mail_24dp_e3e3e3),
                    contentDescription = null
                )
                Text(
                    text = firstEmail,
                    fontSize = 20.sp,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(8.dp)
                )
            }
            if (secondEmail.isNotEmpty()) {
                Row(modifier) {
                    Icon(
                        painter = painterResource(R.drawable.mail_24dp_e3e3e3),
                        contentDescription = null
                    )
                    Text(
                        text = secondEmail,
                        fontSize = 20.sp,
                        lineHeight = 20.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}
@Composable
fun BusinessCard(
    fullName: String,
    title: String,
    phoneNumber: String,
    firstEmail: String,
    secondEmail: String,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        PersonInformation(fullName, title, modifier)
        ContactInformation(phoneNumber, firstEmail, secondEmail)
    }
}
@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    Lab4Theme {
        BusinessCard(
            fullName = "Aleksandr Oralov",
            title = "МГТУ им Г.И.Носова",
            phoneNumber = "+7 717 777 1717",
            firstEmail = "Burmaldushka1@gmail.com",
            secondEmail = "Burmaldyshka2@max.ru")
    }
}
