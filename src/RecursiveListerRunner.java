public class RecursiveListerRunner {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new RecursiveListerFrame("Recursive Lister").setVisible(true);
        });
    }
}