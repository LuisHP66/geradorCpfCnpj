package utils;

import java.security.SecureRandom;

public class RandomCNPJ {

    public RandomCNPJ() {
    }

    private static final int[] WEIGHTS_FOR_DIGIT_1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] WEIGHTS_FOR_DIGIT_2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public String generationCnpj() {
        SecureRandom random = new SecureRandom();
        int[] digits = new int[12];
        for (int i = 0; i < 12; i++) {
            digits[i] = random.nextInt(10);
        }
        int[] calculatedDigits = calculateVerificationDigits(digits);
        return String.format("%d%d%d%d%d%d%d%d%d%d%d%d%d%d",
                digits[0], digits[1], digits[2], digits[3], digits[4], digits[5],
                digits[6], digits[7], digits[8], digits[9], digits[10], digits[11],
                calculatedDigits[0], calculatedDigits[1]);
    }

    private int[] calculateVerificationDigits(int[] digits) {
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += digits[i] * WEIGHTS_FOR_DIGIT_1[i];
        }
        int remainder = sum % 11;
        int digit1 = remainder < 2 ? 0 : 11 - remainder;

        sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += digits[i] * WEIGHTS_FOR_DIGIT_2[i];
        }
        sum += digit1 * WEIGHTS_FOR_DIGIT_2[12];
        remainder = sum % 11;
        int digit2 = remainder < 2 ? 0 : 11 - remainder;

        return new int[]{digit1, digit2};
    }
}
