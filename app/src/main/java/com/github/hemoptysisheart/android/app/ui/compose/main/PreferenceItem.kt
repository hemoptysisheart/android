package com.github.hemoptysisheart.android.app.ui.compose.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PreferenceGroupItem(label: String, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Transparent)
            .padding(8.dp)
            .clickable { onClick }
    ) {
        Text(text = label)
        Spacer(modifier = Modifier.weight(1.0F))
        Text(text = ">", color = Color.Gray)
    }
}

@Composable
@Preview
fun PreferenceGroupItemPreview() {
    PreferenceGroupItem("pref. item preview")
}