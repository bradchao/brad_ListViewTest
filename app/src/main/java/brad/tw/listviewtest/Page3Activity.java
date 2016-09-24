package brad.tw.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class Page3Activity extends AppCompatActivity {
    private ListView list;
    private String[] data = {"Item1","Item2",
            "Item3","Item4","Item5","Item6",
            "Item7","Item8","Item9","Item10"};
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        list = (ListView)findViewById(R.id.page3_list);
        initListView();
    }

    private void initListView(){
        adapter = new MyAdapter();
        list.setAdapter(adapter);
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }

}
