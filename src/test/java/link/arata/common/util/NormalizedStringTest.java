package link.arata.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class NormalizedStringTest {
    @Test
    public void lengthであああの場合() {
        NormalizedString str = new NormalizedString("あああ");
        assertThat(str.length(), is(3));
    }

    @Test
    public void lengthで𠮷野家の場合() {
        NormalizedString str = new NormalizedString("𠮷野家");
        assertThat(str.length(), is(3));
    }
}
