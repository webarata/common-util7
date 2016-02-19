package link.arata.common.util;

import javax.annotation.Nonnull;

/**
 * trimの方向を決めるenum
 * 
 * @author arata
 *
 */
public enum TrimType {
    NONE, BOTH, LEFT, RIGHT;

    /**
     * 指定のtrimをかける
     * 
     * @param value
     *            trim対象の文字列
     * @return trimした文字列
     */
    public @Nonnull String trim(@Nonnull String value) {
        switch (this) {
        case BOTH:
            return StringUtil.trim(value);
        case LEFT:
            return StringUtil.trimLeft(value);
        case RIGHT:
            return StringUtil.trimRight(value);
        case NONE:
            return value;
        }
        // ありえない
        return value;
    }
}
