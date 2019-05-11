import javax.swing.*;


public class App {

    public static void main(String[] args) {

        Srodowisko srodowisko = new Srodowisko();
        JFrame frame = new JFrame("Gra w węża");


        frame.setSize(500, 530);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.addKeyListener(srodowisko);

        ExitSwitch es = new ExitSwitch(srodowisko);
        frame.addKeyListener(es);

        Timer timer = new Timer(600, srodowisko);
        timer.setRepeats(true);
        timer.start();

        Scena scena = new Scena();
        JTable tabela = new JTable(scena);
        scena.setTabela(tabela);
        scena.setSrodowisko(srodowisko);
        srodowisko.setScena(scena);
        tabela.addKeyListener(es);

        frame.add(tabela);
        frame.setVisible(true);
    }
}
