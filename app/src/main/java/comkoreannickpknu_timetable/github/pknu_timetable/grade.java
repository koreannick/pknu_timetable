package comkoreannickpknu_timetable.github.pknu_timetable;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.widget.TextView;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.CookieStore;

/**
 * Created by EunYeong on 2017-02-11.
 */

public class grade extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_grade,container,false);
    //http://m.pknu.ac.kr/13_member/encrypted.jsp?preId=201211682&prePW=1726717
        //로그인 url
        String login_url ="http://m.pknu.ac.kr/13_member/login.jsp";
        //성적확인 url
        String grade_url ="";
        String id = "201211682";
        String pw = "1726717";
        TextView txt_grade = (TextView)view.findViewById(R.id.txt_grade);

        try {
            Connection.Response res2 = Jsoup.connect(login_url)
                    .data("preId",id,"prePW",pw)
                    .timeout(5000)
                    .execute();

            CookieManager cookieManager = CookieManager.getInstance();
            String cookies = cookieManager.getCookie(grade_url);

            Connection.Response re = Jsoup.connect("로그인 이후 접근가능 URL")
                    .header("Cookie", cookies)//쿠키값 전달
                    .execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }
}
