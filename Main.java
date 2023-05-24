
class Main { // client class
    // main method that runs the program
    public static void main(String[] args) {
      Music sfx = new Music();
      sfx.playBGM();
      // prints instructions 
      System.out.println("Player 1: W/S to move up/down");
      System.out.println("Player 2: ↑/↓ to move up/down");
      new GameFrame();
    }
  }