import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlgorithmOptions extends ComponentScreen {
    public AlgorithmOptions(NewGUI f) {
        super(f);
    }
    public void firstAlgorithm(String name,String path) {
        JLabel PNG = new JLabel();
        PNG.setIcon(new ImageIcon(path));
        PNG.setBounds(225, 200, 100, 100);
        PNG.setBackground(Color.WHITE);
        PNG.setOpaque(true);

        JButton b = new JButton(name);
        b.setForeground(Color.BLACK);
        b.setBackground(new Color(192, 27, 54));
        b.setBounds(200, 300, 150, 30);

        add(PNG);
        add(b);
        
        b.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		getFrame().setAlgorithmSelected(true);
        		hide();
        		getFrame().cryptographyWindow(name);
        	}
        });
        getFrame().revalidate();
        getFrame().repaint();
    }
    public void secondAlgorithm(String name,String path) {
        JLabel PNG = new JLabel();
        PNG.setIcon(new ImageIcon(path));
        PNG.setBounds(500, 200, 250, 100);
        PNG.setBackground(Color.WHITE);
        PNG.setOpaque(true);

        JButton b = new JButton(name);
        b.setForeground(Color.BLACK);
        b.setBackground(new Color(192, 27, 54));
        b.setBounds(550, 300, 150, 30);
        b.setOpaque(true);

        add(PNG);
        add(b);
        b.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		getFrame().setAlgorithmSelected(true);
        		hide();
        		getFrame().cryptographyWindow(name);
        	}
        });
        getFrame().revalidate();
        getFrame().repaint();
    }
    public void thirdAlgorithm() {
    	// TODO?
    }
}
