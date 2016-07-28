package link.webarata3.common.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import link.webarata3.common.enums.LineBreakType;
import link.webarata3.common.enums.TrimType;
import link.webarata3.common.enums.UseEmBlank;
import link.webarata3.common.enums.UseLineBreak;
import link.webarata3.common.util.NormalizedString;
import link.webarata3.common.util.NumberUtil;
import link.webarata3.common.util.RegexUtil;
import link.webarata3.common.util.StringUtil;

/**
 * Validation用のHelper
 * 
 * @author arata
 *
 */
public class ValidationHelper {
    private TrimType trimType;
    private LineBreakType lineBreakType;

    // インスタンスのキャッシュ
    private static Map<TrimType, Map<LineBreakType, ValidationHelper>> instanceMap;

    static {
        instanceMap = new HashMap<>();
    }

    /**
     * コンストラクタ。
     * 
     * @param trimType
     *            Validationの前に行うTrimの方向
     * @param lineBrekeType
     *            正規化する改行の種類
     */
    private ValidationHelper(TrimType trimType, LineBreakType lineBreakType) {
        this.trimType = Objects.requireNonNull(trimType);
        this.lineBreakType = Objects.requireNonNull(lineBreakType);
    }

    /**
     * インスタンスを取得する
     * 
     * @param trimType
     *            Validationの前に行うTrimの方向
     * @param lineBreakType
     *            正規化する改行の種類
     * @return ValidationHelperのインスタンス
     */
    public static synchronized ValidationHelper getInstance(TrimType trimType, LineBreakType lineBreakType) {
        Objects.requireNonNull(trimType);
        Objects.requireNonNull(lineBreakType);

        Map<LineBreakType, ValidationHelper> map = instanceMap.get(trimType);
        if (map == null) {
            map = new HashMap<LineBreakType, ValidationHelper>();
            instanceMap.put(trimType, map);
        }
        ValidationHelper validationHelper = map.get(lineBreakType);
        if (validationHelper == null) {
            validationHelper = new ValidationHelper(trimType, lineBreakType);
            map.put(lineBreakType, validationHelper);
        }
        return validationHelper;
    }

    /**
     * 必須チェックをする
     * 
     * @param value
     *            検査する文字列
     * @return 空文字列かnullの場合false
     */
    public boolean required(String value) {
        if (value == null) {
            return false;
        }
        String trimValue = trimType.trim(value);

        return StringUtil.isNotEmpty(trimValue);
    }

    /**
     * 最小文字数のチェックをする
     * 
     * @param value
     *            検査する文字列
     * @param length
     *            最小文字数
     * @return 最小文字数以上の場合true
     */
    public boolean minLength(String value, int length) {
        Objects.requireNonNull(value);

        String trimValue = trimType.trim(value);
        String normalizeValue = StringUtil.normalizeLineBreak(trimValue, lineBreakType);
        NormalizedString normalizedString = new NormalizedString(normalizeValue);
        return normalizedString.length() >= length;
    }

    /**
     * 最大文字数のチェックをする
     * 
     * @param value
     *            検査する文字列
     * @param length
     *            最大文字数
     * @return 最大文字数以上の場合true
     */
    public boolean maxLength(String value, int length) {
        Objects.requireNonNull(value);

        String trimValue = trimType.trim(value);
        String normalizeString = StringUtil.normalizeLineBreak(trimValue, lineBreakType);
        NormalizedString normalizedString = new NormalizedString(normalizeString);
        return normalizedString.length() <= length;
    }

    /**
     * 整数であるかをチェックする
     * 
     * @param value
     *            検査する文字列
     * @return 整数の場合true
     */
    public boolean isInt(String value) {
        Objects.requireNonNull(value);

        String trimValue = trimType.trim(value);
        return NumberUtil.formatInt(trimValue) != null;
    }

    /**
     * 全角カタカナであるかをチェックする
     * 
     * @param value
     *            検査する文字列
     * @param useEmBlank
     *            全角ブランクを許可するか
     * @param useLineBreak
     *            改行を許可するか
     * @return パターンにマッチする場合true
     */
    public boolean isEmKatakana(String value, UseEmBlank useEmBlank, UseLineBreak useLineBreak) {
        Objects.requireNonNull(value);

        String trimValue = trimType.trim(value);

        String pattern = RegexUtil.EM_KATAKANA;
        if (useEmBlank == UseEmBlank.ALLOW) {
            pattern = pattern + RegexUtil.EM_BLANK;
        }
        if (useLineBreak == UseLineBreak.ALLOW) {
            pattern = pattern + RegexUtil.LINE_BREAK;
        }

        return RegexUtil.perfectMatch(pattern, trimValue);
    }
}
