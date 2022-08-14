package com.github.hemoptysisheart.android.app.ui.compose.main

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavigationButton(label: String = "BNB", focus: Boolean = false, onClick: () -> Unit = {}) {
    Button(onClick = onClick, enabled = !focus) {
        if (focus) {
            Text(text = label, fontWeight = Bold)
        } else {
            Text(text = label)
        }
    }
}

@Composable
@Preview
fun BottomNavigationButtonPreviewNoFocus() {
    BottomNavigationButton()
}

@Composable
@Preview
fun BottomNavigationButtonPreviewFocus() {
    BottomNavigationButton(focus = true)
}
