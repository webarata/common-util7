package link.arata.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {
    @Test
    public void isEmptyのnullの場合() {
        assertThat(StringUtil.isEmpty(null), is(true));
    }

    @Test
    public void isEmptyの空文字の場合() {
        assertThat(StringUtil.isEmpty(""), is(true));
    }

    @Test
    public void isEmptyのABCの場合() {
        assertThat(StringUtil.isEmpty("ABC"), is(false));
    }

    @Test
    public void isEmptyのあの場合() {
        assertThat(StringUtil.isEmpty("あ"), is(false));
    }

    @Test
    public void trimLeftの半角ブランクがtrimされること() {
        assertThat(StringUtil.trimLeft(" あいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeft全角ブランクがtrimされること() {
        assertThat(StringUtil.trimLeft("　あいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeftのタブがtrimされること() {
        assertThat(StringUtil.trimLeft("\tあいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeftの改行がtrimされること() {
        assertThat(StringUtil.trimLeft("\nあいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeftのいろいろ混ざった場合にtrimされること() {
        assertThat(StringUtil.trimLeft(" 　\t\nあいうえお"), is("あいうえお"));
    }

    public void trimLeftの右側がtrimされないこと() {
        assertThat(StringUtil.trimLeft("あいうえお\n\t　 "), is("あいうえお\n\t　 "));
    }
}
