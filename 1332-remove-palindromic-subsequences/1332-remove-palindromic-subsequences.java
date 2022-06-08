class Solution {
  public int removePalindromeSub(String s) {
    // answer can only be at most 2 because obviously you can remove all 'a's from the string and then remove all 'b's, that's 2 steps
    // or you can just do it in 1 step if the whole string is palindrome
    return isPalindrome(s) ? 1 : 2;
  }

  boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }
}