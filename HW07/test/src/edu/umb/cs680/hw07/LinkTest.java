package edu.umb.cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    private static FileSystem fs;
    @BeforeAll
    public static void setUpFS(){
        fs= TestFixtureInitializer.createFS();
    }

    LocalDateTime time=LocalDateTime.now();

    private String[] LinkToStringArray(edu.umb.cs680.hw07.Link link){
        String[] LinkInfo = {link.getParent().getName(),
                link.getName(), String.valueOf(link.getSize()),time.toString(),link.getTarget().getName()};
        return LinkInfo;
    }

    @Test
    public void EqualityCheckWithLink(){
        String[] expected={"prjRoot","y","0",time.toString(),"src"};
        Link link= fs.getRootDirs().getLinks().get(0);
        assertArrayEquals(expected,LinkToStringArray(link));
    }


    @Test
    public void CheckParentOfLinkY(){
        setUpFS();
        assertEquals("prjRoot",fs.getRootDirs().getLinks().getFirst().getParent().getName());
    }

    @Test
    public void CheckTargetOfLinkY(){
        setUpFS();
        assertEquals("src",fs.getRootDirs().getLinks().getFirst().getTarget().getName());
    }

    @Test
    public void LinkIsNotDirectory(){
        setUpFS();
        assertFalse(fs.getRootDirs().getLinks().getFirst().isDirectory());
    }

    @Test
    public void LinkHasZeroSize(){
        setUpFS();
        assertEquals(0,fs.getRootDirs().getLinks().getFirst().getSize());
    }

    @Test
    public void CheckLink(){
        setUpFS();
        assertTrue(fs.getRootDirs().getLinks().getFirst().isLink());
    }

    @Test
    public void AppendLinkTest(){

        Directory testRoot = new Directory(null,"testRoot",0, LocalDateTime.now());
        Directory testTarget = new Directory(testRoot,"testTarget",0, LocalDateTime.now());
        Link testlink= new Link(testRoot,"testLink",0, LocalDateTime.now(),testTarget);
        FileSystem f= FileSystem.getFileSystem();
        f.appendRootDir(testRoot);
        testRoot.appendChild(testTarget);
        testRoot.appendChild(testlink);
        assertEquals("testLink",f.getRootDirs().getLinks().getFirst().getName());

    }

}