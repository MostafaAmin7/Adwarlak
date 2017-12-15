import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUIController {
	// Instance
	private static GUIController instance;
	public static GUIController getInstance() {
		if(instance==null) {
			instance = new GUIController();
		}
		return instance;
	}
	// Constructor
	private GUIController() {
		instance=this;
        instance.mainFrame = new JFrame();
        instance.mainFrame.setVisible(true);
		instance.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instance.mainFrame.add(new GuestGUI());
        instance.mainFrame.pack();
	}
	//Attributes
	private JFrame mainFrame;
	private ArrayList<JPanel> previousPanels=new ArrayList<JPanel>();
	
	//Functions
	//Go to previous panel
	public void goPanelBack(JPanel now) {
		int index=instance.previousPanels.size();
		if(index>=1) {
			swapPanel(now, instance.previousPanels.get(index-1));
		}
	}
	//clear Prev Panels
	public void clearPreviousPanels() {
		instance.previousPanels.clear();
	}
	//swaping Panels
    public void swapPanel(JPanel p1,JPanel p2) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                instance.mainFrame.remove(p1);
                instance.mainFrame.add(p2);
                instance.mainFrame.invalidate();
                instance.mainFrame.revalidate();
                instance.mainFrame.pack();
                instance.previousPanels.add(p1);
                if (instance.previousPanels.size()>10) {
					instance.previousPanels.remove(0);
				}
            }
        });
    }
}