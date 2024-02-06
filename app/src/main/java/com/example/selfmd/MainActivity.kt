package com.example.selfmd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.selfmd.navigation.NavGraph
import com.example.selfmd.ui.theme.SelfMdTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SelfMdTheme {
                Surface(modifier = Modifier
                    .statusBarsPadding()
                    .background(MaterialTheme.colorScheme.primary)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))) {

                        val navController = rememberNavController()
                        NavGraph(navController = navController)

                }

            }

        }
    }
}









