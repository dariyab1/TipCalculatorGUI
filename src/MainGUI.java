import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame implements ActionListener{
    private JTextField Bill;
    private JTextField tipPercent;
    private JTextField NumPeople;
    private JButton decreaseTip;
    private JButton addTip;
    private JButton decreaseNumPeople;
    private JButton addNumPeople;
    private JTextField tipTotal;
    private JTextField Total;
    private JPanel MyJPanel;
    private TipCalculator calculator;

    public MainGUI(TipCalculator calculator){
        this.calculator=calculator;
        createUIComponents();
    }

    public void setUpListeners(){
        decreaseTip.addActionListener(this);
        addTip.addActionListener(this);
        decreaseNumPeople.addActionListener(this);
        addNumPeople.addActionListener(this);
    }

    public void createUIComponents(){
        setContentPane(MyJPanel);
        setTitle("My GUI");
        setSize(600, 600);
        setLocation(450,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();
        JButton clickedButton=(JButton) source;
        String buttonText= clickedButton.getName();
        System.out.println(buttonText);
    }
}
