/* CSCE 315 - Fall 2013
 * Contributors - Team G
 * Wesley Tang
 * Sidian Wu
 * Violeta Torres
 * Alejandro Vega
 * Grace Coffman
 */
package com.example.test;


import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;

public class SecondActivity extends Activity {
	private GLSurfaceView mGLView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Show the Up button in the action bar.
		Intent intent = getIntent();
		String species = intent.getStringExtra("Species");
		String region = intent.getStringExtra("Region");
		System.out.print("Species: " + species + "\n" + "Region: " + region + "\n");
		setContentView(R.layout.second_activity_display);		
		TextView s = (TextView)findViewById(R.id.textTitle1);
		s.setText(species+"   --->");
		TextView r = (TextView)findViewById(R.id.textTitle2);
		r.setText(region);
		mGLView = new OpenGlView(this);
	    setContentView(mGLView);
	    setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}

}

class OpenGlView extends GLSurfaceView {

    private final GLRenderer mRenderer;

    public OpenGlView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        // Set the Renderer for drawing on the GLSurfaceView
        mRenderer = new GLRenderer();
        setRenderer(mRenderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    float x_down;
    float y_down;
    float x_up;
    float y_up;
    double deg_0 = 0;
    double deg_45 = 45;
    double deg_90 = 90;
    double deg_125 = 125;
    double deg_180 = 180;
    double deg_225 = 225;
    double deg_270 = 270;
    double deg_315 = 315;
    double deg_360 = 360;
    
    
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        //When screen is swiped, rotate image in the correct direction, taking
    	//into account the x,y, and z components. 
    	//This is achieved by first finding the start and ending positions of the swipe
    	//then finding the angle of the swipe so that the it can be decided how it is 
    	//that the image needs to be rotated. 

                  
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
<<<<<<< HEAD
            	 x_up = x_down = e.getX();
                 y_up = y_down = e.getY();
                  System.out.println("X1: " + x_down);
                  System.out.println("Y1: "+ y_down);
=======
            	  x_down = e.getX();
                  y_down = e.getY();
>>>>>>> 927e195a4bb5936b79673d726d7ca188cc09f3f4
            break;
           // case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_UP:
            	 x_down = x_up;
            	 y_down = y_up;
            	 
            	 x_up = e.getX();
                 y_up = e.getY();
                 Rect outRect = null;
				// Display display = 
                 
                 float y_diff = y_up - y_down;
                 float x_diff = x_up - x_down;
                 System.out.println("X2: " + x_up);
                 System.out.println("Y2: "+ y_up);
                 double angle = Math.toDegrees(Math.atan2(y_diff,- x_diff))+180.0;
                 System.out.println("Angle: " + angle);
                 
                 
                 //get quandrant 
                 double diff_0 = angle - deg_0;
                 double diff_45 = angle - deg_45;
                 double diff_90 = angle - deg_90;
                 double diff_125 = angle - deg_125;
                 double diff_180 = angle - deg_180;
                 double diff_225 = angle - deg_225;
                 double diff_270 = angle - deg_270;
                 double diff_315 = angle - deg_315;
                 double diff_360 = angle - deg_360;
                 
                 double diff = 22.5;
                 float x_angle = mRenderer.mAngleX;
                 float y_angle = mRenderer.mAngleY;
                 float z_angle = mRenderer.mAngleZ;
                 float deg_change = 25;
                 
                 if(diff_0 <= 22.5) {
                	 mRenderer.mAngleY = y_angle + deg_change; 
                 }
                 else if(diff_45 <= 22.5) {
                	 mRenderer.mAngleX = x_angle + deg_change; 
                	 mRenderer.mAngleY = y_angle + deg_change; 
                 }
                 else if(diff_90 <= 22.5) {
                	 mRenderer.mAngleX = x_angle + deg_change; 
                 }
                 else if(diff_125 <= 22.5) {
                	 mRenderer.mAngleX = x_angle + deg_change; 
                	 mRenderer.mAngleY = y_angle - deg_change; 
                 }
                 else if(diff_180 <= 22.5) {
                	 mRenderer.mAngleY = y_angle - deg_change;                 	
                 }
                 else if(diff_225 <= 22.5) {
                	 mRenderer.mAngleX = x_angle - deg_change; 
                	 mRenderer.mAngleY = y_angle - deg_change; 
                 }
                 else if(diff_270 <= 22.5) {
                	 mRenderer.mAngleX = x_angle - deg_change;
                 }
                 else if(diff_315 <= 22.5) {
                	 mRenderer.mAngleX = x_angle - deg_change; 
                	 mRenderer.mAngleY = y_angle + deg_change; 
                 }
                 else if(diff_360 <= 22.5) {
                	 mRenderer.mAngleY = y_angle + deg_change; 
                 }
                 else {
                	 System.out.println("Out of bounds... Cannot find rotation angle");
                 }

                 
                 //get angle adjustments 
                 
                 
                 requestRender();
           break;
                
        }       
        
        return true;
    }
}
