package config

import com.google.gson.Gson
import java.io.File

const val settingsFileName = "MP3-Tag-Builder-App-Settings.json"
const val settingsFolderName = ".mp3-tag-builder-settings"

val internalPath: String = File("").absolutePath
var gson = Gson()

/**
 * App settings
 */
data class AppSettings (
    val fromFolderPath: String = internalPath, // last chosen folder path
    val toFolderPath: String = internalPath   // last saved folder path
) {
    fun get(): AppSettings {
        val fileSettingsText = getSettingsFile().readText()
        return gson.fromJson(fileSettingsText, AppSettings::class.java)
    }

    fun save(settings: AppSettings) {
        val settingsJsonText = gson.toJson(settings)
        getSettingsFile().writeText(settingsJsonText)
    }

    private fun getSettingsFile(): File {
        var file = File(internalPath + "\\" + settingsFolderName)
        if (!file.exists()) {
            file.mkdir()
        }

        file = File(internalPath + "\\" + settingsFolderName + "\\" + settingsFileName)
        if (!file.exists()) {
            file.createNewFile()
            file.writeText(gson.toJson(AppSettings()))
        }

        return file
    }
}
