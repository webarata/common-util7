package link.arata.common.helper;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import link.arata.common.util.LineBreakType;
import link.arata.common.util.NormalizedString;
import link.arata.common.util.NumberUtil;
import link.arata.common.util.StringUtil;
import link.arata.common.util.TrimType;

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
        this.trimType = trimType;
        this.lineBreakType = lineBreakType;
    }

    /**
     * インスタンスを取得する
     * 
     * @param trimType
     *            Validationの前に行うTrimの方向
     * @param lineBreakType
     *            正規化する改行の種類
     * @return
     */
    public static ValidationHelper getInstance(TrimType trimType, LineBreakType lineBreakType) {
        Map<LineBreakType, ValidationHelper> map = instanceMap.get(trimType);
        if (map == null) {
            map = new HashMap<LineBreakType, ValidationHelper>();
            instanceMap.put(trimType, map);
        }
        ValidationHelper validationHelper = map.get(lineBreakType);
        if (validationHelper == null) {
            validationHelper = new ValidationHelper(trimType, lineBreakType);
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
    public boolean required(@Nullable String value) {
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
    public boolean minLength(@Nonnull String value, int length) {
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
    public boolean maxLength(@Nonnull String value, int length) {
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
    public boolean isInt(@Nonnull String value) {
        String trimValue = trimType.trim(value);
        return NumberUtil.formatInt(trimValue) != null;
    }
}
