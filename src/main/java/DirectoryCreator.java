import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

/**
 * Created by Andrew on 11/10/2016.
 */

public class DirectoryCreator {
    public static void createDirectory(String startDirectory) {
        File startDir = new File(startDirectory);
        if (!startDir.exists()) {
            startDir.mkdirs();
        }
    }

    public static void createFile(String startDirectory) throws IOException {
        File startDir = new File(startDirectory);
        startDir.createNewFile();
    }

    public static void createFilesDirectories(Set<String> set, String startDirectory, Set<String> poemSet) throws IOException {
        for (String fileWay : set) {
            String currentDirectory = startDirectory;
            int attachment = -2;
            int len = fileWay.split("/").length;
            for (String newItem : fileWay.split("/")) {
                attachment++;
                currentDirectory += File.separator + newItem;
                if (attachment + 2 == len) {
                    if (newItem.contains(".")) {
                        createFile(currentDirectory);
                        pastePoem(poemSet, currentDirectory, attachment);

                    } else
                        createDirectory(currentDirectory);
                } else
                    createDirectory(currentDirectory);
            }
        }
    }

    public static void pastePoem(Set<String> poem, String currentDirectory, int attachment) throws IOException {
        FileWriter poemWriter = new FileWriter(new File(currentDirectory));
        poemWriter.write((String) poem.toArray()[attachment]);
        poemWriter.close();
    }
}
