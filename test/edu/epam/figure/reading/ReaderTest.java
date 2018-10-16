package edu.epam.figure.reading;

import edu.epam.figure.reader.TetraReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ReaderTest {
    private static final String PATH = "input\\test.txt";
    private TetraReader reader;

    @BeforeClass
    public void setUp(){
        reader = new TetraReader();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void checkFilepath(){
        List<String> stringList = reader.readInfo("input\\in.txt");
    }
}
