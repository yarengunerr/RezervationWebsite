import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton; // JButton sınıfını kullanıyorsanız
import javax.swing.JOptionPane; // JOptionPane sınıfını kullanıyorsanız
import javax.swing.JTextField; // JTextField sınıfını kullanıyorsanız


public class Company extends User {
 
    public static Map<String, List<String>> FirmaSeferleri = new HashMap<>();
    
    public static List<String> Firmalar = new ArrayList<>();

    public static List<String> getFirmalar() {
        return Firmalar;
    }
    
    public static Map<String, String> FirmaKullanicilari = new HashMap<>();
    
    

    public static Map<String, String> getFirmaKullanicilari() {
        return FirmaKullanicilari;
    }
    
    public static Map<String, List<String>> FirmaAraclari = new HashMap<>();
    
   

    public static Map<String, List<String>> getFirmaAraclari() {
        return FirmaAraclari;
    }
    
    private static double hizmetBedeli = 1000.0;

   

    public static double getHizmetBedeli() {
        return hizmetBedeli;
    }

    public static void setHizmetBedeli(double yeniBedel) {
        hizmetBedeli = yeniBedel;
    }
  
    public static void firmaIciIslemler(String firmaAdi) {
    	
 	    
        JFrame firmaIciPaneli = new JFrame("Firma İçi İşlemler");
        firmaIciPaneli.setSize(400, 300);
        firmaIciPaneli.setLocationRelativeTo(null);
        firmaIciPaneli.setLayout(new GridLayout(2, 2));
        
        

        JOptionPane.showMessageDialog(null, "Hoş Geldiniz " + firmaAdi);
        JButton aracEkleButon = new JButton("Araç Ekle");
        JButton aracCikarButon = new JButton("Araç Çıkar");
        JButton seferEkleButon = new JButton("Sefer Ekle");
        JButton seferCikarButon = new JButton("Sefer Çıkar");
        JButton karHesabiButon = new JButton("Günlük Kar Hesabı");

        firmaIciPaneli.add(aracEkleButon);
        firmaIciPaneli.add(aracCikarButon);
        firmaIciPaneli.add(seferEkleButon);
        firmaIciPaneli.add(seferCikarButon);
        firmaIciPaneli.add(karHesabiButon);

        aracEkleButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aracEklePaneli(firmaAdi);
            }
        });

        aracCikarButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aracCikarPaneli(firmaAdi);
            }
        });
        seferEkleButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seferEklePaneli(firmaAdi);
            }
        });

        seferCikarButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seferCikarPaneli(firmaAdi);
            }
        });

        karHesabiButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gunlukKarHesabiYap(firmaAdi);
            }
        });

        firmaIciPaneli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        firmaIciPaneli.setResizable(false);
        firmaIciPaneli.setVisible(true);
    }

    private static void aracEklePaneli(String firmaAdi) {
    	 JFrame aracEklePaneli = new JFrame("Araç Ekle");
         aracEklePaneli.setSize(300, 200);
         aracEklePaneli.setLocationRelativeTo(null);
         aracEklePaneli.setLayout(new GridLayout(5, 2));

         JTextField aracAdiField = new JTextField(10);
         JTextField aracYakitField = new JTextField(10);
         JTextField aracIDField = new JTextField(10);
         JTextField aracKapasiteField = new JTextField(10);
         JButton ekleButon = new JButton("Ekle");

         aracEklePaneli.add(new JLabel("Araç Adı:"));
         aracEklePaneli.add(aracAdiField);
         aracEklePaneli.add(new JLabel("Araç Yakıt Türü:"));
         aracEklePaneli.add(aracYakitField);
         aracEklePaneli.add(new JLabel("Araç ID:"));
         aracEklePaneli.add(aracIDField);
         aracEklePaneli.add(new JLabel("Araç Kapasitesi:"));
         aracEklePaneli.add(aracKapasiteField);
         aracEklePaneli.add(new JLabel(""));
         aracEklePaneli.add(ekleButon);

         ekleButon.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 String aracAdi = aracAdiField.getText();
                 String aracYakit = aracYakitField.getText();
                 String aracID = aracIDField.getText();
                 String aracKapasite = aracKapasiteField.getText();

                 if (!aracAdi.isEmpty() && !aracYakit.isEmpty() && !aracID.isEmpty() && !aracKapasite.isEmpty()) {
                     FirmaAraclari.putIfAbsent(firmaAdi, new ArrayList<>());
                     List<String> araclar = new ArrayList<>(FirmaAraclari.get(firmaAdi));
                     araclar.add(aracAdi + " - " + aracYakit + " - " + aracID + " - " + aracKapasite);
                     FirmaAraclari.put(firmaAdi, araclar);

                     JOptionPane.showMessageDialog(null, "Araç başarıyla eklendi!");
                     aracEklePaneli.dispose();
                 } else {
                     JOptionPane.showMessageDialog(null, "Lütfen geçerli bilgileri girin.");
                 }
             }
         });

         aracEklePaneli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         aracEklePaneli.setResizable(false);
         aracEklePaneli.setVisible(true);
     
    }

    private static void aracCikarPaneli(String firmaAdi) {
   	 JFrame aracCikarPaneli = new JFrame("Araç Çıkar");
        aracCikarPaneli.setSize(300, 200);
        aracCikarPaneli.setLocationRelativeTo(null);
        aracCikarPaneli.setLayout(new BorderLayout());

        JPanel aracPaneli = new JPanel();
        aracPaneli.setLayout(new BoxLayout(aracPaneli, BoxLayout.Y_AXIS));

        aracPaneli.add(new JLabel("Araçlar:"));
        
        List<String> firmaAraclar = FirmaAraclari.getOrDefault(firmaAdi, new ArrayList<>());
        List<String> ilkPencereAraclar = ilkPencere.getFirmaAraclari().getOrDefault(firmaAdi, new ArrayList<>());

        List<String> birlesikAraclar = new ArrayList<>(firmaAraclar);
        birlesikAraclar.addAll(ilkPencereAraclar);

        for (String arac : birlesikAraclar) {
            JCheckBox aracCheckBox = new JCheckBox(arac);
            aracPaneli.add(aracCheckBox);
        }


        JScrollPane scrollPane = new JScrollPane(aracPaneli);
        aracCikarPaneli.add(scrollPane, BorderLayout.CENTER);

        JButton cikarButon = new JButton("Seçilenleri Çıkar");
        aracCikarPaneli.add(cikarButon, BorderLayout.SOUTH);

        cikarButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Component component : aracPaneli.getComponents()) {
                    if (component instanceof JCheckBox) {
                        JCheckBox checkBox = (JCheckBox) component;
                        if (checkBox.isSelected()) {
                       	 birlesikAraclar.remove(checkBox.getText());
                        }
                    }
                }
                FirmaAraclari.put(firmaAdi, birlesikAraclar);
                JOptionPane.showMessageDialog(null, "Seçilen araçlar başarıyla çıkarıldı!");
                aracCikarPaneli.dispose();
            }
        });

        aracCikarPaneli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        aracCikarPaneli.setResizable(false);
        aracCikarPaneli.setVisible(true);
   }

    private static void seferEklePaneli(String firmaAdi) {
    	JFrame seferEklePaneli = new JFrame("Sefer Ekle");
        seferEklePaneli.setSize(300, 200);
        seferEklePaneli.setLocationRelativeTo(null);
        seferEklePaneli.setLayout(new GridLayout(4, 2));

        JTextField seferAdiField = new JTextField(10);
        JTextField kalkisYeriField = new JTextField(10);
        JTextField varisYeriField = new JTextField(10);
        JButton ekleButon = new JButton("Ekle");

        seferEklePaneli.add(new JLabel("Sefer Adı:"));
        seferEklePaneli.add(seferAdiField);
        seferEklePaneli.add(new JLabel("Gidis Güzergahı:"));
        seferEklePaneli.add(kalkisYeriField);
        seferEklePaneli.add(new JLabel("Dönüş Güzergahı:"));
        seferEklePaneli.add(varisYeriField);
        seferEklePaneli.add(new JLabel(""));
        seferEklePaneli.add(ekleButon);

        ekleButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String seferAdi = seferAdiField.getText();
                String kalkisYeri = kalkisYeriField.getText();
                String varisYeri = varisYeriField.getText();

                if (!seferAdi.isEmpty() && !kalkisYeri.isEmpty() && !varisYeri.isEmpty()) {
                    List<String> seferler = new ArrayList<>(FirmaSeferleri.getOrDefault(firmaAdi, new ArrayList<>()));
                    seferler.add(seferAdi + " - " + kalkisYeri + " - " + varisYeri);
                    FirmaSeferleri.put(firmaAdi, seferler);

                    JOptionPane.showMessageDialog(null, "Sefer başarıyla eklendi!");
                    seferEklePaneli.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Lütfen geçerli bilgileri girin.");
                }
            }
        });


        seferEklePaneli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        seferEklePaneli.setResizable(false);
        seferEklePaneli.setVisible(true);
    }

    private static void seferCikarPaneli(String firmaAdi) {
   	 JFrame seferCikarPaneli = new JFrame("Sefer Çıkar");
        seferCikarPaneli.setSize(300, 200);
        seferCikarPaneli.setLocationRelativeTo(null);
        seferCikarPaneli.setLayout(new BorderLayout());

        JPanel seferPaneli = new JPanel();
        seferPaneli.setLayout(new BoxLayout(seferPaneli, BoxLayout.Y_AXIS));

        seferPaneli.add(new JLabel("Seferler:"));
        
        List<String> seferler = new ArrayList<>();

        if (FirmaSeferleri.containsKey(firmaAdi)) {
            seferler.addAll(FirmaSeferleri.get(firmaAdi));
        }

        if (ilkPencere.getFirmaSeferleri().containsKey(firmaAdi)) {
            seferler.addAll(ilkPencere.getFirmaSeferleri().get(firmaAdi));
        }

        
        
        for (String sefer : seferler) {
            JCheckBox seferCheckBox = new JCheckBox(sefer);
            seferPaneli.add(seferCheckBox);
        }

        JScrollPane scrollPane = new JScrollPane(seferPaneli);
        seferCikarPaneli.add(scrollPane, BorderLayout.CENTER);

        JButton cikarButon = new JButton("Seçilenleri Çıkar");
        seferCikarPaneli.add(cikarButon, BorderLayout.SOUTH);

        cikarButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Component component : seferPaneli.getComponents()) {
                    if (component instanceof JCheckBox) {
                        JCheckBox checkBox = (JCheckBox) component;
                        if (checkBox.isSelected()) {
                            seferler.remove(checkBox.getText());
                        }
                    }
                }
                FirmaSeferleri.put(firmaAdi, seferler);
                JOptionPane.showMessageDialog(null, "Seçilen seferler başarıyla çıkarıldı!");
                seferCikarPaneli.dispose();
            }
        });

        seferCikarPaneli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        seferCikarPaneli.setResizable(false);
        seferCikarPaneli.setVisible(true);
   }
    
    private static void gunlukKarHesabiYap(String firmaAdi) {
    
        JOptionPane.showMessageDialog(null, "Günlük Kar Hesabı yapılıyor. Firma Adı: " + firmaAdi);}
    
    public void firmaPanelineGiris(List<String> firmalar) {


        JFrame firmaGirisPaneli = new JFrame("Firma Girişi");
        firmaGirisPaneli.setSize(300, 200);
        firmaGirisPaneli.setLocationRelativeTo(null);
        firmaGirisPaneli.setLayout(new GridLayout(4, 2));

        JTextField kullaniciAdiField = new JTextField(10);
        JPasswordField sifreField = new JPasswordField(10);
        JButton girisButon = new JButton("Giriş");

        firmaGirisPaneli.add(new JLabel("Kullanıcı Adı:"));
        firmaGirisPaneli.add(kullaniciAdiField);
        firmaGirisPaneli.add(new JLabel("Şifre:"));
        firmaGirisPaneli.add(sifreField);
        firmaGirisPaneli.add(new JLabel(""));
        firmaGirisPaneli.add(girisButon);

        girisButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kullaniciAdi = kullaniciAdiField.getText();
                String sifre = new String(sifreField.getPassword());

                if (ilkPencere.getFirmaKullanicilari().containsValue(kullaniciAdi + ":" + sifre)) {
                    JOptionPane.showMessageDialog(null, "Giriş başarılı!");

                    firmaIciIslemler(kullaniciAdi);
                    firmaGirisPaneli.dispose();
                  
                } else {
                    JOptionPane.showMessageDialog(null, "Hatalı Kullanıcı Adı veya Parola girdiniz!");
                }
            }
        });

        firmaGirisPaneli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        firmaGirisPaneli.setResizable(false);
        firmaGirisPaneli.setVisible(true);
    }
    public void kullaniciPaneli(List<String> firmalar) {
        // User sınıfından alınan soyut metodu implement
    }
}