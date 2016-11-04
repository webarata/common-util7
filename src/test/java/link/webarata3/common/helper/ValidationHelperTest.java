package link.webarata3.common.helper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import link.webarata3.common.enums.LineBreakType;
import link.webarata3.common.enums.TrimType;
import link.webarata3.common.enums.UseEmBlank;
import link.webarata3.common.enums.UseLineBreak;

@RunWith(Enclosed.class)
public class ValidationHelperTest {
    @RunWith(Theories.class)
    public static class requiredで両端trimで改行がLFの場合のテスト {
        @DataPoints
        public static Fixture[] PARAMs = { new Fixture(null, false), new Fixture("", false),
                new Fixture(" 　\r\n\t", false), new Fixture("あいうえお", true), new Fixture("あいうえお ", true) };

        private ValidationHelper validationHelper;

        @Before
        public void setUp() {
            validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        }

        @Theory
        public void required(Fixture fixture) throws Exception {
            assertThat(validationHelper.required(fixture.str), is(fixture.expected));
        }

        static class Fixture {
            String str;
            boolean expected;

            Fixture(String str, boolean expected) {
                this.str = str;
                this.expected = expected;
            }
        }
    }

    @RunWith(Theories.class)
    public static class requiredでtrimなしで改行がLFの場合のテスト {
        @DataPoints
        public static Fixture[] PARAMs = { new Fixture(" 　\r\n\t", true), new Fixture("", false),
                new Fixture("あいうえお", true), new Fixture("あいうえお ", true) };

        private ValidationHelper validationHelper;

        @Before
        public void setUp() {
            validationHelper = ValidationHelper.getInstance(TrimType.NONE, LineBreakType.LF);
        }

        @Theory
        public void required(Fixture fixture) throws Exception {
            assertThat(validationHelper.required(fixture.str), is(fixture.expected));
        }

        static class Fixture {
            String str;
            boolean expected;

            Fixture(String str, boolean expected) {
                this.str = str;
                this.expected = expected;
            }
        }
    }

    @RunWith(Theories.class)
    public static class minLengthで両端trimで改行がLFの場合のテスト {
        @DataPoints
        public static Fixture[] PARAMs = { new Fixture("あああ", 2, true), new Fixture("あああ", 3, true),
                new Fixture("あああ", 4, false), new Fixture(" あああ ", 2, true), new Fixture(" あああ ", 3, true),
                new Fixture(" あああ ", 4, false), new Fixture("あ\r\nあ", 2, true), new Fixture("あ\r\nあ", 3, true),
                new Fixture("あ\r\nあ", 4, false), new Fixture("𠮷野家", 2, true), new Fixture("𠮷野家", 3, true),
                new Fixture("𠮷野家", 4, false) };

        private ValidationHelper validationHelper;

        @Before
        public void setUp() {
            validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        }

        @Theory
        public void minLength(Fixture fixture) throws Exception {
            assertThat(validationHelper.minLength(fixture.str, fixture.minLength), is(fixture.expected));
        }

        static class Fixture {
            String str;
            int minLength;
            boolean expected;

            Fixture(String str, int minLength, boolean expected) {
                this.str = str;
                this.minLength = minLength;
                this.expected = expected;
            }
        }
    }

    @RunWith(Theories.class)
    public static class minLengthでtrimなしで改行がCRLFの場合のテスト {
        @DataPoints
        public static Fixture[] PARAMs = { new Fixture("   ", 2, true), new Fixture("   ", 3, true),
                new Fixture("   ", 4, false), new Fixture(" a ", 2, true), new Fixture(" a ", 3, true),
                new Fixture(" a ", 4, false) };

        private ValidationHelper validationHelper;

        @Before
        public void setUp() {
            validationHelper = ValidationHelper.getInstance(TrimType.NONE, LineBreakType.CRLF);
        }

        @Theory
        public void minLength(Fixture fixture) throws Exception {
            assertThat(validationHelper.minLength(fixture.str, fixture.minLength), is(fixture.expected));
        }

        static class Fixture {
            String str;
            int minLength;
            boolean expected;

            Fixture(String str, int minLength, boolean expected) {
                this.str = str;
                this.minLength = minLength;
                this.expected = expected;
            }
        }
    }

    @RunWith(Theories.class)
    public static class maxLengthで両端trimで改行がLFの場合のテスト {
        @DataPoints
        public static Fixture[] PARAMs = { new Fixture("あああ", 2, false), new Fixture("あああ", 3, true),
                new Fixture("あああ", 4, true), new Fixture(" あああ ", 2, false), new Fixture(" あああ ", 3, true),
                new Fixture(" あああ ", 4, true), new Fixture("あ\r\nあ", 2, false), new Fixture("あ\r\nあ", 3, true),
                new Fixture("あ\r\nあ", 4, true), new Fixture("𠮷野家", 2, false), new Fixture("𠮷野家", 3, true),
                new Fixture("𠮷野家", 4, true) };

        private ValidationHelper validationHelper;

        @Before
        public void setUp() {
            validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        }

        @Theory
        public void maxLength(Fixture fixture) throws Exception {
            assertThat(validationHelper.maxLength(fixture.str, fixture.maxLength), is(fixture.expected));
        }

        static class Fixture {
            String str;
            int maxLength;
            boolean expected;

            Fixture(String str, int maxLength, boolean expected) {
                this.str = str;
                this.maxLength = maxLength;
                this.expected = expected;
            }
        }
    }

    @RunWith(Theories.class)
    public static class maxLengthでtrimなしで改行がCRLFの場合のテスト {
        @DataPoints
        public static Fixture[] PARAMs = { new Fixture("   ", 2, false), new Fixture("   ", 3, true),
                new Fixture("   ", 4, true), new Fixture(" a ", 2, false), new Fixture(" a ", 3, true),
                new Fixture(" a ", 4, true) };

        private ValidationHelper validationHelper;

        @Before
        public void setUp() {
            validationHelper = ValidationHelper.getInstance(TrimType.NONE, LineBreakType.CRLF);
        }

        @Theory
        public void maxLength(Fixture fixture) throws Exception {
            assertThat(validationHelper.maxLength(fixture.str, fixture.maxLength), is(fixture.expected));
        }

        static class Fixture {
            String str;
            int maxLength;
            boolean expected;

            Fixture(String str, int maxLength, boolean expected) {
                this.str = str;
                this.maxLength = maxLength;
                this.expected = expected;
            }
        }
    }

    @RunWith(Theories.class)
    public static class isIntで両端trimで改行がLFの場合のテスト {
        @DataPoints
        public static Fixture[] PARAMs = { new Fixture("123", true), new Fixture("-123", true),
                new Fixture("1.0", false), new Fixture("", false), new Fixture(null, false) };

        private ValidationHelper validationHelper;

        @Before
        public void setUp() {
            validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        }

        @Theory
        public void isInt(Fixture fixture) throws Exception {
            assertThat(validationHelper.isInt(fixture.str), is(fixture.expected));
        }

        static class Fixture {
            String str;
            boolean expected;

            Fixture(String str, boolean expected) {
                this.str = str;
                this.expected = expected;
            }
        }
    }

    @Test
    public void isIntで123の場合() throws Exception {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.isInt("123"), is(true));
    }

    @Test
    public void isIntでマイナス123の場合() throws Exception {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.isInt("-123"), is(true));
    }

    @Test
    public void isIntで1点0の場合() throws Exception {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.isInt("1.0"), is(false));
    }

    @Test
    public void isEmKatakanaでアイウエオの場合() throws Exception {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.isEmKatakana("アイウエオ", UseEmBlank.DISALLOW, UseLineBreak.DISALLOW), is(true));
    }

    @Test
    public void isEmKatakanaでアイウエ全角ブランクオで全角ブランクが不許可の場合() throws Exception {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.isEmKatakana("アイウエ　オ", UseEmBlank.DISALLOW, UseLineBreak.DISALLOW), is(false));
    }

    @Test
    public void isEmKatakanaでアイウエ全角ブランクオで全角ブランクが許可の場合() throws Exception {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.isEmKatakana("アイウエ　オ", UseEmBlank.ALLOW, UseLineBreak.DISALLOW), is(true));
    }

    @Test
    public void isEmKatakanaでアイウエ全角ブランク改行オで全角ブランクと改行が許可の場合() throws Exception {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.isEmKatakana("アイウエ　\rオ", UseEmBlank.ALLOW, UseLineBreak.ALLOW), is(true));
    }

    @Test
    public void isEmKatakanaで半角カナの場合() throws Exception {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.BOTH, LineBreakType.LF);
        assertThat(validationHelper.isEmKatakana("ｱｲｳｴｵ", UseEmBlank.DISALLOW, UseLineBreak.DISALLOW), is(false));
    }
}
