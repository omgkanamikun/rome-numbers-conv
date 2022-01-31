package converter;

import converter.service.NumbersConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumbersConverterTest {

    private ServiceLoader<NumbersConverter> serviceLoader;

    @BeforeEach
    void setServiceLoader() {
        serviceLoader = ServiceLoader.load(NumbersConverter.class);
    }

    @Test
    void testConverter() {
        serviceLoader.forEach(numbersConverter -> {
            assertEquals("X", numbersConverter.convert(10));
            assertEquals("MCMLXXXIX", numbersConverter.convert(1989));
            assertEquals("MMXIV", numbersConverter.convert(2014));
            assertEquals("CXXIV", numbersConverter.convert(124));
            assertEquals("LXXXIV", numbersConverter.convert(84));
            assertEquals("DCCCLXXXVIII", numbersConverter.convert(888));
        });
    }
}