package at.pali;

import org.junit.Assert;

public class MD4HashGeneratorTest {

    @org.junit.Test
    public void testStandardCharSet() throws Exception {
        Assert.assertEquals(MD4HashGenerator.getMD4("admin"), "209c6174da490caeb422f3fa5a7ae634");
        Assert.assertEquals(MD4HashGenerator.getMD4("test"), "0cb6948805f797bf2a82807973b89537");
        Assert.assertEquals(MD4HashGenerator.getMD4("1SimplePa3sswordW44ith0"), "2644a9fe0f145bb758898b24943e27c3");
    }

    @org.junit.Test
    public void testExtendedCharSet() throws Exception {
        Assert.assertEquals(MD4HashGenerator.getMD4("admin 99 ("), "e743eecceb200f5ae55bbcb3660f2c44");
        Assert.assertEquals(MD4HashGenerator.getMD4("Password-with/non,alphabetic+chars"), "1282fd3b62fbace63788547a468c96e1");
        Assert.assertEquals(MD4HashGenerator.getMD4("some:more_!ddd#"), "6740be05b8be7104a6f8c3c4ff9945a7");
    }

    @org.junit.Test
    public void testSpecialCharSet() throws Exception {
        Assert.assertEquals(MD4HashGenerator.getMD4("*~'#\\?%"), "55ad34289c0c3f09d3b56f897e04934b");
        Assert.assertEquals(MD4HashGenerator.getMD4("²³§[Üä^°´"), "31ee02b17662ba3d3a70e307a2716d99");
    }

}
