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
	private BufferStrategy bs;
	private Graphics g;
	
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
		System.out.println("HI in render");
		g = bs.getDrawGraphics();
		//Draw Here!
		int[][] AdjMat = makeLevel();
		draw_Grid d = new draw_Grid(AdjMat, g, bs) ;
		g.drawLine(200,200,250,200);
		//d.drawLevel();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 200, 200);
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		while(running){
			tick();
			render();
			running = false;
			System.out.println("HI in run");
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