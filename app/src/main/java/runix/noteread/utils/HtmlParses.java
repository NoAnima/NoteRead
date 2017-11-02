package runix.noteread.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class HtmlParses {
    public HtmlParses(){

    }

    public void jsoupPost(){
        try {
            Document document= Jsoup.connect("http://www.qiushibaike.com/8hr/page/1/")
                    .data("","")
                    .userAgent("")
                    .cookie("","")
                    .timeout(3000)
                    .post();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
