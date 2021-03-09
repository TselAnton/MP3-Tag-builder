package utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import kotlin.io.FileTreeWalk;

public class FileUtils {

    public static List<FileInfo> getAllFilesByPath(String path) {
//        return Files.list(Paths.get(path))

        return Collections.emptyList();
    }

    public static class FileInfo {
        private Path path;
        private boolean isFolder;

        public FileInfo(Path path, boolean isFolder) {
            this.path = path;
            this.isFolder = isFolder;
        }

        public Path getPath() {
            return path;
        }

        public void setPath(Path path) {
            this.path = path;
        }

        public boolean isFolder() {
            return isFolder;
        }

        public void setFolder(boolean folder) {
            isFolder = folder;
        }
    }
}
