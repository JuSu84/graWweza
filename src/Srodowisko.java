import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Srodowisko implements ActionListener, KeyListener {

    public WazModel waz;
    public static final int SZEROKOSC_PLANSZY = 30;
    public static final int WYSOKOSC_PLANSZY = 30;

    private WazDataPunkt pokarm;

    public WazDataPunkt getPokarm() {
        return pokarm;
    }

    public void actionPerformed(ActionEvent e) {
        if (this.czyWazJestSkuty()) {
            System.exit(0);
        }
        boolean czy_jadl = this.czyWazZjadlPokarm();
        this.waz.idzNaprzod(czy_jadl);

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (this.waz.getKierunek() != Kierunek.PRAWO)
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                this.waz.setKierunek(Kierunek.LEWO);
            }
        if (this.waz.getKierunek() != Kierunek.LEWO)
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                this.waz.setKierunek(Kierunek.PRAWO);
            }
        if (this.waz.getKierunek() != Kierunek.DOL)
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                this.waz.setKierunek(Kierunek.GORA);
            }
        if (this.waz.getKierunek() != Kierunek.GORA)
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                this.waz.setKierunek(Kierunek.DOL);
            }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Srodowisko() {
        this.waz = new WazModel(10, 20, Kierunek.LEWO);
        this.waz.setSrodowisko(this);
        this.pokarm = this.generujKandydata();
    }

    private boolean czyWazJestSkuty() {
        WazDataPunkt nowa_glowa = this.waz.pobierzKandydat();
        if (nowa_glowa.getX() <= 0) {
            return false;
        }
        if (Srodowisko.SZEROKOSC_PLANSZY - 1 >= nowa_glowa.getX()) {
            return false;
        }
        if (nowa_glowa.getY() <= 0) {
            return false;
        }
        if (Srodowisko.WYSOKOSC_PLANSZY - 1 >= nowa_glowa.getY()) {
            return false;
        }
        if (this.waz.czyPunktJestWWezu(nowa_glowa)) {
            return false;
        }
        return true;
    }

    private WazDataPunkt generujKandydataBezSprawdzania() {
        Random random = new Random();
        int x = random.nextInt(this.SZEROKOSC_PLANSZY) + 1 % this.SZEROKOSC_PLANSZY - 1;
        int y = random.nextInt(this.WYSOKOSC_PLANSZY) + 1 % this.WYSOKOSC_PLANSZY - 1;
        return new WazDataPunkt(x, y);
    }

    private boolean czyWazZjadlPokarm() {
        return this.pokarm.equals(this.waz.pobierzKandydat());
    }

    private WazDataPunkt generujKandydata() {
        WazDataPunkt datapunkt = this.generujKandydataBezSprawdzania();
        while (this.waz.czyPunktJestWWezu(datapunkt)) {
            datapunkt = this.generujKandydataBezSprawdzania();
        }
        return datapunkt;
    }

}
