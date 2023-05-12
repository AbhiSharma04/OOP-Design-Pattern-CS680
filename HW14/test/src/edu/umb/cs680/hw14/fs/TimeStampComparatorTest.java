package edu.umb.cs680.hw14.fs;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeStampComparatorTest {

    private static FileSystem fs;
    @BeforeAll
    public static void setupFS(){
        fs= TestFixtureInitializer.createFS();
    }
    @Test
    public void CheckTimeStampSortOrderOfDirectoriesUnderRoot(){
        setupFS();
        List<String> expected = List.of("src","lib","test");
        List<String> actual= new ArrayList<>();
        for(edu.umb.cs680.hw14.fs.FSElement e: fs.getRootDirs().getSubDirectories((FSElement f1 , FSElement f2)->f1.creationTime.compareTo(f2.creationTime))){
            actual.add(e.getName());}
        assertEquals(expected,actual);
    }

    @Test
    public void CheckTimeStampOrderOfFilesUnderSrc(){
        setupFS();
        List<String> expected = List.of("a","b");
        List<String> actual= new ArrayList<>();
        for(FSElement e: fs.getRootDirs().getSubDirectories().get(1).getFiles((FSElement f1 , FSElement f2)->f1.creationTime.compareTo(f2.creationTime))){
            actual.add(e.getName());}
        assertEquals(expected,actual);
    }




}
