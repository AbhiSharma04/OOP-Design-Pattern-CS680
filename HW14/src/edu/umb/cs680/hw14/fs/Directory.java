package edu.umb.cs680.hw14.fs;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
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

        Collections.sort(this.FSELement_List,(FSElement f1,FSElement f2)-> f1.getName().compareTo(f2.getName()));
        return this.FSELement_List;
    }
    LinkedList<Directory> Directory_List = new LinkedList<>();
    LinkedList<File> File_List = new LinkedList<>();
    LinkedList<Link> Link_list = new LinkedList<>();

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

        Collections.sort(FSELement_List,(FSElement f1,FSElement f2)-> f1.getName().compareTo(f2.getName()));

        //System.out.println(FSELement_List);

    }
    public int countChildren(){
        return FSELement_List.size();
    }
    public LinkedList<Directory> getSubDirectories(){
        Collections.sort(this.Directory_List,(FSElement f1,FSElement f2)-> f1.getName().compareTo(f2.getName()));
        return this.Directory_List;
    }
    public Directory getParent(){
        return this.ParentDir;
    }

    public LinkedList<File> getFiles(){
        Collections.sort(this.File_List,(FSElement f1,FSElement f2)-> f1.getName().compareTo(f2.getName()));
        return this.File_List;
    }

    public LinkedList<Link> getLinks(Comparator <FSElement> comparator){
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

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator){

        Collections.sort(this.FSELement_List,comparator);
        return this.FSELement_List;
    }

    public LinkedList<Directory> getSubDirectories(Comparator <FSElement> comparator){
        Collections.sort(this.Directory_List,comparator);

        return this.Directory_List;
    }
    public LinkedList<File> getFiles(Comparator <FSElement> comparator){
        Collections.sort(this.File_List,comparator);
        return this.File_List;
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
