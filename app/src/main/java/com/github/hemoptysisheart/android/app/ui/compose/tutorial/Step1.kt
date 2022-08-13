package com.github.hemoptysisheart.android.app.ui.compose.tutorial

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.android.R

const val DEST_STEP_1 = "STEP_1"

@Composable
fun Step1(navController: NavHostController = rememberNavController()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.5F))
        Text(text = "Step #1")
        Spacer(modifier = Modifier.weight(1.0F))
        Row {
            Button(onClick = {}, enabled = false) {
                Text(text = stringResource(R.string.label_navigate_backward))
            }
            Spacer(modifier = Modifier.weight(1.0F))
            Button(onClick = { navController.navigate(DEST_STEP_2) }) {
                Text(text = stringResource(R.string.label_navigate_forward))
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Step1Preview() {
    Step1()
}