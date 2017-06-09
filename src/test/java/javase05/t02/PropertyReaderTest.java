package javase05.t02;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by rusamaha on 6/8/17.
 */
public class PropertyReaderTest {
    PropertyReader pr;
    @Before
    public void init(){
         pr = new PropertyReader();
    }

    @Test(expected = PropertyFileNotFoundException.class)
    public void noSuchFileTest() throws Exception {
        pr.getValueByKey("se0502", "exit");
    }

    @Test
    public void existingFileAndKeyTest(){
        assertEquals("So Long! :)", pr.getValueByKey("se0502.properties", "exit"));
    }

}