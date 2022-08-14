package com.github.hemoptysisheart.android.app.ui.compose.main

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.android.R
import com.github.hemoptysisheart.android.app.ui.compose.main.MenuKey.MENU_3

const val DEST_MAIN_CONTENT_3 = "DEST_MAIN_CONTENT_3"
const val TAG = "MainContent3"

@Composable
fun MainContent3(navController: NavHostController = rememberNavController()) {
    val tutorial = remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .weight(1.0F)
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(R.string.pref_tutorial_switch_label))
                Spacer(modifier = Modifier.weight(1.0F))
                Switch(checked = tutorial.value, onCheckedChange = {
                    Log.v(TAG, "#onClick args : checked=$it")
                    tutorial.value = it
                })
            }
        }
        BottomNavigation(navController, MENU_3)
    }
}

@Composable
@Preview
fun MainContent3Preview() {
    MainContent3()
}
