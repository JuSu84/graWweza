import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ExitSwitch implements KeyListener {
  private KeyListener keyListener;

  public boolean isExit = false;

  public ExitSwitch(KeyListener k1){
      this.keyListener = k1;
  }


    @Override
    public void keyTyped(KeyEvent e) {
    this.keyListener.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.keyListener.keyPressed(e);
        if(e.getKeyCode() == KeyEvent.VK_Q){
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.keyListener.keyReleased(e);
    }
}
