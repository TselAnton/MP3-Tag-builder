package view

import androidx.compose.desktop.AppManager
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*

fun windowMenuBar(authorModal: MutableState<Boolean>) = MenuBar(
    Menu(
        name = "Меню",
        MenuItem(
            name = "О приложении",
            shortcut = KeyStroke(Key.L),
            onClick = { authorModal.value = true }
        ),
        MenuItem(
            name = "Выход",
            onClick = { AppManager.exit() },
            shortcut = KeyStroke(Key.Q)
        )
    )
)

@Composable
fun aboutDialog(aboutModalFlag: MutableState<Boolean>) = Dialog(
    onDismissRequest = {aboutModalFlag.value = false},
    properties = DesktopDialogProperties(
        "О приложении",
        size = IntSize(300, 190)
    )
) {
    Text(
        "Автор: Цель Антон",
        color = Color.Black,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(70.dp, 10.dp),
        fontStyle = FontStyle.Italic
    )
    Text(
        "При поддержки пары бутылок с крепкими напитками и нескольких бессонных ночей :)",
        color = Color.Black,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(10.dp, 40.dp)
    )
}
