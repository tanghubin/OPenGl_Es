package com.opengl.es.test;

import android.opengl.GLU;
import android.os.Bundle;


import javax.microedition.khronos.opengles.GL10;

/**
 * 迷你太阳系
 */
public class DrawSolarSystem extends OpenGLESActivity implements IOpenGLDemo {
    private Star sun = new Star();
    private Star earth = new Star();
    private Star moon = new Star();
    private int angle = 0;

    /**
     * Called when the activity is first created.
     */


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);
        gl.glLoadIdentity();
        gl.glMaterialf(GL10.GL_FRONT_AND_BACK,GL10.GL_EMISSION,0.5f);
        GLU.gluLookAt(gl, 0.0f, 0.0f, 15.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        // Star A
        // Save the current matrix.
        gl.glPushMatrix();
        // Rotate Star A counter-clockwise.
        gl.glRotatef(angle*2, 0, 0, 1);
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        // Draw Star A.
        sun.draw(gl);
        // Restore the last matrix.
        gl.glPopMatrix();
        // Star B
        // Save the current matrix
        gl.glPushMatrix();
        // Rotate Star B before moving it,
        //making it rotate around A.
        gl.glRotatef(-angle * 5, 0, 0, 1);
        // Move Star B.
        gl.glTranslatef(2, 0, 0);
        // Scale it to 50% of Star A
        gl.glScalef(.4f, .4f, .4f);
        gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
        // Draw Star B.
        earth.draw(gl);
        // Star C
        // Save the current matrix
        gl.glPushMatrix();
        // Make the rotation around B
        gl.glRotatef(-angle * 10, 0, 0, 1);
        gl.glTranslatef(2, 0, 0);
        // Scale it to 50% of Star B
        gl.glScalef(.2f, .2f, .2f);
        // Rotate around it's own center.
        gl.glRotatef(angle * 2, 0, 0, 1);
        gl.glColor4f(0.0f, 1.0f, 0.0f, 1.0f);
        // Draw Star C.
        moon.draw(gl);
        // Restore to the matrix as it was before C.
        gl.glPopMatrix();
        // Restore to the matrix as it was before B.
        gl.glPopMatrix();
        // Increse the angle.
        angle++;
    }
}
