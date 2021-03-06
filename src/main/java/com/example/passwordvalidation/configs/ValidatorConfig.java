package com.example.passwordvalidation.configs;

import com.example.passwordvalidation.rules.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:validator.properties")
public class ValidatorConfig {

    @Value("${password.length.error}")
    private String lengthErrorMsg;

    @Value("${password.digit.error}")
    private String digitErrorMsg;

    @Value("${password.lowercase.error}")
    private String lowercaseErrorMsg;

    @Value("${password.uppercase.error}")
    private String uppercaseErrorMsg;

    @Value("${password.special-character.error}")
    private String specialCharacterErrorMsg;

    @Value("${password.sequence-repeat.error}")
    private String sequenceRepeatErrorMsg;

    @Value("${password.white-space.error}")
    private String whiteSpaceErrorMsg;

    @Value("${password.alphanumeric.error}")
    private String alphanumericErrorMsg;

    @Bean
    public List<Rule> getValidationStrategies(){
        List<Rule> list = new ArrayList<>();
        list.add(new LengthRule(lengthErrorMsg));
        list.add(new DigitRule(digitErrorMsg));
        list.add(new LowercaseRule(lowercaseErrorMsg));
        list.add(new UppercaseRule(uppercaseErrorMsg));
        list.add(new SpecialCharacterRule(specialCharacterErrorMsg));
        list.add(new SequenceRepeatRule(sequenceRepeatErrorMsg));
        list.add(new WhitespaceRule(whiteSpaceErrorMsg));
        list.add(new AlphanumericRule(alphanumericErrorMsg));
        return list;
    }

}
