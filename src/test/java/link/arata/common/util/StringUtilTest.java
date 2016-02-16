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
    public void isNotEmptyのnullの場合() {
        assertThat(StringUtil.isNotEmpty(null), is(false));
    }

    @Test
    public void isNotEmptyの空文字の場合() {
        assertThat(StringUtil.isNotEmpty(""), is(false));
    }

    @Test
    public void isNotEmptyのABCの場合() {
        assertThat(StringUtil.isNotEmpty("ABC"), is(true));
    }

    @Test
    public void isNotEmptyのあの場合() {
        assertThat(StringUtil.isNotEmpty("あ"), is(true));
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
    public void trimLeftのLFがtrimされること() {
        assertThat(StringUtil.trimLeft("\nあいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeftのCRがtrimされること() {
        assertThat(StringUtil.trimLeft("\rあいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeftのいろいろ混ざった場合にtrimされること() {
        assertThat(StringUtil.trimLeft(" 　\t\nあいうえお"), is("あいうえお"));
    }

    public void trimLeftの右側がtrimされないこと() {
        assertThat(StringUtil.trimLeft("あいうえお\n\t　 "), is("あいうえお\n\t　 "));
    }

    public void trimLeftですべての文字がtrim対象の場合() {
        assertThat(StringUtil.trimLeft(" 　\t\n"), is(""));
    }

    public void trimLeftで空文字の場合() {
        assertThat(StringUtil.trimLeft(""), is(""));
    }

    @Test
    public void trimRightの半角ブランクがtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお "), is("あいうえお"));
    }

    @Test
    public void trimRight全角ブランクがtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお　"), is("あいうえお"));
    }

    @Test
    public void trimRightのタブがtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお\t"), is("あいうえお"));
    }

    @Test
    public void trimRightのLFがtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお\n"), is("あいうえお"));
    }

    @Test
    public void trimRightのCRがtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお\r"), is("あいうえお"));
    }

    @Test
    public void trimRightのいろいろ混ざった場合にtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお 　\t\n"), is("あいうえお"));
    }

    public void trimRightの左側がtrimされないこと() {
        assertThat(StringUtil.trimRight("\n\t　 あいうえお"), is("あいうえお\n\t　 "));
    }

    public void trimRightですべての文字がtrim対象の場合() {
        assertThat(StringUtil.trimRight(" 　\t\n"), is(""));
    }

    public void trimRightで空文字の場合() {
        assertThat(StringUtil.trimRight(""), is(""));
    }

    @Test
    public void trimの半角ブランクがtrimされること() {
        assertThat(StringUtil.trim(" あいうえお "), is("あいうえお"));
    }

    @Test
    public void trim全角ブランクがtrimされること() {
        assertThat(StringUtil.trim("　あいうえお　"), is("あいうえお"));
    }

    @Test
    public void trimのタブがtrimされること() {
        assertThat(StringUtil.trim("\tあいうえお\t"), is("あいうえお"));
    }

    @Test
    public void trimの改行がtrimされること() {
        assertThat(StringUtil.trim("\nあいうえお\n"), is("あいうえお"));
    }

    @Test
    public void trimのいろいろ混ざった場合にtrimされること() {
        assertThat(StringUtil.trim(" 　\t\nあいうえお 　\t\n"), is("あいうえお"));
    }

    public void trimですべての文字が対象の場合() {
        assertThat(StringUtil.trimRight(" 　\t\n"), is(""));
    }

    public void trimで空文字の場合() {
        assertThat(StringUtil.trim(""), is(""));
    }
}
