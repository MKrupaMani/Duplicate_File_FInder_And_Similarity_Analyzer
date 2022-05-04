import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SimilarityAnalyzerPanel extends JPanel implements ActionListener {
    String[] li = new String[2];
    int count = 0;
    private JButton button1, button2, button3;
    private JFileChooser chooser;
    private JList<String> displayList;
    private DefaultListModel<String> display;
    private JLabel label;

    SimilarityAnalyzerPanel() {
        super(new BorderLayout());
        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel panel = new JPanel(new GridLayout(10, 1, 10, 5));
        button1 = new JButton("File-1");
        button1.addActionListener(this);

        button2 = new JButton("File-2");
        button2.addActionListener(this);

        button3 = new JButton("getSimilarityPercent");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        layout.add(panel);
        label = new JLabel();

        chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        display = new DefaultListModel<>();
        displayList = new JList<>(display);
        displayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        add(layout, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);
        setVisible(true);

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[] result = GetSimilarityPercent.main(li).split(" ");
                    label.setText("Similar Characters : "+result[0]+", Similarity Percent : "+result[1]+"%");
                    count = 0;

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        chooser.showOpenDialog(this);
        String path = String.valueOf(chooser.getSelectedFile());
        li[count] = path;
        count++;
    }
}