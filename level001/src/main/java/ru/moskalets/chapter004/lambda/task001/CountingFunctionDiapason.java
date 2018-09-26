package ru.moskalets.chapter004.lambda.task001;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Класс реализует подсчет функций в диапазоне.
 */
public class CountingFunctionDiapason {
    /**
     * Считает функцию переданную в параметре.
     * @param start
     * @param end
     * @param func
     * @return
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<Double>();
        for (int i = start; i < end; i++) {
            result.add(func.apply((double) i));
        }
        return result;
    }

    /**
     * Линейная функция.
     */
    Function<Double, Double> lineFunction = x -> 2 * x + 1;
    /**
     * Квадратичная функция.
     */
    Function<Double, Double> quadraticFunction = x -> Math.pow(x, 2) + 2 * x + 3;
    /**
     * Логарфмическая функция.
     */
    Function<Double, Double> logarithmicFunction = x -> Math.log(x);

}