package daima;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Boss {

	int x, y;
	int width, height;
	Image[] boss = new Image[24];

	int timer = 0;
	int step = 1;

	public Boss() {
		x = 1200;
		y = 300;
		width = 350;
		height = 120;

		for (int i = 0; i < 24; i++) {

			try {
				System.out.println("tupian/Boss/0" + (i + 1) + ".gif");
				if (i < 9) {
					boss[i] = ImageIO.read(this.getClass().getClassLoader()
							.getResource("tupian/Boss/0" + (i + 1) + ".gif"));
				}
				if (i >= 9) {
					boss[i] = ImageIO.read(this.getClass().getClassLoader()
							.getResource("tupian/Boss/" + (i + 1) + ".gif"));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void draw(Graphics gra) {

		if (step == 1) {
			x = x - 5;
			if (x <= 700) {
				step = 2;
			}
			gra.drawImage(boss[0], x, y, width, height, null);
		}
		if (step == 2) {
			y = y - 5;
			if (y <= 50) {
				step = 3;
			}
			gra.drawImage(boss[0], x, y, width, height, null);
		}
		if (step == 3) {
			y = y + 5;
			if (y >= 300) {
				step = 4;
			}
			gra.drawImage(boss[0], x, y, width, height, null);
		}
		if (step == 4) {
			if (timer < 24) {
				gra.drawImage(boss[timer], x, y, width, height, null);
				timer++;
			} else {
				timer = 0;
				step = 5;
			}
		}
		if (step == 5) {
			if (x <= -300) {
				x = 1200;
				step = 1;
			}
			x = x - 5;
			gra.drawImage(boss[23], x, y, width, height, null);
		}

	}

}
