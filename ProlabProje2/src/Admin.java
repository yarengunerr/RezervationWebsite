import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

public class Admin extends User {

    private static JFrame adminPaneli;

    public static void acilacakAdminPaneli() {
        adminPaneli = new JFrame("Admin Paneli");
        adminPaneli.setSize(400, 300);
        adminPaneli.setLocationRelativeTo(null);
        adminPaneli.setLayout(new GridLayout(2, 2));

        JOptionPane.showMessageDialog(null, "Hoş Geldiniz Yaren ve Selin");
        JButton firmaButon = new JButton("Firmaları Görüntüle");
        JButton yeniKayitButon = new JButton("Yeni Kayıt");
        JButton kayitSilmeButon = new JButton("Kayıt Silme");
        JButton hizmetBedeliButon = new JButton("Hizmet Bedeli");

        adminPaneli.add(firmaButon);
        adminPaneli.add(yeniKayitButon);
        adminPaneli.add(kayitSilmeButon);
        adminPaneli.add(hizmetBedeliButon);

        firmaButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firmalariGoruntule();
            }
        });

        yeniKayitButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                yeniKayitPaneli();
            }
        });

        kayitSilmeButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kayitSilmePaneli();
            }
        });

        hizmetBedeliButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hizmetBedeliPaneli();
            }
        });

        adminPaneli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminPaneli.setResizable(false);
        adminPaneli.setVisible(true);
    }

    private static void firmalariGoruntule() {
        JFrame firmaPaneli = new JFrame("Firmalar");
        firmaPaneli.setSize(300, 200);
        firmaPaneli.setLocationRelativeTo(null);
        firmaPaneli.setLayout(new BorderLayout());

        List<String> firmalar = ilkPencere.getFirmalar();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String firma : firmalar) {
            listModel.addElement(firma);
        }

        JList<String> firmaListesi = new JList<>(listModel);
        firmaListesi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        firmaListesi.setVisibleRowCount(5);

        JScrollPane scrollPane = new JScrollPane(firmaListesi);

        firmaPaneli.add(scrollPane, BorderLayout.CENTER);

        firmaListesi.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    firmaPaneli.dispose();
                }
            }
        });

        firmaPaneli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        firmaPaneli.setResizable(false);
        firmaPaneli.setVisible(true);
    }

    private static void yeniKayitPaneli() {
        JFrame yeniKayitPaneli = new JFrame("Yeni Kayıt Ekle");
        yeniKayitPaneli.setSize(300, 200);
        yeniKayitPaneli.setLocationRelativeTo(null);
        yeniKayitPaneli.setLayout(new GridLayout(5, 2));

        JTextField firmaAdiField = new JTextField(10);
        JTextField kullaniciAdiField = new JTextField(10);
        JPasswordField sifreField = new JPasswordField(10);
        JButton kaydetButon = new JButton("Kaydet");

        yeniKayitPaneli.add(new JLabel("Firma Adı:"));
        yeniKayitPaneli.add(firmaAdiField);
        yeniKayitPaneli.add(new JLabel("Kullanıcı Adı:"));
        yeniKayitPaneli.add(kullaniciAdiField);
        yeniKayitPaneli.add(new JLabel("Şifre:"));
        yeniKayitPaneli.add(sifreField);
        yeniKayitPaneli.add(new JLabel(""));
        yeniKayitPaneli.add(kaydetButon);

        kaydetButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firmaAdi = firmaAdiField.getText();
                String kullaniciAdi = kullaniciAdiField.getText();
                String sifre = new String(sifreField.getPassword());

                if (!firmaAdi.isEmpty() && !kullaniciAdi.isEmpty() && !sifre.isEmpty()) {
                    ilkPencere.getFirmalar().add(firmaAdi);
                    ilkPencere.getFirmaKullanicilari().put(firmaAdi, kullaniciAdi + ":" + sifre);
                    ilkPencere.getFirmaAraclari().put(firmaAdi, new ArrayList<>()); // Her firma için bir araç listesi oluştur

                    firmalariGoruntule();

                    System.out.println("Firma: " + firmaAdi + ", Kullanıcı Adı: " + kullaniciAdi + ", Şifre: " + sifre);

                    JOptionPane.showMessageDialog(null, "Firma başarıyla eklendi!");
                    yeniKayitPaneli.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Lütfen geçerli bilgileri girin.");
                }
            }
        });

        yeniKayitPaneli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        yeniKayitPaneli.setResizable(false);
        yeniKayitPaneli.setVisible(true);
    }

    private static void kayitSilmePaneli() {
        JFrame kayitSilmePaneli = new JFrame("Kayıt Sil");
        kayitSilmePaneli.setSize(300, 200);
        kayitSilmePaneli.setLocationRelativeTo(null);
        kayitSilmePaneli.setLayout(new BorderLayout());

        JPanel firmaPaneli = new JPanel();
        firmaPaneli.setLayout(new BoxLayout(firmaPaneli, BoxLayout.Y_AXIS));

        firmaPaneli.add(new JLabel("Firmalar:"));

        for (String firma : ilkPencere.getFirmalar()) {
            JCheckBox firmaCheckBox = new JCheckBox(firma);
            firmaPaneli.add(firmaCheckBox);
        }

        JScrollPane scrollPane = new JScrollPane(firmaPaneli);
        kayitSilmePaneli.add(scrollPane, BorderLayout.CENTER);

        JButton silButon = new JButton("Seçilenleri Sil");
        kayitSilmePaneli.add(silButon, BorderLayout.SOUTH);

        silButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Component component : firmaPaneli.getComponents()) {
                    if (component instanceof JCheckBox) {
                        JCheckBox checkBox = (JCheckBox) component;
                        if (checkBox.isSelected()) {
                            ilkPencere.getFirmalar().remove(checkBox.getText());
                            ilkPencere.getFirmaKullanicilari().remove(checkBox.getText());
                            ilkPencere.getFirmaAraclari().remove(checkBox.getText());
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Seçilen firmalar başarıyla silindi!");
                kayitSilmePaneli.dispose();
            }
        });

        kayitSilmePaneli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        kayitSilmePaneli.setResizable(false);
        kayitSilmePaneli.setVisible(true);
    }

    private static void hizmetBedeliPaneli() {
        JFrame hizmetBedeliPaneli = new JFrame("Hizmet Bedeli");
        hizmetBedeliPaneli.setSize(300, 150);
        hizmetBedeliPaneli.setLocationRelativeTo(null);
        hizmetBedeliPaneli.setLayout(new GridLayout(3, 2));

        JTextField mevcutBedelField = new JTextField(String.format("%.2f", ilkPencere.getHizmetBedeli()));
        JTextField yeniBedelField = new JTextField(10);
        JButton kaydetButon = new JButton("Kaydet");

        hizmetBedeliPaneli.add(new JLabel("Mevcut Hizmet Bedeli:"));
        hizmetBedeliPaneli.add(mevcutBedelField);
        hizmetBedeliPaneli.add(new JLabel("Yeni Hizmet Bedeli:"));
        hizmetBedeliPaneli.add(yeniBedelField);
        hizmetBedeliPaneli.add(new JLabel(""));
        hizmetBedeliPaneli.add(kaydetButon);

        kaydetButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double yeniBedel = Double.parseDouble(yeniBedelField.getText());
                    ilkPencere.setHizmetBedeli(yeniBedel);
                    mevcutBedelField.setText(String.format("%.2f", ilkPencere.getHizmetBedeli()));
                    JOptionPane.showMessageDialog(null, "Hizmet bedeli başarıyla güncellendi!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Geçerli bir sayı girin.");
                }
            }
        });

        hizmetBedeliPaneli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hizmetBedeliPaneli.setResizable(false);
        hizmetBedeliPaneli.setVisible(true);
    }
    
    public void kullaniciPaneli(List<String> firmalar) {
        // User sınıfından alınan soyut metodu implement 
    }
}
