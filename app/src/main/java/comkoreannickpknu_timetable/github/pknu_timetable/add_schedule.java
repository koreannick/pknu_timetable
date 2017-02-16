package comkoreannickpknu_timetable.github.pknu_timetable;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class add_schedule extends Activity {
    static TextView txt_id;
    static TextView txt_id_info;
    static EditText etxt_search;
    static Button btn_search;
    static ListView lv_subject;
    static ListAdapter subjectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);

        etxt_search = (EditText)findViewById(R.id.etxt_search);
        btn_search = (Button)findViewById(R.id.btn_search);
        lv_subject = (ListView)findViewById(R.id.lv_subject);
        subjectAdapter = new ListAdapter();
        lv_subject.setAdapter(subjectAdapter);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new T().execute(null, null, null);
            }
        });


    }
}
class T extends AsyncTask<Void, Void, Void> {

    String[] ids = new String[4000];
    String[] ids_info= new String[32000];
    String search_subject=add_schedule.etxt_search.getText().toString();
    @Override
    protected Void doInBackground(Void... params) {

        try {
            int i = 0;
            int j = 0;
            Document document = Jsoup.connect("http://m.pknu.ac.kr/07_support/04_2.jsp?hakbu=Ejsza0UJndzgqWN%2BKEUkQQ%3D%3D&keyw="+search_subject).get();

            Elements elements = document.select("th.thl");
            Elements elements2 = document.select("td").not("td.tdl");
            add_schedule.subjectAdapter.dateRemove();
            for(Element e2 : elements2) {
                ids_info[j] = e2.text();
                j++;
            }
            for(Element e : elements) {
                ids[i] = e.text();
                add_schedule.subjectAdapter.addItem(ids[i],ids_info[i*8],ids_info[i*8+1],ids_info[i*8+2],ids_info[i*8+3],ids_info[i*8+4],ids_info[i*8+5],ids_info[i*8+6],ids_info[i*8+7]);
                i++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        add_schedule.subjectAdapter.dataChange();
    }


}