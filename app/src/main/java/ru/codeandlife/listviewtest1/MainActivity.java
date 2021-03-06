package ru.codeandlife.listviewtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/** It's a simple example how to use ListView with ArrayAdapter
 *  @Author Pavel Bobkov
 * */

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemLongClickListener{

    private List<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creates ArrayList and fake data
        list = new ArrayList<>(20);
        for(int i = 0; i < 20; i++){
            list.add("item " + Integer.toString(i));
        }

        //Creates ArrayAdapter and configures ListView
        adapter = new ArrayAdapter<>(this, R.layout.list_item, list);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        //Adds listener to process events
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data;

                //There are a few variants how to get data
                //data = list.get(position);
                data = (String)parent.getItemAtPosition(position);
                //data = (String)parent.getAdapter().getItem(position);

                //Shows a simple message
                Toast.makeText(MainActivity.this,
                        "OnItemClickListener\n" + data, Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String data = (String)parent.getItemAtPosition(position);
        Toast.makeText(MainActivity.this,
                "OnItemLongClickListener\n" + data, Toast.LENGTH_SHORT).show();
        return true;
    }
}
