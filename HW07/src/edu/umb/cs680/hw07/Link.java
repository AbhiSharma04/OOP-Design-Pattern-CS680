package edu.umb.cs680.hw07;

import edu.umb.cs680.hw07.Directory;

import java.time.LocalDateTime;

public class Link extends edu.umb.cs680.hw07.FSElement {

    private edu.umb.cs680.hw07.FSElement target;

    public Link(Directory ParentDir, String name, int size, LocalDateTime creationTime, edu.umb.cs680.hw07.FSElement target){
        super(ParentDir,name,size,creationTime);
        this.target=target;

    }
    public boolean isLink() {
        return true;
    }

    public edu.umb.cs680.hw07.FSElement getTarget(){
        return this.target;
    }

    @Override
    boolean isDirectory() {
        return false;
    }

    public boolean isFile(){
        return false;
    }
}
