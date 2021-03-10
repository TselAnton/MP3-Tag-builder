package view

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorXmlResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import config.AppSettings
import sun.swing.plaf.synth.Paint9Painter
import utils.getListOfFiles

val appSettings = AppSettings().get()

@Composable
fun filesTableBox() = Box(
    modifier = Modifier
        .fillMaxSize()
        .border(1.dp, color = Color.Black)
) {
    val fromFolderPath = remember { mutableStateOf(appSettings.fromFolderPath) }
    val listOfFiles = remember { mutableStateOf(getListOfFiles(appSettings.fromFolderPath)) }

    Column {
        Row(Modifier.padding(10.dp)) {
            IconButton (    // Up button
                onClick = {
                    fromFolderPath.value = appSettings.fromPathUp()
                    listOfFiles.value = getListOfFiles(appSettings.fromFolderPath)
                },
                modifier = Modifier
                    .then(Modifier.preferredSize(20.dp))
            ) {
                Icon(Icons.Filled.KeyboardArrowUp)
            }

            Text("Current folder:", Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp), fontWeight = FontWeight.Bold)
            Text(fromFolderPath.value, Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp))

            IconButton(     // Save button
                onClick = {

                },
                modifier = Modifier
                    .padding(30.dp, 0.dp, 0.dp, 0.dp)
                    .fillMaxWidth(0.3f)
                    .preferredHeight(30.dp)
            ) {
                Icon(imageVector = vectorXmlResource("icons/diskette.svg"))
            }
        }

        ScrollableColumn {
            listOfFiles.value.forEach {
                Row(Modifier.padding(10.dp)) {
                    Button(
                        onClick = {
                            if (it.isFile) {
                                //todo
                            } else {
                                fromFolderPath.value = appSettings.fromPathDown(it.path)
                                listOfFiles.value = getListOfFiles(appSettings.fromFolderPath)
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonConstants.defaultButtonColors(backgroundColor = Color(50, 120, 200))
                    ) {
                        Checkbox(
                            checked = true,
                            onCheckedChange = {}
                        )

                        Text(it.path, color = if (it.isFile) Color.Cyan else Color.White)
                    }
                }
            }
        }
    }
}
