package link.arata.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {
    @Test
    public void isEmptyのnullの場合() {
        assertThat(StringUtil.isEmpty(null), is(true));
    }
}
