package components;

public class Launcher {
	public static int windowSize = 800;
    public static void main(String[] args){
        Game game = new Game("Title!", 800, 800);
        game.start();
        game.stop();
    }

}
