package edu.umb.cs681.nasa;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class ReadingCSV {

    List<String> fileNames = List.of("Boston.csv","Chicago.csv","Dallas.csv","Denver.csv","Jackson.csv","LasVegas.csv","Miami.csv","NewYork.csv","Toronto.csv","Washington.csv");

    public static void main(String[] args) {


        int i;

        ArrayList<Path> pathlist;

        pathlist = List(Paths.get("src/edu/umb/cs681/nasa/"+fileNames.get(0)));

        Stream<String> lines[10];

        try( lines[i] = Files.lines(path[i]) ){
            List<List<String>> matrix = lines.map(line -> {
                        return Stream.of( line.split(",") )
                                .map(value-> value)
                                .collect( Collectors.toList() ); })
                    .collect( Collectors.toList() );

            List<List<String>> massachusetts = matrix.stream().filter((i) -> i.get(4).contains("Massachusetts")).collect(Collectors.toList());
            String totalCases = matrix.stream().filter((i) -> i.get(4).contains("Massachusetts"))
                    .map((i) -> i.get(6)).reduce("0", (temp, result) -> String.valueOf(Integer.parseInt(temp) + Integer.parseInt(result)));

            List<String> suffolk = matrix.stream().filter((i) -> i.get(5).contains("Suffolk")).collect(Collectors.toList()).get(0);

            List<String> worcester = matrix.stream().filter((i) -> i.get(5).contains("Worcester")).collect(Collectors.toList()).get(0);

            System.out.println("Total number of cases in MA: " + totalCases);
            System.out.println("\nInfection rate in Suffolk County: " + suffolk.get(8));
            System.out.println("\nInfection rate in Worcester County: " + worcester.get(8));
            System.out.println("\nAverage Infection Rate in Suffolk & Worchester: " + (Float.parseFloat(suffolk.get(8)) + Float.parseFloat(worcester.get(8))) / 2);
        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}