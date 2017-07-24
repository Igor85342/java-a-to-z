package ru.moskalets.testTask.task2;
/**
 * The class is a list view of the units.
 * author Igor Moskalets
 * Since 23.07.2017
 */
public class Dep {
    private String[] deps;
    public Dep(String[] deps){
        this.deps = deps;
    }
    public int getLength(){
        return this.deps.length;
    }
    public String[] getDeps(){
        return this.deps;
    }
}
