package edu.umb.cs680.hw01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @Test
    void Checkprimesfrom10to20(){
        PrimeGenerator prime= new PrimeGenerator(10,20);
        Long[] expected= {11L,13L,17L,19L};
        prime.generatePrimes();
        assertArrayEquals(expected,prime.getPrimes().toArray());

    }

    @Test
    void Checkprimesfromminus5to10(){
        try{
            PrimeGenerator prime= new PrimeGenerator(-5,10);
        }
        catch (RuntimeException error){
            assertEquals("Wrong input values: from=-5 to=10", error.getMessage());
        }

    }

    @Test
    void Checkprimesfrom100to1(){
        try{
            PrimeGenerator prime= new PrimeGenerator(100,1);
        }
        catch (RuntimeException error){
            assertEquals("Wrong input values: from=100 to=1", error.getMessage());
        }

    }

    @Test
    void CheckisEven(){
        PrimeGenerator prime= new PrimeGenerator(1,20);
        assertTrue(prime.isEven(6), String.valueOf(true));
        assertFalse(prime.isEven(7), String.valueOf(false));
    }
    @Test
    void CheckisPrime(){
        PrimeGenerator prime= new PrimeGenerator(20,30);
        assertTrue(prime.isPrime(23), String.valueOf(true));
        assertFalse(prime.isPrime(27), String.valueOf(false));
    }



}