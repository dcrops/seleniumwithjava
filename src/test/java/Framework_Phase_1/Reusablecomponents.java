package Framework_Phase_1;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Reusablecomponents extends Testbase {

    public Reusablecomponents() throws FileNotFoundException {
    }

    @Test
    public void openBrowser() throws IOException {
        init();
        System.out.println("Test");
    }
}
