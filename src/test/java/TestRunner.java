import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import static org.junit.Assert.assertEquals;

/**
 * Created by Andrew on 11/10/2016.
 */
public class TestRunner {
    private static final String ROOT = "root.txt";
    private static final String FILES = "files.txt";
    private static final String POEM = "poem.txt";

    @BeforeClass
    public static void testStartState() {
        try {
            String startDirectory = Reader.getStartDirectory(ROOT);
            System.out.println("Does the start directory exist?=>No");
            File test = new File(startDirectory);
            assertEquals(false, test.exists());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void testStartDirectoryCreating() {
        try {
            String startDirectory = Reader.getStartDirectory(ROOT);
            DirectoryCreator.createDirectory(startDirectory);
            System.out.println("\nThe start directory was created");
            System.out.println("Does the start directory exist?=>Yes");
            File test = new File(startDirectory);
            assertEquals(true, test.exists());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void testFirstText() {
        Runner.run();
        try {
            String startDirectory = Reader.getStartDirectory(ROOT);
            System.out.println("\nThe testing file is /temp.txt");
            System.out.println("Attachment level = 1");
            File test = new File(startDirectory + "/temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(test));
            System.out.println("Result is Kto ty jestes?");
            assertEquals("Kto ty jestes?", reader.readLine());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void testSecondText() {
        Runner.run();
        try {
            String startDirectory = Reader.getStartDirectory(ROOT);
            System.out.println("\nThe testing file is /layer/temp_1.txt");
            System.out.println("Attachment level = 2");
            File test = new File(startDirectory + "/layer/temp_1.txt");
            BufferedReader reader = new BufferedReader(new FileReader(test));
            System.out.println("Result is Polak maly.");
            assertEquals("Polak maly.", reader.readLine());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void testThirdText() {
        Runner.run();
        try {
            String startDirectory = Reader.getStartDirectory(ROOT);
            System.out.println("\nThe testing file /layer/filecsv.txt");
            System.out.println("Attachment level = 2");
            File test = new File(startDirectory + "/layer/filecsv.txt");
            BufferedReader reader = new BufferedReader(new FileReader(test));
            System.out.println("Result is Polak maly.");
            assertEquals("Polak maly.", reader.readLine());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void testFourthText() {
        Runner.run();
        try {
            String startDirectory = Reader.getStartDirectory(ROOT);
            System.out.println("\nThe testing file /temp-dir/test/file.txt");
            System.out.println("Attachment level = 3");
            File test = new File(startDirectory + "/temp-dir/test/file.txt");
            BufferedReader reader = new BufferedReader(new FileReader(test));
            System.out.println("Result is Jaki znak twoj?");
            assertEquals("Jaki znak twoj?", reader.readLine());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void testFifthText() {
        try {
            Runner.run();
            String startDirectory = Reader.getStartDirectory(ROOT);
            System.out.println("\nThe testing file /layer/temp.txt/test_file.txt");
            System.out.println("Attachment level = 3");
            File test = new File(startDirectory + "/layer/temp.txt/test_file.txt");
            BufferedReader reader = new BufferedReader(new FileReader(test));
            System.out.println("Result is Jaki znak twoj?");
            assertEquals("Jaki znak twoj?", reader.readLine());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }


}
