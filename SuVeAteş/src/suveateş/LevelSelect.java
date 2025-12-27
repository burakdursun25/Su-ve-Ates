package suveateş;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 * Bölüm seçme ekranı
 * @author burak
 */
public class LevelSelect extends JPanel {
    public JButton[] levelButtons;
    public JButton backButton;
    public JLabel titleLabel;
    private int selectedLevel = 1;
    
    public LevelSelect() {
        this.setLayout(null);
        this.setBackground(new Color(40, 40, 60));
        
        // Başlık
        titleLabel = new JLabel("BÖLÜM SEÇ", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(200, 30, 400, 50);
        this.add(titleLabel);
        
        // Bölüm butonları
        levelButtons = new JButton[10];
        String[] levelNames = {
            "1 - Başlangıç",
            "2 - Merdiven", 
            "3 - Zigzag",
            "4 - Çift Yol",
            "5 - Labirent",
            "6 - Tehlikeli Köprüler",
            "7 - Spiral",
            "8 - Asansör",
            "9 - Zor Geçiş",
            "10 - Final"
        };
        
        int startX = 150;
        int startY = 100;
        int buttonWidth = 250;
        int buttonHeight = 40;
        int gap = 10;
        
        for (int i = 0; i < 10; i++) {
            levelButtons[i] = new JButton(levelNames[i]);
            levelButtons[i].setFont(new Font("Arial", Font.BOLD, 16));
            
            int row = i / 2;
            int col = i % 2;
            int x = startX + col * (buttonWidth + 50);
            int y = startY + row * (buttonHeight + gap);
            
            levelButtons[i].setBounds(x, y, buttonWidth, buttonHeight);
            
            
            if (i < 3) {
                levelButtons[i].setBackground(new Color(100, 200, 100)); 
            } else if (i < 6) {
                levelButtons[i].setBackground(new Color(200, 200, 100)); 
            } else if (i < 9) {
                levelButtons[i].setBackground(new Color(200, 150, 100)); 
            } else {
                levelButtons[i].setBackground(new Color(200, 100, 100)); 
            }
            
            this.add(levelButtons[i]);
        }
        
        
        backButton = new JButton("← GERİ");
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setBounds(50, 400, 120, 40);
        backButton.setBackground(new Color(150, 150, 150));
        this.add(backButton);
        
        
        JLabel infoLabel = new JLabel("Yeşil: Kolay | Sarı: Orta | Turuncu: Zor | Kırmızı: Çok Zor", SwingConstants.CENTER);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        infoLabel.setForeground(Color.LIGHT_GRAY);
        infoLabel.setBounds(150, 380, 500, 30);
        this.add(infoLabel);
    }
    
    public int getSelectedLevel() {
        return selectedLevel;
    }
    
    public void setSelectedLevel(int level) {
        this.selectedLevel = level;
    }
}
