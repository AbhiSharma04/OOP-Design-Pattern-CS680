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
        List<List<Double>> expected= List.of( List.of(0.0, 0.16042842892699744, 0.27701998437460823, 0.006302610358126792, 0.22497078375837778), List.of(0.16042842892699744, 0.0, 0.43744841330160567, 0.16673103928512423, 0.06454235483138035), List.of(0.27701998437460823, 0.43744841330160567, 0.0, 0.27071737401648144, 0.501990768132986),  List.of(0.006302610358126792, 0.16673103928512423, 0.27071737401648144, 0.0, 0.23127339411650458),  List.of(0.22497078375837778, 0.06454235483138035, 0.501990768132986, 0.23127339411650458, 0.0));
        Distance dist= new Distance();
        Euclidean euc= new Euclidean();
        List<List<Double>> mat= dist.matrix(carvalues,euc);
        assertEquals(expected,mat);
    }

    @Test
    public void CheckDistancefor2points(){
        Euclidean euc= new Euclidean();
        double expected =0.22497078375837778;
        double distanceeuc= euc.distance(carvalues.get(0),carvalues.get(4));
        assertEquals(expected,distanceeuc);
    }

}