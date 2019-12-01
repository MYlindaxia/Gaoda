package Code;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Zidan {
	int x,y;
	int width,height;
	Image zd;
	boolean on,under,right,left;
	
	public Zidan(int gdx,int gdy){
		x = gdx;
		y = gdy;
		width = 19;
		height = 19;
		try {
			zd=ImageIO.read(this.getClass().getClassLoader().getResource("imgs/zd.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void draw(Graphics gra){
		gra.drawImage(zd,x,y,width,height,null);
	}
	public Rectangle getrRect(){
		return new Rectangle(x,y,width,height);
	}
}
