package edu.umb.cs680.hw06;

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
    LinkedList<edu.umb.cs680.hw06.File> File_List = new LinkedList<edu.umb.cs680.hw06.File>();
    public void appendChild(FSElement child){

        FSELement_List.add(child);
        if(child  instanceof Directory ){
            Directory_List.add((Directory) child);
        }
        else if(child instanceof File){
           File_List.add((edu.umb.cs680.hw06.File) child);
        }
        else{
            throw new IllegalArgumentException("Child must be a directory or a file.");
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

    public LinkedList<edu.umb.cs680.hw06.File> getFiles(){
        return this.File_List;
    }
    public  int getTotalSize(){

            int  totalSizeOfFiles = 0;
            for (FSElement child : FSELement_List) {
                if (child instanceof edu.umb.cs680.hw06.File) {
                    totalSizeOfFiles =totalSizeOfFiles + ((File) child).getSize();

                } else if (child instanceof Directory) {
                    totalSizeOfFiles= totalSizeOfFiles+ ((Directory) child).getTotalSize();
                }
            }
            return totalSizeOfFiles;

    }
    @Override
    public boolean isDirectory() {
        return true;

    }

    public boolean isFile(){
        return false;
    }

}
