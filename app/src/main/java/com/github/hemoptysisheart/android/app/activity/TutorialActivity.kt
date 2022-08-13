package com.github.hemoptysisheart.android.app.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.hemoptysisheart.android.R
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
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tutorial", fontSize = 50.sp)
        Spacer(modifier = Modifier.height(120.dp))
        Button(onClick = { onComplete(context) }, modifier = Modifier.padding(12.dp)) {
            Text(text = stringResource(id = R.string.label_complete), fontSize = 24.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TutorialLayoutPreview() {
    AndroidStudyTheme {
        TutorialLayout()
    }
}