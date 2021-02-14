import androidx.compose.desktop.Window
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.IntSize
import view.aboutDialog
import view.leftPanel
import view.windowMenuBar

private const val TITLE = "MP3 Tag Builder"
private const val MIN_WIDTH = 1400
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

    leftPanel()
}
