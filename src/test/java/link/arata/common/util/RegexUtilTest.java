package link.arata.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.junit.Test;

public class RegexUtilTest {
    @Test
    public void getPatternでキャッすされること() {
        Pattern pattern = RegexUtil.getPattern(RegexUtil.EM_KATAKANA);
        assertThat(RegexUtil.getPattern(RegexUtil.EM_KATAKANA), is(pattern));
    }

    @Test
    public void findで全角カタカナでアイウエオの場合() {
        assertThat(RegexUtil.perfectMatch(RegexUtil.EM_KATAKANA, "アイウエオ"), is(true));
    }

    @Test
    public void findで全角カタカナであいうえおの場合() {
        assertThat(RegexUtil.perfectMatch(RegexUtil.EM_KATAKANA, "あいうえお"), is(false));
    }

    @Test
    public void findで全角カタカナで一番最初の文字の場合() {
        assertThat(RegexUtil.perfectMatch(RegexUtil.EM_KATAKANA, "\u30A0"), is(true));
    }

    @Test
    public void findで全角カタカナで一番最初の文字の1つ前の文字場合() {
        assertThat(RegexUtil.perfectMatch(RegexUtil.EM_KATAKANA, "\u309F"), is(false));
    }

    @Test
    public void findで全角カタカナで一番最後の文字の場合() {
        assertThat(RegexUtil.perfectMatch(RegexUtil.EM_KATAKANA, "\u30FF"), is(true));
    }

    @Test
    public void findで全角カタカナで一番最後の文字の1つ後の文字場合() {
        assertThat(RegexUtil.perfectMatch(RegexUtil.EM_KATAKANA, "\u3100"), is(false));
    }
}
