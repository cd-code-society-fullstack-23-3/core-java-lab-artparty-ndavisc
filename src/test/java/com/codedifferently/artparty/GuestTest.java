package com.codedifferently.artparty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GuestTest {

    @Test
    public void constructorTest01(){
        Guest guest = new Guest("Darth", "Vader", "darthvader@lukeskywalker.com");
        String expected = "First Name: Darth, Last Name: Vader, Email Address: darthvader@lukeskywalker.com, Phone Number: , Reason For Visit: ";
        String actual = guest.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void constructorNoParametersTest02(){
        Guest guest = new Guest();
        String expected = "First Name: , Last Name: , Email Address: , Phone Number: , Reason For Visit: ";
        String actual = guest.toString();
        Assertions.assertEquals(expected, actual);
    }
}
