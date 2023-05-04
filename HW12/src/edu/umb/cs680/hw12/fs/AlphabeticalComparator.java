package edu.umb.cs680.hw12.fs;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement>{
    @Override
    public int compare(FSElement fs1, FSElement fs2) {
        return fs1.getName().compareTo(fs2.getName());
    }
}
