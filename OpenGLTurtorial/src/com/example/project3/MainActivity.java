package com.example.project3;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;


public class MainActivity extends Activity 
{
        /** Hold a reference to our GLSurfaceView */
        private GLSurfaceView mGLSurfaceView;

        @Override
        public void onCreate(Bundle savedInstanceState) 
        {
                super.onCreate(savedInstanceState);
                
                mGLSurfaceView = new GLSurfaceView(this);

                // Check if the system supports OpenGL ES 2.0.
                final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
                final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
                final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;

                if (supportsEs2) 
                {
                        // Request an OpenGL ES 2.0 compatible context.
                        mGLSurfaceView.setEGLContextClientVersion(2);

                        // Set the renderer to our demo renderer, defined below.
                        mGLSurfaceView.setRenderer(new LessonOneRenderer());
                } 
                else 
                {
                        // This is where you could create an OpenGL ES 1.x compatible
                        // renderer if you wanted to support both ES 1 and ES 2.
                        return;
                }

                setContentView(mGLSurfaceView);
        }

        @Override
        protected void onResume() 
        {
                // The activity must call the GL surface view's onResume() on activity onResume().
                super.onResume();
                mGLSurfaceView.onResume();
        }

        @Override
        protected void onPause() 
        {
                // The activity must call the GL surface view's onPause() on activity onPause().
                super.onPause();
                mGLSurfaceView.onPause();
        }  
        
        
        
}

class MyGLSurfaceView extends GLSurfaceView {

    private final LessonOneRenderer mRenderer;

    public MyGLSurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        // Set the Renderer for drawing on the GLSurfaceView
        mRenderer = new LessonOneRenderer();
        setRenderer(mRenderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private float mPreviousY;

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:

                float dx = x - mPreviousX;
                float dy = y - mPreviousY;

                // reverse direction of rotation above the mid-line
                if (y > getHeight() / 2) {
                  dx = dx * -1 ;
                }

                // reverse direction of rotation to left of the mid-line
                if (x < getWidth() / 2) {
                  dy = dy * -1 ;
                }

                mRenderer.mAngle += (dx + dy) * TOUCH_SCALE_FACTOR;  // = 180.0f / 320
                requestRender();
        }

        mPreviousX = x;
        mPreviousY = y;
        return true;
    }
}