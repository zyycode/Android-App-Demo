package com.example.usersystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.method.QwertyKeyListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends Activity {

	public Button btnOK;
	public Button btnCancel;
	public EditText nameText;
	public EditText pswText;
	public TextView displayer;
	
	private static final int SUBACTIVITY2 = 2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);
		
		displayer = (TextView)findViewById(R.id.textView3);
		
		nameText = (EditText)findViewById(R.id.editText1);
		pswText = (EditText)findViewById(R.id.editText2);
		
		btnOK = (Button)findViewById(R.id.button1);
		btnCancel = (Button)findViewById(R.id.button2);
		
		btnOK.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name = "qwer";
				String psw = "1234";
				String saveName = nameText.getText().toString();
				String savePsw = pswText.getText().toString();
				
				if(saveName.equals(name) && savePsw.equals(psw))
				{
					Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
	                startActivityForResult(intent, SUBACTIVITY2);
				} else{
					String txt = "’À∫≈ªÚ√‹¬Î¥ÌŒÛ£¨«Î÷ÿ–¬ ‰»Î£°";
					displayer.setTextColor(Color.rgb(255, 0, 0));
					displayer.setText(txt);
				}
				
			}
		});
		
		btnCancel .setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				displayer.setText("«Î ‰»Îπ‹¬∑’À∫≈º∞√‹¬Î:");
				nameText.setText("");
				pswText.setText("");
			}
		});
		
	}

	

}
