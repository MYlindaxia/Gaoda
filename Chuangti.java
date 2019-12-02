package daima;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class Chuangti extends JFrame{

	Beijing bj = new Beijing();
	static Gaoda gd = new Gaoda();
	///////修改开始
	static ArrayList<Zidan> zds = new ArrayList<Zidan>();
	static ArrayList<Diji> djs = new ArrayList<Diji>();
	static ArrayList<Boom> bs = new ArrayList<Boom>();
	Boss b = new Boss();
	
	Image refresh;
	
	@Override
	public void paint(Graphics g) {
		if(refresh==null){
			refresh = createImage(1200,600);
		}
		Graphics gra = refresh.getGraphics();
		gra.setColor(Color.yellow);
		gra.fillRect(0, 0, 1200, 600);
		
		
		bj.draw(gra);
		gd.draw(gra);
		
		if(gd.shang & !gd.xia & !gd.zuo & !gd.you){
			gd.y = gd.y -5;
		}
		if(!gd.shang & gd.xia & !gd.zuo & !gd.you){
			gd.y = gd.y +5;
		}
		if(!gd.shang & !gd.xia & gd.zuo & !gd.you){
			gd.x = gd.x -5;
		}
		if(!gd.shang & !gd.xia & !gd.zuo & gd.you){
			gd.x = gd.x +5;
		}
		if(gd.shang & !gd.xia & gd.zuo & !gd.you){
			gd.y = gd.y -5;
			gd.x = gd.x -5;
		}
		if(gd.shang & !gd.xia & !gd.zuo & gd.you){
			gd.y = gd.y -5;
			gd.x = gd.x +5;
		}
		if(!gd.shang & gd.xia & gd.zuo & !gd.you){
			gd.y = gd.y +5;
			gd.x = gd.x -5;
		}
		if(!gd.shang & gd.xia & !gd.zuo & gd.you){
			gd.y = gd.y +5;
			gd.x = gd.x +5;
		}
/////修改开始
		for(Zidan zd : zds){//打印所有子弹
			zd.draw(gra);
		}
		Random r = new Random();
		if(r.nextInt(100)>95){//通过随机数产生概率5%生成敌机
			djs.add(new Diji());
		}
		//打印所有敌机
		for(Diji dj : djs){
			dj.draw(gra);
		}
		//碰撞判断
		for(Zidan zd : zds){
			for(Diji dj :djs){
				if(zd.getRect().intersects(dj.getRect())){
					zd.isLive=false;
					dj.isLive=false;
					bs.add(new Boom(dj.x, dj.y));
				}
			}
		}
		//判断并移除子弹
		for(int i = 0;i<zds.size();i++){
			if(zds.get(i).isLive==false){
				zds.remove(i);
			}
		}
		//判断并移除敌机
		for(int i = 0;i<djs.size();i++){
			if(djs.get(i).isLive==false){
				djs.remove(i);
			}
		}
		
		for(int i = 0;i<bs.size();i++){
			if(bs.get(i).isLive==false){
				bs.remove(i);
			}
		}
		
		for(Boom b : bs){
			b.draw(gra);
		}
		
		b.draw(gra);
		
		//测试判断
		if(gd.x<=0){
			gd.x = 0;
		}
		if(gd.y<=30){
			gd.y = 30;
		}
		if(gd.x>=1200-gd.width){
			gd.x = 1200-gd.width;
		}
		if(gd.y >=600-gd.height){
			gd.y = 600-gd.height;
		}
		
		for(int i = 0;i<djs.size();i++){
			if(djs.get(i).x <=-djs.get(i).width){
				djs.remove(i);
			}
		}
		
		
		
		
		g.drawImage(refresh, 0, 0, 1200, 600, null);
		
	}

	public static void main(String[] args) {
		Chuangti ct=new Chuangti();
		ct.setSize(1200,600);
		ct.setVisible(true);
		//当关闭窗口的时候关闭程序
		ct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(c=='a'){
					gd.zuo = false;
				}
				if(c=='d'){
					gd.you = false;
				}
				if(c=='w'){
					gd.shang = false;
				}
				if(c=='s'){
					gd.xia = false;
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(c=='a'){
					gd.zuo = true;
				}
				if(c=='d'){
					gd.you = true;
				}
				if(c=='w'){
					gd.shang = true;
				}
				if(c=='s'){
					gd.xia = true;
				}
				/////修改开始
				if(c=='j'){
					zds.add(new Zidan(gd.x,gd.y));
				}
			}
		});
		
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ct.repaint();
		}
	}
	
	
}
