package link.arata.common.util;

import javax.annotation.Nullable;

/**
 * 数値関連のユーティリティクラス
 * 
 * @author arata
 *
 */
public class NumberUtil {
    /**
     * 文字列をIntegerに変換する。変換出来ない場合にはnullを返す。
     * 
     * @param value
     *            変換する文字列
     * @return 変換した数値
     */
    @Nullable
    public static Integer formatInt(@Nullable String value) {
        if (value == null) {
            return null;
        }
        try {
            return new Integer(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
