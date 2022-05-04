import javax.swing.JFrame;

public class DuplicateFinderMain {

	public static void main() {
		launchFinder();
	}

	private static void launchFinder() {
		JFrame frame = new JFrame("Duplicate Files Finder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.add(new DuplicateFinderPanel());
		frame.setVisible(true);
		frame.setSize(700, 500);
		frame.setLocationRelativeTo(null);

	}

}
