package brad.tw.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private LinkedList<HashMap<String,Object>> data;
    private String[] from = {"title","img","content"};
    private int[] to = {R.id.item_title, R.id.img,
            R.id.item_cont};
    private int[] imgs = {R.drawable.p0, R.drawable.p1,
    R.drawable.p2, R.drawable.p3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.listView);
        initListView();
    }

    private void initListView(){
        data = new LinkedList<>();

        HashMap<String,Object> data0 = new HashMap<>();
        data0.put(from[0], "Brad");
        data0.put(from[2], "Good Song");
        data0.put(from[1], imgs[(int)(Math.random()*4)]);
        data.add(data0);

        HashMap<String,Object> data1 = new HashMap<>();
        data1.put(from[0], "Eric");
        data1.put(from[2], "Song 1");
        data1.put(from[1], imgs[(int)(Math.random()*4)]);
        data.add(data1);

        HashMap<String,Object> data2 = new HashMap<>();
        data2.put(from[0], "Tony");
        data2.put(from[2], "Song 2");
        data2.put(from[1], imgs[(int)(Math.random()*4)]);
        data.add(data2);


        SimpleAdapter adapter =
                new SimpleAdapter(this, data, R.layout.layout_item,
                        from, to);
        list.setAdapter(adapter);
    }
}
