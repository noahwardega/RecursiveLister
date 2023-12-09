import java.io.File;

public class FileLister {

    public String listAllFiles(File directory) {
        StringBuilder result = new StringBuilder();
        listFiles(directory, result, 0);
        return result.toString();
    }

    private void listFiles(File directory, StringBuilder result, int depth) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                for (int i = 0; i < depth; i++) {
                    result.append("  ");
                }
                result.append(file.getName()).append("\n");

                if (file.isDirectory()) {
                    listFiles(file, result, depth + 1);
                }
            }
        }
    }
}
