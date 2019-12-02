package daima;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Gaoda {
 
	int x,y;
	int width,height;
	Image gd;
	
	boolean shang,xia,zuo,you;
	
	public Gaoda(){
		x = 0;
		y = 0;
		width = 119;
		height = 80;
		try {
			gd = ImageIO.read(this.getClass().getClassLoader().getResource("tupian/gd.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics gra){
		gra.drawImage(gd, x, y, width, height, null);
		
	}
}
