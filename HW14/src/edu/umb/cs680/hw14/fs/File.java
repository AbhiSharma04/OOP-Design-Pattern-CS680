package edu.umb.cs680.hw14.fs;

import edu.umb.cs680.hw14.fs.Directory;


import java.time.LocalDateTime;

public class File extends FSElement {
    public File(Directory ParentDir, String name, int size, LocalDateTime creationTime) {
        super(ParentDir, name, size, creationTime);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    boolean isLink() {
        return false;
    }


}
