package edu.umb.cs680.hw08.fs;

public interface FSVisitor {
    public void visit(Link link);
    public void visit(Directory directory);
    public void visit(File file);
}
