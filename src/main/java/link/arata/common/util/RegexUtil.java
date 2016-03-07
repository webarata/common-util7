package link.arata.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正規表現用のユーティリティ
 * 
 * @author arata
 */
public abstract class RegexUtil {
    /** 全角カタカナのパターン */
    public final static String EM_KATAKANA = "^[\\u30A0-\\u30FF]+$";

    private final static Map<String, Pattern> PATTERN_CASH = new HashMap<>();

    /**
     * コンパイルされたPatternオブジェクトを取得する。<br>
     * 一度作成したパターンはキャッシュされる
     * 
     * @param regex
     *            パターン
     * @return
     */
    public static Pattern getPattern(String regex) {
        Pattern pattern = PATTERN_CASH.get(regex);
        if (pattern == null) {
            pattern = Pattern.compile(regex);
            PATTERN_CASH.put(regex, pattern);
        }
        return pattern;
    }

    /**
     * 検査する文字列がパターンに合致するかを調べる
     * 
     * @param regex
     *            パターン
     * @param input
     *            検査する文字列
     * @return パターンにinputが合致する場合true
     */
    public static boolean find(String regex, CharSequence input) {
        Pattern pattern = getPattern(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
