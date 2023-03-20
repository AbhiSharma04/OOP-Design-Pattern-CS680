package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SingletonPrimeGeneratorTest {

    @Test
    void getinstancenonnullcheck() {
        SingletonPrimeGenerator s = SingletonPrimeGenerator.getInstance(20,30);
        Assertions.assertNotNull(s);
        System.out.println(s);
    }

    @Test
    void CheckIdentical(){

        SingletonPrimeGenerator a = SingletonPrimeGenerator.getInstance(20,30);
        SingletonPrimeGenerator b = SingletonPrimeGenerator.getInstance(12,29);
        Assertions.assertEquals(a.hashCode(),b.hashCode());

    }

    @Test
    void Checkprimesfrom20to30(){
        SingletonPrimeGenerator prime=  SingletonPrimeGenerator.getInstance(20,30);
        Long[] expected= {23L,29L};
        prime.generatePrimes();
        assertIterableEquals(Arrays.asList(expected),prime.getPrimes());
    }

    @Test
    void Checkprimesfromminus1to5(){
        try{
            SingletonPrimeGenerator prime= SingletonPrimeGenerator.getInstance(-1,5);
        }
        catch (RuntimeException error){
            assertEquals("Wrong input values: from=-1 to=5", error.getMessage());
        }

    }

    @Test
    void Checkprimesfrom50to5(){
        try{
            SingletonPrimeGenerator prime= SingletonPrimeGenerator.getInstance(50,5);
        }
        catch (RuntimeException error){
            assertEquals("Wrong input values: from=50 to=5", error.getMessage());
        }

    }

}