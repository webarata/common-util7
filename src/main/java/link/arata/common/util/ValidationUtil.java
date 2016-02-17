package link.arata.common.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Validationを行うユーティリティクラス
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
}
