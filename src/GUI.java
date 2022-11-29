import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUI {
    public void MyFrame() {
        // setting up initial screen
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("CryptoGlyph");

        frame.setContentPane(new JLabel(new ImageIcon("src\\img\\background.png")));
        frame.setLayout(null);

        //JPanel homescreenBackground = new JPanel();
        //homescreenBackground.setBackground(Color.WHITE);
        //homescreenBackground.setSize(800,800);
        //homescreenBackground.setLayout(new AbsoluteLayout());

        JLabel sidePanel = new JLabel();
        sidePanel.setBounds(15,0,135, 800);
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
        homeButton.setForeground(Color.WHITE);
        homeButton.setBounds(15, 200, 135, 50);
        //frame.setComponentZOrder(homeButton, 2);

        JLabel homeButtonSelected = new JLabel();
        homeButtonSelected.setBackground(new Color(192, 27, 54));
        homeButtonSelected.setBounds(0, 200, 15, 50);
        homeButtonSelected.setOpaque(true);
        //frame.setComponentZOrder(homeButtonSelected, 2);

        JLabel homePNG = new JLabel();
        homePNG.setIcon(new ImageIcon("src\\img\\home.png"));
        homePNG.setBounds(25,210,30,30);
        homePNG.setBackground(Color.BLACK);
        homePNG.setOpaque(true);
        //frame.setComponentZOrder(homePNG, 1);

        JButton symmetric = new JButton("    Symmetric");
        symmetric.setBackground(Color.BLACK);
        symmetric.setForeground(Color.WHITE);
        symmetric.setBounds(15, 250, 135, 50);

        JLabel symmetricLabel = new JLabel("Symmetric");
        symmetricLabel.setForeground(Color.WHITE);
        symmetricLabel.setBackground(Color.BLACK);
        symmetricLabel.setBounds(65,165,85,20);
        symmetricLabel.setOpaque(true);

        JLabel keyPNG = new JLabel();
        keyPNG.setIcon(new ImageIcon("src\\img\\key.png"));
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
        asymmetric.setForeground(Color.WHITE);
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
        logo.setIcon(new ImageIcon("src\\img\\logo.png"));
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
        introInformation.setForeground(Color.BLACK);
        introInformation.setBackground(Color.WHITE);
        introInformation.setBounds(200,260,500, 90);
        introInformation.setOpaque(true);

//        JLabel introInformation = new JLabel("CryptoGlyph is a cryptographic application that allows users to encrypt and decrypt data\nusing numerous algorithms");
//        introInformation.setForeground(Color.BLACK);
//        introInformation.setBackground(Color.WHITE);
//        introInformation.setBounds(200,260,500, 60);
//        introInformation.setOpaque(true);

        frame.add(sidePanel);
        frame.add(homeButton);
        frame.add(homeButtonSelected);
        frame.add(symmetric);
        frame.add(symmetricSelected);
        frame.add(asymmetric);
        frame.add(asymmetricSelected);
        frame.add(keyPNG);
        frame.add(topPanelSegment);
        frame.add(bottomPanelSegment);
        frame.add(symmetricLabel);
        frame.add(topPanel);
        frame.add(logo);
        frame.add(projectName);
        frame.add(homePNG);
        frame.add(intro);
        frame.add(introInformation);

        symmetric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                symmetricScreen(frame, intro, introInformation, symmetricSelected, homeButtonSelected);
            }
        });

        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.repaint();
        frame.revalidate();
    }

    public void symmetricScreen(JFrame frame, JLabel intro, JTextArea introInformation, JLabel symmetricSelected, JLabel homeButtonSelected) {
        frame.remove(intro);
        frame.remove(introInformation);
        homeButtonSelected.setBackground(Color.BLACK);
        symmetricSelected.setBackground(new Color(192,27,54));

        JLabel caesarsPNG = new JLabel();
        caesarsPNG.setIcon(new ImageIcon("src\\img\\caesarsLogo.png"));
        caesarsPNG.setBounds(225, 200, 100, 100);
        caesarsPNG.setBackground(Color.WHITE);
        caesarsPNG.setOpaque(true);

        JButton caesarsButton = new JButton("Caesar's Cipher");
        caesarsButton.setForeground(Color.BLACK);
        caesarsButton.setBackground(new Color(192,27,54));
        caesarsButton.setBounds(200,300,150,30);

        JLabel a51PNG = new JLabel();
        a51PNG.setIcon(new ImageIcon("src\\img\\a51.png"));
        a51PNG.setBounds(500, 200, 250, 100);
        a51PNG.setOpaque(true);

        JButton a51Button = new JButton("A5/1 Cipher");
        a51Button.setForeground(Color.BLACK);
        a51Button.setBackground(new Color(192,27,54));
        a51Button.setBounds(550,300, 150, 30);
        a51Button.setOpaque(true);

        frame.add(caesarsPNG);
        frame.add(caesarsButton);
        frame.add(a51PNG);
        frame.add(a51Button);

        frame.repaint();
        frame.revalidate();

        List<JComponent> components = new ArrayList<>();
        components.add(caesarsPNG);
        components.add(caesarsButton);
        components.add(a51Button);
        components.add(a51PNG);

        caesarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String algorithm = "Caesar's Cipher";
                cryptographyWindow(algorithm, frame, components);
                //cryptographyWindow(String algorithm, JFrame frame, List<JComponent> components);
            }
        });

        a51Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String algorithm = "A5/1 Cipher";
                cryptographyWindow(algorithm, frame, components);
            }
        });
    }

    public void cryptographyWindow(String algorithm, JFrame frame, List<JComponent> components) {
        for (Component component: components) {
            frame.remove(component);
        }

        JLabel algorithmName = new JLabel(algorithm);
        algorithmName.setBounds(200,200,300,50);
        algorithmName.setFont(new Font("Serif2", Font.BOLD, 25));
        algorithmName.setForeground(Color.BLACK);
        algorithmName.setBackground(Color.WHITE);
        algorithmName.setOpaque(true);

        JLabel plaintext = new JLabel("Plaintext");
        plaintext.setBounds(200,300,150,30);
        plaintext.setBackground(new Color(192,27,54));
        plaintext.setForeground(Color.BLACK);
        plaintext.setOpaque(true);

        JTextField plaintextField = new JTextField();
        plaintextField.setBounds(400, 300, 150, 30);
        plaintextField.setOpaque(true);

        JLabel encryptKey = new JLabel("Key");
        encryptKey.setBounds(200,350,150,30);
        encryptKey.setBackground(new Color(192,27,54));
        encryptKey.setForeground(Color.BLACK);
        encryptKey.setOpaque(true);

        JTextField encryptKeyField = new JTextField();
        encryptKeyField.setBounds(400, 350, 150, 30);
        encryptKeyField.setOpaque(true);

        JButton encryptButton = new JButton("Encrypt");
        encryptButton.setBackground(new Color(192,27,54));
        encryptButton.setForeground(Color.BLACK);
        encryptButton.setBounds(300,400,150,30);
        encryptButton.setOpaque(true);

        JLabel divider = new JLabel();
        divider.setBackground(Color.BLACK);
        divider.setBounds(770,300,10,450);
        divider.setOpaque(true);

        JLabel ciphertext = new JLabel("Ciphertext");
        ciphertext.setForeground(Color.BLACK);
        ciphertext.setBackground(new Color(192,27,54));
        ciphertext.setBounds(1000,300,150,30);
        ciphertext.setOpaque(true);

        JTextField ciphertextField = new JTextField();
        ciphertextField.setBounds(1200,300,150,30);
        ciphertextField.setOpaque(true);

        JLabel decryptKey = new JLabel("Key");
        decryptKey.setBackground(new Color(192,27,54));
        decryptKey.setForeground(Color.BLACK);
        decryptKey.setBounds(1000,350,150,30);
        decryptKey.setOpaque(true);

        JTextField decryptKeyField = new JTextField();
        decryptKeyField.setBounds(1200,350,150,30);
        decryptKeyField.setOpaque(true);

        JButton decryptButton = new JButton("Decrypt");
        decryptButton.setBackground(new Color(192,27,54));
        decryptButton.setForeground(Color.BLACK);
        decryptButton.setBounds(1100,400,150,30);
        decryptButton.setOpaque(true);

        frame.add(algorithmName);
        frame.add(encryptButton);
        frame.add(decryptButton);
        frame.add(plaintext);
        frame.add(plaintextField);
        frame.add(encryptKey);
        frame.add(encryptKeyField);
        frame.add(ciphertext);
        frame.add(ciphertextField);
        frame.add(decryptKey);
        frame.add(decryptKeyField);
        frame.add(divider);

        frame.repaint();
        frame.revalidate();

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plaintext = plaintextField.getText();
                String key = encryptKeyField.getText();
                String ciphertext="";

                switch (algorithm) {
                    case "Caesar's Cipher":
                        Caesar tester = new Caesar();
                        ciphertext = tester.encrypt(plaintext, key);
                        break;
                    case "A5/1 Cipher":
                        //call a51
                        A51 a51 = new A51();
                        ciphertext = a51.encrypt(plaintext, key);
                        break;
                }

                JLabel output = new JLabel("Output");
                output.setFont(new Font("Serif2", Font.BOLD, 20));
                output.setBounds(200, 500, 150, 30);
                output.setBackground(Color.WHITE);
                output.setForeground(Color.BLACK);
                output.setOpaque(true);

                JTextArea encryptionOutput = new JTextArea(ciphertext);
                encryptionOutput.setBackground(new Color(255,255,255,40));
                encryptionOutput.setBounds(200, 550,500,150);
                encryptionOutput.setOpaque(true);

                frame.add(output);
                frame.add(encryptionOutput);

                frame.revalidate();
                frame.repaint();
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciphertext = ciphertextField.getText();
                String key = decryptKeyField.getText();
                String plaintext = "";

                switch (algorithm) {
                    case "Caesar's Cipher":
                        Caesar tester = new Caesar();
                        plaintext = tester.decrypt(ciphertext, key);
                        break;
                    case "A5/1 Cipher":
                        A51 a51 = new A51();
                        plaintext = a51.decrypt(ciphertext, key);
                        break;
                }

                JLabel output = new JLabel("Output");
                output.setFont(new Font("Serif2", Font.BOLD, 20));
                output.setBounds(1000, 500, 150, 30);
                output.setBackground(Color.WHITE);
                output.setForeground(Color.BLACK);
                output.setOpaque(true);

                JTextArea decryptionOutput = new JTextArea(plaintext);
                decryptionOutput.setBackground(new Color(255,255,255,40));
                decryptionOutput.setBounds(1000, 550,500,150);
                decryptionOutput.setOpaque(true);

                frame.add(output);
                frame.add(decryptionOutput);

                frame.repaint();
                frame.revalidate();
            }
        });
    }


    public static void main(String[] args) {
        GUI graphicalInterface = new GUI();
        graphicalInterface.MyFrame();
    }
}
