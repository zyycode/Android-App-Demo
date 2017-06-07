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

public class MainActivity3 extends Activity {
	
	private static final int SUBACTIVITY3 = 3;
	private DBAdapter dbAdepter2;
	
	public TextView displyerTextView;
	
	public EditText nameText;
	public EditText sexText;
	public EditText pswText;
	public EditText emailText;
	public EditText tellText;
	public EditText idEntry;
	
	public Button showButton;
	public Button updateButton;
	public Button clearButton;
	public Button deleteButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity3);
		
		displyerTextView = (TextView)findViewById(R.id.displayview);
		
		nameText = (EditText)findViewById(R.id.editText1);
        pswText = (EditText)findViewById(R.id.editText2);
        sexText = (EditText)findViewById(R.id.editText3);
        emailText = (EditText)findViewById(R.id.editText4);
        tellText = (EditText)findViewById(R.id.editText5);
        idEntry = (EditText)findViewById(R.id.id_entry);
		
		showButton = (Button)findViewById(R.id.button1);
		updateButton = (Button)findViewById(R.id.button2);
		clearButton = (Button)findViewById(R.id.button3);
		deleteButton = (Button)findViewById(R.id.button4);
		
		showButton.setOnClickListener(queryAllButtonListener); 
		updateButton.setOnClickListener(updateButtonListener);     
        clearButton.setOnClickListener(clearButtonListener);
        deleteButton.setOnClickListener(deleteAllButtonListener);
		
		dbAdepter2 = new DBAdapter(this);
        dbAdepter2.open();
	}
	
	OnClickListener queryAllButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			People[] peoples = dbAdepter2.queryAllData();
			if (peoples == null){
				displyerTextView.setText("数据库中没有数据");
				return;
			}
			displyerTextView.setText("数据库：");
			String msg = "";
			for (int i = 0 ; i<peoples.length; i++){
				msg += peoples[i].toString()+"\n";
			}
			displyerTextView.setText(msg);
			
		}
    };
    
    OnClickListener clearButtonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			displyerTextView.setText("");
			nameText.setText("");
			sexText.setText("");
			pswText.setText("");
			emailText.setText("");
			tellText.setText("");
			idEntry.setText("");
		}	
    };
    
    OnClickListener deleteAllButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			dbAdepter2.deleteAllData();
			String msg = "数据全部删除";
			displyerTextView.setText(msg);
		}	
    };
    
//    OnClickListener updateButtonListener = new OnClickListener() {
//    	
//    	public void onClick(View v) {
//    		Intent intent = new Intent(MainActivity3.this, MainActivity.class);
//            startActivityForResult(intent, SUBACTIVITY3);
//            
//          
//    	}
//    };
    
    OnClickListener updateButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			People people = new People();
			people.Name = nameText.getText().toString();
			people.sex = sexText.getText().toString();
			people.password = pswText.getText().toString();
			people.email = emailText.getText().toString();
			people.tell = tellText.getText().toString();
			long id = Integer.parseInt(idEntry.getText().toString());
			long count = dbAdepter2.updateOneData(id, people);
			if (count == -1 ){
				displyerTextView.setText("更新错误！");
			} else {
				displyerTextView.setText("更新成功，更新数据"+String.valueOf(count)+"条");	
				
			}
		}
    };

}
