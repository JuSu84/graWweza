public class WazDataPunkt {

    private int x;
    private int y;

    public boolean equals(WazDataPunkt b){
        return (this.x == b.x) && (this.y ==b.y);
    }

    public WazDataPunkt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lewo(){
        this.x--;
    }

    public void prawo(){
        this.x++;
    }

    public void gora(){
        this.y--;
    }

    public void dol(){
        this.y++;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
