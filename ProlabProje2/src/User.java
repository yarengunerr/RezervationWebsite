import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


interface ILoginable {
    void login(String kullaniciAdi, String sifre);
}

public abstract class User implements ILoginable {

    public abstract void kullaniciPaneli(List<String> firmalar);

    public void firmaPanelineGiris(List<String> firmalar) {
        JFrame firmaPenceresi = new JFrame("Firma Paneli");
        firmaPenceresi.setSize(600, 400);
        firmaPenceresi.setLocationRelativeTo(null);
        firmaPenceresi.setLayout(new GridLayout(2, 1));

        JComboBox<String> firmaComboBox = new JComboBox<>(firmalar.toArray(new String[0]));

        JButton firmaSecButon = new JButton("Firma Seç");
        firmaSecButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String secilenFirma = (String) firmaComboBox.getSelectedItem();
                if (secilenFirma != null) {
                    System.out.println("Seçilen Firma: " + secilenFirma);
                }
                firmaPenceresi.dispose();
                JOptionPane.showMessageDialog(null, "Biletler Aranıyor...");
            }
        });

        firmaPenceresi.add(firmaComboBox);
        firmaPenceresi.add(firmaSecButon);

        firmaPenceresi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        firmaPenceresi.setResizable(false);
        firmaPenceresi.setVisible(true);
    }
    public void login(String kullaniciAdi, String sifre) {
    	
    }
}
