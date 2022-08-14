package com.github.hemoptysisheart.android.app.ui.compose.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.android.app.ui.compose.main.MenuKey.*

@Composable
fun BottomNavigation(
    navController: NavHostController = rememberNavController(),
    focused: MenuKey = MENU_1
) {
    Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
        Spacer(modifier = Modifier.weight(0.1F))
        BottomNavigationButton("#1", focused == MENU_1) { navController.navigate(DEST_MAIN_CONTENT_1) }
        Spacer(modifier = Modifier.weight(0.2F))
        BottomNavigationButton("#2", focused == MENU_2) { navController.navigate(DEST_MAIN_CONTENT_2) }
        Spacer(modifier = Modifier.weight(0.2F))
        BottomNavigationButton("#3", focused == MENU_3) { navController.navigate(DEST_MAIN_CONTENT_3) }
        Spacer(modifier = Modifier.weight(0.1F))
    }
}

enum class MenuKey {
    MENU_1,
    MENU_2,
    MENU_3
}

@Composable
@Preview
fun BottomNavigationPreview() {
    BottomNavigation()
}
