package suveateş;

import java.awt.*;
import java.util.List;
import javax.swing.*;

/**
 * Karakter sınıfı - Su ve Ateş karakterlerini yönetir
 * @author burak
 */
public class Caracter extends JPanel {

    
    private boolean isWaterJumping = false;
    private boolean isFireJumping = false;
    private double waterVelocityY = 0;  
    private double fireVelocityY = 0;   
    private final double GRAVITY = 0.8;       
    private final double JUMP_POWER = -15;    
    private final int MOVE_SPEED = 5;         
    
   
    private boolean waterLeft = false;
    private boolean waterRight = false;
    
    
    private boolean fireLeft = false;
    private boolean fireRight = false;
    
    static int fireX = 100;
    static int fireY = 600;
    static int deadWater = 0;
    static int deadFire = 0;
    static int waterX = 50;
    static int waterY = 600;
    
    
    private Level currentLevel;
    private int currentLevelNumber = 1;
    private boolean waterAtDoor = false;
    private boolean fireAtDoor = false;
    private boolean levelCompleted = false;
    
    
    private LevelCompleteListener levelCompleteListener;
    
    public interface LevelCompleteListener {
        void onLevelComplete(int levelNumber);
    }
    
    public void setLevelCompleteListener(LevelCompleteListener listener) {
        this.levelCompleteListener = listener;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        // Arkaplan rengi
        this.setBackground(new Color(30, 30, 50));
        
        // Bölüm bilgisi
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 20));
        g2.drawString("Bölüm " + currentLevelNumber + ": " + currentLevel.getLevelName(), 10, 25);
        
        // Platformları çiz
        g2.setColor(new Color(80, 80, 100));
        for (Rectangle floor : currentLevel.getFloors()) {
            g2.fill(floor);
            g2.setColor(new Color(100, 100, 120));
            g2.draw(floor);
            g2.setColor(new Color(80, 80, 100));
        }
        
        // Gölleri çiz (mavi)
        g2.setColor(new Color(50, 150, 255));
        for (Rectangle lake : currentLevel.getLakes()) {
            g2.fill(lake);
            // Parlama efekti
            g2.setColor(new Color(100, 180, 255));
            g2.drawRect(lake.x, lake.y, lake.width, lake.height);
            g2.setColor(new Color(50, 150, 255));
        }
        
        // Lavları çiz (kırmızı/turuncu)
        g2.setColor(new Color(255, 100, 50));
        for (Rectangle lava : currentLevel.getLavas()) {
            g2.fill(lava);
            // Parlama efekti
            g2.setColor(new Color(255, 150, 100));
            g2.drawRect(lava.x, lava.y, lava.width, lava.height);
            g2.setColor(new Color(255, 100, 50));
        }
        
        // Su kapısını çiz (mavi kapı)
        Rectangle waterDoor = currentLevel.getWaterDoor();
        g2.setColor(new Color(50, 100, 200));
        g2.fill(waterDoor);
        g2.setColor(new Color(100, 150, 255));
        g2.setStroke(new BasicStroke(3));
        g2.draw(waterDoor);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 12));
        g2.drawString("SU", waterDoor.x + 8, waterDoor.y + 25);
        
        // Ateş kapısını çiz (kırmızı kapı)
        Rectangle fireDoor = currentLevel.getFireDoor();
        g2.setColor(new Color(200, 50, 50));
        g2.fill(fireDoor);
        g2.setColor(new Color(255, 100, 100));
        g2.draw(fireDoor);
        g2.setColor(Color.WHITE);
        g2.drawString("ATEŞ", fireDoor.x + 3, fireDoor.y + 25);
        
        // Ateş karakteri
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(3));
        g2.fillOval(fireX, fireY, 20, 20);
        g2.setColor(new Color(255, 200, 50));
        g2.fillOval(fireX + 5, fireY + 5, 10, 10);
        
        // Su karakteri
        g2.setColor(Color.BLUE);
        g2.fillOval(waterX, waterY, 20, 20);
        g2.setColor(new Color(150, 200, 255));
        g2.fillOval(waterX + 5, waterY + 5, 10, 10);
        
        // Ölüm sayıları
        g2.setFont(new Font("Arial", Font.BOLD, 14));
        g2.setColor(Color.BLUE);
        g2.drawString("Su Ölüm: " + deadWater, 800, 20);
        g2.setColor(Color.RED);
        g2.drawString("Ateş Ölüm: " + deadFire, 900, 20);
        
        // Kapıda olma durumu göstergesi
        if (waterAtDoor) {
            g2.setColor(Color.GREEN);
            g2.drawString("Su kapıda! ✓", 800, 40);
        }
        if (fireAtDoor) {
            g2.setColor(Color.GREEN);
            g2.drawString("Ateş kapıda! ✓", 900, 40);
        }
        
        // Bölüm tamamlandı mesajı
        if (levelCompleted) {
            g2.setColor(new Color(0, 0, 0, 150));
            g2.fillRect(200, 250, 400, 150);
            g2.setColor(Color.GREEN);
            g2.setFont(new Font("Arial", Font.BOLD, 30));
            g2.drawString("BÖLÜM TAMAMLANDI!", 230, 310);
            g2.setFont(new Font("Arial", Font.PLAIN, 18));
            g2.setColor(Color.WHITE);
            if (currentLevelNumber < 10) {
                g2.drawString("Sonraki bölüm için ENTER'a basın", 270, 350);
            } else {
                g2.drawString("TEBRİKLER! Tüm bölümleri tamamladınız!", 240, 350);
            }
        }
    }

    public Caracter() {
        currentLevel = new Level(1);
        initPositions();
        
        Timer timer = new Timer(16, e -> {  // ~60 FPS
            if (!levelCompleted) {
                
                waterVelocityY += GRAVITY;
                fireVelocityY += GRAVITY;
                
                
                if (waterLeft) waterX -= MOVE_SPEED;
                if (waterRight) waterX += MOVE_SPEED;
                if (fireLeft) fireX -= MOVE_SPEED;
                if (fireRight) fireX += MOVE_SPEED;
                
                
                waterY += (int) waterVelocityY;
                fireY += (int) fireVelocityY;
                
                
                applyPhysics();
                checkDoors();
            }
            repaint();
        });
        timer.start();
    }
    
    private void initPositions() {
        waterX = currentLevel.getWaterStartX();
        waterY = currentLevel.getWaterStartY();
        fireX = currentLevel.getFireStartX();
        fireY = currentLevel.getFireStartY();
        waterVelocityY = 0;
        fireVelocityY = 0;
        isWaterJumping = false;
        isFireJumping = false;
    }
    
    public void loadLevel(int levelNumber) {
        this.currentLevelNumber = levelNumber;
        this.currentLevel = new Level(levelNumber);
        initPositions();
        levelCompleted = false;
        waterAtDoor = false;
        fireAtDoor = false;
        deadWater = 0;
        deadFire = 0;
        repaint();
    }
    
    private void checkDoors() {
        Rectangle water = new Rectangle(waterX, waterY, 20, 20);
        Rectangle fire = new Rectangle(fireX, fireY, 20, 20);
        
        waterAtDoor = water.intersects(currentLevel.getWaterDoor());
        fireAtDoor = fire.intersects(currentLevel.getFireDoor());
        
        if (waterAtDoor && fireAtDoor && !levelCompleted) {
            levelCompleted = true;
            if (levelCompleteListener != null) {
                levelCompleteListener.onLevelComplete(currentLevelNumber);
            }
        }
    }
    
    public void nextLevel() {
        if (levelCompleted && currentLevelNumber < 10) {
            loadLevel(currentLevelNumber + 1);
        }
    }
    
    public boolean isLevelCompleted() {
        return levelCompleted;
    }
    
    public int getCurrentLevelNumber() {
        return currentLevelNumber;
    }

    public void moveRihtf() {
        fireRight = true;
    }
    
    public void stopRightf() {
        fireRight = false;
    }

    public void moveLeftf() {
        fireLeft = true;
    }
    
    public void stopLeftf() {
        fireLeft = false;
    }

    public void moveRiht() {
        waterRight = true;
    }
    
    public void stopRight() {
        waterRight = false;
    }

    public void moveLeft() {
        waterLeft = true;
    }
    
    public void stopLeft() {
        waterLeft = false;
    }
    
    public void jumpw() {
        if (!isWaterJumping && !levelCompleted) {
            isWaterJumping = true;
            waterVelocityY = JUMP_POWER;
        }
    }
    
    public void jumpf() {
        if (!isFireJumping && !levelCompleted) {
            isFireJumping = true;
            fireVelocityY = JUMP_POWER;
        }
    }

    public void applyPhysics() {
        Rectangle water = new Rectangle(waterX, waterY, 20, 20);
        Rectangle fire = new Rectangle(fireX, fireY, 20, 20);
        
        List<Rectangle> floors = currentLevel.getFloors();
        List<Rectangle> lakes = currentLevel.getLakes();
        List<Rectangle> lavas = currentLevel.getLavas();
        
       
        for (Rectangle floor : floors) {
            
            if (water.intersects(floor) && waterVelocityY >= 0) {
                waterY = floor.y - 20;  
                waterVelocityY = 0;
                isWaterJumping = false;
            }
            
            if (fire.intersects(floor) && fireVelocityY >= 0) {
                fireY = floor.y - 20;  
                fireVelocityY = 0;
                isFireJumping = false;
            }
        }
        
        
        for (Rectangle lava : lavas) {
            if (water.intersects(lava)) {
                deadWater++;
                waterX = currentLevel.getWaterStartX();
                waterY = currentLevel.getWaterStartY();
                waterVelocityY = 0;
                isWaterJumping = false;
            }
        }
        
        
        for (Rectangle lake : lakes) {
            if (fire.intersects(lake)) {
                deadFire++;
                fireX = currentLevel.getFireStartX();
                fireY = currentLevel.getFireStartY();
                fireVelocityY = 0;
                isFireJumping = false;
            }
        }
        
        
        if (waterX < 0) waterX = 0;
        if (waterX > 950) waterX = 950;
        if (waterY > 750) {
            deadWater++;
            waterX = currentLevel.getWaterStartX();
            waterY = currentLevel.getWaterStartY();
            waterVelocityY = 0;
        }
        
        if (fireX < 0) fireX = 0;
        if (fireX > 950) fireX = 950;
        if (fireY > 750) {
            deadFire++;
            fireX = currentLevel.getFireStartX();
            fireY = currentLevel.getFireStartY();
            fireVelocityY = 0;
        }
    }
}
