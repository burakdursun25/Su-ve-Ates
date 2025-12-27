package suveateş;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 * Su ve Ateş Oyunu - 10 Bölümlü Platform Oyunu
 * @author burak
 */
public class SuVeAteş {

    static int timer = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("SU VE ATEŞ - Platform Oyunu");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(30, 30, 50));
        
        
        JLabel timerLabel = new JLabel(" ");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 15));
        timerLabel.setForeground(Color.WHITE);
        timerLabel.setBounds(450, 5, 200, 30);
        frame.add(timerLabel);
        
        
        Starting_Menu start = new Starting_Menu();
        start.setBounds(0, 0, 1000, 800);
        frame.add(start);
        
       
        LevelSelect levelSelect = new LevelSelect();
        levelSelect.setBounds(0, 0, 1000, 800);
        
       
        ESC esc = new ESC();
        esc.setBounds(0, 0, 1000, 800);
        
        
        Caracter c1 = new Caracter();
        c1.setBounds(0, 0, 1000, 800);

       
        Timer time = new Timer(1000, e -> {
            timer++;
            int minutes = timer / 60;
            int seconds = timer % 60;
            timerLabel.setText(String.format("Süre: %02d:%02d", minutes, seconds));
        });
        
        
        c1.setLevelCompleteListener(levelNumber -> time.stop());

        
        start.start.addActionListener(e -> {
            frame.remove(start);
            frame.add(levelSelect);
            frame.revalidate();
            frame.repaint();
            frame.requestFocusInWindow();
        });
        
        
        for (int i = 0; i < 10; i++) {
            final int levelNum = i + 1;
            levelSelect.levelButtons[i].addActionListener(e -> {
                timer = 0;
                c1.loadLevel(levelNum);
                frame.remove(levelSelect);
                frame.add(c1);
                frame.revalidate();
                frame.repaint();
                frame.requestFocusInWindow();
                time.start();
            });
        }
        
        
        levelSelect.backButton.addActionListener(e -> {
            frame.remove(levelSelect);
            frame.add(start);
            frame.revalidate();
            frame.repaint();
        });
        
        
        esc.contious.addActionListener(e -> {
            frame.remove(esc);
            frame.add(c1);
            frame.revalidate();
            frame.repaint();
            frame.requestFocusInWindow();
            time.start();
        });
        
        
        esc.restartButton.addActionListener(e -> {
            timer = 0;
            c1.loadLevel(c1.getCurrentLevelNumber());
            frame.remove(esc);
            frame.add(c1);
            frame.revalidate();
            frame.repaint();
            frame.requestFocusInWindow();
            time.start();
        });
        
        
        esc.mainMenuButton.addActionListener(e -> {
            timer = 0;
            frame.remove(esc);
            frame.add(start);
            frame.revalidate();
            frame.repaint();
        });

        
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Su karakteri kontrolleri (WASD)
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    c1.moveRiht();
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    c1.moveLeft();
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    c1.jumpw();
                }
                
                
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    c1.moveRihtf();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    c1.moveLeftf();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    c1.jumpf();
                }
                
                
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    frame.remove(c1);
                    frame.add(esc);
                    time.stop();
                    frame.revalidate();
                    frame.repaint();
                    frame.requestFocusInWindow();
                }
                
                
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (c1.isLevelCompleted()) {
                        if (c1.getCurrentLevelNumber() < 10) {
                            timer = 0;
                            c1.nextLevel();
                            time.start();
                        } else {
                            
                            frame.remove(c1);
                            frame.add(start);
                            frame.revalidate();
                            frame.repaint();
                        }
                    }
                }
                
               
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    timer = 0;
                    c1.loadLevel(c1.getCurrentLevelNumber());
                    time.start();
                }
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                // Su karakteri tuş bırakma
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    c1.stopRight();
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    c1.stopLeft();
                }
                
                // Ateş karakteri tuş bırakma
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    c1.stopRightf();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    c1.stopLeftf();
                }
            }
        });
        
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.requestFocus();
    }
}
