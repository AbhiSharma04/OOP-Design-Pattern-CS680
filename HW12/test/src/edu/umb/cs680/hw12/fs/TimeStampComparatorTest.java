package edu.umb.cs680.hw12.fs;
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
        for(FSElement e: fs.getRootDirs().getSubDirectories(new TimeStampComparator())){
            actual.add(e.getName());}
        assertEquals(expected,actual);
    }

    @Test
    public void CheckTimeStampOrderOfFilesUnderSrc(){
        setupFS();
        List<String> expected = List.of("a","b");
        List<String> actual= new ArrayList<>();
        for(FSElement e: fs.getRootDirs().getSubDirectories().get(1).getFiles(new TimeStampComparator())){
            actual.add(e.getName());}
        assertEquals(expected,actual);
    }

    @Test
    public void CheckTimeStampOrderofLinkUnderSrc(){
        List<String> expected =List.of("y");
        List<String> actual= new ArrayList<>();
        for(FSElement e:fs.getRootDirs().getLinks(new TimeStampComparator())){
            actual.add(e.getName());
        }
        assertEquals(expected,actual);
    }



}
