package edu.epam.figure.transformer;

import edu.epam.figure.entity.Point;


public class PointTransformer {
    private static final int COORD_COUNT = 12;
    private static final String REGEX_DELIMETR = "\\s";

    public Point[] createPoints(String input){
        String[] array = input.split(REGEX_DELIMETR);
        double[] coords = new double[COORD_COUNT];
        for (int i = 0; i < array.length; i++) {
            coords[i] = Double.parseDouble(array[i]);
        }
        Point[] result = {new Point(coords[0],coords[1],coords[2]),
                          new Point(coords[3],coords[4],coords[5]),
                          new Point(coords[6],coords[7],coords[8]),
                          new Point(coords[9],coords[10],coords[11])};
        return result;

    }
}
