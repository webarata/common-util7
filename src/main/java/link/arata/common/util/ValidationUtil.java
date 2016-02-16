package link.arata.common.util;

import javax.annotation.Nullable;

/**
 * Validationを行うユーティリティクラス
 * 
 * @author arata
 *
 */
public class ValidationUtil {

    public static boolean required(@Nullable String target) {
        if (target == null) {
            return false;
        }
        String trimTarget = StringUtil.trimRight(target);

        return StringUtil.isNotEmpty(trimTarget);
    }
}
