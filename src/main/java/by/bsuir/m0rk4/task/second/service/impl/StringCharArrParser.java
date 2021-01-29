package by.bsuir.m0rk4.task.second.service.impl;

import by.bsuir.m0rk4.task.second.service.StringParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Predicate;

public class StringCharArrParser implements StringParser {
    private static final Logger LOGGER = LogManager.getLogger(StringRegExpParser.class);

    @Override
    public String deleteAllNonLetterSymbols(String text) {
        LOGGER.info("IN deleteAllNonLetterSymbols - text to parse: {}", text);
        StringBuilder parsedTextBuilder = new StringBuilder(text);
        deleteAllEntriesOfPredicateSeries(parsedTextBuilder, this::nonLetterSpaceCharacter);
        deleteAllEntriesOfPredicateSeries(parsedTextBuilder, Character::isWhitespace);
        String parsedText = parsedTextBuilder.toString().trim();
        LOGGER.info("IN replaceSymbolAtPosInEveryWord - parsed text: {}", parsedText);
        return parsedText;
    }

    private void deleteAllEntriesOfPredicateSeries(StringBuilder parsedTextBuilder, Predicate<Character> cond) {
        for (int i = 0; i < parsedTextBuilder.length(); i++) {
            char currCh = parsedTextBuilder.charAt(i);
            if (cond.test(currCh)) {
                int j = i;
                while (j < parsedTextBuilder.length() && cond.test(parsedTextBuilder.charAt(j))) {
                    j++;
                }
                parsedTextBuilder.replace(i, j, " ");
            }
        }
    }

    private boolean nonLetterSpaceCharacter(char c) {
        return c != ' ' && !Character.isLetter(c);
    }

    @Override
    public String replaceSymbolAtPosInEveryWord(String text, int pos, char target) {
        LOGGER.info("IN replaceSymbolAtPosInEveryWord - text to parse: {} / Position: {} / Char to replace: {}",
                text, pos, target);
        char[] textArr = text.toCharArray();
        for (int i = 0; i < textArr.length; i++) {
            if (Character.isLetter(textArr[i])) {
                int j = 0;
                while (i < textArr.length && Character.isLetter(textArr[i])) {
                    if (j == pos) {
                        textArr[i] = target;
                    }
                    j++;
                    i++;
                }
            }
        }
        String parsedText = new String(textArr);
        LOGGER.info("IN replaceSymbolAtPosInEveryWord - parsed text: {}", parsedText);
        return parsedText;
    }
}
