package com.github.hemoptysisheart.android.app.ui.compose.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

const val DEST_MAIN = "DEST_MAIN"

@Composable
fun Main() {
    Text(text = "Main")
}

@Composable
@Preview(showBackground = true)
fun MainLayout() {
    Main()
}