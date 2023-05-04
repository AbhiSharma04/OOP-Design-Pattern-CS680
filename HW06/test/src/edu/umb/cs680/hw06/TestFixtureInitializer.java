package edu.umb.cs680.hw06;

import edu.umb.cs680.hw06.Directory;
import edu.umb.cs680.hw06.File;
import edu.umb.cs680.hw06.FileSystem;

import java.time.LocalDateTime;

public class TestFixtureInitializer {

    public static edu.umb.cs680.hw06.FileSystem createFS(){
        edu.umb.cs680.hw06.Directory prjRoot = new edu.umb.cs680.hw06.Directory(null,"prjRoot",0, LocalDateTime.now());
        edu.umb.cs680.hw06.Directory src = new edu.umb.cs680.hw06.Directory(prjRoot,"src",0, LocalDateTime.now());
        edu.umb.cs680.hw06.Directory lib = new edu.umb.cs680.hw06.Directory(prjRoot,"lib",0, LocalDateTime.now());
        edu.umb.cs680.hw06.Directory test = new edu.umb.cs680.hw06.Directory(prjRoot,"test",0, LocalDateTime.now());
        edu.umb.cs680.hw06.File x = new edu.umb.cs680.hw06.File(prjRoot,"x",200,LocalDateTime.now());
        // we have initialized all directories and files whose parent is root element
        // we will create children of src directory
        edu.umb.cs680.hw06.File a = new edu.umb.cs680.hw06.File(src,"a",414,LocalDateTime.now());
        edu.umb.cs680.hw06.File b = new edu.umb.cs680.hw06.File(src,"b",30,LocalDateTime.now());

        // we will create children of lib directory
        edu.umb.cs680.hw06.File c = new edu.umb.cs680.hw06.File(lib,"c",500,LocalDateTime.now());

        // we will create children of test directory
        edu.umb.cs680.hw06.Directory srcT = new Directory(test,"src",0, LocalDateTime.now());
        edu.umb.cs680.hw06.File d = new File(srcT,"d",100,LocalDateTime.now());

        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        prjRoot.appendChild(x);

        src.appendChild(a);
        src.appendChild(b);

        lib.appendChild(c);

        test.appendChild(srcT);
        srcT.appendChild(d);

        edu.umb.cs680.hw06.FileSystem fs= FileSystem.getFileSystem();
        fs.appendRootDir(prjRoot);

        return fs;

    }
}
