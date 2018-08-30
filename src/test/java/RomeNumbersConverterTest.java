import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class RomeNumbersConverterTest {

    @Test
    public void testConverter() {
        assertEquals("X", RomeNumbersConverter.getConvert(10));
        assertEquals("MCMLXXXIX", RomeNumbersConverter.getConvert(1989));
        assertEquals("MMXIV", RomeNumbersConverter.getConvert(2014));
        assertEquals("CXXIV", RomeNumbersConverter.getConvert(124));
        assertEquals("LXXXIV", RomeNumbersConverter.getConvert(84));
        assertEquals("DCCCLXXXVIII", RomeNumbersConverter.getConvert(888));
    }
}