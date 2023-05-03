package edu.umb.cs680.hw08.fs.util;


import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.FileSystem;
import edu.umb.cs680.hw08.fs.Link;

import java.time.LocalDateTime;

public class TestFixtureInitializer {
    public static FileSystem createFS(){
        //root element initialized
        Directory prjRoot = new Directory(null,"prjRoot",0, LocalDateTime.now());
        Directory src = new Directory(prjRoot,"src",0, LocalDateTime.now());
        Directory lib = new Directory(prjRoot,"lib",0, LocalDateTime.now());
        Directory test = new Directory(prjRoot,"test",0, LocalDateTime.now());
        File x = new File(prjRoot,"x",200,LocalDateTime.now());
        Link y= new Link(prjRoot,"y",0,LocalDateTime.now(),src);
        // we have initialized all directories and files whose parent is root element
        // we will create children of src directory
        File a = new File(src,"a",414,LocalDateTime.now());
        File b = new File(src,"b",30,LocalDateTime.now());

        // we will create children of lib directory
        File c = new File(lib,"c",500,LocalDateTime.now());

        // we will create children of test directory
        Directory srcT = new Directory(test,"src",0, LocalDateTime.now());
        File d = new File(srcT,"d",100,LocalDateTime.now());

        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        prjRoot.appendChild(x);
        prjRoot.appendChild(y);

        src.appendChild(a);
        src.appendChild(b);

        lib.appendChild(c);

        test.appendChild(srcT);
        srcT.appendChild(d);

        FileSystem fs= FileSystem.getFileSystem();
        fs.appendRootDir(prjRoot);


        FileSearchVisitor visitor = new FileSearchVisitor("a"); prjRoot.accept( visitor );
        visitor.getFoundFiles().size();
//        System.out.println("File found is " + visitor.getFoundFiles().size());
//        System.out.println("File size is " + visitor.getFoundFiles().getFirst().getSize());


        CountingVisitor countVisitor= new CountingVisitor();
        prjRoot.accept(countVisitor);
//        System.out.println("Number of files are : " + countVisitor.getFileNum());
//        System.out.println("Number of Directories are : " + countVisitor.getDirNum());
//        System.out.println("Number of Links are : " + countVisitor.getLinkNum());

        FileCrawlingVisitor FCVisitor = new FileCrawlingVisitor();
        prjRoot.accept(FCVisitor);
//        System.out.println(FCVisitor.getFiles().size());


        return fs;

    }
}