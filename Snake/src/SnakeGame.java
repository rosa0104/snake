import java.awt.Point;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SnakeGame {
	
	//Konstanten delarieren
	private static final char MOVE_RIGHT_KEY = 'r';

	private static final char MOVE_LEFT_KEY = 'l';

	private static final char MOVE_DOWN_KEY = 't';

	private static final char MOVE_UP_KEY = 'h';
	
	//Felder deklarieren		
	private Point playerPosition;
	private Point snakePosition;
	private Set<Snake> alleSnake;
	private Set<Gold> alleGold;
	private Point doorPosition;
	private boolean spielLaeuft;
	
	private Scanner scan;
	

	//Konstruktor
	public SnakeGame(){
		//Felder intitialisieren (Anfangswerte zuweisen)
			playerPosition = new Point(10, 9);
			
			alleGold = initGold();
			alleSnake = initSnake(); 
			doorPosition = new Point(0,5);

			spielLaeuft = false;		
			scan = new Scanner(System.in);
	}

	private Set<Snake> initSnake() {
		HashSet<Snake> newSet = new HashSet<Snake>();
		Snake snake1 = new Snake(25,6);
		newSet.add(snake1);
		Snake snake2 = new Snake(30,1);
		newSet.add(snake2);
		return newSet;
	}

	private HashSet<Gold> initGold() {
		HashSet<Gold> newSet = new HashSet<Gold>();
		Gold gold1 = new Gold(6,6);
		newSet.add(gold1);
		Gold gold2 = new Gold(7,7);
		newSet.add(gold2);
		Gold gold3 = new Gold(9,7);
		newSet.add(gold3);
		return newSet;
	}
	
	public static void main( String[] args)	{
		//Deklariere Variable namens myGame vom Typ SnakeGame (Jede Variable hat einen Typ, das ist entweder ein primitiver Typ wie int oder eine Klasse
		SnakeGame myGame;
		
		//Erzeuge neues Objekt der Klasse SnakeGame und weise es myGame zu
		myGame = new SnakeGame();
		
		//rufe play()-Methode des neuen Objekts auf
		myGame.play();
	}

	private void play() {
		spielLaeuft = true;
		
		while(spielLaeuft){
				rasterMitFigurenZeichnen();
				spielerBewegen();		
				schlangenBewegen();		
				statusBestimmen();
		}
		
		scan.close();
	}

	private void statusBestimmen() {
		if (alleGoldGefunden() && playerPosition.equals(doorPosition)){
			System.out.println("Gewonnen!");
			spielLaeuft = false;
		}

		if (playerPosition.equals(snakePosition)){
			System.out.println("Die Schlange hat dich!");
			spielLaeuft = false;
		}
		
		for (Gold someGold: alleGold){
			if (playerPosition.equals(someGold.getPosition())){
				someGold.gefunden = true;
				someGold.setPosition(-1 , -1);
			};
		}
	}

	private boolean alleGoldGefunden() {
		for (Gold g: alleGold){
			if (g.gefunden == false){
				return false;
			}
		}
		return true;
	}

	private void schlangenBewegen() {
		//Schlangen bewegen sich in Richtung Spieler

		for (Snake snake: alleSnake){
			
		if (playerPosition.x < snake.getPosition().x){
				snake.getPosition().x--;
		} else if (playerPosition.x > snake.getPosition().x) {
				snake.getPosition().x++;
		}

		if (playerPosition.y < snake.getPosition().y){
				snake.getPosition().y--;
		} else if (playerPosition.y > snake.getPosition().y) {
				snake.getPosition().y++;
		}
		}
	}


	private void spielerBewegen() {
		//Konsoleneingabe und Spielerposition verändern	
		switch (scan.next().charAt(0)){
				case MOVE_UP_KEY: playerPosition.y = Math.max(0,  playerPosition.y -1); break;
				case MOVE_DOWN_KEY: playerPosition.y = Math.min(9,  playerPosition.y +1); break;
				case MOVE_LEFT_KEY: playerPosition.x = Math.max(0,  playerPosition.x -1); break;
				case MOVE_RIGHT_KEY: playerPosition.x = Math.min(39,  playerPosition.x +1); break;
		}
	}

	private void rasterMitFigurenZeichnen() {
		for (int y = 0; y < 10; y++){
				for (int x = 0; x < 40; x++){
						Point p = new Point (x,y);
						if (playerPosition.equals(p)) {
								System.out.print('&');
						} else if (snakePositions().contains(p)){
								System.out.print('s');
						} else if (goldPositions().contains(p)){
								System.out.print('$');
						} else if (doorPosition.equals(p)){
								System.out.print('#');
						} else {
								System.out.print('.');
						}
				}
			System.out.println();
		}
	}

	private Set<Point> goldPositions() {
		Set<Point> allPositions = new HashSet<Point>();
		for (Gold g: alleGold){
			allPositions.add(g.getPosition());
		}
		return allPositions;
	}
	
	private Set<Point> snakePositions() {
		Set<Point> allPositions = new HashSet<Point>();
		for (Snake s: alleSnake){
			allPositions.add(s.getPosition());
		}
		return allPositions;
	}

}
