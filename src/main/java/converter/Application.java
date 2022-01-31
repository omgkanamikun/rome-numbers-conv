package converter;

import converter.service.NumbersConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ServiceLoader;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        final ServiceLoader<NumbersConverter> load = ServiceLoader.load(NumbersConverter.class);

        load.forEach(numbersConverter -> {
            log.info("Welcome to the {}", numbersConverter.getClass().getSimpleName());
            final var arab = 33;
            final String convertedNumber = numbersConverter.convert(33);
            log.info("arabic number {} in roman is {}", arab, convertedNumber);

            log.info("input the new arabic number to convert");

            log.info("{}", numbersConverter.convert());
        });
    }
}
