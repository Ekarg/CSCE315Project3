/* CSCE 315 - Fall 2013
 * Contributors - Team G
 * Wesley Tang
 * Sidian Wu
 * Violeta Torres
 * Alejandro Vega
 * Grace Coffman
 */
package com.example.test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}
	
	public void launch(View view)  
	{  
		 Intent intent = new Intent();
		 intent.setClass(this,SecondActivity.class);
		 RadioButton r1ga=(RadioButton)findViewById(R.id.radioButton1);
		 RadioButton r2ga=(RadioButton)findViewById(R.id.radioButton2);
		 RadioButton r3ga=(RadioButton)findViewById(R.id.radioButton3);
		 RadioButton r1gb=(RadioButton)findViewById(R.id.radioButton4);
		 RadioButton r2gb=(RadioButton)findViewById(R.id.radioButton5);
		 RadioButton r3gb=(RadioButton)findViewById(R.id.radioButton6);
		 String species = new String();
		 if(r1ga.isChecked())
		 {
			 species = (String) r1ga.getText();
		 }
		 

		 else if(r2ga.isChecked())
		 {
			 species = (String) r2ga.getText();
		 }
		 

		 else if(r3ga.isChecked())
		 {
			 species = (String) r3ga.getText();
		 }
		 
		 String region = new String();
		 if(r1gb.isChecked())
		 {
			 region = (String) r1gb.getText();
		 }
		 

		 else if(r2gb.isChecked())
		 {
			 region = (String) r2gb.getText();
		 }
		 

		 else if(r3gb.isChecked())
		 {
			 region = (String) r3gb.getText();
		 }
		 
		 System.out.print("Species: " + species + "\n" + "Region: " + region + "\n");
		 intent.putExtra("Species", species);
		 intent.putExtra("Region", region);
		 
		 
		//START XML PARSE
	    	// File Usage:
	    	//		data_small.xml - First four Row items worth of data from data_LARGE.xml
	    	//		data_large.xml - Contains the full 3975 Row items worth of data from a 
	    	//						 a single file off of NeuroMorpho.org. 
		
		 
		 try {
				Queue<Float> _q = new LinkedList<Float>();
				Data d = new Data();
				//String field = species + "_" + region;
				
				//Field f = R.raw.class.getDeclaredField(field);
				int value = 0;
				if(species.compareTo("Human") == 0){
					if(region.compareTo("Brain") == 0)
						value = R.raw.human_brain;
					else if(region.compareTo("Spine") == 0)
						value = R.raw.human_spine;
					else if(region.compareTo("Eye") == 0)
						value = R.raw.human_eye;
				}
				else if(species.compareTo("Mouse") == 0){
					if(region.compareTo("Brain") == 0)
						value = R.raw.mouse_brain;
					else if(region.compareTo("Spine") == 0)
						value = R.raw.mouse_spine;
					else if(region.compareTo("Eye") == 0)
						value = R.raw.mouse_eye;
				}
				else if(species.compareTo("Rat") == 0){
					if(region.compareTo("Brain") == 0)
						value = R.raw.rat_brain;
					else if(region.compareTo("Spine") == 0)
						value = R.raw.rat_spine;
					else if(region.compareTo("Eye") == 0)
						value = R.raw.rat_spine;
				}
					
			
				InputStream ins = getResources().openRawResource(value); //issues may happen here
			//	InputStream ins = getResources().openRawResource(f.getInt(null));
				
				//NOTE : Currently using data_small.xml
				int hold;
				char c;
				hold = ins.read();
				while(true) {
					if (hold == -1) {
						break;
					}
				   c=(char)hold;
				   if (c == '<') {
					   String temp = "";
					   for (int i = 0; i < 5; ++i) {
						   hold = ins.read();
						   c=(char)hold;
						   temp += c;
					   }
					   if (temp.equals("item>")) {
						   String number = "";
						   hold = ins.read();
						   c=(char)hold;
						   while (c != '<') {
							   number += c;
							   hold = ins.read();
							   c=(char)hold;
						   }					   
						   float parsed_float = Float.parseFloat(number);
						   _q.add(parsed_float);
					   }
				   }
				   hold = ins.read();
				}
				ArrayList<Row> _a = new ArrayList<Row>();
				while (!_q.isEmpty()) {
					_a.add(new Row((int)Math.round(_q.remove()), (int)Math.round(_q.remove()), _q.remove(), _q.remove(), _q.remove(), _q.remove(), (int)Math.round(_q.remove())));
				}
				d.setArray(_a);
				GetFile.setData(d);
				System.out.println("SUCCESS: XML PARSED\n");
			} catch (IOException e) {
				System.out.println("IOException\n");
			}
			//END XML PARSE
	catch (NotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IllegalArgumentException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
		 
		 
		 
		 
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
