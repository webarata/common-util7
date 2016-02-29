package link.arata.common.helper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import link.arata.common.enums.LineBreakType;
import link.arata.common.enums.TrimType;

public class ValidationHelperTest {
    @Test
    public void requiredがnullの場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.required(null), is(false));
    }

    @Test
    public void requiredが空文字の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.required(""), is(false));
    }

    @Test
    public void requiredが空白文字の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.required(" 　\r\n\t"), is(false));
    }

    @Test
    public void requiredがあいうえおの場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.required("あいうえお"), is(true));
    }

    @Test
    public void requiredがあいうえおと空白ブランクの場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.required("あいうえお "), is(true));
    }

    @Test
    public void requiredが空白文字でtrimしない場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.NONE, LineBreakType.LF);
        assertThat(validationHelper.required(" 　\r\n\t"), is(true));
    }

    @Test
    public void requiredでデフォルトをtrimしないにして空白文字場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.NONE, LineBreakType.LF);
        assertThat(validationHelper.required(" 　\r\n\t"), is(true));
    }

    @Test
    public void minLengthであああで2文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.minLength("あああ", 2), is(true));
    }

    @Test
    public void minLengthであああで3文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.minLength("あああ", 3), is(true));
    }

    @Test
    public void minLengthであああで4文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.minLength("あああ", 4), is(false));
    }

    @Test
    public void minLengthで半角ブランクあああ半角ブランクで2文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.minLength(" あああ ", 2), is(true));
    }

    @Test
    public void minLengthで半角ブランクあああ半角ブランクで3文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.minLength(" あああ ", 3), is(true));
    }

    @Test
    public void minLengthで半角ブランクあああ半角ブランクで4文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.minLength(" あああ ", 4), is(false));
    }

    @Test
    public void minLengthであCRLFあで2文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.minLength("あ\r\nあ", 2), is(true));
    }

    @Test
    public void minLengthであCRLFあで3文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.minLength("あ\r\nあ", 3), is(true));
    }

    @Test
    public void minLengthであCRLFあで4文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.minLength("あ\r\nあ", 4), is(false));
    }

    @Test
    public void minLengthで𠮷野家で2文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.minLength("𠮷野家", 2), is(true));
    }

    @Test
    public void minLengthで𠮷野家で3文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.minLength("𠮷野家", 3), is(true));
    }

    @Test
    public void minLengthで𠮷野家で4文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.minLength("𠮷野家", 4), is(false));
    }

    public void minLengthで半角ブランク3つでtrimせず2文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.NONE, LineBreakType.CRLF);
        assertThat(validationHelper.minLength("   ", 2), is(true));
    }

    public void minLengthで半角ブランク3つでtrimせず3文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.NONE, LineBreakType.CRLF);
        assertThat(validationHelper.minLength("   ", 3), is(true));
    }

    public void minLengthで半角ブランク3つでtrimせず4文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.NONE, LineBreakType.CRLF);
        assertThat(validationHelper.minLength("   ", 4), is(false));
    }

    @Test
    public void maxLengthであああで2文字以下の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.maxLength("あああ", 2), is(false));
    }

    @Test
    public void maxLengthであああで3文字以下の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.maxLength("あああ", 3), is(true));
    }

    @Test
    public void maxLengthであああで4文字以下の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.maxLength("あああ", 4), is(true));
    }

    @Test
    public void maxLengthで半角ブランクあああ半角ブランクで2文字以下の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.maxLength(" あああ ", 2), is(false));
    }

    @Test
    public void maxLengthで半角ブランクあああ半角ブランクで3文字以下の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.maxLength(" あああ ", 3), is(true));
    }

    @Test
    public void maxLengthで半角ブランクあああ半角ブランクで4文字以下の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.maxLength(" あああ ", 4), is(true));
    }

    @Test
    public void maxLengthであCRLFあで2文字以上の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.maxLength("あ\r\nあ", 2), is(false));
    }

    @Test
    public void maxLengthであCRLFあで3文字以下の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.maxLength("あ\r\nあ", 3), is(true));
    }

    @Test
    public void maxLengthであCRLFあで4文字以下の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.maxLength("あ\r\nあ", 4), is(true));
    }

    @Test
    public void maxLengthで𠮷野家で2文字以下の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.maxLength("𠮷野家", 2), is(false));
    }

    @Test
    public void maxLengthで𠮷野家で3文字以下の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.maxLength("𠮷野家", 3), is(true));
    }

    @Test
    public void maxLengthで𠮷野家で4文字以下の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.maxLength("𠮷野家", 4), is(true));
    }

    public void maxLengthで半角ブランク3つでtrimせず2文字以下の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.NONE, LineBreakType.CRLF);
        assertThat(validationHelper.maxLength("   ", 2), is(false));
    }

    public void maxLengthで半角ブランク3つでtrimせず3文字以下の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.NONE, LineBreakType.CRLF);
        assertThat(validationHelper.maxLength("   ", 3), is(true));
    }

    public void maxLengthで半角ブランク3つでtrimせず4文字以下の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.NONE, LineBreakType.CRLF);
        assertThat(validationHelper.maxLength("   ", 4), is(true));
    }

    public void isIntで123の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.isInt("123"), is(true));
    }

    public void isIntでマイナス123の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.isInt("-123"), is(true));
    }

    public void isIntで1点0の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.isInt("1.0"), is(false));
    }
}
