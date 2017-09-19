// Note
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class WebScraping {
    //Comment
    public static void main(String[] args) {
        System.out.println(wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(wordCount3(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(wordCount2(urlToString("http://erdani.com/tdpl/hamlet.txt"), "he"));
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static int wordCount(final String s) {
        boolean start = true;
        int charPlace = 0;
        int wordLen = 0;
        int wordCount = 0;
        while (charPlace < (s.length() - 1)) {
            charPlace = charPlace + 1;
            if (s.charAt(charPlace) == ' ') {
                if (wordLen > 0) {
                    wordCount += 1;
                    wordLen = 0;
                }
            } else {
                wordLen += 1;
            }
        }
        return wordCount;
    }

    public static int wordCount2(final String s4, final String s3) {
        boolean start = true;
        int charPlace = 0;
        int wordLen = 0;
        int wordCount = 0;
        String s2 = s3.toLowerCase();
        String s = s4.toLowerCase();
        int findings = 0;
        String currentWord = "";
        while (charPlace < (s.length() - 1)) {
            charPlace = charPlace + 1;
            if (s.charAt(charPlace) == ' ') {
                if (wordLen > 0) {
                    wordCount += 1;
                    wordLen = 0;
                    if (currentWord.equals(s2)) {
                        findings += 1;
                    }
                    currentWord = "";
                }
            } else {
                wordLen += 1;
                currentWord += s.charAt(charPlace);
            }
        }
        return findings;
    }

    public static int wordCount3(final String s4) {
        boolean start = true;
        int charPlace = 0;
        int wordLen = 0;
        int wordCount = 0;
        String s = s4.toLowerCase();
        int findings = 0;
        String[] fo = new String[40000];
        int nextPos = 0;
        String currentWord = "";
        while (charPlace < (s.length() - 1)) {
            charPlace = charPlace + 1;
            if (s.charAt(charPlace) == ' ') {
                if (wordLen > 0) {
                    wordCount += 1;
                    wordLen = 0;
                    if (java.util.Arrays.asList(fo).contains(currentWord)) {
                        //findings += 1;
                    } else {
                        findings += 1;
                        fo[nextPos] = currentWord;
                        nextPos += 1;
                    }
                    currentWord = "";
                }
            } else {
                wordLen += 1;
                currentWord += s.charAt(charPlace);
            }
        }
        return findings;
    }

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
