package shlyapin.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    private JButton button = new JButton("Press");
    private JPanel panel = new JPanel();
    private JTextField input = new JTextField("",5);
    private JLabel label = new JLabel("Input");
    private JRadioButton radioButton = new JRadioButton("выбери 1 ");
    private JRadioButton radioButton1 = new JRadioButton("выбери 2 ");
    private JCheckBox checkBox = new JCheckBox("выбери", false);
    private Container container = this.getContentPane();

    public Window(){
        super("Simple Exemple");
        this.setBounds(100,100,250,100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        label.setLocation(100,100);
//        this.add(label);

        container.setLayout(new GridLayout(4,2,2,2));
        container.add(label);
        container.add(input);
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton);
        container.add(radioButton);
        radioButton.setSelected(true);
        container.add(radioButton1);
        container.add(checkBox);
        button.addActionListener(new ButtonEvent());
        container.add(button);
    }
    class ButtonEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){
            String messege = "";
            messege += "Button was pressed\n";
            messege += "Text is "+input.getText()+"\n";
            messege += (radioButton.isSelected()?"radio #1 ":"radio #2 ")+" is selected!\n";
            messege += "CheckBox is "+((checkBox.isSelected()) ? "checked" : "unChecked");
            JOptionPane.showMessageDialog(null,messege,"output",JOptionPane.PLAIN_MESSAGE);
//            container.remove(0);
//            container.remove(0);
//            container.remove(0);
//            container.remove(0);
//            container.remove(0);
//            container.remove(0);
        }
    }
}
