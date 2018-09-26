package ru.moskalets.chapter004.lambda.task001;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.List;

/**
 * Тесты для класса CountingFunctionDiapasonTest.
 */
public class CountingFunctionDiapasonTest {
    /**
     * Тест для линейной функции.
     */
    @Test
    public void testLineFunction() {
        CountingFunctionDiapason cfd = new CountingFunctionDiapason();
        List<Double> result = new ArrayList<Double>();
        result = cfd.diapason(1, 4, cfd.lineFunction);
        assertThat(result, is(Arrays.asList(3D, 5D, 7D)));
    }

    /**
     * Тест для квадратичной функции.
     */
    @Test
    public void testQuadraticFunction() {
        CountingFunctionDiapason cfd = new CountingFunctionDiapason();
        List<Double> result = new ArrayList<Double>();
        result = cfd.diapason(1, 4, cfd.quadraticFunction);
        assertThat(result, is(Arrays.asList(6D, 11D, 18D)));
    }

    /**
     * Тест для логарифмической функции.
     */
    @Test
    public void testLogarithmicFunction() {
        CountingFunctionDiapason cfd = new CountingFunctionDiapason();
        List<Double> result = new ArrayList<Double>();
        result = cfd.diapason(1, 4, cfd.logarithmicFunction);
        assertThat(result, is(Arrays.asList(0D, 0.6931471805599453D,  1.0986122886681098D)));
    }
}