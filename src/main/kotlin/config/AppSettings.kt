package config

import com.google.gson.Gson
import utils.ROOT_DIR
import java.io.File
import java.nio.file.Paths

const val settingsFileName = "MP3-Tag-Builder-App-Settings.json"
const val settingsFolderName = ".mp3-tag-builder-settings"

val internalPath: String = Paths.get("").toAbsolutePath().toString()
var gson = Gson()

/**
 * App settings
 */
data class AppSettings (
    var fromFolderPath: String = internalPath, // last chosen folder path
    var toFolderPath: String = internalPath   // last saved folder path
) {
    fun get(): AppSettings {
        val fileSettingsText = getSettingsFile().readText()
        return gson.fromJson(fileSettingsText, AppSettings::class.java)
    }

    fun save(settings: AppSettings) {
        val settingsJsonText = gson.toJson(settings)
        getSettingsFile().writeText(settingsJsonText)
    }

    fun fromPathUp(): String {
        this.fromFolderPath = upPath(fromFolderPath)
        this.save(this)
        return fromFolderPath
    }

    fun toPathUp(): String {
        toFolderPath = upPath(toFolderPath)
        this.save(this)
        return toFolderPath
    }

    fun fromPathDown(path: String): String {
        fromFolderPath = downPath(fromFolderPath, path)
        this.save(this)
        return fromFolderPath
    }

    fun toPathDown(path: String): String {
        toFolderPath = downPath(toFolderPath, path)
        this.save(this)
        return toFolderPath
    }

    private fun downPath(path: String, to: String): String {
        if (path == ROOT_DIR) {
            return to
        }
        return if (path.endsWith("\\")) path + to else path + "\\" + to
    }

    private fun upPath(path: String): String {
        val pathSplit = path.split("\\")

        if (pathSplit.size > 1) {
            if (pathSplit.size == 2 && pathSplit[1].isBlank()) {
                return ROOT_DIR
            } else if (pathSplit.size == 2 && pathSplit[1].isNotBlank()) {
                val index: Int = path.indexOfLast { '\\' == it }
                return if (index != -1) path.substring(0, index + 1) else path
            }
            val index: Int = path.indexOfLast { '\\' == it }
            return if (index != -1) path.substring(0, index) else path
        } else {
            return ROOT_DIR
        }
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
