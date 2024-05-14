package com.example.mbti

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mbti.ui.theme.MbtiTheme


open class MbtiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MbtiTheme {
                MbtiScreen()

            }
        }
    }

    @Composable
    fun MbtiScreen() {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            val context = LocalContext.current as? Activity
            Text(text = "당신의 유형은?")
             val MyMbti = Mbti()
            MyMbti.knowMbti(mbti = "탐험가형")
            MyMbti.knowMbti(mbti = "외교관형")
            MyMbti.knowMbti(mbti = "분석가형")
            MyMbti.knowMbti(mbti = "관리자형")
        }

    }
}




/* 첫번째 방법.
*  각 버튼마다 Activity를 보내고,
*  밑의 Mbti에 화면 구성을 넣은 후
*  Activity에 함수를 불러오는 방식으로 진행 가능할 것*/

/* 두번째 방법.
*  밑의 Mbti에 해당 값을 보내는 방식을 만들고,
*  다음 Activity에는 값에 알맞는 이미지를 출력하게 하는 것
*  관건은 onClick에 있는 값을 보낼 수 있는가 중요하다.*/


open class Mbti {
    @Composable
    open fun knowMbti(mbti: String) {
        val context = LocalContext.current as? Activity
        Divider( modifier = Modifier.height(3.dp))  // 반복되니 추후 변경
        Button(onClick = {
            val intent = Intent(context, ResultActivity::class.java)
            context?.startActivity(intent)
            val exp = Explorer()
            when(mbti) {
                "탐험가형" -> "${/*TODO*/}"
                "외교관형" -> "${/*TODO*/}"
                "분석가형" -> "${/*TODO*/}"
                "관리자형" -> "${/*TODO*/}"
            }
            intent.putExtra("type",mbti)  // '만약'(if) 여기서 버튼이 해당 값으로 들어가면, 값을 넘겨주는 것으로 TODO
        }) {
            Text(text = mbti)
        }
    }
}


class Explorer : Mbti() { // *S*P
//TODO

}

class Diplomats : Mbti() {  // *NF*
//TODO
}

class Analysts : Mbti() { // *NT*
//TODO
}

class Sentinels : Mbti() { // *S*J
//TODO
}