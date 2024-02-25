import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ilkPencere {

	 private static Map<String, List<String>> FirmaSeferleri = new HashMap<>();
	 
	 public static Map<String, List<String>> getFirmaSeferleri() {
         return FirmaSeferleri;
     }
	    
	    private static List<String> Firmalar = new ArrayList<>();

	    public static List<String> getFirmalar() {
	        return Firmalar;
	    }
	    
	    private static Map<String, String> FirmaKullanicilari = new HashMap<>();
	    
	    

	    public static Map<String, String> getFirmaKullanicilari() {
	        return FirmaKullanicilari;
	    }
	    
	    private static Map<String, List<String>> FirmaAraclari = new HashMap<>();
	    
	 
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
	    
	public static void main(String[] args) {
		
		
	    FirmaKullanicilari.put("A", "A:123");
	    FirmaKullanicilari.put("B", "B:123");
	    FirmaKullanicilari.put("C", "C:123");
	    FirmaKullanicilari.put("D", "D:123");
	    FirmaKullanicilari.put("F", "F:123");

	    Firmalar.add("A");
	    Firmalar.add("B");
	    Firmalar.add("C");
	    Firmalar.add("D");
	    Firmalar.add("F");

	    FirmaAraclari.put("A", List.of("Otobüs1 - Benzin - 123id - 20", "Otobüs2 - Benzin - 123id - 15"));
	    FirmaAraclari.put("B", List.of("Otobüs1 - Motorin - 123id - 15 ", "Otobüs2 - Motorin - 123id - 20"));
	    FirmaAraclari.put("C", List.of("Otobüs1 - Motorin - 123id - 20", "Uçak1 - Gaz - 123id - 30", "Uçak2 - Gaz - 123id - 30"));
	    FirmaAraclari.put("D", List.of("Tren1 - Elektrik - 123id - 25", "Tren2 - Elektrik - 123id - 25", "Tren3 - Elektrik - 123id - 25"));
	    FirmaAraclari.put("F", List.of("Uçak1 - Gaz - 123id - 30", "Uçak2 - Gaz - 123id - 30"));

	    FirmaSeferleri.put("A", List.of("Istanbul - Kocaeli - Ankara - Kocaeli - Istanbul - Kocaeli\r\n"
	            + "- Ankara - Kocaeli - Istanbul", "Istanbul - Kocaeli - Ankara - Kocaeli - Istanbul - Kocaeli\r\n"
	            + "- Ankara - Kocaeli - Istanbul"));
	    FirmaSeferleri.put("B", List.of("Istanbul - Kocaeli - Ankara - 6+Kocaeli - Istanbul - Kocaeli\\r\\n\"\r\n"
        		+ "        		+ \"- Ankara - Kocaeli - Istanbul\",\" Istanbul - Kocaeli - Eskisehir - Konya - Eskisehir - Kocaeli\\r\\n\"\r\n"
        		+ "        				+ \"-\\r\\n\"\r\n"
        		+ "        				+ \"IStanbul\""));
        FirmaSeferleri.put("C", List.of("Karayolu: Istanbul - Kocaeli - Eskisehir - Konya - Eskisehir - Kocaeli\r\n"
        		+ "-\r\n"
        		+ "IStanbul","Istanbul - Konya - Istanbul","Istanbul - Konya - Istanbul"));
        FirmaSeferleri.put("D", List.of(" Istanbul - Kocaeli - Bilecik - Eskisehir - Ankara - Eskisehir\r\n"
        		+ "- Bilecik - Kocaeli - Istanbu"," Istanbul - Kocaeli - Bilecik - Eskisehir - Konya - Eskisehir\r\n"
        				+ "- Bilecik - Kocaeli - Istanbul"," Istanbul - Kocaeli - Bilecik - Eskisehir - Konya - Eskisehir\r\n"
        						+ "- Bilecik - Kocaeli - Istanbul"));
        FirmaSeferleri.put("F", List.of("Istanbul - Ankara - Istanbul","Istanbul - Ankara - Istanbul"));


        SwingUtilities.invokeLater(() -> {
            JFrame ilkPencere = new JFrame("REZERVASYON SİSTEMİ");
            ilkPencere.setSize(500, 600);
            ilkPencere.setLocation(100, 200);
            ilkPencere.getContentPane().setLayout(new FlowLayout());

            JButton buton1 = new JButton("Admin");
            ilkPencere.getContentPane().add(buton1);


            buton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JPanel adminPaneli = new JPanel();
                    JTextField kullaniciAdiField = new JTextField(10);
                    JPasswordField parolaField = new JPasswordField(10);

                    adminPaneli.add(new JLabel("Kullanıcı Adı:"));
                    adminPaneli.add(kullaniciAdiField);
                    adminPaneli.add(new JLabel("Parola:"));
                    adminPaneli.add(parolaField);

                    int result = JOptionPane.showConfirmDialog(null, adminPaneli, "Giriş", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        String kullaniciAdi = kullaniciAdiField.getText();
                        String parola = new String(parolaField.getPassword());

                        if (kullaniciAdi.equals("fındıkelması") && parola.equals("2805")) {
                            Admin.acilacakAdminPaneli();
                        } else {
                            JOptionPane.showMessageDialog(null, "Hatalı Kullanıcı Adı veya Parola girdiniz! ");
                        }
                    }
                }
            });

            JButton buton2 = new JButton("Bilet Bul");
            ilkPencere.getContentPane().add(buton2);

            buton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	User user = new ConcreteUser();
                    user.kullaniciPaneli(Firmalar); 
                }
            });

            JButton buton3 = new JButton("Firma");
            ilkPencere.getContentPane().add(buton3);

            buton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!Firmalar.isEmpty()) {
                        Company company = new Company();
                        company.firmaPanelineGiris(Firmalar);
                    } else {
                        JOptionPane.showMessageDialog(null, "Firma listesi boş!");
                    }
                }
            });
            ilkPencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ilkPencere.setResizable(false);
            ilkPencere.setVisible(true);
        });
    }
}
