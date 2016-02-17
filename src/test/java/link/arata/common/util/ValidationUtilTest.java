package link.arata.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ValidationUtilTest {
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

    public void requiredが空白文字でtrimしない場合() {
        assertThat(ValidationUtil.required(" 　\r\n\t", TrimType.NONE), is(true));
    }
}
