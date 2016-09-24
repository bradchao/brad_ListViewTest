package brad.tw.listviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Page2Activity extends AppCompatActivity {
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        title = (TextView)findViewById(R.id.page2_title);

        Intent it = getIntent();
        title.setText(it.getStringExtra("title"));


    }
}
