package daima;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Beijing {

	int x,y;
	int width,height;
	Image bj1,bj2;
	
	public Beijing(){
		x = 0;
		y = 0;
		width = 1200;
		height = 600;
		try {
			bj1 = ImageIO.read(this.getClass().getClassLoader().getResource("tupian/bj.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bj2 = bj1;
	}
	
	public void draw(Graphics gra){
		gra.drawImage(bj1, x, y, width, height, null);
		gra.drawImage(bj2, x+1200, y, width, height, null);
		if(x<=-1200){
			x = 0;
		}
		x = x-2;
	}
	
	
}
