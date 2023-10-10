import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame
{
    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;

    ImageIcon rockIcon;
    ImageIcon paperIcon;
    ImageIcon scissorsIcon;

    JLabel playWins;
    JLabel compWins;
    JLabel tie;

    JTextField pWins;
    JTextField cWins;
    JTextField tText;

    JTextArea results;
    JScrollPane rPlane;

    int playerWins = 0;
    int computerWins = 0;
    int ties = 0;

    public RockPaperScissorsFrame() {
        JPanel buttonPnl = new JPanel();
        buttonPnl.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        rockIcon = new ImageIcon("Rock.jpg");
        Image Rok = rockIcon.getImage();
        Image scaledRok = Rok.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        rockIcon = new ImageIcon(scaledRok);
        rockBtn = new JButton("Rock", rockIcon);
        paperIcon = new ImageIcon("Paper.png");
        Image Pap = paperIcon.getImage();
        Image scaledPap = Pap.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        paperIcon = new ImageIcon(scaledPap);
        paperBtn = new JButton("Paper", paperIcon);
        scissorsIcon = new ImageIcon("Scissors.png");
        Image Siz = scissorsIcon.getImage();
        Image scaledSiz = Siz.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        scissorsIcon = new ImageIcon(scaledSiz);
        scissorsBtn = new JButton("Scissors", scissorsIcon);
        quitBtn = new JButton("Quit");

        buttonPnl.add(rockBtn);
        buttonPnl.add(paperBtn);
        buttonPnl.add(scissorsBtn);
        buttonPnl.add(quitBtn);

        JPanel statsPnl = new JPanel();
        statsPnl.setLayout(new GridLayout(3, 2));
        statsPnl.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        playWins = new JLabel("Player Wins:");
        pWins = new JTextField(5);
        pWins.setEditable(false);
        compWins = new JLabel("Computer Wins:");
        cWins = new JTextField(5);
        cWins.setEditable(false);
        tie = new JLabel("Ties:");
        tText = new JTextField(5);
        tText.setEditable(false);

        statsPnl.add(playWins);
        statsPnl.add(pWins);
        statsPnl.add(compWins);
        statsPnl.add(cWins);
        statsPnl.add(tie);
        statsPnl.add(tText);

        JPanel resultPnl = new JPanel();
        resultPnl.setLayout(new BorderLayout());
        results = new JTextArea(10, 40);
        results.setEditable(false);
        rPlane = new JScrollPane(results);

        resultPnl.add(rPlane);

        add(buttonPnl, BorderLayout.NORTH);
        add(statsPnl, BorderLayout.WEST);
        add(resultPnl, BorderLayout.CENTER);


        quitBtn.addActionListener(e -> System.exit(0));
        rockBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runGame("Rock");
            }
        });
        paperBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runGame("Paper");

            }
        });
        scissorsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runGame("Scissors");

            }
        });


        pack();
    }

    private void runGame(String playChoice)
    {
        Random random = new Random();
        String[] choices = {"Rock", "Paper", "Scissors"};
        String compChoice = choices[random.nextInt(choices.length)];

        String resultEnd = determineWinner(playChoice, compChoice);

        results.append(resultEnd + "\n");

        pWins.setText(String.valueOf(playerWins));
        cWins.setText(String.valueOf(computerWins));
        tText.setText(String.valueOf(ties));
    }

    private String determineWinner(String playChoice, String compChoice){
        if (playChoice.equals(compChoice))
        {
            ties++;
            return "It is a tie. You both chose " + playChoice;
        }
        else if (
                (playChoice.equals("Rock") && compChoice.equals("Scissors"))
                || (playChoice .equals("Paper") && compChoice.equals("Rock"))
                || (playChoice.equals("Scissors") && compChoice.equals("Paper"))
        ) {
            playerWins++;
            return playChoice + " beats " + compChoice + " (You win!)";
        }
        else
        {
            computerWins++;
            return compChoice + " beats " + playChoice + " (Computer wins.)";

        }
}

}
