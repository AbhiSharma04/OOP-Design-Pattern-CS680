package edu.umb.cs680.hw07;

import edu.umb.cs680.hw07.Directory;

import java.time.LocalDateTime;

abstract class FSElement {
    protected String name ;
    protected edu.umb.cs680.hw07.Directory ParentDir;
    protected int size;
    protected LocalDateTime creationTime;

    public FSElement(edu.umb.cs680.hw07.Directory ParentDir, String name , int size, LocalDateTime creationTime){
        this.ParentDir= ParentDir;
        this.name= name ;
        this.size= size;
        this.creationTime=creationTime;
    }
    public Directory getParent(){
        return this.ParentDir;

    }
    public int getSize(){
        return this.size;
    }

    public String getName(){
        return this.name;
    }
    abstract boolean isDirectory();

    abstract boolean isLink();
}
