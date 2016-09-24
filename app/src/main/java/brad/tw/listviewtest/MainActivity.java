package brad.tw.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private LinkedList<HashMap<String,String>> data;
    private String[] from = {"title","content"};
    private int[] to = {R.id.item_title, R.id.item_cont};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.listView);
        initListView();
    }

    private void initListView(){
        data = new LinkedList<>();

        HashMap<String,String> data0 = new HashMap<>();
        data0.put(from[0], "Brad");
        data0.put(from[1], "Good Song");
        data.add(data0);

        HashMap<String,String> data1 = new HashMap<>();
        data1.put(from[0], "Eric");
        data1.put(from[1], "Song 1");
        data.add(data1);

        HashMap<String,String> data2 = new HashMap<>();
        data2.put(from[0], "Tony");
        data2.put(from[1], "Song 2");
        data.add(data2);


        SimpleAdapter adapter =
                new SimpleAdapter(this, data, R.layout.layout_item,
                        from, to);
        list.setAdapter(adapter);
    }
}
