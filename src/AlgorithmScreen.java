import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlgorithmScreen extends ComponentScreen
{
    public String algorithm;
    public JLabel algorithmName = new JLabel("");
    public JTextField plaintextField;
    public JTextField encryptKeyField;
    public JTextField ciphertextField;
    public JTextField decryptKeyField;
    public JTextArea decryptionOutput;


    public AlgorithmScreen(NewGUI f){
        super(f);
//        This section is the constant JComponents that do not change
        JLabel plaintext = new JLabel("Plaintext");
        plaintext.setBounds(300,300,150,30);
        plaintext.setBackground(new Color(192,27,54));
        plaintext.setForeground(Color.BLACK);
        plaintext.setOpaque(true);


        JLabel encryptKey = new JLabel("Key");
        encryptKey.setBounds(300,350,150,30);
        encryptKey.setBackground(new Color(192,27,54));
        encryptKey.setForeground(Color.BLACK);
        encryptKey.setOpaque(true);

        JLabel decryptKey = new JLabel("Key");
        decryptKey.setBackground(new Color(192,27,54));
        decryptKey.setForeground(Color.BLACK);
        decryptKey.setBounds(900,350,150,30);
        decryptKey.setOpaque(true);

        JLabel divider = new JLabel();
        divider.setBackground(Color.BLACK);
        divider.setBounds(770,300,10,450);
        divider.setOpaque(true);

        JLabel ciphertext = new JLabel("Ciphertext");
        ciphertext.setForeground(Color.BLACK);
        ciphertext.setBackground(new Color(192,27,54));
        ciphertext.setBounds(900,300,150,30);
        ciphertext.setOpaque(true);

        JLabel output = new JLabel("Output");
        output.setFont(new Font("Serif2", Font.BOLD, 20));
        output.setBounds(800, 500, 150, 30);
        output.setBackground(Color.WHITE);
        output.setForeground(Color.BLACK);
        output.setOpaque(true);

        JButton encryptButton = new JButton("Encrypt");
        encryptButton.setBackground(new Color(192,27,54));
        encryptButton.setForeground(Color.BLACK);
        encryptButton.setBounds(400,400,150,30);
        encryptButton.setOpaque(true);

        JButton decryptButton = new JButton("Decrypt");
        decryptButton.setBackground(new Color(192,27,54));
        decryptButton.setForeground(Color.BLACK);
        decryptButton.setBounds(1000,400,150,30);
        decryptButton.setOpaque(true);

//        This section is the JComponents that do change

//        This JLabel algorithmName gets the text changed based on the algorithm.
        algorithmName.setBounds(200,200,300,50);
        algorithmName.setFont(new Font("Serif2", Font.BOLD, 25));
        algorithmName.setForeground(Color.BLACK);
        algorithmName.setBackground(Color.WHITE);
        algorithmName.setOpaque(true);


        plaintextField = new JTextField();
        plaintextField.setBounds(500, 300, 150, 30);
        plaintextField.setOpaque(true);

        encryptKeyField = new JTextField();
        encryptKeyField.setBounds(500, 350, 150, 30);
        encryptKeyField.setOpaque(true);


        ciphertextField = new JTextField();
        ciphertextField.setBounds(1100,300,150,30);
        ciphertextField.setOpaque(true);


        decryptKeyField = new JTextField();
        decryptKeyField.setBounds(1100,350,150,30);
        decryptKeyField.setOpaque(true);


//        These JComponents change.
        JTextArea encryptionOutput = new JTextArea("");
        encryptionOutput.setBackground(new Color(255,255,255,40));
        encryptionOutput.setBounds(200, 550,500,150);
        encryptionOutput.setOpaque(true);

        JLabel eOut = new JLabel("Output");
        eOut.setFont(new Font("Serif2", Font.BOLD, 20));
        eOut.setBounds(200, 500, 150, 30);
        eOut.setBackground(Color.WHITE);
        eOut.setForeground(Color.BLACK);
        eOut.setOpaque(true);


//        1000, 500, 150, 30)
        decryptionOutput = new JTextArea("");
        decryptionOutput.setBackground(new Color(255,255,255,40));
        decryptionOutput.setBounds(800, 550,500,150);
        decryptionOutput.setOpaque(true);

//        Show the decryptionOutput field, just with blank output.
        add(output);
        add(eOut);
        add(encryptionOutput);
        add(decryptionOutput);

        add(algorithmName);
        add(encryptButton);
        add(decryptButton);
        add(plaintext);
        add(plaintextField);
        add(encryptKey);
        add(encryptKeyField);
        add(ciphertext);
        add(ciphertextField);
        add(decryptKey);
        add(decryptKeyField);
        add(divider);
        update();

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plaintext = plaintextField.getText();
                String key = encryptKeyField.getText();
                String ciphertext="";

                switch (algorithm) {
                    case "Caesar's Cipher":
                        System.out.println("GOT HERE");
                        Caesar tester = new Caesar();
                        ciphertext = tester.encrypt(plaintext, key);
                        break;
                    case "A5/1 Cipher":
                        //call a51
                        A51 a51 = new A51();
                        ciphertext = a51.encrypt(plaintext, key);
                        break;
                    case "Knapsack":
                    	Knapsack k = new Knapsack();
                    	ciphertext = k.encrypt(plaintext,key);
                    	break;
                    case "RSA":
                    	RSA rsa = new RSA();
                    	ciphertext = rsa.encrypt(plaintext,key);
                    	break;
                }
                encryptionOutput.setText(ciphertext);
                update();

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
                    case "Knapsack":
                        Knapsack k = new Knapsack();
                        plaintext = k.decrypt(ciphertext,key);
                        break;
                    case "RSA":
                        RSA rsa = new RSA();
                        plaintext = rsa.decrypt(ciphertext,key);
                        break;
                }
                decryptionOutput.setText(plaintext);
                update();
            }
        });
    }

    public void setAlgorithmName(String algorithm){
        this.algorithm = algorithm;
        algorithmName.setText(this.algorithm);
        update();
    }

}
