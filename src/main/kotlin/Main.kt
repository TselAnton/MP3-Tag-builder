import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import view.aboutDialog
import view.filesTableBox
import view.infoPanel
import view.windowMenuBar

private const val TITLE = "MP3 Tag Builder"
private const val MIN_WIDTH = 900
private const val MIN_HEIGHT = 600

val aboutModalFlag: MutableState<Boolean> = mutableStateOf(false)

fun main() = Window(
    title = TITLE,
    size = IntSize(MIN_WIDTH, MIN_HEIGHT),
    icon = null,
    menuBar = windowMenuBar(aboutModalFlag),
) {

    if (aboutModalFlag.value) {
        aboutDialog(aboutModalFlag)
    }

    Row(modifier = Modifier.fillMaxSize()) {
        //todo: add left panel later
        filesTableBox()
    }
}
