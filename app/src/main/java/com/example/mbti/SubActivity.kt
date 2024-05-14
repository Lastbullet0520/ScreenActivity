package com.example.mbti

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mbti.ui.theme.MbtiTheme

class SubActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MbtiTheme {
                SubScreen()
            }

        }
    }

    @Composable
    fun SubScreen() {
        val context = LocalContext.current as? Activity
        Column(
            modifier = Modifier
                .width(400.dp)
                .height((430.dp)),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) {

                MbtiImage(
                    modifier = Modifier
                        .align(Alignment.TopStart), type = R.drawable.intj
                )

                MbtiImage(modifier = Modifier.align(Alignment.TopEnd), type = R.drawable.intp)

                MbtiImage(modifier = Modifier.align(Alignment.BottomStart), type = R.drawable.entj)

                MbtiImage(modifier = Modifier.align(Alignment.BottomEnd), type = R.drawable.entp)
            }
            Button(onClick = {
                context?.finish()
            }) {
                Text(text = "뒤로 이동")
            }

        }


    }

    @Composable
    fun MbtiImage(modifier: Modifier, type: Int) {
        Image(
            modifier = modifier
                .width(200.dp)
                .height(200.dp),
            painter = painterResource(id = type),
            contentDescription = "$type",
            contentScale = ContentScale.FillBounds,
        )
    }
}

















