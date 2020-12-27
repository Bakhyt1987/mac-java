package com.baha;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

    @Test
    public  void testPrimes(){
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public  void testPrimes2(){
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
    }



}
