package ru.moskalets.testtask.task2;
import java.util.*;

/**
 * Sorts the elements in ascending or descending order.
 * author Igor Moskalets
 * Since 07.03.2018
 */
public class ReferenceUnits {
    /**
     * Хранилище департаментов.
     */
    private Set<Dep> deps = new HashSet<Dep>();
    /**
     * The default constructor.
     */
    public ReferenceUnits() {
    }

    /**
     * Парсит строку в ArrayList, создает объекты Dep с параметром в конструкторе ArrayList и добавляет их в хранилище
     *  deps.
     * @param array
     */
    public void parcing(String[] array) {
        HashSet<String> newSet = new HashSet<String>(Arrays.asList(array));
        HashSet<String> tempSet = new HashSet<>();
        for (String line: array) {
            this.deps.add(new Dep(new ArrayList<>(Arrays.asList(line.split("\\\\")))));
        }
        addingMissingDepartments(this.deps);
    }

    /**
     * Распечатавыет Set.
     * @param set
     */
    public void print(Set<Dep> set) {
        for (Dep dep: set) {
          dep.print();
        }
        System.out.println();
    }

    /**
     * Возвращает deps.
     * @return
     */
    public Set<Dep> getDeps() {
        return this.deps;
    }

    /**
     * Сортировка по возврастанию.
     */
    public Set<Dep> sortAscending(Set<Dep> set) {
        TreeSet<Dep> ascendingTree = new TreeSet<>(new Comparator<Dep>() {
            public int compare(Dep o1, Dep o2) {
                int result = 1;
                boolean flag = false;
                if (o1.getDeps().size() >= o2.getDeps().size()) {
                    for (int i = 0; i < o2.getDeps().size(); i++) {
                        if (o1.getDeps().get(i).compareTo(o2.getDeps().get(i)) != 0) {
                            result = o1.getDeps().get(i).compareTo(o2.getDeps().get(i));
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        result = 1;
                    }
                } else {
                    for (int i = 0; i < o1.getDeps().size(); i++) {
                        if (o1.getDeps().get(i).compareTo(o2.getDeps().get(i)) != 0) {
                            result = o1.getDeps().get(i).compareTo(o2.getDeps().get(i));
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        result = -1;
                    }
                }
                return result;
            }
        });
        ascendingTree.addAll(set);
       return ascendingTree;
    }

    /**
     * Сортировка по убыванию, при которой сохраняется иерархическая структура.
     * Например:
     * k2\
     * k2\sk1\
     * k2\sk1\ssk2\
     * k2\sk1\ssk1\
     * k1\
     * k1\sk2\
     * k1\sk1\
     * k1\sk1\ssk2\
     * k1\sk1\ssk1\
     */
    public Set<Dep> sortDescending(Set<Dep> set) {
        TreeSet<Dep> descendingTree = new TreeSet<>(new Comparator<Dep>() {
            public int compare(Dep o1, Dep o2) {
                int result = -1;
                boolean flag = false;
                if (o1.getDeps().size() >= o2.getDeps().size()) {
                    for (int i = 0; i < o2.getDeps().size(); i++) {
                        if (o1.getDeps().get(i).compareTo(o2.getDeps().get(i)) != 0) {
                            result = o2.getDeps().get(i).compareTo(o1.getDeps().get(i));
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        result = 1;
                    }
                } else {
                    for (int i = 0; i < o1.getDeps().size(); i++) {
                        if (o1.getDeps().get(i).compareTo(o2.getDeps().get(i)) != 0) {
                            result = o2.getDeps().get(i).compareTo(o1.getDeps().get(i));
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        result = -1;
                    }
                }
                return result;
            }
        });
        descendingTree.addAll(set);
        return descendingTree;
    }

    /**
     * Добавляют отдельно верхнеуровневые элементы, если есть элементы входящие в них. Например K1\SK1 есть, а К1 нет.
     * => будет добавлен K1.
     */
    public void addingMissingDepartments(Set<Dep> set) {
        Set<Dep> tempSet = new HashSet<>();
        for (Dep dep: set) {
            if (dep.getDeps().size() > 1) {
                ArrayList<String> arrayList = new ArrayList<String>();
                for (String line: dep.getDeps()) {
                    arrayList.add(line);
                    tempSet.add(new Dep(new ArrayList<String>(arrayList)));
                }
            }
        }
        this.deps.addAll(tempSet);

    }
}
