package link.arata.common.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 入出力関連のユーティリティ
 * 
 * @author arata
 */
public abstract class IoUtil {
    /**
     * ファイルのコピーをする
     * 
     * @param srcFileName
     *            コピー元ファイル名
     * @param destFileName
     *            コピー先ファイル名
     * @throws IOException
     *             ファイルが正しくコピーできていない場合
     */
    public static void copyFile(String srcFileName, String destFileName) throws IOException {
        File srcFile = new File(srcFileName);
        File destFile = new File(destFileName);
        @SuppressWarnings("resource")
        FileChannel inputChannel = new FileInputStream(srcFile).getChannel();
        try {
            @SuppressWarnings("resource")
            FileChannel outputChannel = new FileOutputStream(destFile).getChannel();
            try {
                outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
            } finally {
                closeQuietly(outputChannel);
            }
        } finally {
            closeQuietly(inputChannel);
        }

        if (srcFile.length() != destFile.length()) {
            throw new IOException("Failed to copy full contents from '" + srcFile + "' to '" + destFile + "'");
        }
    }

    /**
     * ファイルのクローズ。例外は無視する
     * 
     * @param closeable
     *            クローズするファイル
     */
    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
