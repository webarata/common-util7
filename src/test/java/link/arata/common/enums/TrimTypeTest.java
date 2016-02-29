package link.arata.common.enums;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import link.arata.common.enums.TrimType;

public class TrimTypeTest {
    @Test
    public void trimType_NONEの場合() {
        assertThat(TrimType.NONE.trim(" あいうえお "), is(" あいうえお "));
    }

    @Test
    public void trimType_BOTHの場合() {
        assertThat(TrimType.BOTH.trim(" あいうえお "), is("あいうえお"));
    }

    @Test
    public void trimType_LEFTの場合() {
        assertThat(TrimType.LEFT.trim(" あいうえお "), is("あいうえお "));
    }

    @Test
    public void trimType_RIGHTの場合() {
        assertThat(TrimType.RIGHT.trim(" あいうえお "), is(" あいうえお"));
    }
}
