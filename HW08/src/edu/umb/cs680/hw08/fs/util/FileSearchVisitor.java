package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.FSVisitor;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.Link;

import java.util.LinkedList;

public class FileSearchVisitor implements FSVisitor {

    public String fileName;
    LinkedList<File> foundFiles= new LinkedList<File>();

    public FileSearchVisitor(String fName){
        fileName=fName;
    }


    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory directory) {
        return;

    }

    @Override
    public void visit(File file) {
        if(file.getName().equals(fileName)){
            foundFiles.add(file); }
    }

    public LinkedList<File> getFoundFiles(){
        return foundFiles;
    }
}
