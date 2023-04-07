package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.FileSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSearchVisitorTest {

    private static FileSystem fs;
    @BeforeAll
    public static void setupFS(){
        fs=TestFixtureInitializer.createFS();
    }

    @Test
    public void Check_x_InFileList(){

        FileSearchVisitor FSVisitor = new FileSearchVisitor("x");
        fs.getRootDirs().accept( FSVisitor );
        assertEquals("x",FSVisitor.getFoundFiles().getFirst().getName());

    }

    @Test
    public void Check_a_InFileList(){

        FileSearchVisitor FSVisitor = new FileSearchVisitor("a");
        fs.getRootDirs().accept( FSVisitor );
        assertEquals("a",FSVisitor.getFoundFiles().getFirst().getName());

    }

    @Test
    public void Check_b_InFileList(){

        FileSearchVisitor FSVisitor = new FileSearchVisitor("b");
        fs.getRootDirs().accept( FSVisitor );
        assertEquals("b",FSVisitor.getFoundFiles().getFirst().getName());

    }

    @Test
    public void Check_c_InFileList(){

        FileSearchVisitor FSVisitor = new FileSearchVisitor("c");
        fs.getRootDirs().accept( FSVisitor );
        assertEquals("c",FSVisitor.getFoundFiles().getFirst().getName());

    }

    @Test
    public void Check_d_InFileList(){

        FileSearchVisitor FSVisitor = new FileSearchVisitor("d");
        fs.getRootDirs().accept( FSVisitor );
        assertEquals("d",FSVisitor.getFoundFiles().getFirst().getName());

    }


}