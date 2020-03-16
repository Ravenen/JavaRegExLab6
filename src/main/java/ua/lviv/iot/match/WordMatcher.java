package ua.lviv.iot.match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordMatcher {
  public static String deleteWordsStartingWithConsonantByLength(String inputString, int length) {
    return WordMatcher.deleteWordsByPattern(inputString,
        "\\b[qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM]\\w{" + (length - 1) + "}\\b");
  }

  private static String deleteWordsByPattern(String inputString, String patternString) {
    return WordMatcher.replaceTextByPattern(inputString, "", patternString);
  }

  private static String replaceTextByPattern(String inputString, String replacement, String patternString) {
    Pattern pattern = Pattern.compile(patternString);
    Matcher matcher = pattern.matcher(inputString);
    return matcher.replaceAll(replacement);
  }
}
