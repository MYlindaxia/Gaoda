package Code;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	int x,y;
	int height,width;
	Image bj1,bj2;
	
	public Background(){
		x = 0;
		y = 0;
		height = 600;
		width = 1200;
		try {
			bj1=ImageIO.read(this.getClass().getClassLoader().getResource("imgs/bj.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bj2=bj1;
	}
	public void draw(Graphics gra){
		gra.drawImage(bj1, x, y, height, width, null);
		gra.drawImage(bj2, x+1200, y, height, width, null);
		if(x<=-1200){
			x = 0;
		}
		x = x-2;
	}

}
