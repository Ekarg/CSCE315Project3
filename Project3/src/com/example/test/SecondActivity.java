package com.example.test;


import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
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
		setupActionBar();
		mGLView = new MyGLSurfaceView(this);
	    setContentView(mGLView);
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
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}

class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer mRenderer;

    public MyGLSurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        // Set the Renderer for drawing on the GLSurfaceView
        mRenderer = new MyGLRenderer();
        setRenderer(mRenderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private float mPreviousY;
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
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

                  
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
            	  x_down = e.getX();
                  y_down = e.getY();
                  System.out.println("X1: " + x_down);
                  System.out.println("Y1: "+ y_down);
            break;
            case MotionEvent.ACTION_UP:
            	 x_up = e.getX();
                 y_up = e.getY();
                 
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
