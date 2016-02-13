package link.arata.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * 入出力関連のユーティリティ
 * 
 * @author arata
 */
public class IoUtil {
    /**
     * InputStreamからバイナリデータの読み込み
     * 
     * @param is
     *            読み込むInputStream
     * @return 読み込んだ結果
     * @throws IOException
     *             発生する例外
     */
    @Nullable
    public static byte[] readByteAndClose(@Nonnull InputStream is) throws IOException {
        byte[] result = null;
        ByteArrayOutputStream baos = null;
        try {
            int block = 8 * 1024;
            baos = new ByteArrayOutputStream(block);
            byte[] buff = new byte[block];
            while (true) {
                int len = is.read(buff, 0, block);
                if (len < 0) {
                    break;
                }
                baos.write(buff, 0, len);
            }
            result = baos.toByteArray();
        } finally {
            is.close();
            if (baos != null) {
                baos.close();
            }
        }

        return result;
    }
}
