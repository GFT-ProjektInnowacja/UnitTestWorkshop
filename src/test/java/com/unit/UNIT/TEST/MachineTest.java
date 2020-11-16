package com.unit.UNIT.TEST;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
    public void shouldClearAmountOfMoney() {
        //given
        int finalResult = 0;
        //when
        machine.winInfo();
        //then
        assertEquals(machine.bankAmount, finalResult);
    }

    @Test
    public void shouldFiveElementsInList() {
        //given
        int numberOfElements = 5;
        //when
        machine.generateThreeSigns();
        //then
        assertEquals(machine.gameSigns.size(), numberOfElements);
    }

    @Test
    public void shouldElementsFromZeroToNine() {
        //given
        CheckNumberTest checkTest = new CheckNumberTest();
        //when
        machine.generateThreeSigns();
        //then
        assertTrue(checkTest.check(machine.gameSigns));
    }

    @Test
    public void shouldPlayerWin() {
        //given
        List<Integer> mockList = new ArrayList<>();
        mockList.add(7);
        mockList.add(7);
        mockList.add(7);
        mockList.add(7);
        mockList.add(7);
        machine.gameSigns = mockList;
        //when
        machine.checkWin();
        //then
        assertTrue(machine.checkWin());
    }

    @Test
    public void shouldNotIncreaseAmountOfMoney() {
        //given
        Money money = new Money(10);
        int finalResult = machine.bankAmount;
        when(validator.validateMoney(money)).thenReturn(false);
        //when
        machine.insertCoin(money);
        //then
        assertEquals(finalResult, machine.bankAmount);
        verify(validator,times(1)).validateMoney(money);
    }

    @Test
    public void shouldGenerateThreeGameSigns() {
        //given
        int numberOfGameSigns = 3;
        //when
        machine.generateThreeSigns();
        //then
        assertEquals(numberOfGameSigns, machine.gameSigns.size());
    }

    @Test
    public void shouldGenerateGameSignsInRangeFromZeroToNine() {
        //given
        int lowerBound = 0;
        int upperBound = 9;
        //when
        machine.generateThreeSigns();
        //then
        for(int gameSign : machine.gameSigns) {
            assertTrue(gameSign >= lowerBound);
            assertTrue(gameSign <= upperBound);
        }
    }

    @Test
    public void shouldNotStartGameWhenInsertedInvalidMoney() {
        //given
        Machine machineSpy = Mockito.spy(machine);
        Money invalidMoney = new Money(0);
        //when
        machineSpy.insertCoin(invalidMoney);
        //then
        verify(machineSpy, times(0)).startGame();
    }

    @Test
    public void shouldStartGame() {
        //given
        Machine machineSpy = Mockito.spy(machine);
        Money money = new Money(4);
        when(validator.validateMoney(money)).thenReturn(true);
        //when
        machineSpy.insertCoin(money);
        //then
        verify(machineSpy, times(1)).startGame();
    }
}
