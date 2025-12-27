package suveateş;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 * Bölüm (Level) sınıfı - Zigzag engelli Su ve Ateş bölümleri
 * @author burak
 */
public class Level {
    private final int levelNumber;
    private String levelName;
    private final List<Rectangle> floors = new ArrayList<>();
    private final List<Rectangle> lakes = new ArrayList<>();
    private final List<Rectangle> lavas = new ArrayList<>();
    private int waterStartX, waterStartY;
    private int fireStartX, fireStartY;
    private Rectangle waterDoor;
    private Rectangle fireDoor;
    
    public Level(int levelNumber) {
        this.levelNumber = levelNumber;
        setupLevel();
    }
    
    private void setupLevel() {
        switch(levelNumber) {
            case 1: setupLevel1(); break;
            case 2: setupLevel2(); break;
            case 3: setupLevel3(); break;
            case 4: setupLevel4(); break;
            case 5: setupLevel5(); break;
            case 6: setupLevel6(); break;
            case 7: setupLevel7(); break;
            case 8: setupLevel8(); break;
            case 9: setupLevel9(); break;
            case 10: setupLevel10(); break;
            default: setupLevel1();
        }
    }
    
    // BÖLÜM 1 - Tapınak Girişi (Öğretici)
    private void setupLevel1() {
        levelName = "Tapınak Girişi";
        
        // Zemin
        floors.add(new Rectangle(0, 680, 300, 40));
        floors.add(new Rectangle(400, 680, 200, 40));
        floors.add(new Rectangle(700, 680, 280, 40));
        
        // 1. kat - zigzag
        floors.add(new Rectangle(50, 550, 250, 25));
        floors.add(new Rectangle(650, 550, 250, 25));
        
        // 2. kat
        floors.add(new Rectangle(300, 420, 350, 25));
        
        // 3. kat - zigzag
        floors.add(new Rectangle(50, 290, 300, 25));
        floors.add(new Rectangle(600, 290, 300, 25));
        
        // Çatı
        floors.add(new Rectangle(280, 160, 400, 25));
        
        // Zemin engelleri
        lakes.add(new Rectangle(300, 695, 100, 25));
        lavas.add(new Rectangle(600, 695, 100, 25));
        
        // 1. kat engelleri (zigzag)
        lavas.add(new Rectangle(100, 545, 60, 8));
        lakes.add(new Rectangle(750, 545, 60, 8));
        
        // 2. kat engelleri
        lakes.add(new Rectangle(350, 415, 50, 8));
        lavas.add(new Rectangle(550, 415, 50, 8));
        
        // 3. kat engelleri (zigzag)
        lavas.add(new Rectangle(150, 285, 50, 8));
        lakes.add(new Rectangle(700, 285, 50, 8));
        
        waterStartX = 50;
        waterStartY = 640;
        fireStartX = 800;
        fireStartY = 640;
        
        waterDoor = new Rectangle(350, 120, 40, 40);
        fireDoor = new Rectangle(570, 120, 40, 40);
    }
    
    // BÖLÜM 2 - Kristal Mağara
    private void setupLevel2() {
        levelName = "Kristal Mağara";
        
        // Zemin
        floors.add(new Rectangle(0, 680, 200, 40));
        floors.add(new Rectangle(350, 680, 260, 40));
        floors.add(new Rectangle(760, 680, 220, 40));
        
        // 1. kat zigzag
        floors.add(new Rectangle(100, 570, 200, 25));
        floors.add(new Rectangle(400, 540, 180, 25));
        floors.add(new Rectangle(680, 570, 200, 25));
        
        // 2. kat zigzag
        floors.add(new Rectangle(50, 430, 250, 25));
        floors.add(new Rectangle(400, 400, 180, 25));
        floors.add(new Rectangle(680, 430, 250, 25));
        
        // 3. kat
        floors.add(new Rectangle(200, 280, 560, 25));
        
        // Çatı
        floors.add(new Rectangle(300, 150, 360, 25));
        
        // Zemin engelleri
        lakes.add(new Rectangle(200, 695, 150, 25));
        lavas.add(new Rectangle(610, 695, 150, 25));
        
        // 1. kat zigzag engeller
        lavas.add(new Rectangle(150, 565, 50, 8));
        lakes.add(new Rectangle(440, 535, 60, 8));
        lavas.add(new Rectangle(780, 565, 50, 8));
        
        // 2. kat zigzag engeller
        lakes.add(new Rectangle(100, 425, 60, 8));
        lavas.add(new Rectangle(440, 395, 60, 8));
        lakes.add(new Rectangle(800, 425, 60, 8));
        
        // 3. kat engeller
        lavas.add(new Rectangle(300, 275, 50, 8));
        lakes.add(new Rectangle(450, 275, 60, 8));
        lavas.add(new Rectangle(620, 275, 50, 8));
        
        waterStartX = 50;
        waterStartY = 640;
        fireStartX = 880;
        fireStartY = 640;
        
        waterDoor = new Rectangle(370, 110, 40, 40);
        fireDoor = new Rectangle(550, 110, 40, 40);
    }
    
    // BÖLÜM 3 - İkiz Kuleler
    private void setupLevel3() {
        levelName = "İkiz Kuleler";
        
        // Zemin
        floors.add(new Rectangle(0, 680, 180, 40));
        floors.add(new Rectangle(400, 680, 180, 40));
        floors.add(new Rectangle(800, 680, 180, 40));
        
        // Sol kule basamakları
        floors.add(new Rectangle(20, 570, 160, 20));
        floors.add(new Rectangle(20, 450, 160, 20));
        floors.add(new Rectangle(20, 330, 160, 20));
        
        // Sağ kule basamakları
        floors.add(new Rectangle(800, 570, 160, 20));
        floors.add(new Rectangle(800, 450, 160, 20));
        floors.add(new Rectangle(800, 330, 160, 20));
        
        // Orta köprüler zigzag
        floors.add(new Rectangle(180, 510, 200, 20));
        floors.add(new Rectangle(580, 510, 220, 20));
        floors.add(new Rectangle(300, 390, 380, 20));
        floors.add(new Rectangle(180, 270, 620, 20));
        
        // Çatı
        floors.add(new Rectangle(100, 150, 780, 25));
        
        // Zemin engelleri
        lakes.add(new Rectangle(180, 695, 220, 25));
        lavas.add(new Rectangle(580, 695, 220, 25));
        
        // Sol kule engeller
        lavas.add(new Rectangle(60, 565, 50, 8));
        lakes.add(new Rectangle(80, 445, 50, 8));
        lavas.add(new Rectangle(60, 325, 50, 8));
        
        // Sağ kule engeller
        lakes.add(new Rectangle(860, 565, 50, 8));
        lavas.add(new Rectangle(840, 445, 50, 8));
        lakes.add(new Rectangle(860, 325, 50, 8));
        
        // Köprü engelleri zigzag
        lakes.add(new Rectangle(250, 505, 60, 8));
        lavas.add(new Rectangle(660, 505, 60, 8));
        lavas.add(new Rectangle(400, 385, 50, 8));
        lakes.add(new Rectangle(550, 385, 50, 8));
        lakes.add(new Rectangle(300, 265, 50, 8));
        lavas.add(new Rectangle(500, 265, 50, 8));
        lakes.add(new Rectangle(680, 265, 50, 8));
        
        waterStartX = 60;
        waterStartY = 640;
        fireStartX = 880;
        fireStartY = 640;
        
        waterDoor = new Rectangle(300, 110, 40, 40);
        fireDoor = new Rectangle(640, 110, 40, 40);
    }
    
    // BÖLÜM 4 - Yeraltı Nehri
    private void setupLevel4() {
        levelName = "Yeraltı Nehri";
        
        // Zemin parçalı
        floors.add(new Rectangle(0, 680, 150, 40));
        floors.add(new Rectangle(250, 680, 150, 40));
        floors.add(new Rectangle(500, 680, 150, 40));
        floors.add(new Rectangle(750, 680, 230, 40));
        
        // 1. kat zigzag
        floors.add(new Rectangle(80, 580, 180, 25));
        floors.add(new Rectangle(360, 550, 180, 25));
        floors.add(new Rectangle(640, 580, 200, 25));
        
        // 2. kat zigzag (ters yön)
        floors.add(new Rectangle(600, 450, 280, 25));
        floors.add(new Rectangle(300, 420, 200, 25));
        floors.add(new Rectangle(50, 450, 180, 25));
        
        // 3. kat
        floors.add(new Rectangle(150, 310, 280, 25));
        floors.add(new Rectangle(520, 310, 280, 25));
        
        // Çatı
        floors.add(new Rectangle(280, 180, 400, 25));
        
        // Zemin su nehirleri
        lakes.add(new Rectangle(150, 695, 100, 25));
        lakes.add(new Rectangle(400, 695, 100, 25));
        lakes.add(new Rectangle(650, 695, 100, 25));
        
        // 1. kat engeller zigzag
        lavas.add(new Rectangle(120, 575, 50, 8));
        lakes.add(new Rectangle(400, 545, 60, 8));
        lavas.add(new Rectangle(720, 575, 50, 8));
        
        // 2. kat engeller zigzag
        lakes.add(new Rectangle(700, 445, 60, 8));
        lavas.add(new Rectangle(380, 415, 50, 8));
        lakes.add(new Rectangle(100, 445, 50, 8));
        
        // 3. kat engeller
        lavas.add(new Rectangle(220, 305, 50, 8));
        lakes.add(new Rectangle(350, 305, 50, 8));
        lavas.add(new Rectangle(600, 305, 50, 8));
        lakes.add(new Rectangle(720, 305, 50, 8));
        
        waterStartX = 50;
        waterStartY = 640;
        fireStartX = 880;
        fireStartY = 640;
        
        waterDoor = new Rectangle(350, 140, 40, 40);
        fireDoor = new Rectangle(570, 140, 40, 40);
    }
    
    // BÖLÜM 5 - Volkan Tapınağı
    private void setupLevel5() {
        levelName = "Volkan Tapınağı";
        
        // Zemin
        floors.add(new Rectangle(0, 680, 200, 40));
        floors.add(new Rectangle(350, 680, 280, 40));
        floors.add(new Rectangle(780, 680, 200, 40));
        
        // 1. kat - geniş zigzag
        floors.add(new Rectangle(50, 570, 220, 25));
        floors.add(new Rectangle(380, 540, 220, 25));
        floors.add(new Rectangle(710, 570, 220, 25));
        
        // 2. kat - ters zigzag
        floors.add(new Rectangle(650, 430, 280, 25));
        floors.add(new Rectangle(350, 400, 200, 25));
        floors.add(new Rectangle(50, 430, 200, 25));
        
        // 3. kat
        floors.add(new Rectangle(200, 290, 250, 25));
        floors.add(new Rectangle(530, 290, 250, 25));
        
        // Çatı
        floors.add(new Rectangle(300, 160, 380, 25));
        
        // Zemin lav havuzları
        lavas.add(new Rectangle(200, 695, 150, 25));
        lavas.add(new Rectangle(630, 695, 150, 25));
        
        // 1. kat lav/su zigzag
        lavas.add(new Rectangle(100, 565, 60, 8));
        lakes.add(new Rectangle(180, 565, 50, 8));
        lavas.add(new Rectangle(430, 535, 70, 8));
        lakes.add(new Rectangle(520, 535, 50, 8));
        lavas.add(new Rectangle(780, 565, 60, 8));
        lakes.add(new Rectangle(860, 565, 50, 8));
        
        // 2. kat zigzag
        lakes.add(new Rectangle(720, 425, 60, 8));
        lavas.add(new Rectangle(830, 425, 50, 8));
        lakes.add(new Rectangle(390, 395, 60, 8));
        lavas.add(new Rectangle(470, 395, 50, 8));
        lakes.add(new Rectangle(100, 425, 60, 8));
        lavas.add(new Rectangle(180, 425, 50, 8));
        
        // 3. kat
        lavas.add(new Rectangle(260, 285, 50, 8));
        lakes.add(new Rectangle(370, 285, 50, 8));
        lavas.add(new Rectangle(590, 285, 50, 8));
        lakes.add(new Rectangle(700, 285, 50, 8));
        
        waterStartX = 50;
        waterStartY = 640;
        fireStartX = 880;
        fireStartY = 640;
        
        waterDoor = new Rectangle(380, 120, 40, 40);
        fireDoor = new Rectangle(560, 120, 40, 40);
    }
    
    // BÖLÜM 6 - Buz Mağarası
    private void setupLevel6() {
        levelName = "Buz Mağarası";
        
        // Zemin
        floors.add(new Rectangle(0, 680, 220, 40));
        floors.add(new Rectangle(380, 680, 220, 40));
        floors.add(new Rectangle(760, 680, 220, 40));
        
        // Alt zigzag platformlar
        floors.add(new Rectangle(150, 590, 180, 25));
        floors.add(new Rectangle(420, 560, 150, 25));
        floors.add(new Rectangle(660, 590, 180, 25));
        
        // Orta büyük platform
        floors.add(new Rectangle(100, 460, 780, 25));
        
        // Üst zigzag
        floors.add(new Rectangle(50, 350, 200, 25));
        floors.add(new Rectangle(350, 320, 280, 25));
        floors.add(new Rectangle(730, 350, 200, 25));
        
        // Çatı zigzag
        floors.add(new Rectangle(150, 210, 280, 25));
        floors.add(new Rectangle(530, 210, 280, 25));
        
        // En üst
        floors.add(new Rectangle(320, 100, 340, 25));
        
        // Zemin buz havuzları
        lakes.add(new Rectangle(220, 695, 160, 25));
        lakes.add(new Rectangle(600, 695, 160, 25));
        
        // Alt zigzag engeller
        lavas.add(new Rectangle(190, 585, 50, 8));
        lakes.add(new Rectangle(450, 555, 60, 8));
        lavas.add(new Rectangle(720, 585, 50, 8));
        
        // Orta platform engelleri (çok!)
        lakes.add(new Rectangle(180, 455, 50, 8));
        lavas.add(new Rectangle(300, 455, 50, 8));
        lakes.add(new Rectangle(420, 455, 50, 8));
        lavas.add(new Rectangle(540, 455, 50, 8));
        lakes.add(new Rectangle(660, 455, 50, 8));
        lavas.add(new Rectangle(780, 455, 50, 8));
        
        // Üst zigzag engeller
        lavas.add(new Rectangle(100, 345, 50, 8));
        lakes.add(new Rectangle(180, 345, 50, 8));
        lavas.add(new Rectangle(420, 315, 60, 8));
        lakes.add(new Rectangle(520, 315, 60, 8));
        lavas.add(new Rectangle(780, 345, 50, 8));
        lakes.add(new Rectangle(860, 345, 50, 8));
        
        // Çatı engelleri
        lakes.add(new Rectangle(220, 205, 60, 8));
        lavas.add(new Rectangle(340, 205, 50, 8));
        lavas.add(new Rectangle(600, 205, 60, 8));
        lakes.add(new Rectangle(720, 205, 50, 8));
        
        waterStartX = 60;
        waterStartY = 640;
        fireStartX = 880;
        fireStartY = 640;
        
        waterDoor = new Rectangle(400, 60, 40, 40);
        fireDoor = new Rectangle(540, 60, 40, 40);
    }
    
    // BÖLÜM 7 - Antik Tapınak
    private void setupLevel7() {
        levelName = "Antik Tapınak";
        
        // Zemin
        floors.add(new Rectangle(0, 680, 180, 40));
        floors.add(new Rectangle(280, 680, 180, 40));
        floors.add(new Rectangle(560, 680, 180, 40));
        floors.add(new Rectangle(840, 680, 140, 40));
        
        // 1. kat çapraz
        floors.add(new Rectangle(50, 580, 200, 25));
        floors.add(new Rectangle(320, 560, 150, 25));
        floors.add(new Rectangle(540, 540, 150, 25));
        floors.add(new Rectangle(760, 560, 180, 25));
        
        // 2. kat ters çapraz
        floors.add(new Rectangle(700, 430, 240, 25));
        floors.add(new Rectangle(450, 410, 180, 25));
        floors.add(new Rectangle(200, 430, 180, 25));
        floors.add(new Rectangle(30, 450, 120, 25));
        
        // 3. kat
        floors.add(new Rectangle(100, 310, 350, 25));
        floors.add(new Rectangle(530, 310, 350, 25));
        
        // Çatı
        floors.add(new Rectangle(280, 180, 420, 25));
        
        // Zemin engelleri
        lakes.add(new Rectangle(180, 695, 100, 25));
        lavas.add(new Rectangle(460, 695, 100, 25));
        lakes.add(new Rectangle(740, 695, 100, 25));
        
        // 1. kat çapraz engeller
        lavas.add(new Rectangle(100, 575, 50, 8));
        lakes.add(new Rectangle(180, 575, 40, 8));
        lavas.add(new Rectangle(360, 555, 50, 8));
        lakes.add(new Rectangle(580, 535, 50, 8));
        lavas.add(new Rectangle(650, 535, 40, 8));
        lakes.add(new Rectangle(820, 555, 50, 8));
        
        // 2. kat ters çapraz engeller
        lakes.add(new Rectangle(760, 425, 60, 8));
        lavas.add(new Rectangle(860, 425, 50, 8));
        lakes.add(new Rectangle(500, 405, 60, 8));
        lavas.add(new Rectangle(580, 405, 40, 8));
        lakes.add(new Rectangle(250, 425, 60, 8));
        lavas.add(new Rectangle(330, 425, 40, 8));
        
        // 3. kat engeller
        lavas.add(new Rectangle(160, 305, 50, 8));
        lakes.add(new Rectangle(280, 305, 50, 8));
        lavas.add(new Rectangle(380, 305, 40, 8));
        lakes.add(new Rectangle(600, 305, 50, 8));
        lavas.add(new Rectangle(720, 305, 50, 8));
        lakes.add(new Rectangle(820, 305, 40, 8));
        
        waterStartX = 50;
        waterStartY = 640;
        fireStartX = 880;
        fireStartY = 640;
        
        waterDoor = new Rectangle(360, 140, 40, 40);
        fireDoor = new Rectangle(580, 140, 40, 40);
    }
    
    // BÖLÜM 8 - Karanlık Orman
    private void setupLevel8() {
        levelName = "Karanlık Orman";
        
        // Zemin (çok parçalı)
        floors.add(new Rectangle(0, 680, 120, 40));
        floors.add(new Rectangle(200, 680, 120, 40));
        floors.add(new Rectangle(400, 680, 120, 40));
        floors.add(new Rectangle(600, 680, 120, 40));
        floors.add(new Rectangle(800, 680, 180, 40));
        
        // Ağaç dalları 1. kat
        floors.add(new Rectangle(60, 590, 150, 20));
        floors.add(new Rectangle(280, 570, 150, 20));
        floors.add(new Rectangle(500, 590, 150, 20));
        floors.add(new Rectangle(720, 570, 180, 20));
        
        // 2. kat dallar ters
        floors.add(new Rectangle(650, 470, 200, 20));
        floors.add(new Rectangle(400, 450, 180, 20));
        floors.add(new Rectangle(150, 470, 180, 20));
        
        // 3. kat
        floors.add(new Rectangle(50, 350, 250, 20));
        floors.add(new Rectangle(380, 330, 220, 20));
        floors.add(new Rectangle(680, 350, 250, 20));
        
        // 4. kat ters
        floors.add(new Rectangle(550, 230, 350, 20));
        floors.add(new Rectangle(100, 230, 350, 20));
        
        // Çatı
        floors.add(new Rectangle(300, 120, 380, 25));
        
        // Zemin engelleri
        lavas.add(new Rectangle(120, 695, 80, 25));
        lakes.add(new Rectangle(320, 695, 80, 25));
        lavas.add(new Rectangle(520, 695, 80, 25));
        lakes.add(new Rectangle(720, 695, 80, 25));
        
        // 1. kat dal engelleri
        lakes.add(new Rectangle(100, 585, 40, 8));
        lavas.add(new Rectangle(160, 585, 40, 8));
        lakes.add(new Rectangle(320, 565, 50, 8));
        lavas.add(new Rectangle(390, 565, 40, 8));
        lakes.add(new Rectangle(540, 585, 50, 8));
        lavas.add(new Rectangle(600, 585, 40, 8));
        lakes.add(new Rectangle(780, 565, 50, 8));
        lavas.add(new Rectangle(850, 565, 40, 8));
        
        // 2. kat engeller
        lavas.add(new Rectangle(700, 465, 50, 8));
        lakes.add(new Rectangle(780, 465, 50, 8));
        lavas.add(new Rectangle(450, 445, 50, 8));
        lakes.add(new Rectangle(520, 445, 50, 8));
        lavas.add(new Rectangle(200, 465, 50, 8));
        lakes.add(new Rectangle(270, 465, 50, 8));
        
        // 3. kat engeller
        lakes.add(new Rectangle(100, 345, 40, 8));
        lavas.add(new Rectangle(180, 345, 40, 8));
        lakes.add(new Rectangle(250, 345, 40, 8));
        lavas.add(new Rectangle(430, 325, 50, 8));
        lakes.add(new Rectangle(520, 325, 50, 8));
        lavas.add(new Rectangle(730, 345, 40, 8));
        lakes.add(new Rectangle(810, 345, 40, 8));
        lavas.add(new Rectangle(880, 345, 40, 8));
        
        // 4. kat engeller
        lavas.add(new Rectangle(150, 225, 50, 8));
        lakes.add(new Rectangle(280, 225, 50, 8));
        lavas.add(new Rectangle(380, 225, 50, 8));
        lakes.add(new Rectangle(600, 225, 50, 8));
        lavas.add(new Rectangle(730, 225, 50, 8));
        lakes.add(new Rectangle(850, 225, 50, 8));
        
        waterStartX = 40;
        waterStartY = 640;
        fireStartX = 900;
        fireStartY = 640;
        
        waterDoor = new Rectangle(380, 80, 40, 40);
        fireDoor = new Rectangle(560, 80, 40, 40);
    }
    
    // BÖLÜM 9 - Gökyüzü Sarayı
    private void setupLevel9() {
        levelName = "Gökyüzü Sarayı";
        
        // Zemin
        floors.add(new Rectangle(0, 680, 160, 40));
        floors.add(new Rectangle(260, 680, 160, 40));
        floors.add(new Rectangle(520, 680, 160, 40));
        floors.add(new Rectangle(780, 680, 200, 40));
        
        // 1. kat merdiven
        floors.add(new Rectangle(50, 600, 180, 20));
        floors.add(new Rectangle(300, 580, 180, 20));
        floors.add(new Rectangle(550, 560, 180, 20));
        floors.add(new Rectangle(800, 540, 150, 20));
        
        // 2. kat ters merdiven
        floors.add(new Rectangle(700, 440, 200, 20));
        floors.add(new Rectangle(450, 420, 180, 20));
        floors.add(new Rectangle(200, 400, 180, 20));
        floors.add(new Rectangle(30, 380, 120, 20));
        
        // 3. kat merdiven
        floors.add(new Rectangle(80, 300, 200, 20));
        floors.add(new Rectangle(350, 280, 200, 20));
        floors.add(new Rectangle(620, 260, 200, 20));
        
        // 4. kat ters
        floors.add(new Rectangle(550, 180, 300, 20));
        floors.add(new Rectangle(200, 160, 280, 20));
        
        // Çatı
        floors.add(new Rectangle(350, 80, 280, 25));
        
        // Zemin engelleri
        lakes.add(new Rectangle(160, 695, 100, 25));
        lavas.add(new Rectangle(420, 695, 100, 25));
        lakes.add(new Rectangle(680, 695, 100, 25));
        
        // 1. kat merdiven engeller
        lavas.add(new Rectangle(90, 595, 40, 8));
        lakes.add(new Rectangle(160, 595, 40, 8));
        lavas.add(new Rectangle(340, 575, 50, 8));
        lakes.add(new Rectangle(420, 575, 40, 8));
        lavas.add(new Rectangle(590, 555, 50, 8));
        lakes.add(new Rectangle(670, 555, 40, 8));
        lavas.add(new Rectangle(840, 535, 50, 8));
        
        // 2. kat ters engeller
        lakes.add(new Rectangle(750, 435, 50, 8));
        lavas.add(new Rectangle(830, 435, 50, 8));
        lakes.add(new Rectangle(500, 415, 50, 8));
        lavas.add(new Rectangle(580, 415, 40, 8));
        lakes.add(new Rectangle(250, 395, 50, 8));
        lavas.add(new Rectangle(330, 395, 40, 8));
        
        // 3. kat engeller
        lavas.add(new Rectangle(130, 295, 50, 8));
        lakes.add(new Rectangle(210, 295, 50, 8));
        lavas.add(new Rectangle(400, 275, 50, 8));
        lakes.add(new Rectangle(480, 275, 50, 8));
        lavas.add(new Rectangle(670, 255, 50, 8));
        lakes.add(new Rectangle(760, 255, 50, 8));
        
        // 4. kat engeller
        lavas.add(new Rectangle(600, 175, 50, 8));
        lakes.add(new Rectangle(700, 175, 50, 8));
        lavas.add(new Rectangle(800, 175, 40, 8));
        lakes.add(new Rectangle(260, 155, 50, 8));
        lavas.add(new Rectangle(360, 155, 50, 8));
        lakes.add(new Rectangle(430, 155, 40, 8));
        
        waterStartX = 40;
        waterStartY = 640;
        fireStartX = 900;
        fireStartY = 640;
        
        waterDoor = new Rectangle(420, 40, 40, 40);
        fireDoor = new Rectangle(520, 40, 40, 40);
    }
    
    // BÖLÜM 10 - Final: Elementler Tapınağı
    private void setupLevel10() {
        levelName = "Elementler Tapınağı";
        
        // Zemin (çok parçalı)
        floors.add(new Rectangle(0, 680, 100, 40));
        floors.add(new Rectangle(180, 680, 100, 40));
        floors.add(new Rectangle(360, 680, 100, 40));
        floors.add(new Rectangle(540, 680, 100, 40));
        floors.add(new Rectangle(720, 680, 100, 40));
        floors.add(new Rectangle(900, 680, 80, 40));
        
        // 1. kat zigzag yoğun
        floors.add(new Rectangle(40, 600, 140, 20));
        floors.add(new Rectangle(240, 580, 140, 20));
        floors.add(new Rectangle(440, 600, 140, 20));
        floors.add(new Rectangle(640, 580, 140, 20));
        floors.add(new Rectangle(840, 600, 140, 20));
        
        // 2. kat ters zigzag
        floors.add(new Rectangle(760, 490, 180, 20));
        floors.add(new Rectangle(520, 470, 180, 20));
        floors.add(new Rectangle(280, 490, 180, 20));
        floors.add(new Rectangle(40, 470, 180, 20));
        
        // 3. kat zigzag
        floors.add(new Rectangle(80, 370, 200, 20));
        floors.add(new Rectangle(350, 350, 280, 20));
        floors.add(new Rectangle(700, 370, 200, 20));
        
        // 4. kat
        floors.add(new Rectangle(150, 260, 280, 20));
        floors.add(new Rectangle(550, 260, 280, 20));
        
        // 5. kat
        floors.add(new Rectangle(300, 170, 380, 20));
        
        // Çatı
        floors.add(new Rectangle(380, 80, 220, 25));
        
        // Zemin tüm engeller
        lavas.add(new Rectangle(100, 695, 80, 25));
        lakes.add(new Rectangle(280, 695, 80, 25));
        lavas.add(new Rectangle(460, 695, 80, 25));
        lakes.add(new Rectangle(640, 695, 80, 25));
        lavas.add(new Rectangle(820, 695, 80, 25));
        
        // 1. kat yoğun engeller
        lakes.add(new Rectangle(70, 595, 40, 8));
        lavas.add(new Rectangle(130, 595, 40, 8));
        lakes.add(new Rectangle(280, 575, 40, 8));
        lavas.add(new Rectangle(340, 575, 40, 8));
        lakes.add(new Rectangle(480, 595, 40, 8));
        lavas.add(new Rectangle(540, 595, 40, 8));
        lakes.add(new Rectangle(680, 575, 40, 8));
        lavas.add(new Rectangle(740, 575, 40, 8));
        lakes.add(new Rectangle(880, 595, 40, 8));
        lavas.add(new Rectangle(940, 595, 40, 8));
        
        // 2. kat ters engeller
        lavas.add(new Rectangle(800, 485, 50, 8));
        lakes.add(new Rectangle(870, 485, 50, 8));
        lavas.add(new Rectangle(560, 465, 50, 8));
        lakes.add(new Rectangle(630, 465, 50, 8));
        lavas.add(new Rectangle(320, 485, 50, 8));
        lakes.add(new Rectangle(390, 485, 50, 8));
        lavas.add(new Rectangle(80, 465, 50, 8));
        lakes.add(new Rectangle(150, 465, 50, 8));
        
        // 3. kat engeller
        lavas.add(new Rectangle(120, 365, 40, 8));
        lakes.add(new Rectangle(200, 365, 40, 8));
        lavas.add(new Rectangle(400, 345, 50, 8));
        lakes.add(new Rectangle(500, 345, 50, 8));
        lavas.add(new Rectangle(570, 345, 40, 8));
        lakes.add(new Rectangle(750, 365, 40, 8));
        lavas.add(new Rectangle(830, 365, 40, 8));
        
        // 4. kat engeller
        lakes.add(new Rectangle(200, 255, 50, 8));
        lavas.add(new Rectangle(300, 255, 50, 8));
        lakes.add(new Rectangle(380, 255, 40, 8));
        lavas.add(new Rectangle(600, 255, 50, 8));
        lakes.add(new Rectangle(700, 255, 50, 8));
        lavas.add(new Rectangle(780, 255, 40, 8));
        
        // 5. kat engeller
        lavas.add(new Rectangle(350, 165, 50, 8));
        lakes.add(new Rectangle(430, 165, 50, 8));
        lavas.add(new Rectangle(510, 165, 50, 8));
        lakes.add(new Rectangle(590, 165, 50, 8));
        
        waterStartX = 30;
        waterStartY = 640;
        fireStartX = 920;
        fireStartY = 640;
        
        waterDoor = new Rectangle(420, 40, 40, 40);
        fireDoor = new Rectangle(520, 40, 40, 40);
    }
    
    // Getter metodları
    public int getLevelNumber() { return levelNumber; }
    public String getLevelName() { return levelName; }
    public List<Rectangle> getFloors() { return floors; }
    public List<Rectangle> getLakes() { return lakes; }
    public List<Rectangle> getLavas() { return lavas; }
    public int getWaterStartX() { return waterStartX; }
    public int getWaterStartY() { return waterStartY; }
    public int getFireStartX() { return fireStartX; }
    public int getFireStartY() { return fireStartY; }
    public Rectangle getWaterDoor() { return waterDoor; }
    public Rectangle getFireDoor() { return fireDoor; }
}
