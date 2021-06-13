
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import javax.swing.JFrame;

public class task2 implements GLEventListener{
	  private static float f[] = new float[20];
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
   	   try {
		      File myObj = new File("D:\\Users\\user\\eclipse-workspace\\lab1\\src\\coordinates.txt");
		      Scanner myReader = new Scanner(myObj);
		      for(int i=0; i<20; i++) {
			        String x = myReader.nextLine(); 
			        f[i]=Float.parseFloat(x);
			        
			      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	   
	   task2 l = new task2();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      	      	      
	      final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
	   	 
	   	 final GL2 gl = drawable.getGL().getGL2();
         gl.glPointSize(10);

   	   	for(int i=0; i<20;i++) {
   		   float x = f[i];
   		   float y = f[++i];
   		   System.out.println(x +","+y);
     	  gl.glBegin (GL2.GL_POINTS);//static field
     	  gl.glVertex2d(x,y);
          gl.glEnd();
   	   }
          
      
   }
   
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
   public void init(GLAutoDrawable drawable) {
      // method body
	   //4. drive the display() in a loop
	    }
   
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   //end of main
}//end of classimport javax.media.opengl.GL2;
