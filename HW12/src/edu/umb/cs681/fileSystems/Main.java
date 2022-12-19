package edu.umb.cs681.fileSystems;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args){

        Directory root=new Directory(null,"Root",0,LocalDateTime.now() );

        Directory desktop=new Directory(root,"Desktop",0,LocalDateTime.now() );
        Directory projects=new Directory(desktop,"MSCSProjects",0,LocalDateTime.now() );
        Directory fall=new Directory(projects,"CS681",0,LocalDateTime.now() );
        Directory spring=new Directory(projects,"CS680",0,LocalDateTime.now() );
        File file1=new File(fall,"hw1",1,LocalDateTime.now() );
        File file2=new File(fall,"hw2",2,LocalDateTime.now() );
        File file3=new File(fall,"hw3",3,LocalDateTime.now() );
        File file4=new File(spring,"hw1",4,LocalDateTime.now() );
        File file5=new File(spring,"hw2",5,LocalDateTime.now() );
        File file6=new File(spring,"hw3",6,LocalDateTime.now() );
        File file7=new File(projects,"MLFile",1020,LocalDateTime.now() );

        System.out.println("The Size of the directory Root: " + root.getTotalSize());
        System.out.println("The Size of the directory Desktop: " + desktop.getTotalSize());
        System.out.println("The Size of the directory Projects: " + projects.getTotalSize());
        System.out.println("The Size of the directory Spring: " + spring.getTotalSize());
        System.out.println("The Size of the directory Fall: " + fall.getTotalSize());


    }
}