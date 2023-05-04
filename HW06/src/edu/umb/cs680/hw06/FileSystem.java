package edu.umb.cs680.hw06;

import java.time.LocalDateTime;

public class FileSystem {

    private static FileSystem instance = null;
    private edu.umb.cs680.hw06.Directory rootDirectory;

    private FileSystem(){
    }
    public static FileSystem getFileSystem(){
        if(instance==null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public edu.umb.cs680.hw06.Directory getRootDirs(){
        return rootDirectory;
    }
    public void appendRootDir(edu.umb.cs680.hw06.Directory root) {
        this.rootDirectory = root;
    }

    public static void main(String[] args) {
        System.out.println("Hello to File System");
    }
}
