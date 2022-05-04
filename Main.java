import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        launchFinder();
    }

    private static void launchFinder() {
        JFrame frame = new JFrame("Duplicate Files Finder && Similarity Analyzer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.add(new DuplicateFinderAndSimilarityAnalyzerPanel());
        frame.setVisible(true);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
    }
}
