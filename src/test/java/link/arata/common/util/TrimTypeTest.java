package link.arata.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TrimTypeTest {
    @Test
    public void trimType_NONEのテスト() {
        assertThat(TrimType.NONE.trim(" あいうえお "), is(" あいうえお "));
    }

    @Test
    public void trimType_BOTHのテスト() {
        assertThat(TrimType.BOTH.trim(" あいうえお "), is("あいうえお"));
    }

    @Test
    public void trimType_LEFTのテスト() {
        assertThat(TrimType.LEFT.trim(" あいうえお "), is("あいうえお "));
    }

    @Test
    public void trimType_RIGHTのテスト() {
        assertThat(TrimType.RIGHT.trim(" あいうえお "), is(" あいうえお"));
    }
}
