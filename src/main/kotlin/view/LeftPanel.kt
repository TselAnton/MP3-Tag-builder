package view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun leftPanel() = Box(
    modifier = Modifier
        .fillMaxHeight()
        .width(500.dp)
        .border(3.dp, color = Color.Gray)
) {

}
