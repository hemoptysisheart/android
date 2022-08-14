package com.github.hemoptysisheart.android.app.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.github.hemoptysisheart.android.R
import com.github.hemoptysisheart.android.app.activity.LauncherActivity.Companion.TAG
import com.github.hemoptysisheart.android.ui.theme.AndroidStudyTheme
import com.github.hemoptysisheart.domain.preferences.Preferences
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@AndroidEntryPoint
class LauncherActivity : ComponentActivity() {
    companion object {
        val TAG = LauncherActivity::class.simpleName
    }

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidStudyTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    LauncherLayout(
                        navigateTo = {
                            if (preferences.tutorial.enable) {
                                Intent(baseContext, MainActivity::class.java)
                            } else {
                                Intent(baseContext, TutorialActivity::class.java)
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LauncherLayout(navigateTo: () -> Intent = { Intent() }) {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.launcher_main_message),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }

    LaunchedEffect(true) {
        delay(2_000L)

        val intent = navigateTo()
        Log.v(TAG, "#LaunchedEffect : intent=$intent")
        context.startActivity(intent)
    }
}

@Composable
@Preview(showBackground = true)
fun LauncherPreview() {
    AndroidStudyTheme {
        LauncherLayout()
    }
}