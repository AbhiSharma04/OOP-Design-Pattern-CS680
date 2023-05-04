package edu.umb.cs680.hw12.fs;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement fs1, FSElement fs2) {
        return fs2.getName().compareTo(fs1.getName());
    }
}
