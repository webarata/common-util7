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
}
