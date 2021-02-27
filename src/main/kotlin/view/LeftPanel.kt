package view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorXmlResource
import androidx.compose.ui.unit.dp

@Composable
fun infoPanel() = Column (modifier = Modifier
        .fillMaxHeight()
        .width(400.dp)
        .border(1.dp, color = Color.Black)
) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 100.dp, max = 300.dp)
        .border(5.dp, color = Color.Red)    //todo: remove
    ) {

//        val leftButtonImg =  vectorXmlResource("img\\left_button.svg")
//        val leftButtonImg =  imageResource("img\\left_button.png")
//
//        Image(leftButtonImg)
//
//        Text("Photo")
//        Text("Right")
    }
}
