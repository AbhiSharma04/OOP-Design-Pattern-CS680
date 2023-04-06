package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class FileSystem {

    private static edu.umb.cs680.hw07.FileSystem instance = null;
    private edu.umb.cs680.hw07.Directory rootDirectory;

    private FileSystem(){
    }
    public static edu.umb.cs680.hw07.FileSystem getFileSystem(){
        if(instance==null) {
            instance = new edu.umb.cs680.hw07.FileSystem();
        }
        return instance;
    }

    public edu.umb.cs680.hw07.Directory getRootDirs(){
        return rootDirectory;
    }
    public void appendRootDir(edu.umb.cs680.hw07.Directory root) {
        this.rootDirectory = root;
    }

    public static void main(String[] args) {

        edu.umb.cs680.hw07.Directory prjRoot = new edu.umb.cs680.hw07.Directory(null,"prjRoot",0, LocalDateTime.now());
        edu.umb.cs680.hw07.Directory src = new edu.umb.cs680.hw07.Directory(prjRoot,"src",0, LocalDateTime.now());
        edu.umb.cs680.hw07.Directory lib = new edu.umb.cs680.hw07.Directory(prjRoot,"lib",0, LocalDateTime.now());
        edu.umb.cs680.hw07.Directory test = new edu.umb.cs680.hw07.Directory(prjRoot,"test",0, LocalDateTime.now());
        edu.umb.cs680.hw07.File x = new edu.umb.cs680.hw07.File(prjRoot,"x",200,LocalDateTime.now());
        // we have initialized all directories and files whose parent is root element
        // we will create children of src directory
        edu.umb.cs680.hw07.File a = new edu.umb.cs680.hw07.File(src,"a",414,LocalDateTime.now());
        edu.umb.cs680.hw07.File b = new edu.umb.cs680.hw07.File(src,"b",30,LocalDateTime.now());

        // we will create children of lib directory
        edu.umb.cs680.hw07.File c = new edu.umb.cs680.hw07.File(lib,"c",500,LocalDateTime.now());

        // we will create children of test directory
        edu.umb.cs680.hw07.Directory srcT = new Directory(test,"src",0, LocalDateTime.now());
        edu.umb.cs680.hw07.File d = new File(srcT,"d",100,LocalDateTime.now());

        Link y= new Link(prjRoot,"y",100,LocalDateTime.now(),src);

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

        edu.umb.cs680.hw07.FileSystem file= new edu.umb.cs680.hw07.FileSystem();
        file.appendRootDir(prjRoot);
        System.out.println("Hello to File handling");


    }
}
