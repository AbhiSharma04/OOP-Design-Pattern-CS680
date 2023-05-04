package edu.umb.cs680.hw12.fs;


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
        System.out.println("Welcome to File System");
    }
}


