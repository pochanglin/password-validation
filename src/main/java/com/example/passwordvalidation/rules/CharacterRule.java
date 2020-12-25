package com.example.passwordvalidation.rules;

public abstract class CharacterRule implements IPasswordValidationRule {

    protected static String getMatchingCharacters(final String characters,
                                                  final String input,
                                                  final int maximumLength) {
        final StringBuilder sb = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            final char c = input.charAt(i);
            if (characters.indexOf(c) != -1) {
                if (sb.length() < maximumLength) {
                    sb.append(c);
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }

    protected static boolean checkResult(final int num,
                                         final String matchingCharacters){
        return num == 0 ?
               matchingCharacters.length() == num :
               matchingCharacters.length() >= num;
    }

}
