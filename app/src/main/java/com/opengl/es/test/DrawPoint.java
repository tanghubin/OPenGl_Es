package com.opengl.es.test;

import android.os.Bundle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * 绘制点
 */
public class DrawPoint extends OpenGLESActivity implements IOpenGLDemo {
    float[] vertexArray = new float[]{// xyz
            -1f, 0f, -1.0f,
            -1f, 1f, -1.0f,
            -1f, -1f, -1.0f,
    };

    /**
     * 以屏幕中心为原点，xy不变 向右向上增长，z轴是屏幕由内向外 零界点值0 刚好看不见，则设置 z=-1
     * <p>
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
        gl.glColor4f(1f, 1f, 1f, 1.0f);//设置颜色 0黑 1白 例如1,1,1,1 白色
        gl.glPointSize(40f);//设置点大小
        gl.glLoadIdentity();//加载
        gl.glTranslatef(0, 0, -10);//平移   xyz z轴
//        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertex);
        gl.glDrawArrays(GL10.GL_POINTS, 0, 3);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

}  