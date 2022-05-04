import javax.swing.JFrame;

class SimilarityAnalyzerMain {

    public static void main() {
        launchFinder();
    }

    private static void launchFinder() {
        JFrame frame = new JFrame("Similarity Analyzer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.add(new SimilarityAnalyzerPanel());
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

    }

}
