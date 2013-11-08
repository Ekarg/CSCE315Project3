package com.example.test;

import com.example.test.R.id;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Button launch = (Button) findViewById(R.id.button1);
		//launch.setEnabled(true);
		
	
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void launch(View view)  
	{  
		 Intent intent = new Intent();
		 intent.setClass(this,SecondActivity.class);
		 startActivity(intent);
		 
		
	}  

	public void onRadioButtonClicked(View view)
	{
		Button launch = (Button) findViewById(R.id.button1);
		RadioButton human, mouse, rat, brain, spine, eye;
		
		human = (RadioButton)findViewById(R.id.radioButton1);
		mouse = (RadioButton)findViewById(R.id.radioButton2);
		rat = (RadioButton)findViewById(R.id.radioButton3);
		spine = (RadioButton)findViewById(R.id.radioButton4);
		brain = (RadioButton)findViewById(R.id.radioButton5);
		eye = (RadioButton)findViewById(R.id.radioButton6);
		
		if(human.isChecked() && brain.isChecked() || human.isChecked() && eye.isChecked() || human.isChecked() && spine.isChecked()) 
		{
			launch.setEnabled(true);
		}
		
		if(rat.isChecked() && brain.isChecked() || rat.isChecked() && eye.isChecked() || rat.isChecked() && spine.isChecked()) 
		{
			launch.setEnabled(true);
		}
		
		if(mouse.isChecked() && brain.isChecked() || mouse.isChecked() && eye.isChecked() || mouse.isChecked() && spine.isChecked()) 
		{
			launch.setEnabled(true);
		}
		
	}
	
	
}	

