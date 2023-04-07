package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.FileSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileCrawlingVisitorTest {

    private static FileSystem fs;
    @BeforeAll
    public static void setupFS(){
        fs=TestFixtureInitializer.createFS();
    }

    @Test
    public void CheckNoOfFilesUsingFCVisitor(){
        FileCrawlingVisitor FCVisitor = new FileCrawlingVisitor();
        fs.getRootDirs().accept(FCVisitor);
        assertEquals(5,FCVisitor.getFiles().size());
    }

}