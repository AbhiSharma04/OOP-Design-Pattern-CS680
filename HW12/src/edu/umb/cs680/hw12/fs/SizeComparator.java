package edu.umb.cs680.hw12.fs;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement fs1, FSElement fs2) {
        return fs1.getSize()-fs2.getSize();
    }
}
