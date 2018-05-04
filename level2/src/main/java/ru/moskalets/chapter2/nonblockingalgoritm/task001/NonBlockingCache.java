package ru.moskalets.chapter2.nonblockingalgoritm.task001;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  Кеш для хранение моделей работающий на неблокирующих алгоритмах.
 */
public class NonBlockingCache {
    /**
     *container - контейнер для моделей.
     */
    private ConcurrentHashMap<Integer, Model> container = new ConcurrentHashMap<>();
    /**
     * Добавление элемента.
     * @param id
     */
    public void add(int id) {
        this.container.put(id, new Model(id));
    }

    /**
     * Изменение элемента.
     * @param id
     * @param upModel
     * @throws OplimisticException
     */
    public void update(int id, Model upModel) throws OplimisticException {
            this.container.computeIfPresent(id, (k, v) -> {
                upModel.setVersion(this.container.get(id).getVersion() + 1);
                upModel.setId(this.container.get(id).getId());
                Model result = null;
                if (this.container.get(id).getVersion() + 1 == upModel.getVersion()) {
                    result = upModel;
                } else {
                    try {
                        throw new OplimisticException("Oplimistic Exception !!!");
                    } catch (OplimisticException e) {
                        e.printStackTrace();
                    }
                }
                return result;
            });
    }

    /**
     * Удаление элемента.
     * @param id
     */
    public void delete(int id) {
            this.container.remove(id);
    }
    /**
     * Вовзращает контейнер.
     * @return
     */
    public ConcurrentHashMap<Integer, Model> getContainer() {
        return this.container;
    }
}
