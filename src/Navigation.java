import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Navigation {
    HashMap<String,JComponent> navMap = new HashMap<>();
    String[] labels = {"Home","Symmetric","Asymmetric"};
    JLabel homeButtonSelected;
    JLabel symmetricSelected;
    JLabel asymmetricSelected;
    JComponent[] selectedLabels = {homeButtonSelected,symmetricSelected,asymmetricSelected};

    public Navigation(){
        homeButtonSelected = new JLabel();
        homeButtonSelected.setBackground(new Color(192, 27, 54));
        homeButtonSelected.setBounds(0, 200, 15, 50);
        homeButtonSelected.setOpaque(true);

        symmetricSelected = new JLabel();
        symmetricSelected.setBackground(Color.BLACK);
        //symmetricSelected.setBackground(new Color(192,27,54));
        symmetricSelected.setBounds(0, 250, 15, 50);
        symmetricSelected.setOpaque(true);

        asymmetricSelected = new JLabel();
        //asymmetricSelected.setBackground(new Color(192, 27, 54));
        asymmetricSelected.setBackground(Color.BLACK);
        asymmetricSelected.setBounds(0, 300, 15, 50);
        asymmetricSelected.setOpaque(true);
//        for (
//                navMap.put()

//        ArrayList<JComponent> jcs = new JComponent[];
//        navigate("Home"){
//            if(selected == Home)
//                return;
//            else{
//                for(k,v in hashmap)
//                    if(!= selected)
//                        hide or remove
//            }
//        }
//        for k,v in HashMpa


//        navMap["Home"] =
    }
    public void navigate(String s){



//        homeButtonSelected.setBackground(Color.BLACK);
//        symmetricSelected.setBackground(new Color(192,27,54));
    }
}
