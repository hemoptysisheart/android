package com.github.hemoptysisheart.android.app.ui.compose.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.android.app.ui.compose.component.BottomNavigation
import com.github.hemoptysisheart.android.app.ui.compose.component.MenuKey.MENU_1

const val DEST_MAIN_CONTENT_1 = "DEST_MAIN_CONTENT_1"

@Composable
fun MainContent1(navController: NavHostController = rememberNavController()) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(0.5F))
        Text(text = "Main Content #1")
        Spacer(modifier = Modifier.weight(1.0F))
        BottomNavigation(navController, MENU_1)
    }
}

@Composable
@Preview
fun MainContent1Preview() {
    MainContent1()
}