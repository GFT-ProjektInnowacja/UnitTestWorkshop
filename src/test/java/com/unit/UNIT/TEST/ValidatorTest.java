package com.unit.UNIT.TEST;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        this.validator = new Validator();
    }

    @Test
    public void shouldReturnTrueWhenValidatingValidMoney() {
        //given
        Money five = new Money(5);
        Money two = new Money(2);
        Money one = new Money(1);
        //when
        boolean validatingFiveResult = validator.validateMoney(five);
        boolean validatingTwoResult = validator.validateMoney(two);
        boolean validatingOneResult = validator.validateMoney(one);
        //then
        assertTrue(validatingFiveResult);
        assertTrue(validatingTwoResult);
        assertTrue(validatingOneResult);
    }
}
