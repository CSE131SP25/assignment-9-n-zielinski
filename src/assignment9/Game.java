package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake snake;
	private Food food;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		snake = new Snake();
		food = new Food();
		
		
	}
	
	public void play() {
		while (true) {  
			if (!snake.isInbounds()) break;
			
			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			// System.out.println("Keypress: " + dir);
			
			 if (dir != -1) snake.changeDirection(dir);

	            snake.move();
	            if (snake.eatFood(food)) {
	                food = new Food();
	            }

	            updateDrawing();
	            StdDraw.pause(50);
	            
		}
		
		showGameOverScreen();
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
        snake.draw();
        food.draw();
        StdDraw.show();
	}
	
	private void showGameOverScreen() {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.text(0.5, 0.5, "Game Over");
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
