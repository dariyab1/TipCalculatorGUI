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
    private JButton setButton;
    private TipCalculator calculator;

    public MainGUI(){
        createUIComponents();
        setUpListeners();
        calculator=new TipCalculator(0,15,1);
        tipPercent.setText("15%");
        NumPeople.setText("1");
        Bill.setText("0.00");
        tipTotal.setText("$0.00");
        Total.setText("$0.00");
    }

    public void setUpListeners(){
        decreaseTip.addActionListener(this);
        addTip.addActionListener(this);
        decreaseNumPeople.addActionListener(this);
        addNumPeople.addActionListener(this);
        setButton.addActionListener(this);
    }

    public void createUIComponents(){
        setContentPane(MyJPanel);
        setTitle("My GUI");
        setSize(700, 400);
        setLocation(450,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();
        JButton clickedButton=(JButton) source;
        if(clickedButton.equals(addTip)){
            calculator.increaseTip();
            tipPercent.setText(calculator.getTip()+"%");
        }
        if(clickedButton.equals(decreaseTip)){
            calculator.decreaseTip();
            tipPercent.setText(calculator.getTip()+"%");
        }
        if(clickedButton.equals(addNumPeople)){
            calculator.increaseNumPeople();
            NumPeople.setText(""+calculator.getNumberOfPeople());
        }
        if(clickedButton.equals(decreaseNumPeople)){
            calculator.decreaseNumPeople();
            NumPeople.setText(""+calculator.getNumberOfPeople());
        }
        if(clickedButton.equals(setButton)){
            calculator.setBill(Double.parseDouble(Bill.getText()));
            Total.setText("$"+calculator.totalPerPerson());
            tipTotal.setText("$"+calculator.tipPerPerson());
        }
    }



}
