import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RecursiveListerFrame extends JFrame {
    private JButton startButton;
    private JButton quitButton;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JLabel titleLabel;

    public RecursiveListerFrame(String title) {
        super(title);

        startButton = new JButton("Start");
        quitButton = new JButton("Quit");
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        titleLabel = new JLabel("Recursive Lister");

        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.add(quitButton);

        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButtonClicked();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitButtonClicked();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void startButtonClicked() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            FileLister fileLister = new FileLister();
            String fileListing = fileLister.listAllFiles(selectedDirectory);
            textArea.setText(fileListing);
        }
    }

    private void quitButtonClicked() {
        System.exit(0);
    }
}

