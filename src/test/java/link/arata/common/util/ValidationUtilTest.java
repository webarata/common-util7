package link.arata.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public abstract class ValidationUtilTest {
    @Test
    public void requiredがnullの場合() {
        assertThat(ValidationUtil.required(null), is(false));
    }

    @Test
    public void requiredが空文字の場合() {
        assertThat(ValidationUtil.required(""), is(false));
    }

    @Test
    public void requiredが空白文字の場合() {
        assertThat(ValidationUtil.required(" 　\r\n\t"), is(false));
    }

    @Test
    public void requiredがあいうえおの場合() {
        assertThat(ValidationUtil.required("あいうえお"), is(true));
    }

    @Test
    public void requiredがあいうえおと空白ブランクの場合() {
        assertThat(ValidationUtil.required("あいうえお "), is(true));
    }

    @Test
    public void requiredが空白文字でtrimしない場合() {
        assertThat(ValidationUtil.required(" 　\r\n\t", TrimType.NONE), is(true));
    }

    @Test
    public void minLengthであああで2文字以上の場合() {
        assertThat(ValidationUtil.minLength("あああ", 2), is(true));
    }

    @Test
    public void minLengthであああで3文字以上の場合() {
        assertThat(ValidationUtil.minLength("あああ", 3), is(true));
    }

    @Test
    public void minLengthであああで4文字以上の場合() {
        assertThat(ValidationUtil.minLength("あああ", 4), is(false));
    }

    @Test
    public void minLengthで半角ブランクあああ半角ブランクで2文字以上の場合() {
        assertThat(ValidationUtil.minLength(" あああ ", 2), is(true));
    }

    @Test
    public void minLengthで半角ブランクあああ半角ブランクで3文字以上の場合() {
        assertThat(ValidationUtil.minLength(" あああ ", 3), is(true));
    }

    @Test
    public void minLengthで半角ブランクあああ半角ブランクで4文字以上の場合() {
        assertThat(ValidationUtil.minLength(" あああ ", 4), is(false));
    }

    @Test
    public void minLengthであCRLFあで2文字以上の場合() {
        assertThat(ValidationUtil.minLength("あ\r\nあ", 2), is(true));
    }

    @Test
    public void minLengthであCRLFあで3文字以上の場合() {
        assertThat(ValidationUtil.minLength("あ\r\nあ", 3), is(true));
    }

    @Test
    public void minLengthであCRLFあで4文字以上の場合() {
        assertThat(ValidationUtil.minLength("あ\r\nあ", 4), is(false));
    }

    @Test
    public void minLengthで𠮷野家で2文字以上の場合() {
        assertThat(ValidationUtil.minLength("𠮷野家", 2), is(true));
    }

    @Test
    public void minLengthで𠮷野家で3文字以上の場合() {
        assertThat(ValidationUtil.minLength("𠮷野家", 3), is(true));
    }

    @Test
    public void minLengthで𠮷野家で4文字以上の場合() {
        assertThat(ValidationUtil.minLength("𠮷野家", 4), is(false));
    }

    public void minLengthで半角ブランク3つでtrimせず2文字以上の場合() {
        assertThat(ValidationUtil.minLength("   ", 2, LineBreakType.CRLF, TrimType.NONE), is(true));
    }

    public void minLengthで半角ブランク3つでtrimせず3文字以上の場合() {
        assertThat(ValidationUtil.minLength("   ", 3, LineBreakType.CRLF, TrimType.NONE), is(true));
    }

    public void minLengthで半角ブランク3つでtrimせず4文字以上の場合() {
        assertThat(ValidationUtil.minLength("   ", 4, LineBreakType.CRLF, TrimType.NONE), is(false));
    }

    @Test
    public void maxLengthであああで2文字以下の場合() {
        assertThat(ValidationUtil.maxLength("あああ", 2), is(false));
    }

    @Test
    public void maxLengthであああで3文字以下の場合() {
        assertThat(ValidationUtil.maxLength("あああ", 3), is(true));
    }

    @Test
    public void maxLengthであああで4文字以下の場合() {
        assertThat(ValidationUtil.maxLength("あああ", 4), is(true));
    }

    @Test
    public void maxLengthで半角ブランクあああ半角ブランクで2文字以下の場合() {
        assertThat(ValidationUtil.maxLength(" あああ ", 2), is(false));
    }

    @Test
    public void maxLengthで半角ブランクあああ半角ブランクで3文字以下の場合() {
        assertThat(ValidationUtil.maxLength(" あああ ", 3), is(true));
    }

    @Test
    public void maxLengthで半角ブランクあああ半角ブランクで4文字以下の場合() {
        assertThat(ValidationUtil.maxLength(" あああ ", 4), is(true));
    }

    @Test
    public void maxLengthであCRLFあで2文字以上の場合() {
        assertThat(ValidationUtil.maxLength("あ\r\nあ", 2), is(false));
    }

    @Test
    public void maxLengthであCRLFあで3文字以下の場合() {
        assertThat(ValidationUtil.maxLength("あ\r\nあ", 3), is(true));
    }

    @Test
    public void maxLengthであCRLFあで4文字以下の場合() {
        assertThat(ValidationUtil.maxLength("あ\r\nあ", 4), is(true));
    }

    @Test
    public void maxLengthで𠮷野家で2文字以下の場合() {
        assertThat(ValidationUtil.maxLength("𠮷野家", 2), is(false));
    }

    @Test
    public void maxLengthで𠮷野家で3文字以下の場合() {
        assertThat(ValidationUtil.maxLength("𠮷野家", 3), is(true));
    }

    @Test
    public void maxLengthで𠮷野家で4文字以下の場合() {
        assertThat(ValidationUtil.maxLength("𠮷野家", 4), is(true));
    }

    public void maxLengthで半角ブランク3つでtrimせず2文字以下の場合() {
        assertThat(ValidationUtil.maxLength("   ", 2, LineBreakType.CRLF, TrimType.NONE), is(false));
    }

    public void maxLengthで半角ブランク3つでtrimせず3文字以下の場合() {
        assertThat(ValidationUtil.maxLength("   ", 3, LineBreakType.CRLF, TrimType.NONE), is(true));
    }

    public void maxLengthで半角ブランク3つでtrimせず4文字以下の場合() {
        assertThat(ValidationUtil.maxLength("   ", 4, LineBreakType.CRLF, TrimType.NONE), is(true));
    }

    public void isIntで123の場合() {
        assertThat(ValidationUtil.isInt("123"), is(true));
    }

    public void isIntでマイナス123の場合() {
        assertThat(ValidationUtil.isInt("-123"), is(true));
    }

    public void isIntで1点0の場合() {
        assertThat(ValidationUtil.isInt("1.0"), is(false));
    }
}
