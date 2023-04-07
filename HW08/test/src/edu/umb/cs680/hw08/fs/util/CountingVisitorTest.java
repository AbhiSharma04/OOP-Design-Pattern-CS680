package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.FileSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingVisitorTest {

    private static FileSystem fs;
    @BeforeAll
    public static void setupFS(){
        fs=TestFixtureInitializer.createFS();
    }

    @Test
    public void CheckNumberOfDirectories(){
        CountingVisitor countVisitorDir= new CountingVisitor();
        fs.getRootDirs().accept(countVisitorDir);
        System.out.println("Number of Directories are : " + countVisitorDir.getDirNum());
        assertEquals(5,countVisitorDir.getDirNum());
    }


    @Test
    public void CheckNumberOfFiles(){
        CountingVisitor countVisitorFiles= new CountingVisitor();
        fs.getRootDirs().accept(countVisitorFiles);
        System.out.println("Number of files are : " + countVisitorFiles.getFileNum());
        assertEquals(5,countVisitorFiles.getFileNum());
    }

    @Test
    public void CheckNumberOfLinks(){
        CountingVisitor countVisitorLinks= new CountingVisitor();
        fs.getRootDirs().accept(countVisitorLinks);
        System.out.println("Number of Links are : " + countVisitorLinks.getLinkNum());
        assertEquals(1,countVisitorLinks.getLinkNum());
    }

    @Test

    public void CountAllFSElements(){
        CountingVisitor countVisitorElem= new CountingVisitor();
        fs.getRootDirs().accept(countVisitorElem);
        assertEquals(11,countVisitorElem.getDirNum()+countVisitorElem.getFileNum()+countVisitorElem.getLinkNum());

    }

}