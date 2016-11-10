import java.io.IOException;
import java.util.Set;

/**
 * Created by Andrew on 11/10/2016.
 */
public class Runner {
    private static final String ROOT = "root.txt";
    private static final String FILES = "files.txt";
    private static final String POEM = "poem.txt";

    public static void run() {
        try {
            String startDirectory = Reader.getStartDirectory(ROOT);
            DirectoryCreator.createDirectory(startDirectory);
            Set<String> dirSet = Reader.getStringSet(FILES);
            Set<String> poemSet = Reader.getStringSet(POEM);
            DirectoryCreator.createFilesDirectories(dirSet, startDirectory, poemSet);
        } catch (IOException exception) {
            exception.getLocalizedMessage();
        }

    }
}
