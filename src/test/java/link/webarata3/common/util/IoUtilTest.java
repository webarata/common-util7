package link.webarata3.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class IoUtilTest {

    private static String BASE_DIR;

    @BeforeClass
    public static void setUpClass() throws URISyntaxException {
        File file = new File(IoUtil.class.getResource("IoUtilSrc.txt").toURI());
        BASE_DIR = file.getParent();
    }

    public static class ファイルコピー {
        @After
        public void tearDown() {
            new File(BASE_DIR + File.separator + "IoUtilDest.txt").delete();
        }

        @Test
        public void copyFileのファイル名の場合のテスト() throws IOException {
            IoUtil.copyFile(BASE_DIR + File.separator + "IoUtilSrc.txt", BASE_DIR + File.separator + "IoUtilDest.txt");

            assertThat(new File(BASE_DIR + File.separator + "IoUtilDest.txt").exists(), is(true));
        }

        @Test
        public void copyFileのstreamの場合テスト() throws IOException {
            IoUtil.copyFile(new FileInputStream(new File(BASE_DIR, "IoUtilSrc.txt")),
                    new FileOutputStream(new File(BASE_DIR, "IoUtilDest.txt")));

            assertThat(new File(BASE_DIR + File.separator + "IoUtilDest.txt").exists(), is(true));
        }
    }
}
