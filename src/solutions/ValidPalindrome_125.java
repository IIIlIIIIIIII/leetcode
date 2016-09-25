package solutions;

/**
 * https://leetcode.com/problems/valid-palindrome/
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note:
 * Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid
 * palindrome.
 */
public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!isLetterOrNum(s.charAt(left))) ++left;
            else if (!isLetterOrNum(s.charAt(right))) --right;
            else if (!equalIgnoreCase(s.charAt(left++), s.charAt(right--))) return false;
        }
        return true;
    }

    private boolean isLetterOrNum(char ch) {
        return isLetter(ch) || isNum(ch);
    }

    private boolean isLetter(char ch) {
        return 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z';
    }

    private boolean isNum(char ch) {
        return '0' <= ch && ch <= '9';
    }

    private boolean equalIgnoreCase(char ch1, char ch2) {
        return ch1 == ch2 || isLetter(ch1) && isLetter(ch2) &&
            Math.abs(ch1 - ch2) == Math.abs('a' - 'A');
    }

    // my 2nd version
    public boolean isPalindrome2(String s) {
        if (s == null) return true;
        s = s.trim().toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isAlnum(s.charAt(i))) ++i;
            while (i < j && !isAlnum(s.charAt(j))) --j;
            if (i == j) return true;
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    private boolean isAlnum(char ch) {
        return '0' <= ch && ch <= '9' || 'a' <= ch && ch <= 'z';
    }
}
