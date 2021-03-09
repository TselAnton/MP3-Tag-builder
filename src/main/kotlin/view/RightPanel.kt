package view

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon

import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import config.AppSettings
import utils.getListOfFiles
import javax.swing.border.Border

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
            Button(
                onClick = {
                    fromFolderPath.value = appSettings.fromPathUp()
                    listOfFiles.value = getListOfFiles(appSettings.fromFolderPath)
                },
                modifier = Modifier
                    .then(Modifier.preferredSize(20.dp)),
            ) {
//                Icon(asset = Icons.Filled.KeyboardArrowUp, tint = Color.White)
            }

            Text(
                "Current folder is ${fromFolderPath.value}",
                Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)
            )
        }

        ScrollableColumn {
            listOfFiles.value.forEach {
                Button(
                    onClick = {
                        fromFolderPath.value = appSettings.fromPathDown(it.path)
                        listOfFiles.value = getListOfFiles(appSettings.fromFolderPath)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.LightGray)
                ) {
                    Text(it.path, color = if (it.isFile) Color.Cyan else Color.White)
                }
            }
        }
    }

}