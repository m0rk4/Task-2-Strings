package by.bsuir.m0rk4.task.second.service.factory;

import by.bsuir.m0rk4.task.second.service.StringParser;
import by.bsuir.m0rk4.task.second.service.impl.StringCharArrParser;
import by.bsuir.m0rk4.task.second.service.impl.StringRegExpParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringParserFactory {
    private static final Logger LOGGER = LogManager.getLogger(StringParserFactory.class);

    public StringParser createStringParser(ParserType parserType) {
        LOGGER.info("IN createStringParser - parserType name: {}", parserType.name());
        switch (parserType) {
            case REG_EXP:
                return new StringRegExpParser();
            case CHAR_ARR:
                return new StringCharArrParser();
            default:
                throw new IllegalArgumentException("ParserType with name: " + parserType.name() + " is illegal");
        }
    }
}
