package edu.umb.cs680.hw06;

import java.time.LocalDateTime;

public class File extends FSElement {

    public File(Directory ParentDir, String name, int size, LocalDateTime creationTime) {
        super(ParentDir, name, size, creationTime);
    }
    public String getName(){
        return this.name;
    }

    public boolean isFile(){
        return true;
    }


    @Override
    boolean isDirectory() {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to file class");
    }
}
