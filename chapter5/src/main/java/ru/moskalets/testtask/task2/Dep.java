package ru.moskalets.testtask.task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * The class is a list view of the units.
 * author Igor Moskalets
 * Since 07.03.2018
 */
public class Dep {
    /**
     * Последовательная цепочка департаментов.
     */
    private ArrayList<String> deps = new ArrayList<String>();

    /**
     * Конструктор.
     * @param deps
     */
    public Dep(ArrayList<String> deps) {
        this.deps = deps;
    }

    /**
     * Возвращет this.deps.
     * @return
     */
    public ArrayList<String> getDeps() {
        return this.deps;
    }

    /**
     * Печатает this.deps.
     */
    public void print() {
        for (String line: this.deps) {
            System.out.print(line + "\\");
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Dep dep = (Dep) o;

        return deps != null ? deps.equals(dep.deps) : dep.deps == null;
    }

    @Override
    public int hashCode() {
        return deps != null ? deps.hashCode() : 0;
    }
}
