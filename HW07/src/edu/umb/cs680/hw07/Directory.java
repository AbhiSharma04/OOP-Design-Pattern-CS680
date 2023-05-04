package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends edu.umb.cs680.hw07.FSElement {
    edu.umb.cs680.hw07.Directory ParentDir;
    LinkedList<edu.umb.cs680.hw07.FSElement> FSELement_List = new LinkedList<edu.umb.cs680.hw07.FSElement>();


    public Directory(edu.umb.cs680.hw07.Directory ParentDir, String name, int size, LocalDateTime creationTime) {
        super(ParentDir, name, size, creationTime);
        this.ParentDir=ParentDir;
    }
    public String getName(){
        return this.name;
    }

    public LinkedList<edu.umb.cs680.hw07.FSElement> getChildren(){
        return this.FSELement_List;
    }
    LinkedList<edu.umb.cs680.hw07.Directory> Directory_List = new LinkedList<edu.umb.cs680.hw07.Directory>();
    LinkedList<edu.umb.cs680.hw07.File> File_List = new LinkedList<edu.umb.cs680.hw07.File>();
    LinkedList<Link> Link_list = new LinkedList<Link>();

    public void appendChild(edu.umb.cs680.hw07.FSElement child){

        FSELement_List.add(child);
        if(child instanceof Directory){
            Directory_List.add((edu.umb.cs680.hw07.Directory) child);
        }
        else if(child instanceof Link){
           Link_list.add((Link) child);
        }
        else if(child instanceof File){
            File_List.add((edu.umb.cs680.hw07.File) child);
        }

    }
    public int countChildren(){
        return FSELement_List.size();
    }
    public LinkedList<edu.umb.cs680.hw07.Directory> getSubDirectories(){

        return this.Directory_List;
    }
    public edu.umb.cs680.hw07.Directory getParent(){
        return this.ParentDir;
    }

    public LinkedList<edu.umb.cs680.hw07.File> getFiles(){
        return this.File_List;
    }

    public LinkedList<Link> getLinks(){
        return this.Link_list;
    }

    public  int getTotalSize(){

            int  totalSize = 0;
            for (edu.umb.cs680.hw07.FSElement child : FSELement_List) {
                if (child instanceof edu.umb.cs680.hw07.File) {
                    totalSize += ((File) child).getSize();

                } else if (child instanceof edu.umb.cs680.hw07.Directory) {
                    totalSize += ((edu.umb.cs680.hw07.Directory) child).getTotalSize();
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

}
