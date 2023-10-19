package com.example.listviewdangcap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.listviewdangcap.Adapters.ToolAdapters;
import com.example.listviewdangcap.module.tool;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView lvTool;
    ArrayList<tool> listTool;
    ToolAdapters adapterTool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTool=findViewById(R.id.lvTool);
        listTool=new ArrayList<>();
        listTool.add(new tool("Nghi phep",R.drawable.edit));
        listTool.add(new tool("Chấm công",R.drawable.calendar));
        listTool.add(new tool("Góp ý",R.drawable.book));
        listTool.add(new tool("Lương",R.drawable.money));
        listTool.add(new tool("Công tác",R.drawable.place));
        listTool.add(new tool("Tài Liệu",R.drawable.document2));

        adapterTool=new ToolAdapters(MainActivity.this,R.layout.list_tool,listTool);
        lvTool.setAdapter(adapterTool);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.seachmenu,menu);
        MenuItem seachBar=menu.findItem(R.id.seachBar);
        SearchView searchView= (SearchView) seachBar.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                adapterTool.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapterTool.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}