package service;

import by.bsuir.m0rk4.task.second.service.StringParser;
import by.bsuir.m0rk4.task.second.service.factory.ParserType;
import by.bsuir.m0rk4.task.second.service.factory.StringParserFactory;
import org.junit.Assert;
import org.junit.Test;

public class StringRegExpParserTest {
    private final StringParserFactory stringParserFactory = new StringParserFactory();
    private final StringParser stringRegExpParser = stringParserFactory.createStringParser(ParserType.REG_EXP);

    @Test
    public void testDeleteAllNonLetterSymbolsShouldStayTheSameWhenEmptyStringApplied() {
        // given
        String text = "";

        // when
        String res = stringRegExpParser.deleteAllNonLetterSymbols(text);

        // then
        Assert.assertEquals("", res);
    }

    @Test
    public void testDeleteAllNonLetterSymbolsShouldDeleteAllNonLetterSymbolsWhenNonEmptyStringApplied() {
        // given
        String text = "I     like     3,000    ca,rs   at 4ll!";

        // when
        String res = stringRegExpParser.deleteAllNonLetterSymbols(text);

        // then
        Assert.assertEquals("I like ca rs at ll", res);
    }

    @Test
    public void testReplaceSymbolAtPosInEveryWordShouldReplaceSymbolAtPosInEveryWordWhenNonEmptyStringApplied() {
        // given
        String text = "  I     like     3,000    ca,rs   at 4ll!";

        // when
        String res = stringRegExpParser.replaceSymbolAtPosInEveryWord(text, 2, '$');

        // then
        Assert.assertEquals("  I     li$e     3,000    ca,rs   at 4ll!", res);
    }

    @Test
    public void testReplaceSymbolAtPosInEveryWordShouldReplaceSymbolAtPosInEveryWordWhenNonEmptyStringApplied2() {
        // given
        String text = "Hello world   today is great day hah GOGO 123!! ssd";

        // when
        String res = stringRegExpParser.replaceSymbolAtPosInEveryWord(text, 2, '%');

        // then
        Assert.assertEquals("He%lo wo%ld   to%ay is gr%at da% ha% GO%O 123!! ss%", res);
    }

}
