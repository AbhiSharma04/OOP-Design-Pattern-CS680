package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {
    private static FileSystem fs;
    @BeforeAll
    public static void setUpFS(){
        fs =  TestFixtureInitializer.createFS();
    }

    @Test
    public void CheckNameforFileX(){
        setUpFS();
        assertEquals("x",fs.getRootDirs().getFiles().getFirst().getName());
    }

    @Test
    public void CheckParentforFileX(){
        setUpFS();
        assertEquals("prjRoot",fs.getRootDirs().getName());
    }

    @Test
    public void CheckFileSizeforD(){
        setUpFS();
        int expected=100;
        assertEquals(expected,fs.getRootDirs().getSubDirectories().get(2).getSubDirectories().get(0).getFiles().get(0).getSize());
    }

    @Test
    public void CheckFileSizeNotNull(){
        setUpFS();
        assertNotNull(fs.getRootDirs().getFiles().getFirst());
    }
    @Test
    public void FileIsNotDirectory(){
        setUpFS();
        assertFalse(fs.getRootDirs().getFiles().getFirst().isDirectory(),"File is not a directory");
    }




}