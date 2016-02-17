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

    @Test
    public void charAtであいうで0の場合() {
        NormalizedString str = new NormalizedString("あいう");
        assertThat(str.charAt(0), is("あ"));
    }

    @Test
    public void charAtであいうで1の場合() {
        NormalizedString str = new NormalizedString("あいう");
        assertThat(str.charAt(1), is("い"));
    }

    @Test
    public void charAtで𠮷野家で0の場合() {
        NormalizedString str = new NormalizedString("𠮷野家");
        assertThat(str.charAt(0), is("𠮷"));
    }

    @Test
    public void charAtで𠮷野家で1の場合() {
        NormalizedString str = new NormalizedString("𠮷野家");
        assertThat(str.charAt(1), is("野"));
    }

    @Test
    public void charAtで野𠮷家で0の場合() {
        NormalizedString str = new NormalizedString("野𠮷家");
        assertThat(str.charAt(0), is("野"));
    }

    @Test
    public void charAtで野𠮷家で1の場合() {
        NormalizedString str = new NormalizedString("野𠮷家");
        assertThat(str.charAt(1), is("𠮷"));
    }

    @Test
    public void charAtで野𠮷𠀋で0の場合() {
        NormalizedString str = new NormalizedString("野𠮷丄");
        assertThat(str.charAt(0), is("野"));
    }

    @Test
    public void charAtで野𠮷𠀋で1の場合() {
        NormalizedString str = new NormalizedString("野𠮷丄");
        assertThat(str.charAt(1), is("𠮷"));
    }

    @Test
    public void charAtで野𠮷𠀋で2の場合() {
        NormalizedString str = new NormalizedString("野𠮷丄");
        assertThat(str.charAt(2), is("丄"));
    }
}
