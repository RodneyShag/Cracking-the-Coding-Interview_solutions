package _16_08_English_Int;

// Solution is mostly from online book solutions 
//
// Tricks:
// - use arrays as data structure for the words
// - split at the commas of a long number (into groups of 3), using a function called "numToStringl00"
// - don't forget to consider negative numbers

public class EnglishInt {

    public static String[] digits = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    public static String[] teens  = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] tens   = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] bigs   = {"", "Thousand", "Million", "Billion"};

    public static String numToString(int num) {
        if (num < 0) {
            return "Negative " + numToString(-1 * num);
        } else if (num == 0) {
            return "Zero";
        }

        int bigsIndex = 0;
        StringBuffer sb = new StringBuffer();

        /* We create the string from right to left, inserting in the front. This makes code clean and scalability easier */
        while (num > 0) {
            if (num % 1000 != 0) {
                sb.insert(0, numToString100(num % 1000) + bigs[bigsIndex] + " ");
            }
            num /= 1000;
            bigsIndex++;
        }
        return sb.toString();
    }

    public static String numToString100(int num) {
        if (num < 0) {
            return "Negative " + numToString(-1 * num);
        } else if (num == 0) {
            return "Zero";
        } else if (num > 999) {
            return null;
        }

        StringBuffer sb = new StringBuffer();

        /* Hundreds */
        if (num >= 100) {
            int digit = num / 100;
            sb.append(digits[digit] + " Hundred ");
            num = num % 100; // now we have a 2-digit number
        }

        /* Tens */
        int tensDigit   = num / 10;
        int singleDigit = num % 10;

        if (num >= 10 && num <= 19) {
            sb.append(teens[singleDigit] + " ");
            return sb.toString();
        } else if (num >= 20) {
            sb.append(tens[tensDigit] + " ");
        }

        /* Single Digit */
        if (singleDigit != 0) {
            sb.append(digits[singleDigit] + " ");
        }

        return sb.toString();
    }
}
