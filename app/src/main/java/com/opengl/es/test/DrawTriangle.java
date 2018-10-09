package com.opengl.es.test;

import android.os.Bundle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * 绘制三角形
 */
public class DrawTriangle extends OpenGLESActivity implements IOpenGLDemo {
    float vertexArray[] = {
            //1
            -0.8f, 0.6f, 0f,
            -0.6f, 0.6f, 0f,
            -0.7f, 0.8f, 0f,
            //2
            -0.2f, 0.6f, 0f,
            0.2f, 0.6f, 0f,
            0f, 0.8f, 0f,
            //3
            0.6f, 0.6f, 0f,
            0.8f, 0.6f, 0f,
            0.7f, 0.8f, 0f,
            //4
            -0.8f, -0.2f, 0f,
            -0.6f, -0.2f, 0f,
            -0.7f, 0.2f, 0f,
            //5
            -0.15f, -0.15f, 0f,
            0.15f, -0.15f, 0f,
            0f, 0.15f, 0f,
            //6
            0.6f, -0.2f, 0f,
            0.8f, -0.2f, 0f,
            0.7f, 0.2f, 0f,
            //7
            -0.8f, -0.8f, 0f,
            -0.6f, -0.8f, 0f,
            -0.7f, -0.6f, 0f,
            //8
            -0.2f, -0.8f, 0f,
            0.2f, -0.8f, 0f,
            0, -0.6f, 0f,
            //9
            0.6f, -0.8f, 0f,
            0.8f, -0.8f, 0f,
            0.7f, -0.6f, 0f,
    };
    private int index = 0;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void DrawScene(GL10 gl) {
        super.DrawScene(gl);
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertexArray.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertex = vbb.asFloatBuffer();
        vertex.put(vertexArray);
        vertex.position(0);
        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -4);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertex);
        index++;
        index %= 15;
        switch (index) {
            case 0:
            case 1:
            case 2:
                gl.glColor4f(0.0f, 1.0f, 0.0f, 1.0f);
                gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vertexArray.length / 3);
                break;
            case 3:
            case 4:
            case 5:
//                gl.glColor4f(0.0f, 1.0f, 0.0f, 1.0f);
//                gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertexArray.length / 3);
                break;
            case 6:
            case 7:
            case 8:
            case 9:
//                gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
//                gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, vertexArray.length / 3);
                break;
        }
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
