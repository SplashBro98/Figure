package edu.epam.figure.util;

import edu.epam.figure.entity.Tetrahedron;

public class IdGenerator {
    private static final long MAX_TETRA_ID = 100000;
    private static final long MAX_POINT_ID = 100000;
    private static long tetraCounter = 1;
    private static long pointCounter = 1;

    public static long getTetraId(){
        return tetraCounter++;
    }
    public static long getPointId(){
        return pointCounter++;
    }

    private IdGenerator() {
    }
}
