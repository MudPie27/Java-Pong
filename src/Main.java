package src;
class Main { // client class
    // main method that runs the program
    public static void main(String[] args) {
      SoundEffects sfx = new SoundEffects();
      sfx.playBGM();
      new GameFrame();
    }
  }