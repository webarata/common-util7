package link.arata.common.util;

import java.text.Normalizer;

/**
 * 正規化された文字列を扱うクラス
 * 
 * @author arata
 *
 */
public class NormalizedString {
    private String originalString;
    private String normalizedString;

    /**
     * コンストラクタ
     * 
     * @param originalString
     *            オリジナルの文字列
     */
    public NormalizedString(String originalString) {
        this.originalString = originalString;
        this.normalizedString = Normalizer.normalize(this.originalString, Normalizer.Form.NFC);
    }

    /**
     * オリジナルの文字列を返す
     * 
     * @return オリジナルの文字列
     */
    public String getOriginalString() {
        return originalString;
    }

    /**
     * 文字数を返す
     * 
     * @return 文字数
     */
    public int length() {
        return normalizedString.codePointCount(0, normalizedString.length());
    }
}
