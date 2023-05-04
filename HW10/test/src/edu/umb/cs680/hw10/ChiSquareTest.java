package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChiSquareTest {
    static List<List<Double>> carvalues;
    @BeforeAll
    public static void setupCarvalues(){
        carvalues= MinMaxNormalization.CarNormalizedvalues();
    }


    @Test
    public void CheckcarValuesbyMatrixEuclidean(){
        setupCarvalues();
        List<List<Double>> expected= List.of(List.of(0.0, 0.027669338365049593, 0.01489004555745375, 0.004496059551813846, 0.056560342234079776), List.of(0.027669338365049593, 0.0, 0.0023507496775242703, 0.01102283761449263, 0.0066507161736241), List.of(0.01489004555745375, 0.0023507496775242703, 0.0, 0.003318852532943051, 0.01656541458065993), List.of(0.004496059551813846, 0.01102283761449263, 0.003318852532943051, 0.0, 0.03315917533648493), List.of(0.056560342234079776, 0.0066507161736241, 0.01656541458065993, 0.03315917533648493, 0.0));
        ChiSquare chi= new ChiSquare();
        List<List<Double>> mat= Distance.matrix(carvalues,chi);
        assertEquals(expected,mat);
    }

    @Test
    public void CheckDistancefor2points(){
        ChiSquare chi= new ChiSquare();
        double expected =0.056560342234079776;
        double distancechi= chi.distance(carvalues.get(0),carvalues.get(4));
        assertEquals(expected,distancechi);
    }



}