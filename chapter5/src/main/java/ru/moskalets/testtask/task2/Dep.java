package ru.moskalets.testtask.task2;
/**
 * The class is a list view of the units.
 * author Igor Moskalets
 * Since 23.07.2017
 */
public class Dep {
    /**
     * The units.
     */
    private String[] deps;
    /**
     * @param deps Units.
     */
    public Dep(String[] deps) {
        this.deps = deps;
    }
    /**
     * This metod return Length deps.
     * @return int.
     */
    public int getLength() {
        return this.deps.length;
    }
    /**
     * This metod return deps.
     * @return String[].
     */
    public String[] getDeps() {
        return this.deps;
    }
}
