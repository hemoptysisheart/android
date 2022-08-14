package com.github.hemoptysisheart.android.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.android.app.ui.compose.main.*
import com.github.hemoptysisheart.android.ui.theme.AndroidStudyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    companion object {
        val TAG = MainActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidStudyTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MainLayout()
                }
            }
        }
    }
}

@Composable
fun MainLayout() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = DEST_MAIN_CONTENT_1) {
        composable(DEST_MAIN_CONTENT_1) { MainContent1(navController) }
        composable(DEST_MAIN_CONTENT_2) { MainContent2(navController) }
        composable(DEST_MAIN_CONTENT_3) { MainContent3(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun MainLayoutPreview() {
    AndroidStudyTheme {
        MainLayout()
    }
}