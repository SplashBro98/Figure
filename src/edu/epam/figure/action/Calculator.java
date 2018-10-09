package edu.epam.figure.action;

import edu.epam.figure.entity.Point;
import edu.epam.figure.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.lang.Math.*;

public class Calculator{
    private static Logger logger = LogManager.getLogger();

    public double calculateSquare(Tetrahedron tetr) {
        double lengthAtoB = calculateLength(tetr.getA(), tetr.getB());
        double lengthBtoC = calculateLength(tetr.getB(), tetr.getC());
        double lengthAtoC = calculateLength(tetr.getA(), tetr.getC());
        double lengthAtoD = calculateLength(tetr.getA(), tetr.getD());
        double lengthBtoD = calculateLength(tetr.getB(), tetr.getD());
        double lengthCtoD = calculateLength(tetr.getC(), tetr.getD());

        double squareABC = calculateSideSquare(lengthAtoB, lengthBtoC, lengthAtoC);
        double squareABD = calculateSideSquare(lengthAtoB, lengthAtoD, lengthBtoD);
        double squareBCD = calculateSideSquare(lengthBtoC, lengthBtoD, lengthCtoD);
        double squareACD = calculateSideSquare(lengthAtoC, lengthAtoD, lengthCtoD);

        return (squareABC + squareABD + squareBCD + squareACD);
    }

    public double calculateVolume(Tetrahedron tetr) {
        double[][] array = {{1, tetr.getA().getX(), tetr.getA().getY(), tetr.getA().getZ()},
                {1, tetr.getB().getX(), tetr.getB().getY(), tetr.getB().getZ()},
                {1, tetr.getC().getX(), tetr.getC().getY(), tetr.getC().getZ()},
                {1, tetr.getD().getX(), tetr.getD().getY(), tetr.getD().getZ()}};
        return (1 / 6.0) * determinate(array);
    }

    public double calculatePerimetr(Tetrahedron tetr){
        Point[][] array = {{tetr.getA(),tetr.getB()},{tetr.getA(),tetr.getC()},{tetr.getA(),tetr.getD()},
                {tetr.getB(),tetr.getC()},{tetr.getB(),tetr.getD()},{tetr.getC(),tetr.getD()}};
        double sum = 0.0;
        for (int i = 0; i < array.length; i++) {
            sum += calculateLength(array[i][0],array[i][1]);
        }
        return sum;
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




    private double calculateSideSquare(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return pow(p * (p - a) * (p - b) * (p - c), 0.5);
    }

    private double calculateLength(Point a, Point b) {
        double sum = sqrt(abs(a.getX() - b.getX())) + sqrt(abs(a.getY() - b.getY())) +
                sqrt(abs(a.getZ() - b.getZ()));
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
