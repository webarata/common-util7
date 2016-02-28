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
public abstract class ValidationUtil {
    private static TrimType DEFAULT_TRIM_TYPE = TrimType.BOTH;

    private static LineBreakType DEFAULT_LINE_BREAK_TYPE = LineBreakType.LF;

    /**
     * デフォルトのtrim方向を決める。明示しない場合には、このTrimが使用される。
     * 
     * @param defaultTrim
     *            デフォルトのtrim方向
     */
    public static void setDefaultTrim(@Nonnull TrimType defaultTrimType) {
        DEFAULT_TRIM_TYPE = defaultTrimType;
    }

    /**
     * デフォルトの改行コードを決める。
     * 
     * @param lineBreakType
     *            デフォルトの改行コード
     */
    public static void setDefaultLineBreakType(@Nonnull LineBreakType lineBreakType) {
        DEFAULT_LINE_BREAK_TYPE = lineBreakType;
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
     * @param lineBreakType
     *            正規化する改行コード
     * @param trimType
     *            検査前に行うtrimの種類
     * @return 最小文字数以上の場合true
     */
    public static boolean minLength(@Nonnull String value, int length, @Nonnull LineBreakType lineBreakType,
            @Nonnull TrimType trimType) {
        value = trimType.trim(value);
        value = StringUtil.normalizeLineBreak(value, lineBreakType);
        NormalizedString normalizedString = new NormalizedString(value);
        return normalizedString.length() >= length;
    }

    /**
     * デフォルトのLineBreakType、TrimTypeを使用し最小文字数のチェックをする
     * 
     * @param value
     *            検査する文字列
     * @param length
     *            最小文字数
     * @return 最小文字数以上の場合true
     */
    public static boolean minLength(@Nonnull String value, int length) {
        return minLength(value, length, DEFAULT_LINE_BREAK_TYPE, DEFAULT_TRIM_TYPE);
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
     * @param lineBreakType
     *            正規化する改行コード
     * @return 最大文字数以上の場合true
     */
    public static boolean maxLength(@Nonnull String value, int length, @Nonnull LineBreakType lineBreakType,
            @Nonnull TrimType trimType) {
        value = trimType.trim(value);
        value = StringUtil.normalizeLineBreak(value, lineBreakType);
        NormalizedString normalizedString = new NormalizedString(value);
        return normalizedString.length() <= length;
    }

    /**
     * デフォルトのLineBreakType、TrimTypeを使用し最大文字数のチェックをする
     * 
     * @param value
     *            検査する文字列
     * @param length
     *            最大文字数
     * @return 最大文字数以上の場合true
     */
    public static boolean maxLength(@Nonnull String value, int length) {
        return maxLength(value, length, DEFAULT_LINE_BREAK_TYPE, DEFAULT_TRIM_TYPE);
    }

    /**
     * 整数であるかをチェックする
     * 
     * @param value
     *            検査する文字列
     * @return 整数の場合true
     */
    public static boolean isInt(@Nonnull String value) {
        return NumberUtil.formatInt(value) != null;
    }
}
