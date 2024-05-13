package com.example.mbti

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.mbti.ui.theme.MbtiTheme

class NActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MbtiTheme {
                NScreen()
            }
        }
    }

    @Composable
    fun NScreen() {
        val context = LocalContext.current as? Activity
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "SF나 판타지를 좋아하니?")
            Button(onClick = {
                intent = Intent(context, SubActivity::class.java)
                context?.startActivity(intent)
            }) {
                Text(text = "응")
            }
            Button(onClick = {
                intent = Intent(context, SActivity::class.java)
                context?.startActivity(intent)
            }) {
                Text(text = "아니")
            }
            Button(onClick = {
                context?.finish()
            }) {
                Text(text = "뒤로")
            }
        }
    }
}