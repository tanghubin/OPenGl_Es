package com.opengl.es.test;

import javax.microedition.khronos.opengles.GL10;

public class DrawSphere extends OpenGLESActivity implements IOpenGLDemo {
    Sphere sphere= new Sphere();
    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);
        sphere.draw(gl);
    }
}
