package com.training.jdbc;

import java.util.InputMismatchException;
import java.util.Scanner;


import java.util.*;
import java.util.ArrayList;
import java.util.Random;

public class New_Account {
	 public long generateAcc() { 
         Random rnd = new Random();
         char [] digits = new char[11];
         digits[0] = (char) (rnd.nextInt(9) + '1');
         for(int i=1; i<digits.length; i++) {
             digits[i] = (char) (rnd.nextInt(10) + '0');
         }
         return Long.parseLong(new String(digits));
     }
}       