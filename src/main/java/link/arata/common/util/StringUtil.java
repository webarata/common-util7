package link.arata.common.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * String関連のユーティリティクラス
 * 
 * @author arata
 */
public class StringUtil {
    /**
     * 文字列がnullか空文字列かをチェックする
     * 
     * @param target
     *            検査する文字列
     * @return 文字列がnullもしくは空文字列の場合true
     */
    public static boolean isEmpty(@Nullable String target) {
        if (target == null) {
            return true;
        }
        if (target.length() == 0) {
            return true;
        }
        return false;
    }

    public static String trimLeft(@Nonnull String target) {
        int i = 0;
        for (; i < target.length(); i++) {
            if (!Character.isWhitespace(target.charAt(i))) {
                break;
            }
        }

        return target.substring(i);
    }
}
