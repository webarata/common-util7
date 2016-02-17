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
     * @param target
     *            trim対象の文字列
     * @return trimした文字列
     */
    public @Nonnull String trim(@Nonnull String target) {
        switch (this) {
        case BOTH:
            return StringUtil.trim(target);
        case LEFT:
            return StringUtil.trimLeft(target);
        case RIGHT:
            return StringUtil.trimRight(target);
        case NONE:
            return target;
        }
        // ありえない
        return target;
    }
}
