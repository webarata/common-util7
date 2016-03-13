package link.arata.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.BeforeClass;
import org.junit.Test;

public class IoUtilTest {

    private static String BASE_DIR;

    @BeforeClass
    public static void setup() {
        try {
            File file = new File(IoUtil.class.getResource("IoUtilSrc.txt").toURI());
            BASE_DIR = file.getParent();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void copyFileのテスト() throws IOException {
        IoUtil.copyFile(BASE_DIR + File.separator + "IoUtilSrc.txt", BASE_DIR + File.separator + "IoUtilDest.txt");
        assertThat(new File(BASE_DIR + File.separator + "IoUtilDest.txt").exists(), is(true));
        new File(BASE_DIR + File.separator + "IoUtilDest.txt").delete();
    }
}
