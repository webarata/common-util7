package link.arata.common.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Validationを行うユーティリティクラス<br>
 * 参考: http://qiita.com/kawasima/items/41632dbd423dc0445e14
 * 
 * @author arata
 *
 */
public class ValidationUtil {
    private static TrimType DEFAULT_TRIM_TYPE = TrimType.BOTH;

    /**
     * デフォルトのtrim方向を決める。明示しない場合には、このTrimが使用される。
     * 
     * @param defaultTrim
     */
    public static void setDefaultTrim(@Nonnull TrimType defaultTrimType) {
        DEFAULT_TRIM_TYPE = defaultTrimType;
    }

    /**
     * 必須チェックをする
     * 
     * @param target
     *            検査する文字列
     * @param trimType
     *            検査前に行うtrimの種類
     * @return 空文字列かnullの場合false
     */
    public static boolean required(@Nullable String target, @Nonnull TrimType trimType) {
        if (target == null) {
            return false;
        }
        String trimTarget = trimType.trim(target);

        return StringUtil.isNotEmpty(trimTarget);
    }

    /**
     * デフォルトのTrimTypeを使用した必須チェック
     * 
     * @param target
     *            検査する文字列
     * @return 空文字列かnullの場合false
     */
    public static boolean required(@Nullable String target) {
        return required(target, DEFAULT_TRIM_TYPE);
    }

    /**
     * 最小文字数のチェックをする
     * 
     * @param target
     *            検査する文字列
     * @param length
     *            最小文字数
     * @param trimType
     *            検査前に行うtrimの種類
     * @return 最小文字数以上の場合true
     */
    public static boolean minLength(@Nonnull String target, int length, @Nonnull TrimType trimType) {
        String trimTarget = trimType.trim(target);
        NormalizedString normalizedString = new NormalizedString(trimTarget);
        return normalizedString.length() >= length;
    }

    /**
     * デフォルトのTrimTypeを使用し最小文字数のチェックをする
     * 
     * @param target
     *            検査する文字列
     * @param length
     *            最小文字数
     * @param trimType
     *            検査前に行うtrimの種類
     * @return 最小文字数以上の場合true
     */
    public static boolean minLength(@Nonnull String target, int length) {
        return minLength(target, length, DEFAULT_TRIM_TYPE);
    }
}
