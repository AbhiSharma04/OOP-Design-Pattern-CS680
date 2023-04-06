package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {
    private static edu.umb.cs680.hw06.FileSystem fs;
    @BeforeAll
    public static void setUpFS(){
        fs =  TestFixtureInitializer.createFS();
    }
    LocalDateTime time=LocalDateTime.now();

    private String[] FileToStringArray(File file){
        String[] FileInfo = {file.getParent().getName(),
                file.getName(), String.valueOf(file.getSize()),time.toString()};
        return FileInfo;
    }

    @Test
    public void EqualityCheckWithSrcFile(){
        String[] expected={"src","a","414",time.toString()};
        File file= fs.getRootDirs().getSubDirectories().get(0).getFiles().getFirst();
        assertArrayEquals(expected,FileToStringArray(file));
    }




    @Test
    public void CheckIfClassIsSingelton(){
        setUpFS();
        edu.umb.cs680.hw06.FileSystem file1= edu.umb.cs680.hw06.FileSystem.getFileSystem();
        edu.umb.cs680.hw06.FileSystem file2= FileSystem.getFileSystem();
        assertSame(file2,file1);
    }

    @Test
    public void CheckRootDirName(){
        setUpFS();
        String expected="prjRoot";
        assertEquals(expected,fs.getRootDirs().getName());
    }

    @Test
    public void CheckRootParentisNull(){
        setUpFS();
        assertNull(fs.getRootDirs().getParent());
    }





}