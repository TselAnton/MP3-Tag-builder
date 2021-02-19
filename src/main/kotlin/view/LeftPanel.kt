package view


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun infoPanel() = Box(
    modifier = Modifier
        .fillMaxHeight()
        .width(400.dp)
        .border(1.dp, color = Color.Black)
) {
    Column (Modifier.fillMaxSize()) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 100.dp, max = 300.dp)
            .border(5.dp, color = Color.Red)
        ) {
            Text("Left")
            Text("Photo")
            Text("Right")
        }
    }
}
