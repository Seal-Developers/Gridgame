package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game implements Runnable {


	private Display display;
	public int width, height;
	public static int gridSize=8;
	public String title;
	public static Color customColor = new Color(10,250,250);
	private boolean running = false;
	private Thread thread;
	int i=0;
	private BufferStrategy bs;
	private Graphics g;
	int[][] AdjMat = Level.getLevel(Level.setMatrix(gridSize));
	draw_Grid d;
	drawComponents d1;
	character ch;
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		this.ch = new character(gridSize);
	}
	
	private void init(){
		display = new Display(title, width, height);
	}
	
	private void tick(){
		
	}
	/**
	 * This is the main game loop 
	 * @throws InterruptedException 
	 */
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		i++;
		g = bs.getDrawGraphics();
		g.fillRect(0, 0, 600, 600);
		d = new draw_Grid(AdjMat, g, bs); 
		d1 = new drawComponents(AdjMat, g, bs);
		Color customColor = new Color(10,250,250);
		g.setColor(customColor);
		//Draw Here!
		d.drawLevel();
		//draw components
		for(int i = 1; i <= 64; i++) {
			ch.setoneDPosition(i);
			d1.drawCharacter(ch);
		}
		enemy Enemy = new horizontalEnemies(8);
		/*for(int i = 1; i <= 64; i++) {
			Enemy.setoneDPosition(i);
			d1.drawEnemy(Enemy);
		}*/
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