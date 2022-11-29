import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Navigation extends ComponentScreen {
    private String location = "HOME";
    private HashMap<String,JLabel> navMap = new HashMap<>();
    private String[] labels = {"HOME","SYMMETRIC","ASYMMETRIC"};
    private JLabel homeButtonSelected;
    private JLabel symmetricSelected;
    private JLabel asymmetricSelected;
    private JLabel[] selectedLabels = {homeButtonSelected,symmetricSelected,asymmetricSelected};

    public Navigation(NewGUI f){
        super(f);
        homeButtonSelected = new JLabel();
        homeButtonSelected.setBackground(new Color(192, 27, 54));
        homeButtonSelected.setBounds(0, 200, 15, 50);
        homeButtonSelected.setOpaque(true);

        symmetricSelected = new JLabel();
        symmetricSelected.setBackground(Color.BLACK);
        symmetricSelected.setBounds(0, 250, 15, 50);
        symmetricSelected.setOpaque(true);

        asymmetricSelected = new JLabel();
        asymmetricSelected.setBackground(Color.BLACK);
        asymmetricSelected.setBounds(0, 300, 15, 50);
        asymmetricSelected.setOpaque(true);
//        for (int i=0;i<3;i++){
//            navMap.put(labels[i],selectedLabels[i]);
//
//        }
        add(homeButtonSelected);
        add(symmetricSelected);
        add(asymmetricSelected);
        show();


//        navMap["Home"] =
    }
    public void navigate(String s){
        if (s.equals(location)){
            System.out.println("Already at: "+ location);
            return;
        }
        location = s;

        if(s.equals("SYMMETRIC")){
            symmetricSelected.setBackground(Color.RED);
            homeButtonSelected.setBackground(Color.BLACK);
            asymmetricSelected.setBackground(Color.BLACK);
        }
        else if(s.equals("ASYMMETRIC")){
            asymmetricSelected.setBackground(Color.RED);
            homeButtonSelected.setBackground(Color.BLACK);
            symmetricSelected.setBackground(Color.BLACK);
        }
        else{
            homeButtonSelected.setBackground(Color.RED);
            symmetricSelected.setBackground(Color.BLACK);
            asymmetricSelected.setBackground(Color.BLACK);
        }

//        for (String key: navMap.keySet()){
//            if(!key.equals(s)){
//                System.out.println(key);
//                if(navMap.get(key).getBackground() != Color.BLACK){
//                    navMap.get(key).setBackground(Color.BLACK);
//                }
//            }
//        }
//        navMap.get(s).setBackground(Color.RED);
////        navMap.get(s).setBackground(new Color(192,27,54));
        update();
    }
}
