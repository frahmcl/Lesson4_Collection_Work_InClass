package us.mattgreen.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import us.mattgreen.FileInput;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FileInputTest {
    private FileInput indata;
    @Before
    public void setUp(){
       indata  = new FileInput("the_book.csv");
    }
    @Test
    public void testFile(){

        assertNotNull("Reader should return data.  ",
                indata.fileReadLine());

    }
    @After
    public void tearDown(){
        indata.fileClose();
    }
}
