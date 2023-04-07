package edu.umb.cs680.hw08.fs;


import edu.umb.cs680.hw08.fs.util.CountingVisitor;
import edu.umb.cs680.hw08.fs.util.FileCrawlingVisitor;
import edu.umb.cs680.hw08.fs.util.FileSearchVisitor;

import java.time.LocalDateTime;

public class FileSystem  {
    private static FileSystem instance = null;
    private Directory rootDirectory;

    private FileSystem() {
    }

    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public Directory getRootDirs() {
        return rootDirectory;
    }

    public void appendRootDir(Directory root) {
        this.rootDirectory = root;
    }

    public static void main(String[] args) {

        Directory prjRoot = new Directory(null, "prjRoot", 0, LocalDateTime.now());
        Directory src = new Directory(prjRoot, "src", 0, LocalDateTime.now());
        Directory lib = new Directory(prjRoot, "lib", 0, LocalDateTime.now());
        Directory test = new Directory(prjRoot, "test", 0, LocalDateTime.now());
        edu.umb.cs680.hw08.fs.File x = new edu.umb.cs680.hw08.fs.File(prjRoot, "x", 200, LocalDateTime.now());
        // we have initialized all directories and files whose parent is root element
        // we will create children of src directory
        edu.umb.cs680.hw08.fs.File a = new edu.umb.cs680.hw08.fs.File(src, "a", 414, LocalDateTime.now());
        edu.umb.cs680.hw08.fs.File b = new edu.umb.cs680.hw08.fs.File(src, "b", 30, LocalDateTime.now());

        // we will create children of lib directory
        edu.umb.cs680.hw08.fs.File c = new edu.umb.cs680.hw08.fs.File(lib, "c", 500, LocalDateTime.now());

        // we will create children of test directory
        edu.umb.cs680.hw08.fs.Directory srcT = new edu.umb.cs680.hw08.fs.Directory(test, "src", 0, LocalDateTime.now());
        edu.umb.cs680.hw08.fs.File d = new edu.umb.cs680.hw08.fs.File(srcT, "d", 100, LocalDateTime.now());
        edu.umb.cs680.hw08.fs.Link y= new Link(prjRoot,"y",0,LocalDateTime.now(),src);

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

        edu.umb.cs680.hw08.fs.FileSystem file = new edu.umb.cs680.hw08.fs.FileSystem();
        file.appendRootDir(prjRoot);
        FileSearchVisitor visitor = new FileSearchVisitor("a"); prjRoot.accept( visitor );
        visitor.getFoundFiles().size();
        System.out.println("File found is " + visitor.getFoundFiles().size());
        System.out.println("File size is " + visitor.getFoundFiles().getFirst().getSize());


        CountingVisitor countVisitor= new CountingVisitor();
        prjRoot.accept(countVisitor);
        System.out.println("Number of files are : " + countVisitor.getFileNum());
        System.out.println("Number of Directories are : " + countVisitor.getDirNum());
        System.out.println("Number of Links are : " + countVisitor.getLinkNum());

        FileCrawlingVisitor FCVisitor = new FileCrawlingVisitor();
        prjRoot.accept(FCVisitor);
        System.out.println(FCVisitor.getFiles().size());
    }
}


