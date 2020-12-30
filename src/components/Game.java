package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	int i=0;
	private BufferStrategy bs;
	private Graphics g;
	int[][] AdjMat = Level.getLevel(Level.setMatrix(3));
	draw_Grid d;
	drawComponents d1;
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init(){
		display = new Display(title, width, height);
	}
	
	private void tick(){
		
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		i++;
		g = bs.getDrawGraphics();
		g.fillRect(0, 0, 200, 200);
		d = new draw_Grid(AdjMat, g, bs); 
		d1 = new drawComponents(AdjMat, g, bs);
		Color customColor = new Color(10,250,250);
		g.setColor(customColor);
		//Draw Here!
		d.drawLevel();
		//draw components
		character ch = new character(width);
		d1.drawCharacter(ch);
		d1.drawHE(null);
		d1.drawVE(null);
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		while(running){
			tick();
			render();
		}
		stop();
		
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.run();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public int[][] makeLevel() {
		int[][] basemap = new int[9][9];
        basemap = Level.setMatrix(3);

        int[][] level = new int[9][9];
        level = Level.getLevel(basemap);
        return level;
	}
	
}