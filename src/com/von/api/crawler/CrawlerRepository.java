package com.von.api.crawler;

import com.von.api.common.AbstractRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CrawlerRepository extends AbstractRepository {
    private Map<String, ?> map;
    private CrawlerRepository(){
        map = new HashMap<>();
    };
    private static CrawlerRepository instance = new CrawlerRepository();
    public static CrawlerRepository getInstance(){
        return instance;
    }



    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
        Document doc = Jsoup.connect("https://music.bugs.co.kr/chart").timeout(10*1000).get();
        Elements elems = doc.select("table.byChart");
        Iterator<Element> title = elems.select("p.title").iterator();
        Iterator<Element> artist = elems.select("p.artist").iterator();
        Iterator<Element> rank = elems.select("div.ranking").iterator();

        Map<String, Iterator<Element>> sing = new HashMap<>();
        sing.put("1",title);
        sing.put("2",artist);
        sing.put("3",rank);

        return sing;
    }


    public Map<String,?> saveMelon(Map<String, ?> paramMap) throws IOException {
        Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").timeout(10*1000).get();
        Elements elems = doc.select("tbody");
        Iterator<Element> title = elems.select("div.rank01").iterator();
        Iterator<Element> artist = elems.select("div.rank02 > span").iterator();
        Iterator<Element> rank = elems.select("span.rank").iterator();
        Map<String, Iterator<Element>> sing = new HashMap<>();
        sing.put("1",title);
        sing.put("2",artist);
        sing.put("3",rank);

        return sing;
    }
}