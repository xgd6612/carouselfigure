package bizfocus.com.carouselfigurelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import bizfocus.com.carouselfigurelibrary.carousefigure.Carouse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Carouse  carouse = (Carouse) findViewById(R.id.carouse);
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.img_home_banner1);
        list.add(R.mipmap.img_home_banner2);
        list.add(R.mipmap.img_home_banner3);
        list.add(R.mipmap.img_home_banner4);
        list.add(R.mipmap.img_home_banner5);
        carouse.setList(list);
    }
}
