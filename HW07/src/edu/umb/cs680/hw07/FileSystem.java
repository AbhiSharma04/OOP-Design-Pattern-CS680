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
        System.out.println("Hello to File System");


    }
}
