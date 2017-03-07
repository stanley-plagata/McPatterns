/**
 * @author Stanley Plagata
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class McPatternsPresenter {
    //This is the class that will handle the model <-> UI communication.
    private String file;
    private ArrayList<MenuModel> menu;
    private McPatternsGUI view;
    
    public McPatternsPresenter(String file) {
    	this.file = file;
    }

    public ArrayList<MenuModel> loadMenuItems() throws FileNotFoundException {
    	menu = new ArrayList<MenuModel>();
    	Scanner in = new Scanner(new File(this.getFile()));
    	while (in.hasNextLine()) {
    		String[] item = in.nextLine().replace("|", " - ").split(" - ");
    		String itemName = item[0];
    		double itemPrice = Double.parseDouble(item[1]);
			menu.add(new MenuModel(itemName, itemPrice));
    	}
    	in.close();
    	return menu;
    }
    
    public String getFile() {
    	return file;
    }

    public void attachView(McPatternsGUI view) {
        this.view = view;
    }
}