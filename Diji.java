package Code;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Diji {
	int x,y;
	int width,height;
	Image dj;
	boolean isLive = true;
	
	public Diji(){
		x = 0;
		Random r = new Random();
		y = r.nextInt(600);
		width = 96;
		height = 68;
		try {
			dj=ImageIO.read(this.getClass().getClassLoader().getResource("imgs/dj.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void draw(Graphics gra){
		gra.drawImage(dj,x,y,width,height,null);
	}
	public Rectangle getrRect(){
		return new Rectangle(x,y,width,height);
	}

}
