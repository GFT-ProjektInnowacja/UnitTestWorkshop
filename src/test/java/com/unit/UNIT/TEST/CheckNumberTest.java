package com.unit.UNIT.TEST;

import java.util.List;

public class CheckNumberTest {
    public CheckNumberTest() {}

    public boolean check(List<Integer> gameSigns) {
        for(Integer x : gameSigns) {
            if(x < 0 || x > 9) return false;
        }
        return true;
    }
}
