package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EuclideanTest {
    static List<List<Double>> carvalues;
    @BeforeAll
    public static void setupCarvalues(){
        carvalues= MinMaxNormalization.CarNormalizedvalues();
    }

    @Test
    public void CheckcarValuesbyMatrixEuclidean(){
        setupCarvalues();
        List<List<Double>> expected= List.of( List.of(0.0, 0.09695978061172472, 0.0638127054955143, 0.030495383648381842, 0.16355753114199276), List.of(0.09695978061172472, 0.0, 0.033147075116210414, 0.06646439696334287, 0.06659775053026804), List.of(0.0638127054955143, 0.033147075116210414, 0.0, 0.03331732184713246, 0.09974482564647845),  List.of(0.030495383648381842, 0.06646439696334287, 0.03331732184713246, 0.0, 0.1330621474936109),  List.of(0.16355753114199276, 0.06659775053026804, 0.09974482564647845, 0.1330621474936109, 0.0));
        Euclidean euc= new Euclidean();
        List<List<Double>> mat= Distance.matrix(carvalues,euc);
        assertEquals(expected,mat);
    }

    @Test
    public void CheckDistancefor2points(){
        Euclidean euc= new Euclidean();
        double expected =0.16355753114199276;
        double distanceeuc= euc.distance(carvalues.get(0),carvalues.get(4));
        assertEquals(expected,distanceeuc);
    }

}