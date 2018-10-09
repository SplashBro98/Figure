package edu.epam.figure.register;

import edu.epam.figure.action.Calculator;
import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.observer.Observer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class TetraRegister implements Observer<Tetrahedron> {
    private static Logger logger = LogManager.getLogger();
    private static TetraRegister instance;
    private Map<Long,Parametr> parametrs;

    private TetraRegister() {
       parametrs = new TreeMap<>();
    }

    public static TetraRegister getInstance(){
        if(instance == null){
            instance = new TetraRegister();
        }
        return instance;
    }
    public boolean addTetrahedron(Tetrahedron tetr){
        if(parametrs.containsKey(tetr.getTetraId())){
            logger.log(Level.ERROR,"This tetrahedron is already in register");
            return false;
        }
        Calculator calculator = new Calculator();
        double volume = calculator.calculateVolume(tetr);
        double square = calculator.calculateSquare(tetr);
        double perimetr = calculator.calculatePerimetr(tetr);
        Parametr parametr = new Parametr(volume,square,perimetr);
        parametrs.put(tetr.getTetraId(),parametr);
        return true;
    }

    public Map<Long, Parametr> getParametrs() {
        return Collections.unmodifiableMap(parametrs);
    }

    @Override
    public void handleEvent(Tetrahedron tetrahedron) {
        Calculator calculator = new Calculator();
        double volume = calculator.calculateVolume(tetrahedron);
        double square = calculator.calculateSquare(tetrahedron);
        double perimetr = calculator.calculatePerimetr(tetrahedron);
        Parametr parametr = new Parametr(volume,square,perimetr);
        parametrs.replace(tetrahedron.getTetraId(),parametr);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("TetraRegister: \n");
        parametrs.forEach((Long aLong, Parametr parametr) ->  builder.append("Id: " + aLong +
                    ", volume: " + parametr.getVolume() +
                    ", square: " + parametr.getSquare() +
                    ", perimetr: " + parametr.getPerimetr() + "\n"));
        return builder.toString();
    }
}
