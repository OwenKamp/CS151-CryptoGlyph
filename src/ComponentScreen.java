import java.util.ArrayList;

import javax.swing.*;

public class ComponentScreen{
	private NewGUI f;
	private ArrayList<JComponent> componentList = new ArrayList<>();
	
	public ComponentScreen(NewGUI f) {
		this.f = f;
	}
	
	protected NewGUI getFrame() {
		return f;
	}
//	Add components the order they will be placed on top of each other. First one is front layer, second is behind.
	public void add(JComponent c) {
		componentList.add(c);
	}
	
	public void hide() {
		for (JComponent c: componentList) {
			f.remove(c);
		}
		f.revalidate();
		f.repaint();
	}
	
	public void show() {
		for (JComponent c: componentList) {
			f.add(c);
		}
		f.revalidate();
		f.repaint();
	}

	public void update(){
		f.revalidate();
		f.repaint();
	}
}
