

package erg2;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.*;
import java.awt.GraphicsConfiguration;
import com.sun.j3d.utils.applet.MainFrame; 
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
/**
 *
 * Autor: Cesar Peña
 *
 */
public class Axis extends BranchGroup{
        private Appearance app;
        private RenderingAttributes rr;
        private Shape3D s3dx;
        private Shape3D s3dy;
        private Shape3D s3dz;

	public Axis() {
            // Defino los colores para cada uno de los vertices de los Ejes X,Y,Z
            Color3f red   = new Color3f(1.0f, 0.0f, 0.0f);
	    Color3f green = new Color3f(0.0f, 1.0f, 0.0f);
	    Color3f blue  = new Color3f(0.0f, 0.0f, 1.0f);
            
	    // Eje X
	    LineArray axisXLines = new LineArray(2, LineArray.COORDINATES | LineArray.COLOR_3 );
            s3dx= new Shape3D(axisXLines);
            s3dx.setAppearance(new Appearance());
            s3dx.setCapability(s3dx.ALLOW_APPEARANCE_WRITE);
	    addChild(s3dx);

	    axisXLines.setCoordinate(0, new Point3f(-1.0f, 0.0f, 0.0f));
	    axisXLines.setCoordinate(1, new Point3f( 1.0f, 0.0f, 0.0f));

            axisXLines.setColor(0,blue);
	    axisXLines.setColor(1,blue);

	    //Eje Y
	    LineArray axisYLines = new LineArray(2,LineArray.COORDINATES | LineArray.COLOR_3 );
             s3dy= new Shape3D(axisYLines);
             s3dy.setAppearance(new Appearance());
             s3dy.setCapability(s3dy.ALLOW_APPEARANCE_WRITE);
	     addChild(s3dy);
             
	    axisYLines.setCoordinate(0, new Point3f( 0.0f,-1.0f, 0.0f));
	    axisYLines.setCoordinate(1, new Point3f( 0.0f, 1.0f, 0.0f));
            axisYLines.setColor(0, blue);
	    axisYLines.setColor(1, blue);

	    // Eje Z
	    Point3f z1 = new Point3f( 0.0f, 0.0f,-1.0f);
	    Point3f z2 = new Point3f( 0.0f, 0.0f, 1.1f);

	    LineArray axisZLines = new LineArray(10,LineArray.COORDINATES  | LineArray.COLOR_3 );
            s3dz= new Shape3D(axisZLines);
            s3dz.setAppearance(new Appearance());
            s3dz.setCapability(s3dz.ALLOW_APPEARANCE_WRITE);
	    addChild(s3dz);

	    axisZLines.setCoordinate(0, z1);
	    axisZLines.setCoordinate(1, z2);
	    axisZLines.setCoordinate(2, z2);
	    axisZLines.setCoordinate(3, new Point3f( 0.01f, 0.01f, 1.05f));
	    axisZLines.setCoordinate(4, z2);
	    axisZLines.setCoordinate(5, new Point3f(-0.01f, 0.01f, 1.05f));
	    axisZLines.setCoordinate(6, z2);
	    axisZLines.setCoordinate(7, new Point3f( 0.01f,-0.01f, 1.05f));
	    axisZLines.setCoordinate(8, z2);
	    axisZLines.setCoordinate(9, new Point3f(-0.01f,-0.01f, 1.05f));

	    Color3f colors[] = new Color3f[9];
	    colors[0] = blue;
	    for(int v = 1; v < 9; v++){
		colors[v] = red;
	    }

	    axisZLines.setColors(1, colors);
	    	    
	}
        
        public void ver(boolean band){
         app=new Appearance();
         rr=new RenderingAttributes();
         rr.setVisible(band);
         app.setRenderingAttributes(rr);
         s3dx.setAppearance(app);
         s3dy.setAppearance(app);
         s3dz.setAppearance(app);
        }

	public Axis getBG(){
	    return this;
	}

    } 
