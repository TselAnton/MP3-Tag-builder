package utils

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

data class FileInfo(val path: String, val isFile: Boolean)

private const val MP3_EXP = "mp3"
const val ROOT_DIR = "\\"

fun getListOfFiles(path: String): List<FileInfo> {
    try {
        return if (ROOT_DIR == path) {
            File.listRoots()
                .map { it.toString() }
                .map { FileInfo(it, false) }
                .toList()

        } else {
            Files.list(Paths.get(path))
                .filter { !it.fileName.toString().startsWith(".") }
                .filter { !it.fileName.toString().contains(".") || it.fileName.toString().endsWith(MP3_EXP) }
                .map { FileInfo(it.fileName.toString(), File(it.toString()).isFile) }
                .toList()
        }
    } catch (e: Exception) {
        println("Something went wrong: $e")
        return emptyList();
    }
}
