import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Andrew on 10/21/2016.
 */
public class Reader {

    public static String getStartDirectory(String root) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(root)));
        String startDirectory = reader.readLine() + File.separator + reader.readLine();
        return startDirectory;
    }

    public static Set<String> getStringSet(String files) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(files)));
        Set<String> set = new LinkedHashSet<String>();
        String currentDirectory = reader.readLine();
        while (currentDirectory != null) {
            set.add(currentDirectory);
            currentDirectory = reader.readLine();
        }
        reader.close();
        return set;
    }
}
