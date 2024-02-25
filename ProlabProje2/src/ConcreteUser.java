import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ConcreteUser extends User {

    public void kullaniciPaneli(List<String> firmalar) {
        SwingUtilities.invokeLater(() -> {
            JFrame kullaniciPaneli = new JFrame("Kullanıcı Paneli");
            kullaniciPaneli.setSize(1200, 800);
            kullaniciPaneli.setLocationRelativeTo(null);
            kullaniciPaneli.setLayout(new GridLayout(7, 2));

            JComboBox<String> seferlerComboBox = new JComboBox<>();
            seferlerComboBox.addItem("Demiryolu: Istanbul - Kocaeli - Bilecik - Eskisehir - Ankara - Eskisehir - Bilecik - Kocaeli - Istanbul (gidiş-dönüş)");
            seferlerComboBox.addItem("Demiryolu: Istanbul - Kocaeli - Bilecik - Eskisehir - Konya - Eskisehir - Bilecik - Kocaeli - Istanbul (gidiş-dönüş)");
            seferlerComboBox.addItem("Karayolu: Istanbul - Kocaeli - Ankara - Kocaeli - Istanbul - Kocaeli - Ankara - Istanbul (gidiş-dönüş)");
            seferlerComboBox.addItem("Karayolu: Istanbul - Kocaeli - Eskisehir - Konya - Eskisehir - Kocaeli - Istanbul (gidiş-dönüş)");
            seferlerComboBox.addItem("Havayolu: Istanbul - Konya - Istanbul (gidiş-dönüş)");
            seferlerComboBox.addItem("Havayolu: Istanbul - Ankara - Istanbul (gidiş-dönüş)");

            JTextField tarihField = new JTextField(5);

            JComboBox<Integer> yolcuSayisiComboBox = new JComboBox<>();
            for (int i = 1; i <= 5; i++) {
                yolcuSayisiComboBox.addItem(i);
            }

            JButton biletBulButon = new JButton("Bilet Bul");

            biletBulButon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    kullaniciPaneli.dispose();
                    firmaPanelineGiris(firmalar);
                }
            });

            JPanel tarihPaneli = new JPanel();
            tarihPaneli.setLayout(new FlowLayout());

            String[] tarihler = {
                    "4 Aralık 2023",
                    "5 Aralık 2023",
                    "6 Aralık 2023",
                    "7 Aralık 2023",
                    "8 Aralık 2023",
                    "9 Aralık 2023",
                    "10 Aralık 2023"
            };

            for (String tarih : tarihler) {
                JButton tarihButon = new JButton(tarih);
                tarihPaneli.add(tarihButon);

                tarihButon.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        tarihField.setText(tarih);
                    }
                });
            }

            kullaniciPaneli.add(new JLabel("Sefer Seçimi:"));
            kullaniciPaneli.add(seferlerComboBox);
            kullaniciPaneli.add(new JLabel("Yolculuk Tarihi:"));
            kullaniciPaneli.add(tarihField);
            kullaniciPaneli.add(new JLabel("Yolcu Sayısı:"));
            kullaniciPaneli.add(yolcuSayisiComboBox);
            kullaniciPaneli.add(new JLabel("Tarihler:"));
            kullaniciPaneli.add(tarihPaneli);
            kullaniciPaneli.add(new JLabel(""));
            kullaniciPaneli.add(new JLabel(""));
            kullaniciPaneli.add(new JLabel(""));
            kullaniciPaneli.add(biletBulButon);

            kullaniciPaneli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            kullaniciPaneli.setResizable(false);
            kullaniciPaneli.setVisible(true);
        });
    }
}
