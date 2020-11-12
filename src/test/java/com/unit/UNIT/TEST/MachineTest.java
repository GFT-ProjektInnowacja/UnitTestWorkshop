package com.unit.UNIT.TEST;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MachineTest {

    private Machine machine;

/*    @Mock
    private Validator validator;*/

    @BeforeEach
    public void setUp(){
        this.machine = new Machine(/*validator*/);
    }

    @Test
    public void shouldIncreaseAmountOfMoney(){
        //given
        Money money = new Money(5);
        int finalResult = 10005;
        //when
        machine.insertCoin(money);
        //then
        assertEquals(machine.bankAmount, finalResult);
    }

/*
    @Test
    public void shouldIncreaseAmountOfMoney2(){
        //given
        Money money = new Money(5);
        when(validator.validateMoney(money)).thenReturn(true);

        //when
        machine.insertCoin(money);

        verify(validator,times(1)).validateMoney(money);

    }
*/


}