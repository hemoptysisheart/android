package com.github.hemoptysisheart.android.app.ui.compose.tutorial

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.android.R

const val DEST_STEP_3 = "DEST_STEP_3"

@Composable
fun Step3(
    navController: NavHostController = rememberNavController(),
    onComplete: (context: Context) -> Unit = {}
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.5F))
        Text(text = "Step #3")
        Spacer(modifier = Modifier.weight(1.0F))
        Row {
            Button(onClick = { navController.navigateUp() }) {
                Text(text = stringResource(R.string.label_navigate_backward))
            }
            Spacer(modifier = Modifier.weight(1.0F))
            Button(onClick = { onComplete(context) }) {
                Text(text = stringResource(id = R.string.label_complete))
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Step3Preview() {
    Step3()
}