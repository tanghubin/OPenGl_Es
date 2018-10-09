package com.opengl.es.test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class DrawPentagram extends OpenGLESActivity {
    float vertexArray[] = {
            -0.5f,- 0.5f, 0.5f,
           - 0.6f,0.2f,0f,
            0f,0.6f,0f,
            0.6f,0.2f,0f,
            0.5f,-0.6f,0f
    };

    @Override
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
        gl.glTranslatef(0, 0, -5);//平移   xyz z轴
//        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertex);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 5);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }
}
