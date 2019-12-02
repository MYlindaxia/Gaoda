package daima;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Boom {

	int x,y;
	int width,height;
	Image[] bs = new Image[6];
	int timer = 0;
	boolean isLive = true;
	
	public Boom(int djx,int djy){
		x = djx;
		y = djy;
		width = 119;
		height = 119;
		for(int i = 0;i<6;i++){
			try {
				bs[i] = ImageIO.read(this.getClass().getClassLoader().getResource("tupian/Explosion/0"+(i+1)+".gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void draw(Graphics gra){
		gra.drawImage(bs[timer], x, y, width, height,null);
		if(timer>=5){
			timer = 0;
			isLive = false;
		}else{
			timer++;
		}
		
	}
	
	
}
