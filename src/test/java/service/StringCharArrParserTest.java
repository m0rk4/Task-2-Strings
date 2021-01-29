package service;

import by.bsuir.m0rk4.task.second.service.StringParser;
import by.bsuir.m0rk4.task.second.service.factory.ParserType;
import by.bsuir.m0rk4.task.second.service.factory.StringParserFactory;
import org.junit.Assert;
import org.junit.Test;

public class StringCharArrParserTest {
    private final StringParserFactory stringParserFactory = new StringParserFactory();
    private final StringParser stringCharArrParser = stringParserFactory.createStringParser(ParserType.CHAR_ARR);

    @Test
    public void testReplaceSymbolAtPosInEveryWordShouldLeaveSameWhenLengthNotEnoughApplied() {
        // given
        String text = "  Iefd     like     3,000    ca,rs   at 4ll!";

        // when
        String res = stringCharArrParser.replaceSymbolAtPosInEveryWord(text, 4, '$');

        // then
        Assert.assertEquals("  Iefd     like     3,000    ca,rs   at 4ll!", res);
    }

    @Test
    public void testDeleteAllNonLetterSymbolsShouldBecomeEmptyWhenSpacesStringApplied() {
        // given
        String text = "         ";

        // when
        String res = stringCharArrParser.deleteAllNonLetterSymbols(text);

        // then
        Assert.assertEquals("", res);
    }

    @Test
    public void testReplaceSymbolAtPosInEveryWordShouldReplaceSymbolAtPosInEveryWordWhenNonEmptyStringApplied() {
        // given
        String text = "  I     like     3,000    ca,rs   at 4ll!";

        // when
        String res = stringCharArrParser.replaceSymbolAtPosInEveryWord(text, 2, '$');

        // then
        Assert.assertEquals("  I     li$e     3,000    ca,rs   at 4ll!", res);
    }

    @Test
    public void testDeleteAllNonLetterSymbolsShouldDeleteAllNonLetterSymbolsWhenNonEmptyStringApplied() {
        // given
        String text = "    ca,rs   at 4ll!     ";

        // when
        String res = stringCharArrParser.deleteAllNonLetterSymbols(text);

        // then
        Assert.assertEquals("ca rs at ll", res);
    }
}
