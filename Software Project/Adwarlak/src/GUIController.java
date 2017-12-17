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
//        instance.mainFrame.setSize(750, 600);
        instance.mainFrame.setVisible(true);
		instance.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        running=new GuestGUI();
		instance.mainFrame.add(running);
		instance.mainFrame.revalidate();
	}
	//Attributes
	private JFrame mainFrame;
	private JPanel running;
	private ArrayList<JPanel> previousPanels=new ArrayList<JPanel>();
	
	//Functions
	//Go to previous panel
	public void goPanelBack() {
		int index=instance.previousPanels.size();
		if(index>=1) {
			swapPanelWith(instance.previousPanels.get(index-1));
		}
	}
	//clear Prev Panels
	public void clearPreviousPanels() {
		instance.previousPanels.clear();
	}
	//swaping Panels
    public void swapPanelWith(JPanel p2) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	instance.previousPanels.add(running);
                if (instance.previousPanels.size()>10) {
					instance.previousPanels.remove(0);
				}
                instance.mainFrame.remove(running);
                running=p2;
                instance.mainFrame.add(running);
                instance.mainFrame.invalidate();
                instance.mainFrame.revalidate();
                instance.mainFrame.pack();
            }
        });
    }
}