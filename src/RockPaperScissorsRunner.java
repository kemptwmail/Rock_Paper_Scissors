import javax.swing.*;

public class RockPaperScissorsRunner
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            RockPaperScissorsFrame frame = new RockPaperScissorsFrame();
            frame.setTitle("Rock, Paper, Scissors Game");
            frame.setSize(800,800);
            frame.setDefaultCloseOperation(3);
            frame.setVisible(true);
        });

    }
}