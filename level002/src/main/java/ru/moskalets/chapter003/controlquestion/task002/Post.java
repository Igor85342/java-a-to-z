package ru.moskalets.chapter003.controlquestion.task002;

/**
 * Класс реализует объект post, в котором хранятся распарсинные данные из текущего поста.
 */
public class Post {
    /**
     * name
     */
    private final String name;
    /**
     * url
     */
    private final String url;

    /**
     * Конструктор
     * @param name
     * @param url
     */
    public Post(String name, String url) {
        this.name = name;
        this.url = url;
    }

    /**
     * Возвращает name.
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Возвращает url.
     * @return
     */
    public String getUrl() {
        return this.url;
    }
}