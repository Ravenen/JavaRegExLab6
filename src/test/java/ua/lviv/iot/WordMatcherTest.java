package ua.lviv.iot;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.match.WordMatcher;

class WordMatcherTest {

  @BeforeEach
  void setUp() {
  }

  @Test
  void testDeleteWordsStartingWithConsonantByLength2() {
    int inputLength = 2;
    String inputString = "What I supposed to do? I have to delete what? Ok, here is test string.";

    String input = inputString + "\n" + inputLength;
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    try (Scanner scanner = new Scanner(System.in);) {
      String stringToCheck = scanner.nextLine();
      int lengthOfWord = scanner.nextInt();

      String actual = WordMatcher.deleteWordsStartingWithConsonantByLength(stringToCheck, lengthOfWord);
      String expected = "What I supposed  ? I have  delete what? Ok, here is test string.";
      assertEquals(expected, actual);
    }
  }

  @Test
  void testDeleteWordsStartingWithConsonantByLength4() {
    int inputLength = 4;
    String inputString = "What I supposed to do? I have to delete what? Ok, here is test string.";

    String input = inputString + "\n" + inputLength;
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    try (Scanner scanner = new Scanner(System.in);) {
      String stringToCheck = scanner.nextLine();
      int lengthOfWord = scanner.nextInt();

      String actual = WordMatcher.deleteWordsStartingWithConsonantByLength(stringToCheck, lengthOfWord);
      String expected = " I supposed to do? I  to delete ? Ok,  is  string.";
      assertEquals(expected, actual);
    }
  }

}
