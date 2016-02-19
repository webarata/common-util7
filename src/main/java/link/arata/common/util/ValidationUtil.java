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
     * @param value
     *            検査する文字列
     * @param trimType
     *            検査前に行うtrimの種類
     * @return 空文字列かnullの場合false
     */
    public static boolean required(@Nullable String value, @Nonnull TrimType trimType) {
        if (value == null) {
            return false;
        }
        String trimValue = trimType.trim(value);

        return StringUtil.isNotEmpty(trimValue);
    }

    /**
     * デフォルトのTrimTypeを使用した必須チェック
     * 
     * @param value
     *            検査する文字列
     * @return 空文字列かnullの場合false
     */
    public static boolean required(@Nullable String value) {
        return required(value, DEFAULT_TRIM_TYPE);
    }

    /**
     * 最小文字数のチェックをする
     * 
     * @param value
     *            検査する文字列
     * @param length
     *            最小文字数
     * @param trimType
     *            検査前に行うtrimの種類
     * @return 最小文字数以上の場合true
     */
    public static boolean minLength(@Nonnull String value, int length, @Nonnull TrimType trimType) {
        String trimValue = trimType.trim(value);
        NormalizedString normalizedString = new NormalizedString(trimValue);
        return normalizedString.length() >= length;
    }

    /**
     * デフォルトのTrimTypeを使用し最小文字数のチェックをする
     * 
     * @param value
     *            検査する文字列
     * @param length
     *            最小文字数
     * @param trimType
     *            検査前に行うtrimの種類
     * @return 最小文字数以上の場合true
     */
    public static boolean minLength(@Nonnull String value, int length) {
        return minLength(value, length, DEFAULT_TRIM_TYPE);
    }

    /**
     * 最大文字数のチェックをする
     * 
     * @param value
     *            検査する文字列
     * @param length
     *            最大文字数
     * @param trimType
     *            検査前に行うtrimの種類
     * @return 最大文字数以上の場合true
     */
    public static boolean maxLength(@Nonnull String value, int length, @Nonnull TrimType trimType) {
        String trimValue = trimType.trim(value);
        NormalizedString normalizedString = new NormalizedString(trimValue);
        return normalizedString.length() <= length;
    }

    /**
     * デフォルトのTrimTypeを使用し最大文字数のチェックをする
     * 
     * @param value
     *            検査する文字列
     * @param length
     *            最大文字数
     * @param trimType
     *            検査前に行うtrimの種類
     * @return 最大文字数以上の場合true
     */
    public static boolean maxLength(@Nonnull String value, int length) {
        return maxLength(value, length, DEFAULT_TRIM_TYPE);
    }
}
