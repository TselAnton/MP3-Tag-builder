package view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun filesTableBox() = Box(
    modifier = Modifier
        .fillMaxSize()
        .border(1.dp, color = Color.Black)
) {
    Text("Some text")
}