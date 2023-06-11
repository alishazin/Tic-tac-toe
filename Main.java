
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;

class Game {

    JLabel title;
    int gameState = 0; // 0: playing, 1: stopped
    int turn = 1; // 1: player one, 2: player two
    JButton[][] boxes = new JButton[3][3];
    int values[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}; 
    JFrame f;
    JButton restartButt;
    // 0: blank, 1: x, 2: o

    public void initialize() {

        this.f = new JFrame("Tic Tac Toe");

        this.title = new JLabel("Player One's Turn", JLabel.CENTER);
        this.title.setBounds(0, 40, 415,20); 
        this.title.setFont(new Font("Verdana", Font.PLAIN, 20));

        JButton box11=new JButton("");  
        box11.setBounds(50,100, 100,100); 
        box11.setFocusPainted(false);
        box11.setFont(new Font("Verdana", Font.PLAIN, 20));
        box11.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {boxClick(1, 1);}  
        });
        this.boxes[0][0] = box11;
        
        JButton box12=new JButton("");  
        box12.setBounds(150,100, 100,100); 
        box12.setFocusPainted(false);
        box12.setFont(new Font("Verdana", Font.PLAIN, 20));
        box12.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {boxClick(1, 2);}  
        });  
        this.boxes[0][1] = box12;
        
        JButton box13=new JButton("");  
        box13.setBounds(250,100, 100,100); 
        box13.setFocusPainted(false);
        box13.setFont(new Font("Verdana", Font.PLAIN, 20));
        box13.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {boxClick(1, 3);}  
        });
        this.boxes[0][2] = box13;
        
        JButton box21=new JButton("");  
        box21.setBounds(50,200, 100,100); 
        box21.setFocusPainted(false);
        box21.setFont(new Font("Verdana", Font.PLAIN, 20));
        box21.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {boxClick(2, 1);}  
        });
        this.boxes[1][0] = box21;
        
        JButton box22=new JButton("");  
        box22.setBounds(150,200, 100,100); 
        box22.setFocusPainted(false);
        box22.setFont(new Font("Verdana", Font.PLAIN, 20));
        box22.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {boxClick(2, 2);}  
        });
        this.boxes[1][1] = box22;
        
        JButton box23=new JButton("");  
        box23.setBounds(250,200, 100,100); 
        box23.setFocusPainted(false);
        box23.setFont(new Font("Verdana", Font.PLAIN, 20));
        box23.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {boxClick(2, 3);}  
        });
        this.boxes[1][2] = box23;
        
        JButton box31=new JButton("");  
        box31.setBounds(50,300, 100,100); 
        box31.setFocusPainted(false);
        box31.setFont(new Font("Verdana", Font.PLAIN, 20));
        box31.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {boxClick(3, 1);}  
        });
        this.boxes[2][0] = box31;
        
        JButton box32=new JButton("");  
        box32.setBounds(150,300, 100,100); 
        box32.setFocusPainted(false);
        box32.setFont(new Font("Verdana", Font.PLAIN, 20));
        box32.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {boxClick(3, 2);}  
        });
        this.boxes[2][1] = box32;
        
        JButton box33=new JButton("");  
        box33.setBounds(250,300, 100,100); 
        box33.setFocusPainted(false);
        box33.setFont(new Font("Verdana", Font.PLAIN, 20));
        box33.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {boxClick(3, 3);}  
        });
        this.boxes[2][2] = box33;
        
        this.f.add(title);this.f.add(box11);this.f.add(box12);this.f.add(box13);this.f.add(box21);
        this.f.add(box22);this.f.add(box23);this.f.add(box31);this.f.add(box32);this.f.add(box33);
        

        f.setSize(415,600); 
        f.setLayout(null);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void boxClick(int row, int col) {
        if (this.gameState == 0) {
            if (this.values[row - 1][col - 1] == 0) {
                if (this.turn == 1) {
                    this.boxes[row - 1][col - 1].setText("X");
                    this.boxes[row - 1][col - 1].setForeground(Color.BLACK);;
                    this.values[row - 1][col - 1] = 1;
                } else if (this.turn == 2) {
                    this.boxes[row - 1][col - 1].setText("O");
                    this.boxes[row - 1][col - 1].setForeground(Color.BLUE);;
                    this.values[row - 1][col - 1] = 2;
                }
                this.boxes[row - 1][col - 1].setRolloverEnabled(false);
                this.changeTurn();
                this.checkForWin();
            }
        }
    }

    public void changeTurn() {
        if (this.turn == 1) {
            this.title.setText("Player Two's Turn");
            this.turn = 2;
        } else if (this.turn == 2) {
            this.title.setText("Player One's Turn");
            this.turn = 1;
        }
    }

    public void checkForWin() {

        // Checking if anyone won

        int i;
        
        // 1. checking row wins
        for (i = 0; i < 3; i++) {
            if (this.values[i][0] == 1 && this.values[i][1] == 1 && this.values[i][2] == 1) {
                this.endGame(1);
            } else if (this.values[i][0] == 2 && this.values[i][1] == 2 && this.values[i][2] == 2) {
                this.endGame(2);
            }
        }
        
        // 2. checking col wins
        for (i = 0; i < 3; i++) {
            if (this.values[0][i] == 1 && this.values[1][i] == 1 && this.values[2][i] == 1) {
                this.endGame(1);
            } else if (this.values[0][i] == 2 && this.values[1][i] == 2 && this.values[2][i] == 2) {
                this.endGame(2);
            }
        }
        
        // Checking tl to br
        if (this.values[0][0] == 1 && this.values[1][1] == 1 && this.values[2][2] == 1) {
            this.endGame(1);
        } else if (this.values[0][0] == 2 && this.values[1][1] == 2 && this.values[2][2] == 2) {
            this.endGame(2);
        }
        
        // Checking tr to bl
        if (this.values[0][2] == 1 && this.values[1][1] == 1 && this.values[2][0] == 1) {
            this.endGame(1);
        } else if (this.values[0][2] == 2 && this.values[1][1] == 2 && this.values[2][0] == 2) {
            this.endGame(2);
        }

        // Checking tied
        if (this.gameState == 0) {
            int k;
            for (i=0; i<3; i++) {
                for (k=0; k<3; k++) {
                    if (this.values[i][k] == 0) return;
                }
            }
            endGame(0);
        }
        
    }
    
    public void endGame(int state) {
        // 0: tied, 1: one won, 2: two won

        if (state == 0) {
            this.title.setText("Game Tied");
        } else if (state == 1) {
            this.title.setText("Player One Won");
        } else if (state == 2) {
            this.title.setText("Player Two Won");
        }
        this.title.setForeground(Color.RED);
        this.gameState = 1;

        // Add restart button
        this.restartButt = new JButton();
        this.restartButt.setText("Restart Game");  
        this.restartButt.setBackground(Color.GREEN);;  
        this.restartButt.setForeground(Color.BLACK);;  
        this.restartButt.setBounds(125, 470, 125, 50);
        this.restartButt.setFont(new Font("Verdana", Font.PLAIN, 12)); 
        this.restartButt.setFocusPainted(false); 
        this.restartButt.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {restartGame();}  
        });

        this.f.add(this.restartButt);
        this.refreshFrame();

    }

    public void restartGame() {
        for (int i=0; i<3; i++) {
            for (int k=0; k<3; k++) {
                
                this.values[i][k] = 0;
                this.boxes[i][k].setText("");
                this.boxes[i][k].setRolloverEnabled(true);
                
            }
        }

        this.title.setText("Player One's Turn");
        this.gameState = 0;
        this.turn = 1;
        this.f.remove(this.restartButt);
        this.refreshFrame();
        
    }

    public void refreshFrame() {
        f.setVisible(false);
        f.setVisible(true);
    }

};

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        game.initialize();

    }

};