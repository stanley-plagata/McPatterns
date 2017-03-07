/**
 * @author Stanley Plagata
 */
import java.io.FileNotFoundException;

public class McPatterns {
    public static void main(String[] args) throws FileNotFoundException {
        McPatternsGUI gui = new McPatternsGUI(new McPatternsPresenter("menu.txt"));
    }
 }