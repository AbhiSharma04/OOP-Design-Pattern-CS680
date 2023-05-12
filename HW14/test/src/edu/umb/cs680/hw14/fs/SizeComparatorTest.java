package edu.umb.cs680.hw14.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SizeComparatorTest {
    private static FileSystem fs;
    @BeforeAll
    public static void setupFS(){
        fs= TestFixtureInitializer.createFS();
    }


    @Test
    public void CheckSizeOrderOfFilesUnderSrc(){
        setupFS();
        List<String> expected = List.of("b","a");
        List<String> actual= new ArrayList<>();
        for(FSElement e: fs.getRootDirs().getSubDirectories().get(1).getFiles((FSElement f1, FSElement f2)->f1.getSize()-f2.getSize())){
            actual.add(e.getName());}
        assertEquals(expected,actual);
    }


    @Test
    public void CheckSizeOrderOfDirectoriesUnderRoot(){
        setupFS();
        List<String> expected = List.of("src","lib","test");
        List<String> actual= new ArrayList<>();
        for(FSElement e: fs.getRootDirs().getSubDirectories((FSElement f1, FSElement f2)->f1.getSize()-f2.getSize())){
            actual.add(e.getName());}
        assertEquals(expected,actual);
    }

    @Test
    public void CheckSizeOrderofLinkUnderSrc(){
        List<String> expected =List.of("y");
        List<String> actual= new ArrayList<>();
        for(FSElement e:fs.getRootDirs().getLinks((FSElement f1, FSElement f2)->f1.getSize()-f2.getSize())){
            actual.add(e.getName());
        }
        assertEquals(expected,actual);
    }



}
