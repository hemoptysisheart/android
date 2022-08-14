package com.github.hemoptysisheart.android.app.ui.compose.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.android.app.ui.compose.component.MenuKey.*
import com.github.hemoptysisheart.android.app.ui.compose.main.DEST_MAIN_CONTENT_1
import com.github.hemoptysisheart.android.app.ui.compose.main.DEST_MAIN_CONTENT_2
import com.github.hemoptysisheart.android.app.ui.compose.main.DEST_MAIN_CONTENT_3

@Composable
fun BottomNavigation(
    navController: NavHostController = rememberNavController(),
    focused: MenuKey = MENU_1
) {
    Row(modifier = Modifier.padding(10.dp)) {
        if (MENU_1 == focused) {
            Button(onClick = { }, enabled = false) {
                Text(text = "#1", fontWeight = Bold)
            }
        } else {
            Button(onClick = { navController.navigate(DEST_MAIN_CONTENT_1) }) {
                Text(text = "#1")
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        if (MENU_2 == focused) {
            Button(onClick = { }, enabled = false) {
                Text(text = "#2", fontWeight = Bold)
            }
        } else {
            Button(onClick = { navController.navigate(DEST_MAIN_CONTENT_2) }) {
                Text(text = "#2")
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        if (MENU_3 == focused) {
            Button(onClick = { }, enabled = false) {
                Text(text = "#3", fontWeight = Bold)
            }
        } else {
            Button(onClick = { navController.navigate(DEST_MAIN_CONTENT_3) }) {
                Text(text = "#3")
            }
        }
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
