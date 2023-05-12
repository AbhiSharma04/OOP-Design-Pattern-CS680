package edu.umb.cs680.hw14.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseAlphabeticalComparatorTest {
    private static FileSystem fs;
    @BeforeAll
    public static void setupFS(){
        fs= TestFixtureInitializer.createFS();
    }



    @Test
    public void CheckReverseAlphabeticalOrderOfRootUnderDirectories(){
        List<String> expected = List.of("test","src","lib");
        List<String> actual= new ArrayList<>();
        for(FSElement e: fs.getRootDirs().getSubDirectories((FSElement f1,FSElement f2) ->f2.getName().compareTo(f1.getName()))){
            actual.add(e.getName());}
        assertEquals(expected,actual);
    }

    @Test
    public void CheckReverseAlphabeticalOrderofFilesUnderSrc(){
        setupFS();
        List<String> expected = List.of("b","a");
        List<String> actual= new ArrayList<>();
        for(FSElement e: fs.getRootDirs().getSubDirectories().get(1).getFiles((FSElement f1,FSElement f2) ->f2.getName().compareTo(f1.getName()))){
            actual.add(e.getName());}
        assertEquals(expected,actual);
    }

    @Test
    public void CheckReverseAlphabeticalOrderofLinkUnderSrc(){
        List<String> expected =List.of("y");
        List<String> actual= new ArrayList<>();
        for(FSElement e:fs.getRootDirs().getLinks((FSElement f1,FSElement f2) ->f2.getName().compareTo(f1.getName()))){
            actual.add(e.getName());
        }
        assertEquals(expected,actual);
    }

}
