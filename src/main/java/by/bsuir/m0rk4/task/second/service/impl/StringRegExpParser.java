package by.bsuir.m0rk4.task.second.service.impl;

import by.bsuir.m0rk4.task.second.service.StringParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegExpParser implements StringParser {

    private static final Logger LOGGER = LogManager.getLogger(StringRegExpParser.class);

    private static final String NON_LETTER_SYMBOLS_SPACES_SPACES_REG_EXP = "[^a-zA-Zа-яА-Я ]+";
    private static final String NON_LETTER_SYMBOLS_REG_EXP = "[^a-zA-Zа-яА-Я]+";
    private static final String WORD_REG_EXP = "[a-zA-Zа-яА-Я]+";
    private static final String SPACES_REX_EXP = "\\s+";

    @Override
    public String deleteAllNonLetterSymbols(String text) {
        LOGGER.info("IN deleteAllNonLetterSymbols - text to parse: {}", text);
        String parsedText = text.replaceAll(NON_LETTER_SYMBOLS_SPACES_SPACES_REG_EXP, " ");
        parsedText = parsedText.replaceAll(SPACES_REX_EXP, " ");
        parsedText = parsedText.trim();
        LOGGER.info("IN deleteAllNonLetterSymbols - parsed text: {}", parsedText);
        return parsedText;
    }

    @Override
    public String replaceSymbolAtPosInEveryWord(String text, int pos, char target) {
        LOGGER.info("IN replaceSymbolAtPosInEveryWord - text to parse: {} / Position: {} / Char to replace: {}",
                text, pos, target);
        Pattern wordPattern = Pattern.compile(WORD_REG_EXP);
        Matcher wordMatcher = wordPattern.matcher(text);
        while (wordMatcher.find()) {
            int start = wordMatcher.start();
            int end = wordMatcher.end();
            String word = text.substring(start, end);
            char[] wordArr = word.toCharArray();
            if (pos >= 0 && pos < wordArr.length) {
                wordArr[pos] = target;
            }
            text = text.substring(0, start) + new String(wordArr) + text.substring(end);
        }
        LOGGER.info("IN replaceSymbolAtPosInEveryWord - parsed text: {}", text);
        return text;
    }

    private String[] getSplitNonEmptyStrings(String text, String reg) {
        String[] tokens = text.split(reg);
        List<String> resultSet = new LinkedList<>();
        for (String token : tokens) {
            if (!token.isEmpty()) {
                resultSet.add(token);
            }
        }
        return resultSet.toArray(new String[0]);
    }
}
