/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suveateş;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Duraklatma Menüsü
 * @author burak
 */
public class ESC extends JPanel {
    public JButton contious;
    public JButton restartButton;
    public JButton mainMenuButton;
    
    public ESC() {
        this.setLayout(null);
        this.setBackground(new Color(40, 40, 60));
        
        // Duraklatıldı başlığı
        JLabel pauseLabel = new JLabel("OYUN DURAKLATILDI", SwingConstants.CENTER);
        pauseLabel.setFont(new Font("Arial", Font.BOLD, 36));
        pauseLabel.setForeground(Color.WHITE);
        pauseLabel.setBounds(250, 150, 500, 50);
        this.add(pauseLabel);
        
        // Devam et butonu
        contious = new JButton("▶ DEVAM ET");
        contious.setFont(new Font("Arial", Font.BOLD, 20));
        contious.setBounds(375, 250, 250, 50);
        contious.setBackground(new Color(50, 150, 50));
        contious.setForeground(Color.WHITE);
        contious.setFocusPainted(false);
        this.add(contious);
        
        // Yeniden başlat butonu
        restartButton = new JButton("↻ YENİDEN BAŞLAT");
        restartButton.setFont(new Font("Arial", Font.BOLD, 20));
        restartButton.setBounds(375, 320, 250, 50);
        restartButton.setBackground(new Color(200, 150, 50));
        restartButton.setForeground(Color.WHITE);
        restartButton.setFocusPainted(false);
        this.add(restartButton);
        
        // Ana menü butonu
        mainMenuButton = new JButton("⌂ ANA MENÜ");
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        mainMenuButton.setBounds(375, 390, 250, 50);
        mainMenuButton.setBackground(new Color(150, 50, 50));
        mainMenuButton.setForeground(Color.WHITE);
        mainMenuButton.setFocusPainted(false);
        this.add(mainMenuButton);
        
        // Bilgi etiketi
        JLabel infoLabel = new JLabel("Devam etmek için butona tıklayın veya ESC tuşuna basın", SwingConstants.CENTER);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        infoLabel.setForeground(Color.LIGHT_GRAY);
        infoLabel.setBounds(250, 480, 500, 30);
        this.add(infoLabel);
    }
}
