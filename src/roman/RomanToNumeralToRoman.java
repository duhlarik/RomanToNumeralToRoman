package roman;

public class RomanToNumeralToRoman {

	int[] numbers = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000, 4000 };
	String[] romans = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M", "MV" };

	public String toRoman(int number) {

		String roman = "";

		while (number > 0) {
			int hit = 0;
			for (int i = 0; i < numbers.length; i++) {
				if (number >= numbers[i]) {
					hit = i;
				}
			}
			roman += romans[hit];
			number -= numbers[hit];
		}
		return roman;
	}

	public int toNumber(String roman) {

		int result = 0;
		String currentRoman = "";
		int currentHit = 0;
		int current = 0;
		String rightRoman = "";
		int rightHit = 0;
		int right = 0;

		for (int i = 0; i < roman.length(); i++) {
			currentRoman = roman.substring(i, i + 1);

			for (int j = 0; j < romans.length; j++) {

				if (romans[j].equalsIgnoreCase(currentRoman)) {
					currentHit = j;
				}
				current = numbers[currentHit];
			}

			if (i < roman.length() - 1) {
				rightRoman = roman.substring(i + 1, i + 2);

				for (int k = 0; k < romans.length; k++) {

					if (romans[k].equalsIgnoreCase(rightRoman)) {
						rightHit = k;
					}
					right = numbers[rightHit];
				}
			}

			if (right > current) {
				current *= -1;
			}
			result += current;
		}
		return result;
	}
}
