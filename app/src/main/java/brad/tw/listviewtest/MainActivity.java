package brad.tw.listviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

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
    private EditText input;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.editInput);
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


        adapter =
                new SimpleAdapter(this, data, R.layout.layout_item,
                        from, to);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "p = " + position,
                        Toast.LENGTH_SHORT).show();
                if (position==0){
                    gotoPage3();
                }else {
                    gotoPage2(position);
                }
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("brad", "p = " + position);
                removeItem(position);
                return true;
            }
        });
    }

    private void gotoPage2(int p){
        Intent it = new Intent(this, Page2Activity.class);
        it.putExtra("title", (String)data.get(p).get(from[0]));
        startActivity(it);
    }

    private void removeItem(int n){
        data.remove(n);
        adapter.notifyDataSetChanged();
    }

    private void gotoPage3(){
        Intent it = new Intent(this, Page3Activity.class);
        startActivity(it);
    }

    public void addItem(View v){
        String input = this.input.getText().toString();

        HashMap<String,Object> newdata = new HashMap<>();
        newdata.put(from[0], input);
        newdata.put(from[2], "Song 2");
        newdata.put(from[1], imgs[(int)(Math.random()*4)]);
        data.add(newdata);

        adapter.notifyDataSetChanged();

    }

}
