package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    private static FileSystem fs;
    @BeforeAll
    public static void setUpFS(){
        fs =  TestFixtureInitializer.createFS();

    }
    LocalDateTime time=LocalDateTime.now();

    private String[] dirToStringArray(Directory d){
        String[] dirInfo = {d.getParent().getName(),
            d.getName(), String.valueOf(d.getSize()),time.toString()};
        return dirInfo;
    }

    @Test
    public void EqualityCheckWithSrc(){
        String[] expected={"prjRoot","src","0",time.toString()};
        Directory d= fs.getRootDirs().getSubDirectories().get(0);
        assertArrayEquals(expected,dirToStringArray(d));
    }

    @Test

    public void EqualityCheckWithTest(){
        setUpFS();
        String[] expected={"prjRoot","test","0",time.toString()};
        Directory d= fs.getRootDirs().getSubDirectories().get(2);
        assertArrayEquals(expected,dirToStringArray(d));
    }



    @Test
    public void Rootelementcountchildren(){
        setUpFS();
        assertEquals(4, fs.getRootDirs().countChildren());
    }

    @Test
    public void RootalwaysNotNull(){
        setUpFS();
        assertNotNull(fs.getRootDirs());
    }
    @Test
    public void CheckParentforRoot(){
        setUpFS();
        assertNull(fs.getRootDirs().getParent());
    }

    @Test
    public void CheckFilesUnderRoot(){
        setUpFS();
        int expected =1;//as we have only one file under root
        assertEquals(expected,fs.getRootDirs().getFiles().size());
    }

    @Test
    public void CheckTotalSizeofDirectory(){
        setUpFS();
        int expected =1244;// we have calculated this from test fixture
        assertEquals(expected,fs.getRootDirs().getTotalSize());
    }

    @Test
    public void CheckIfRootIsDirectory(){
        setUpFS();
        assertTrue(fs.getRootDirs().isDirectory());
    }

    @Test
    public void CheckNameOfRoot(){
        setUpFS();
        assertEquals("prjRoot",fs.getRootDirs().getName());
    }

    @Test
    public void DirectoryIsNotFile(){
        setUpFS();
        assertFalse(fs.getRootDirs().getSubDirectories().get(0).isFile());
    }

    @Test
    public void AppendRootTest(){
        Directory testRoot= new Directory(null,"testRoot",0, LocalDateTime.now());
        edu.umb.cs680.hw06.FileSystem fs= FileSystem.getFileSystem();
        fs.appendRootDir(testRoot);
        assertEquals("testRoot",fs.getRootDirs().getName());
    }




}