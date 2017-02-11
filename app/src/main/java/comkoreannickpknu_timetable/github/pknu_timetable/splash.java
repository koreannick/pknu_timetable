package comkoreannickpknu_timetable.github.pknu_timetable;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

//splash  2초간 띄어준다.

public class splash extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 상단바 삭제
        setContentView(R.layout.activity_splash);

        ImageView iv_logo = (ImageView) findViewById(R.id.iv_logo);
        Glide.with(this).load(R.drawable.splash).into(iv_logo);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                finish();
            }
        }, 2000);// 2 초
    }
}
