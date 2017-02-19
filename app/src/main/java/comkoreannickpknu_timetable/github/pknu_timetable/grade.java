package comkoreannickpknu_timetable.github.pknu_timetable;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.CookieStore;

/**
 * Created by EunYeong on 2017-02-11.
 */

public class grade extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
    //http://m.pknu.ac.kr/13_member/encrypted.jsp?preId=201211682&prePW=1726717
        String id = "201211682";
        String pw = "1726717";
        String sessionID="";
        CookieStore cookies;
        try {
            Connection.Response res2 = Jsoup.connect("http://m.pknu.ac.kr/13_member/login.jsp")
                    .data("preId",id,"prePW",pw)
                    .cookie("JSESSIONID",sessionID)
                    .timeout(5000)
                    .execute();
//            cookies=res2.cookies();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inflater.inflate(R.layout.fragment_grade,container,false);
    }
}
