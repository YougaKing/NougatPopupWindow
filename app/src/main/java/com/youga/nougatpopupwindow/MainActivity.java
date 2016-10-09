package com.youga.nougatpopupwindow;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button little = (Button) findViewById(R.id.little);

        Button multiple = (Button) findViewById(R.id.multiple);


        final NougatWindow window = new NougatWindow(this);

        little.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> strings = getStrings(3);
                window.showWindow(v, strings);
            }
        });


        multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> strings = getStrings(20);
                window.showWindow(v, strings);
            }
        });
    }

    @NonNull
    private List<String> getStrings(int count) {
        List<String> strings = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            strings.add("第" + i + "个");
        }
        return strings;
    }
}
