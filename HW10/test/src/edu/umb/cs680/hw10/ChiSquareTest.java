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
        List<List<Double>> expected= List.of(List.of(0.0, 0.02314377170898314, 0.038621896866840214, 2.7479951011316662E-5, 0.05148838826934106), List.of(0.02314377170898314, 0.0, 0.11485566794060484, 0.024717773503404875, 0.00629148874038219), List.of(0.038621896866840214, 0.11485566794060484, 0.0, 0.0366519599235637, 0.1639506192254027), List.of(2.7479951011316662E-5, 0.024717773503404875, 0.0366519599235637, 0.0, 0.05372477700414985), List.of(0.05148838826934106, 0.00629148874038219, 0.1639506192254027, 0.05372477700414985, 0.0));
        Distance dist= new Distance();
        ChiSquare chi= new ChiSquare();
        List<List<Double>> mat= dist.matrix(carvalues,chi);
        assertEquals(expected,mat);
    }

    @Test
    public void CheckDistancefor2points(){
        ChiSquare chi= new ChiSquare();
        double expected =0.05148838826934106;
        double distancechi= chi.distance(carvalues.get(0),carvalues.get(4));
        assertEquals(expected,distancechi);
    }



}