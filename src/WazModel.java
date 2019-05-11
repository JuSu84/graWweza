import java.util.LinkedList;
import java.util.Random;

public class WazModel {
    public LinkedList<WazDataPunkt> waz = new LinkedList<WazDataPunkt>();
    private Kierunek kierunek;
    private Srodowisko srodowisko;

    public void setSrodowisko(Srodowisko srodowisko) {
        this.srodowisko = srodowisko;
    }

    public boolean czyPunktJestWWezu(WazDataPunkt a) {
        for (int i = 0; i < this.waz.size(); i++) {
            if (a.equals(this.waz.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void idzNaprzod(boolean czyZjadlPokarm){
        WazDataPunkt nowa_glowa = this.pobierzKandydat();
        if(!czyZjadlPokarm){
            this.waz.removeLast();
        }
        this.waz.addFirst(nowa_glowa);
    }

    public WazDataPunkt pobierzKandydat() {
        WazDataPunkt glowa = this.waz.getFirst();

        if (kierunek == Kierunek.LEWO) {
            glowa.lewo();
        }
        if (kierunek == Kierunek.PRAWO) {
            glowa.prawo();
        }
        if (kierunek == Kierunek.GORA) {
            glowa.gora();
        }
        if (kierunek == Kierunek.DOL) {
            glowa.dol();
        }
        return glowa;
    }

    public Srodowisko getSrodowisko() {
        return srodowisko;
    }

    public WazModel(int x, int y, Kierunek kierunek) {
        WazDataPunkt glow_weza = new WazDataPunkt(x, y);
        this.waz.add(glow_weza);
        this.kierunek = kierunek;
    }

    public Kierunek getKierunek() {
        return kierunek;
    }

    public void setKierunek(Kierunek kierunek) {
        this.kierunek = kierunek;
    }
}
