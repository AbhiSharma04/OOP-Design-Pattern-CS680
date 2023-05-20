package edu.umb.cs680.hw16.Part2;

public interface Observer<T> {
    public void update(Observable<T> sender, T event);
}
