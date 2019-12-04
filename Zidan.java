package daima;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Zidan {
	int x,y;
	int width,height;
	Image zd;
	
	boolean isLive= true;
	public Zidan(int gdx,int gdy){
		x = gdx;
		y = gdy;
		width = 19;
		height = 19;
		try {
			zd = ImageIO.read(this.getClass().getClassLoader().getResource("tupian/zd.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics gra){
		//x = Integer.parseInt(Math.round(Math.sin(Math.cos(1))*100)+"")+50;
		//y = Integer.parseInt(Math.round(Math.sin(Math.cos(1))*100)+"")+10;
		
		gra.drawImage(zd, x, y, width, height, null);
		x = x+10;
	}
	
	public Rectangle getRect(){
		return new Rectangle(x,y,width,height);
	}
//test
}
