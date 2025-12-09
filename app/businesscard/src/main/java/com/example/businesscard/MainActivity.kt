package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
                BusinessCard(
                    fullName = "Александр Оралов",
                    title = "МГТУ им Г.И.Носова",
                    phoneNumber = "+7 717 777 1717",
                    firstEmail = "Burmaldushka1@gmail.com",
                    secondEmail = "Burmaldyshka2@max.ru")

            }
        }
    }
}

@Composable
fun PersonInformation(
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.android_logo)
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .background(color = Color(0xFF073042))
                .size(120.dp, 120.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = fullName,
            fontSize = 36.sp,
            lineHeight = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
        )
        Text(
            text = title,
            fontSize = 24.sp,
            lineHeight = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ContactInformation(
    phoneNumber: String,
    firstEmail: String,
    secondEmail: String,
    modifier: Modifier = Modifier
) {
    Column(modifier, horizontalAlignment = Alignment.Start) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            //horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.contact_phone_24dp_e3e3e3),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp,40.dp)

            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = phoneNumber,
                fontSize = 20.sp,
                lineHeight = 20.sp,
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.mail_24dp_e3e3e3),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp,40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = firstEmail,
                fontSize = 20.sp,
                lineHeight = 20.sp,
            )
        }
        if (secondEmail.isNotEmpty()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(R.drawable.mail_24dp_e3e3e3),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp,40.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = secondEmail,
                    fontSize = 20.sp,
                    lineHeight = 20.sp,
                )
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFd2e8d4)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            PersonInformation(
                fullName = fullName,
                title = title,
                modifier = Modifier
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            ContactInformation(
                phoneNumber = phoneNumber,
                firstEmail = firstEmail,
                secondEmail = secondEmail,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp)
                    .padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    Lab4Theme {
        BusinessCard(
            fullName = "Александр Оралов",
            title = "МГТУ им Г.И.Носова",
            phoneNumber = "+7 717 777 1717",
            firstEmail = "Burmaldushka1@gmail.com",
            secondEmail = "Burmaldyshka2@max.ru",
            modifier = Modifier.background(color = Color(0xFFd2e8d4)))
    }
}
