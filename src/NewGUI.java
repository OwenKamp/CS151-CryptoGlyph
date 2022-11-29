import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class NewGUI extends JFrame{
    ComponentScreen baseComponents;
    ComponentScreen introComponents;

    ComponentScreen symmetricAlgorithmComponents;
    AlgorithmScreen algorithmComponents;
    public NewGUI() {
        // setting up initial screen
        init();


        JLabel sidePanel = new JLabel();
        sidePanel.setBounds(15,0,135, 800);
        sidePanel.setForeground(Color.WHITE);
        sidePanel.setBackground(Color.BLACK);
        sidePanel.setOpaque(true);

        JLabel topPanel = new JLabel();
        topPanel.setBounds(150,0,1250,15);
        topPanel.setBackground(new Color(192,27,54));
        topPanel.setOpaque(true);

        JLabel topPanelSegment = new JLabel();
        topPanelSegment.setBounds(0, 0, 15, 200);
        topPanelSegment.setBackground(Color.BLACK);
        topPanelSegment.setOpaque(true);

        JButton homeButton = new JButton("    Home");
        homeButton.setBackground(Color.BLACK);
        homeButton.setForeground(Color.RED);
        homeButton.setBounds(15, 200, 135, 50);
        //setComponentZOrder(homeButton, 2);

        JLabel homeButtonSelected = new JLabel();
        homeButtonSelected.setBackground(new Color(192, 27, 54));
        homeButtonSelected.setBounds(0, 200, 15, 50);
        homeButtonSelected.setOpaque(true);
        //setComponentZOrder(homeButtonSelected, 2);

        JLabel homePNG = new JLabel();
        homePNG.setIcon(new ImageIcon("src/home.png"));
        homePNG.setBounds(25,210,30,30);
        homePNG.setForeground(Color.BLACK);
        homePNG.setBackground(Color.RED);
        homePNG.setOpaque(true);
        //setComponentZOrder(homePNG, 1);

        JButton symmetric = new JButton("    Symmetric");
        symmetric.setBackground(Color.BLACK);
        symmetric.setForeground(Color.RED);
        symmetric.setBounds(15, 250, 135, 50);

        JLabel symmetricLabel = new JLabel("Symmetric");
        symmetricLabel.setForeground(Color.RED);
        symmetricLabel.setBackground(Color.WHITE);
        symmetricLabel.setBounds(65,165,85,20);
        symmetricLabel.setOpaque(true);

        JLabel keyPNG = new JLabel();
        keyPNG.setIcon(new ImageIcon("src/key.png"));
        keyPNG.setBounds(25,260,30,30);
        keyPNG.setBackground(Color.BLACK);
        keyPNG.setOpaque(true);

        JLabel symmetricSelected = new JLabel();
        symmetricSelected.setBackground(Color.BLACK);
        //symmetricSelected.setBackground(new Color(192,27,54));
        symmetricSelected.setBounds(0, 250, 15, 50);
        symmetricSelected.setOpaque(true);

        JButton asymmetric = new JButton("    Asymmetric");
        asymmetric.setBackground(Color.BLACK);
        asymmetric.setForeground(Color.RED);
        asymmetric.setBounds(15, 300, 135, 50);

        JLabel asymmetricSelected = new JLabel();
        //asymmetricSelected.setBackground(new Color(192, 27, 54));
        asymmetricSelected.setBackground(Color.BLACK);
        asymmetricSelected.setBounds(0, 300, 15, 50);
        asymmetricSelected.setOpaque(true);

        JLabel bottomPanelSegment = new JLabel();
        bottomPanelSegment.setBackground(Color.BLACK);
        bottomPanelSegment.setBounds(0,350,15,450);
        bottomPanelSegment.setOpaque(true);

        JLabel logo = new JLabel();
        logo.setBackground(new Color(192,27,54));
        logo.setBounds(180,15,105,105);
        logo.setIcon(new ImageIcon("src/logo.png"));
        logo.setOpaque(true);

        JLabel projectName = new JLabel("    CryptoGlyph");
        projectName.setBackground(new Color(192,27,54));
        projectName.setForeground(Color.WHITE);
        projectName.setBounds(180,120,105,20);
        projectName.setOpaque(true);

        JLabel intro = new JLabel("Welcome to CryptoGlyph!");
        intro.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 30));
        intro.setForeground(Color.BLACK);
        intro.setBackground(Color.WHITE);
        intro.setBounds(200,200,350,50);
        intro.setOpaque(true);

        JTextArea introInformation = new JTextArea("CryptoGlyph is a cryptographic application that allows users to encrypt and decrypt data using\nnumerous algorithms such as Caesar's Cipher, A5/1 and AES. To get started please select\nthe type of cipher you would like to use (symmetric or asymmetric). From here you can\nchoose a specific algorithm, select the cryptography mode and input the plaintext / ciphertext\nalong with any keys.");
        introInformation.setEditable(false);
        introInformation.setForeground(Color.BLACK);
        introInformation.setBackground(Color.WHITE);
        introInformation.setBounds(200,260,500, 90);
        introInformation.setOpaque(true);

        baseComponents.add(keyPNG);
        baseComponents.add(homePNG);
        baseComponents.add(homeButton);
        baseComponents.add(homeButtonSelected);
        baseComponents.add(symmetric);
        baseComponents.add(symmetricSelected);
        baseComponents.add(asymmetric);
        baseComponents.add(asymmetricSelected);
        baseComponents.add(symmetricLabel);
        baseComponents.add(projectName);
        baseComponents.add(logo);
        baseComponents.add(sidePanel);
        baseComponents.add(topPanelSegment);
        baseComponents.add(bottomPanelSegment);
        baseComponents.add(topPanel);
        baseComponents.show();

        introComponents.add(intro);
        introComponents.add(introInformation);
        introComponents.show();

        symmetric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                symmetricScreen(symmetricSelected, homeButtonSelected);
            }
        });

//        asymmetricSelected.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                asymmetricScreen(intro,introInformation,asymmetricSelected,homeButtonSelected)
//            }
//        });

        setSize(800, 600);
        setVisible(true);
        repaint();
        revalidate();
    }

//    public void asymmetricScreen()

    public void symmetricScreen(JLabel symmetricSelected, JLabel homeButtonSelected) {
        introComponents.hide();
        homeButtonSelected.setBackground(Color.BLACK);
        symmetricSelected.setBackground(new Color(192,27,54));

        JLabel caesarsPNG = new JLabel();
        caesarsPNG.setIcon(new ImageIcon("src/caesarsLogo.png"));
        caesarsPNG.setBounds(225, 200, 100, 100);
        caesarsPNG.setBackground(Color.WHITE);
        caesarsPNG.setOpaque(true);

        JButton caesarsButton = new JButton("Caesar's Cipher");
        caesarsButton.setForeground(Color.BLACK);
        caesarsButton.setBackground(new Color(192,27,54));
        caesarsButton.setBounds(200,300,150,30);

        JLabel a51PNG = new JLabel();
        a51PNG.setIcon(new ImageIcon("src/a51.png"));
        a51PNG.setBounds(500, 200, 250, 100);
        a51PNG.setOpaque(true);

        JButton a51Button = new JButton("A5/1 Cipher");
        a51Button.setForeground(Color.BLACK);
        a51Button.setBackground(new Color(192,27,54));
        a51Button.setBounds(550,300, 150, 30);
        a51Button.setOpaque(true);

        symmetricAlgorithmComponents.add(caesarsPNG);
        symmetricAlgorithmComponents.add(caesarsButton);
        symmetricAlgorithmComponents.add(a51PNG);
        symmetricAlgorithmComponents.add(a51Button);
        symmetricAlgorithmComponents.show();

        caesarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                symmetricAlgorithmComponents.hide();
                String algorithm = "Caesar's Cipher";
                cryptographyWindow(algorithm);
            }
        });

        a51Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                symmetricAlgorithmComponents.hide();
                String algorithm = "A5/1 Cipher";
                cryptographyWindow(algorithm);
            }
        });
    }

    public void cryptographyWindow(String algorithm) {
        algorithmComponents.setAlgorithmName(algorithm);
        algorithmComponents.show();
    }
    
    public void init() {
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("CryptoGlyph");

        setContentPane(new JLabel(new ImageIcon("src/background.png")));
        setLayout(null);
        baseComponents = new ComponentScreen(this);
        introComponents = new ComponentScreen(this);
        symmetricAlgorithmComponents = new ComponentScreen(this);
        algorithmComponents = new AlgorithmScreen(this);

    }


    public static void main(String[] args) {
        NewGUI graphicalInterface = new NewGUI();
//    	System.out.println("Working Directory = " + System.getProperty("user.dir"));
    }
}
