package easy;

public class Id125 {
	public boolean isPalindrome(String s) {
		// Will not parse string to create a only-alphanumeric string since that gets
		// O(n) space

		// 2 pointers pattern, front-back
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (!Character.isLetterOrDigit(s.charAt(left))) {
				left++;
				continue;
			}

			if (!Character.isLetterOrDigit(s.charAt(right))) {
				right--;
				continue;
			}

			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
				System.out.println("Left: " + s.charAt(left) + " Right: " + s.charAt(right));
				return false;
			}

			left++;
			right--;
		}

		return true;
	}
}
