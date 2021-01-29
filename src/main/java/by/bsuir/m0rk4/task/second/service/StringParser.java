package by.bsuir.m0rk4.task.second.service;

public interface StringParser {
    String deleteAllNonLetterSymbols(String text);
    String replaceSymbolAtPosInEveryWord(String text, int pos, char target);
}
