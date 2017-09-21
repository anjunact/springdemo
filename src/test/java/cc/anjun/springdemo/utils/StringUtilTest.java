package cc.anjun.springdemo.utils;

import org.mockito.Mockito;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class StringUtilTest {
	@Test
	public void testConcat() {
		StringUtil stringUtilMock = Mockito.mock(StringUtil.class);
		
		Mockito.when(stringUtilMock.concat("a", "b")).thenReturn("ab");
		Mockito.when(stringUtilMock.concat("aa", "bb")).thenReturn("aabb");

		assertEquals(stringUtilMock.concat("a", "b"), "ab");		
		assertEquals(stringUtilMock.concat("aa", "bb"), "aabb");
	}
}
