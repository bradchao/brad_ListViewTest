package brad.tw.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
        private LayoutInflater inflater;

        MyAdapter(){
            inflater = LayoutInflater.from(Page3Activity.this);
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                convertView = inflater.inflate(R.layout.layout_item3,parent,false);
            }

            TextView title = (TextView) convertView.findViewById(R.id.item3_title);
            title.setText(data[position]);

            return convertView;
        }
    }

}
