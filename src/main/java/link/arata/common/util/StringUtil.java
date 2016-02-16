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

    /**
     * 文字列がnullや空文字でないことをチェックする
     * 
     * @param target
     *            検査する文字列
     * @return 文字列がnullもしくは空文字列でない場合true
     */
    public static boolean isNotEmpty(@Nullable String target) {
        return !isEmpty(target);
    }

    /**
     * 文字列の左側の空白とそれに準ずる文字の連続を取り除く
     * 
     * @param target
     *            対象の文字列
     * @return 左側をtrimした結果の文字列
     */
    @Nonnull
    public static String trimLeft(@Nonnull String target) {
        int i = 0;
        for (; i < target.length(); i++) {
            if (!Character.isWhitespace(target.charAt(i))) {
                break;
            }
        }

        return target.substring(i);
    }

    /**
     * 文字列の右側の空白とそれに準ずる文字の連続を取り除く
     * 
     * @param target
     *            対象の文字列
     * @return 右側をtrimした結果の文字列
     */
    @Nonnull
    public static String trimRight(@Nonnull String target) {
        int i = target.length() - 1;
        for (; i >= 0; i--) {
            if (!Character.isWhitespace(target.charAt(i))) {
                break;
            }
        }

        return target.substring(0, i + 1);
    }

    /**
     * 文字列の両端の空白とそれに準ずる文字の連続を取り除く
     * 
     * @param target
     *            対象の文字列
     * @return 右側をtrimした結果の文字列
     */
    @Nonnull
    public static String trim(@Nonnull String target) {
        String trimString = trimLeft(target);
        return trimRight(trimString);
    }
}
