import org.junit.Test;
import quanlyphonggym.Util.CheckSoDienThoai;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckInputStringPhoneNumberTest {
    // valid == 10 số
    @Test
    public void pc1() {
        assertTrue(CheckSoDienThoai.checkSoDienThoai("0998298099"));
    }
    // Invalid < 10 số
    @Test
    public void pc2() {
        assertFalse(CheckSoDienThoai.checkSoDienThoai("123456789"));
    }
    // Invalid > 10 số
    @Test
    public void pc3() {
        assertFalse(CheckSoDienThoai.checkSoDienThoai("12345678901"));
    }

    // Invalid : toàn chữ
    @Test
    public void pc4() {
        assertFalse(CheckSoDienThoai.checkSoDienThoai("jgkdjdkeke"));
    }

    // Invalid : 10 số nhưng có chữ
    @Test
    public void pc5() {
        assertFalse(CheckSoDienThoai.checkSoDienThoai("9098huyi89"));
    }

    // Invalid : null
    @Test
    public void pc6() {
        assertFalse(CheckSoDienThoai.checkSoDienThoai(""));
    }
}
