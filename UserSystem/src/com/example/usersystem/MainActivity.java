package com.example.usersystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public DBAdapter dbAdepter;

	public EditText nameText;
	public EditText sexText;
	public EditText pswText;
	public EditText RpswText;
	public EditText emailText;
	public EditText tellText;
	
	public Button buttonOK;
	public Button cancelbtn;
	public Button guanliButton;
	
	public TextView labelView;
	
	public static final int SUBACTIVITY1 = 1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        labelView = (TextView)findViewById(R.id.label);
        
        nameText = (EditText)findViewById(R.id.editText1);
        pswText = (EditText)findViewById(R.id.editText2);
        RpswText = (EditText)findViewById(R.id.editText3);
        sexText = (EditText)findViewById(R.id.editText4);
        emailText = (EditText)findViewById(R.id.editText5);
        tellText = (EditText)findViewById(R.id.editText6);
        
        buttonOK = (Button)findViewById(R.id.button1);
        cancelbtn = (Button)findViewById(R.id.button2);
        guanliButton = (Button)findViewById(R.id.button3);
        
        dbAdepter = new DBAdapter(this);
        dbAdepter.open();
        
        guanliButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent, SUBACTIVITY1);
			}
		});
        
        buttonOK.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		
                People people = new People();
    			people.Name = nameText.getText().toString();
    			people.sex = sexText.getText().toString();
    			people.password = pswText.getText().toString();
    			people.email = emailText.getText().toString();
    			people.tell = tellText.getText().toString();
    			long colunm = dbAdepter.insert(people);
    			if (colunm == -1 ){
    				labelView.setText("添加过程错误！");
    			} else {
    				labelView.setText("成功添加数据，ID："+String.valueOf(colunm));		
    			}
    		}	       	
        });
    }
    



}
