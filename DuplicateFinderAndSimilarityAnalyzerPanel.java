import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DuplicateFinderAndSimilarityAnalyzerPanel extends JPanel {
    private JButton button1, button2;
    private JPanel buttonPanel1, buttonPanel2;

    DuplicateFinderAndSimilarityAnalyzerPanel() {
        super(new BorderLayout());

        button1 = new JButton("Duplicate Files Finder");
        buttonPanel1 = new JPanel();
        buttonPanel1.add(button1);

        button2 = new JButton("Similarity Analyzer");
        buttonPanel2 = new JPanel();
        buttonPanel2.add(button2);

        add(buttonPanel1, BorderLayout.PAGE_START);
        add(buttonPanel2, BorderLayout.CENTER);
        setVisible(true);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DuplicateFinderMain.main();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimilarityAnalyzerMain.main();
            }
        });
    }
}
