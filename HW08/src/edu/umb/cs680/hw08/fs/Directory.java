package edu.umb.cs680.hw08.fs;

import edu.umb.cs680.hw08.fs.util.FileSearchVisitor;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
    Directory ParentDir;
    LinkedList<FSElement> FSELement_List = new LinkedList<FSElement>();


    public Directory(Directory ParentDir, String name, int size, LocalDateTime creationTime) {
        super(ParentDir, name, size, creationTime);
        this.ParentDir=ParentDir;
    }
    public String getName(){
        return this.name;
    }

    public LinkedList<FSElement> getChildren(){
        return this.FSELement_List;
    }
    LinkedList<Directory> Directory_List = new LinkedList<Directory>();
    LinkedList<File> File_List = new LinkedList<File>();
    LinkedList<Link> Link_list = new LinkedList<Link>();

    public void appendChild(FSElement child){

        FSELement_List.add(child);
        if(child instanceof Directory){
            Directory_List.add((Directory) child);
        }
        else if(child instanceof Link){
            Link_list.add((Link) child);
        }
        else if(child instanceof File){
            File_List.add((File) child);
        }

    }
    public int countChildren(){
        return FSELement_List.size();
    }
    public LinkedList<Directory> getSubDirectories(){

        return this.Directory_List;
    }
    public Directory getParent(){
        return this.ParentDir;
    }

    public LinkedList<File> getFiles(){
        return this.File_List;
    }

    public LinkedList<Link> getLinks(){
        return this.Link_list;
    }

    public  int getTotalSize(){

        int  totalSize = 0;
        for (FSElement child : FSELement_List) {
            if (child instanceof File) {
                totalSize += ((File) child).getSize();

            } else if (child instanceof Directory) {
                totalSize += ((Directory) child).getTotalSize();
            }
        }
        return totalSize;

    }
    @Override
    public boolean isDirectory() {
        return true;

    }

    @Override
    boolean isLink() {
        return false;
    }

    @Override
    public void accept(FSVisitor v) {
        super.accept(v);
        v.visit(this);
        for(FSElement e: FSELement_List){
            e.accept(v); }
    }

}
