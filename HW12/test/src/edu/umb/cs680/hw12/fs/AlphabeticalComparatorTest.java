package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlphabeticalComparatorTest {
    private static FileSystem fs;
    @BeforeAll
    public static void setupFS(){
        fs= TestFixtureInitializer.createFS();
    }

    @Test
    public void CheckAlphabeticalSortOrderOfDirectoriesUnderRoot(){
        setupFS();
        List<String> expected = List.of("lib","src","test");
        List<String> actual= new ArrayList<>();
        for(FSElement e: fs.getRootDirs().getSubDirectories(new AlphabeticalComparator())){
            actual.add(e.getName());}
        assertEquals(expected,actual);
    }

    @Test
    public void CheckDefaultOrderOfRootSubDirectories(){
        setupFS();
        List<String> expected = List.of("lib","src","test");
        List<String> actual= new ArrayList<>();
        for(FSElement e: fs.getRootDirs().getSubDirectories()){
            actual.add(e.getName());}
        assertEquals(expected,actual);
    }

    @Test
    public void CheckAlphabeticalOrderofFilesUnderSrc(){
        setupFS();
        List<String> expected = List.of("a","b");
        List<String> actual= new ArrayList<>();
        for(FSElement e: fs.getRootDirs().getSubDirectories().get(1).getFiles(new AlphabeticalComparator())){
            actual.add(e.getName());}
        assertEquals(expected,actual);
    }

    @Test
    public void CheckAlphabeticalOrderofLinkUnderSrc(){
        List<String> expected =List.of("y");
        List<String> actual= new ArrayList<>();
        for(FSElement e:fs.getRootDirs().getLinks(new AlphabeticalComparator())){
            actual.add(e.getName());
            }
        assertEquals(expected,actual);
    }

}






