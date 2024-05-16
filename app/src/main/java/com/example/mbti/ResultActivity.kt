package com.example.mbti

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mbti.ui.theme.MbtiTheme

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MbtiTheme {
                ResultScreen()
            }
        }
    }

    @Composable
    fun ResultScreen() {
        /* MbtiActivity에서 넘긴 정보를 ResultActivity에 받아오기 */
        val context = LocalContext.current as? Activity
        val topStartImg = intent.getStringArrayListExtra("type")?.get(0)
        val topEndImg = intent.getStringArrayListExtra("type")?.get(1)
        val bottomStartImg = intent.getStringArrayListExtra("type")?.get(2)
        val bottomEndImg = intent.getStringArrayListExtra("type")?.get(3)

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .width(400.dp)
                    .height(400.dp)
            ) {
                MbtiImage(
                    modifier = Modifier
                        .align(Alignment.TopStart), type = topStartImg   // type를 변수로 줄 예정 TODO
                )

                MbtiImage(
                    modifier = Modifier
                        .align(Alignment.TopEnd), type = topEndImg // type를 변수로 줄 예정 TODO
                )

                MbtiImage(
                    modifier = Modifier
                        .align(Alignment.BottomStart), type = bottomStartImg// type를 변수로 줄 예정 TODO
                )

                MbtiImage(
                    modifier = Modifier
                        .align(Alignment.BottomEnd), type = bottomEndImg // type를 변수로 줄 예정 TODO
                )

            }
            Spacer(modifier = Modifier.height(60.dp).fillMaxWidth())
            Button(onClick = {
                context?.finish()
            }) {
                Text(text = "뒤로 이동")
            }
        }
    }

    @Composable
    private fun MbtiImage(modifier: Modifier, type: String?) {
        val typeEncoder = if (type.isNullOrEmpty()) {
            0
        } else {
            resources.getIdentifier("$type", "drawable", packageName)
        }
        if (typeEncoder != 0 ) {
            Image(
                modifier = modifier
                    .width(200.dp)
                    .height(200.dp),
                painter = painterResource(id = typeEncoder),
                contentDescription = type,
                contentScale = ContentScale.FillBounds,
            )
        } else {
            // Optionally, you can display a default or error image here
            val topStartImg = intent.getStringArrayListExtra("type")
            Text(text = "Image not found, type is $type \n $topStartImg", modifier = modifier)
        }
    }
}