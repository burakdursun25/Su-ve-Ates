/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suveateş;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 * Başlangıç Menüsü
 * @author burak
 */
public class Starting_Menu extends JPanel {
    public JButton start;
    public JLabel label;
    public JLabel subtitle;
    public JLabel controlsLabel;

    public Starting_Menu() {
        this.setLayout(null);
        this.setBackground(new Color(30, 30, 50));
        
        // Ana başlık
        label = new JLabel("SU VE ATEŞ", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 48));
        label.setForeground(Color.WHITE);
        label.setBounds(250, 100, 500, 60);
        this.add(label);
        
        // Alt başlık
        subtitle = new JLabel("Platform Macera Oyunu", SwingConstants.CENTER);
        subtitle.setFont(new Font("Arial", Font.ITALIC, 20));
        subtitle.setForeground(new Color(150, 150, 200));
        subtitle.setBounds(250, 160, 500, 30);
        this.add(subtitle);
        
        // Su karakteri göstergesi
        JLabel waterIcon = new JLabel("● SU", SwingConstants.CENTER);
        waterIcon.setFont(new Font("Arial", Font.BOLD, 24));
        waterIcon.setForeground(Color.BLUE);
        waterIcon.setBounds(300, 220, 150, 40);
        this.add(waterIcon);
        
        // Ateş karakteri göstergesi
        JLabel fireIcon = new JLabel("● ATEŞ", SwingConstants.CENTER);
        fireIcon.setFont(new Font("Arial", Font.BOLD, 24));
        fireIcon.setForeground(Color.RED);
        fireIcon.setBounds(550, 220, 150, 40);
        this.add(fireIcon);
        
        // Başlat butonu
        start = new JButton("🎮 OYNA");
        start.setFont(new Font("Arial", Font.BOLD, 28));
        start.setBounds(375, 300, 250, 60);
        start.setBackground(new Color(50, 150, 50));
        start.setForeground(Color.WHITE);
        start.setFocusPainted(false);
        this.add(start);
        
        // Kontrol talimatları
        JLabel controlTitle = new JLabel("KONTROLLER", SwingConstants.CENTER);
        controlTitle.setFont(new Font("Arial", Font.BOLD, 18));
        controlTitle.setForeground(Color.WHITE);
        controlTitle.setBounds(350, 400, 300, 25);
        this.add(controlTitle);
        
        JLabel waterControls = new JLabel("Su: W A D (Zıpla, Sol, Sağ)", SwingConstants.CENTER);
        waterControls.setFont(new Font("Arial", Font.PLAIN, 14));
        waterControls.setForeground(new Color(100, 150, 255));
        waterControls.setBounds(350, 430, 300, 20);
        this.add(waterControls);
        
        JLabel fireControls = new JLabel("Ateş: ↑ ← → (Zıpla, Sol, Sağ)", SwingConstants.CENTER);
        fireControls.setFont(new Font("Arial", Font.PLAIN, 14));
        fireControls.setForeground(new Color(255, 150, 100));
        fireControls.setBounds(350, 455, 300, 20);
        this.add(fireControls);
        
        JLabel otherControls = new JLabel("ESC: Duraklat | R: Yeniden Başlat | ENTER: Sonraki Bölüm", SwingConstants.CENTER);
        otherControls.setFont(new Font("Arial", Font.PLAIN, 12));
        otherControls.setForeground(Color.LIGHT_GRAY);
        otherControls.setBounds(250, 485, 500, 20);
        this.add(otherControls);
        
        // Oyun açıklaması
        JLabel gameInfo = new JLabel("<html><center>İki karakteri kontrol ederek her bölümü tamamla!<br>Su göle, Ateş lavlara girebilir. Tersine dokunmak ölüm demek!</center></html>", SwingConstants.CENTER);
        gameInfo.setFont(new Font("Arial", Font.PLAIN, 13));
        gameInfo.setForeground(new Color(180, 180, 180));
        gameInfo.setBounds(200, 530, 600, 50);
        this.add(gameInfo);
        
        // Bölüm sayısı
        JLabel levelInfo = new JLabel("10 Zorlu Bölüm!", SwingConstants.CENTER);
        levelInfo.setFont(new Font("Arial", Font.BOLD, 16));
        levelInfo.setForeground(new Color(255, 215, 0));
        levelInfo.setBounds(350, 590, 300, 25);
        this.add(levelInfo);
    }
}
