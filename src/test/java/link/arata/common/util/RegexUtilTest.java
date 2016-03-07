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
        assertThat(RegexUtil.find(RegexUtil.EM_KATAKANA, "アイウエオ"), is(true));
    }

    @Test
    public void findで全角カタカナであいうえおの場合() {
        assertThat(RegexUtil.find(RegexUtil.EM_KATAKANA, "あいうえお"), is(false));
    }
}
