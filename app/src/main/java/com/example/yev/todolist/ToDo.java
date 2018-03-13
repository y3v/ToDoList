package com.example.yev.todolist;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;

public class ToDo extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopUp();
            }
        });

        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, list );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v,int position, long id) {
                Log.d("LIST ITEM", "CLICKED!!!!!!!!!!!!!!!!!!!!");
            }
        });
    }

    private void createPopUp(){
        CoordinatorLayout main = findViewById(R.id.main);
        int width = CoordinatorLayout.LayoutParams.WRAP_CONTENT;
        int height = CoordinatorLayout.LayoutParams.WRAP_CONTENT;

        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);
        final PopupWindow popupWindow = new PopupWindow(popupView,width,height, true);

        popupWindow.showAtLocation(main, Gravity.CENTER, 0,0);


        Button okButton = popupWindow.getContentView().findViewById(R.id.buttonOK);
        Button cancelButton = popupWindow.getContentView().findViewById(R.id.buttonCancel);
        final TextInputEditText userInput = popupWindow.getContentView().findViewById(R.id.inputTask);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("OK BUTTON", "CLICKED!!!!!!!!!!!!!!!!!!!!");
                list.add(userInput.getText().toString());
                popupWindow.dismiss();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CANCEL BUTTON", "CLICKED!!!!!!!!!!!!!!!!!!!!");
                popupWindow.dismiss();
            }
        });

    }

}
