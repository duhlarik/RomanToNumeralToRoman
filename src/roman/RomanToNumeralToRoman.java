package roman;

import java.util.HashMap;
import java.util.Map;

public class RomanToNumeralToRoman {

	Map<String, Integer> RomanToNumber;

	public RomanToNumeralToRoman() {
		RomanToNumber = new HashMap<String, Integer>();
		RomanToNumber.put("I", 1);
		RomanToNumber.put("V", 5);
		RomanToNumber.put("X", 10);
		RomanToNumber.put("L", 50);
		RomanToNumber.put("C", 100);
		RomanToNumber.put("D", 500);
		RomanToNumber.put("M", 1000);
	}

	public int toNumber(String roman) {
		int result = 0;
		for (int i = 0; i < roman.length(); i++) {
			int right = rightRoman(roman, i);
			int current = RomanToNumber.get(String.valueOf(roman.charAt(i)));
			// I think this is messy and would like to refactor it, but I'm not sure how
			if (right > current) {
				current *= -1;
			}
			result += current;
		}
		return result;
	}

	public int rightRoman(String roman, int i) {
		int right = 0;
		if (i < roman.length() - 1) {
			String rightRoman = roman.substring(i + 1, i + 2);
			right = RomanToNumber.get(rightRoman);
		}
		return right;
	}

	public String toRoman(int number) {
		
		String roman = "";
		
		int[] numbers = {1,4,5,9,10,40,50,90,100,400,500,900,1000,4000,5000};
		String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M", "MV", "V"};
		
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
}
