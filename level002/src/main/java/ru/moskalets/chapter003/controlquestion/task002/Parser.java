package ru.moskalets.chapter003.controlquestion.task002;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Класс реализует объект, который парсит темы форума по ключевым словам и текущему году.
 */
public class Parser {
    /**
     * posts
     */
    private ArrayList<Post> posts = new ArrayList<Post>();

    /**
     * В методе определятеся количество страниц с вакансиями, для каждой страницы вызывается метод parsingPage(),
     * если год не текущей, цикл прерывается.
     * @throws IOException
     */
    public void parsingPosts() throws IOException {
        String pageUrl = "http://www.sql.ru/forum/job-offers/1";
        Document doc = Jsoup.connect(pageUrl).get();
        int numberOfPages = Integer.parseInt(doc.select(".sort_options").last().select("a").last().text());
        boolean yearEnd = false;
        for (int i = 1; i < numberOfPages + 1; i++) {
           yearEnd = parsingPage(Integer.toString(i));
           if (yearEnd) {
               break;
           }
        }
        Collections.reverse(this.posts);
    }

    /**
     * Метод парсит страницу по номеру.
     * @param pageNumber
     * @return
     * @throws IOException
     */
    public boolean parsingPage(String pageNumber) throws IOException {
        Document doc = Jsoup.connect("http://www.sql.ru/forum/job-offers/".concat(pageNumber)).get();
        Elements elements = doc.select(".postslisttopic > a");
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < elements.size(); i++) {
            String header = elements.get(i).text();
            String url = elements.get(i).absUrl("href");
            String stringDate = parsingPageVacancy(url);
            if (thisYearCheck(stringDate)) {
                if (header.toLowerCase().contains("java") & !header.toLowerCase().contains("script")) {
                    posts.add(new Post(header, url));
                }
            } else {
                count++;
            }
        }
        if (count >= 50) {
            flag = true;
        }
        return flag;
    }

    /**
     * Метод заходит в пост и возвращает строку с датой создания этого поста.
     * @param url
     * @return
     * @throws IOException
     */
    public String parsingPageVacancy(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.getElementsByAttributeValue("class", "msgFooter");
        return elements.get(0).ownText().substring(0, elements.get(0).ownText().indexOf(" ["));
    }

    /**
     * Метод возвращает текущий год.
     * @return
     */
    public int getCurrentYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        return Integer.valueOf(sdf.format(new Date()).toString());
    }

    /**
     * Метод возвращет год текущего поста.
     * @param date
     * @return
     */
    public int getPostYear(String date) {
        int result;
        if (date.toLowerCase().contains("вчера") | date.toLowerCase().contains("сегодня")) {
            result = getCurrentYear();
        } else {
            int position = date.indexOf(",");
            result = Integer.valueOf(date.substring(position - 2, position));
        }
        return result;
    }

    /**
     * Проверяет создан ли пост в текущем году.
     * @param date
     * @return
     */
    public boolean thisYearCheck(String date) {
        return getCurrentYear() == getPostYear(date);
    }

    /**
     * Возвращает список с постами.
     * @return
     */
    public ArrayList<Post> getPosts() {
        return this.posts;
    }
}