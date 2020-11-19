package com.unit.UNIT.TEST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MachineTest {

    private Machine machine;

    @Mock
    private Validator validator;

    @BeforeEach
    public void setUp(){
        this.machine = new Machine(validator);
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

    @Test
    public void shouldIncreaseAmountOfMoney2(){
        //given
        Money money = new Money(5);
        when(validator.validateMoney(money)).thenReturn(true);

        //when
        machine.insertCoin(money);

        verify(validator,times(1)).validateMoney(money);

    }

    @Test
    public void shouldPlayerWinTheGame() {
        //given
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            integerList.add(7);

        machine.gameSigns = integerList;

        //when
        machine.checkWin();

        //then
        assertTrue(machine.checkWin());
    }


    @Test
    public void shouldPlayerLoseTheGame() {
        //given
        List<Integer> integerList = new ArrayList<>();

        for(int i = 1; i < 6; i++)
            integerList.add(i);

        machine.gameSigns = integerList;

        //when
        machine.checkWin();

        //then
        assertFalse(machine.checkWin());
    }

    @Test
    public void shouldIncreaseListOfAmountOfMoney() {
        //given
        List <Money> moneyList = new ArrayList<>();

        int finalBankAccountResult = 10025;

        for (int i = 0; i < 5; i++)
            moneyList.add(new Money(5));

        for (Money money : moneyList)
            when(validator.validateMoney(money)).thenReturn(true);

        //when
        for (Money money : moneyList)
            machine.insertCoin(money);

        //then
        assertEquals(finalBankAccountResult, machine.bankAmount);
        verify(validator,times(5)).validateMoney(any(Money.class));
    }

    @Test
    public void shouldNotIncreaseListOfAmountOfMoney() {
        //given
        List<Money> moneyList = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            moneyList.add(new Money(50));

        int finalResult = machine.bankAmount;

        for (Money money : moneyList)
            when(validator.validateMoney(money)).thenReturn(false);

        //when
        for (Money money : moneyList)
            machine.insertCoin(money);

        //then
        assertEquals(finalResult, machine.bankAmount);
        verify(validator,times(5)).validateMoney(any(Money.class));
    }

    @Test
    public void shouldClearBankAccountAfterPlayerWin() {
        //given
        int accountAfterWin = 0;

        //when
        machine.winInfo();

        //then
        assertEquals(accountAfterWin, machine.bankAmount);
    }
}
