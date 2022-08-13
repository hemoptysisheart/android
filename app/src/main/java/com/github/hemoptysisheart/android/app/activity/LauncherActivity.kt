package com.github.hemoptysisheart.android.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.android.ui.theme.AndroidStudyTheme

class LauncherActivity : ComponentActivity() {
    companion object {
        val TAG = LauncherActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    LauncherLayout()
                }
            }
        }
    }
}

@Composable
fun LauncherLayout() {
    Text(text = "Hello!")
}

@Composable
@Preview(showBackground = true)
fun LauncherPreview() {
    AndroidStudyTheme {
        LauncherLayout()
    }
}