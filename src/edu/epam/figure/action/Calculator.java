package edu.epam.figure.action;

import edu.epam.figure.entity.Point;
import edu.epam.figure.entity.RegularTetrahedron;
import edu.epam.figure.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Calculator {
    private static Logger logger = LogManager.getLogger();

    public double calculateSquare(Tetrahedron tetr) {
        if (tetr instanceof RegularTetrahedron) {
            RegularTetrahedron regularTetrahedron = (RegularTetrahedron) tetr;
            return pow(3.0, 0.5) * Math.sqrt(regularTetrahedron.getLength());
        }
        double length1 = calculateLength(tetr.getA(), tetr.getB());
        double length2 = calculateLength(tetr.getB(), tetr.getC());
        double length3 = calculateLength(tetr.getA(), tetr.getC());
        double length4 = calculateLength(tetr.getA(), tetr.getD());
        double length5 = calculateLength(tetr.getB(), tetr.getD());
        double length6 = calculateLength(tetr.getC(), tetr.getD());

        double square1 = calculateSideSquare(length1, length2, length3);
        double square2 = calculateSideSquare(length1, length4, length5);
        double square3 = calculateSideSquare(length2, length5, length6);
        double square4 = calculateSideSquare(length3, length4, length6);

        return (square1 + square2 + square3 + square4);
    }

    public double calculateVolume(Tetrahedron tetr) {
        if (tetr instanceof RegularTetrahedron) {
            RegularTetrahedron regularTetrahedron = (RegularTetrahedron) tetr;
            return (pow(2.0, 0.5) * pow(regularTetrahedron.getLength(), 3.0)) / 12;
        }

        double[][] array = {{1, tetr.getA().getX(), tetr.getA().getY(), tetr.getA().getZ()},
                {1, tetr.getB().getX(), tetr.getB().getY(), tetr.getB().getZ()},
                {1, tetr.getC().getX(), tetr.getC().getY(), tetr.getC().getZ()},
                {1, tetr.getD().getX(), tetr.getD().getY(), tetr.getD().getZ()}};
        return (1 / 6.0) * determinate(array);
    }

    public boolean isOnePlane(Point a, Point b, Point c, Point d) {
        Point[][] array = {{a, b, c, d}, {a, c, b, d}, {a, d, b, c}};
        int i = 0;
        while (i < array.length){
            double[] vec1 = {array[i][1].getX() - array[i][0].getX(),
                    array[i][1].getY() - array[i][0].getY(),
                    array[i][1].getZ() - array[i][0].getZ()};
            double[] vec2 = {array[i][3].getX() - array[i][2].getX(),
                    array[i][3].getY() - array[i][2].getY(),
                    array[i][3].getZ() - array[i][2].getZ()};
            double[] vec3 = {array[i][2].getX() - array[i][1].getX(),
                    array[i][2].getY() - array[i][1].getY(),
                    array[i][2].getZ() - array[i][1].getZ()};
            double[][] vectors = {{vec1[0],vec2[0],vec3[0]},
                                  {vec1[1],vec2[1],vec3[1]},
                                  {vec1[2],vec2[2],vec3[2]}};
            if(determinate(vectors) == 0){
                return true;
            }
            i++;
        }
        return false;
    }

    //check collinear
//    public boolean isOneLine(Point a, Point b, Point c){
//
//    }


    private double calculateSideSquare(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return pow(p * (p - a) * (p - b) * (p - c), 0.5);
    }

    private double calculateLength(Point a, Point b) {
        double sum = Math.sqrt(abs(a.getX() - b.getX())) + Math.sqrt(abs(a.getY() - b.getY())) +
                Math.sqrt(abs(a.getZ() - b.getZ()));
        return pow(sum, 0.5);
    }

    //вычисление определителя
    private double determinate(double[][] array) {
        for (int k = 0; k < array.length - 1; k++) {
            for (int i = k + 1; i < array.length; i++) {
                if (array[k][k] == 0) {
                    int l = k;
                    while (array[k][k] == 0) {
                        if(l == array.length){
                            return 0;
                        }
                        for (int j = k; j < array.length; j++) {
                            double g = array[j][k];
                            array[j][k] = array[j][l];
                            array[j][l] = g;
                        }
                        l++;
                    }
                }
                double t = array[i][k] / array[k][k];
                for (int j = k; j < array.length; j++) {
                    array[i][j] -= (array[k][j] * t);
                }
            }
        }

        double result = 1.0;
        for (int i = 0; i < array.length; i++) {
            result *= array[i][i];
        }
        return result;
    }
}
