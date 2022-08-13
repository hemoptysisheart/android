package com.github.hemoptysisheart.android.app.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.github.hemoptysisheart.android.app.ui.compose.tutorial.*
import com.github.hemoptysisheart.android.ui.theme.AndroidStudyTheme
import com.github.hemoptysisheart.domain.preferences.Preferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TutorialActivity : ComponentActivity() {
    companion object {
        val TAG = TutorialActivity::class.simpleName
    }

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    TutorialLayout(
                        onComplete = { context ->
                            preferences.tutorial.enable = true
                            Log.v(TAG, "#onComplete tutorial pref. updated : preferences=${preferences}")

                            context.startActivity(Intent(context, MainActivity::class.java))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun TutorialLayout(onComplete: (context: Context) -> Unit = {}) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = DEST_STEP_1) {
        composable(DEST_STEP_1) { Step1(navController) }
        composable(DEST_STEP_2) { Step2(navController) }
        composable(DEST_STEP_3) { Step3(navController, onComplete) }
    }
}

@Composable
@Preview(showBackground = true)
fun TutorialLayoutPreview() {
    AndroidStudyTheme {
        TutorialLayout()
    }
}