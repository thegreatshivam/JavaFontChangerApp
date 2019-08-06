import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame{
    private JTextField textField;
    private JCheckBox italicFontChanger;
    private JCheckBox boldFontChanger;
    private JRadioButton redColor;
    private JRadioButton greenColor;
    private JRadioButton blackColor;

    public Gui(){
        super("The world's best ever App");
        setLayout(new FlowLayout());

        textField = new JTextField("Check the check boxes");
        textField.setFont(new Font("Sherif", Font.PLAIN, 25));
        add(textField);

        italicFontChanger = new JCheckBox("Italic");
        boldFontChanger = new JCheckBox("Bold");
        add(boldFontChanger);
        add(italicFontChanger);

        redColor = new JRadioButton("Red");
        greenColor = new JRadioButton("Green");
        blackColor = new JRadioButton("Default");
        add(redColor);
        add(greenColor);
        add(blackColor);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(redColor);
        buttonGroup.add(greenColor);
        buttonGroup.add(blackColor);

        HandlerClass handler = new HandlerClass();

        boldFontChanger.addItemListener(handler);
        italicFontChanger.addItemListener(handler);

        redColor.addItemListener(handler);
        greenColor.addItemListener(handler);
        blackColor.addItemListener(handler);

    }
    private class HandlerClass implements ItemListener {
        public void itemStateChanged(ItemEvent event){
            Font font = null;

            if(boldFontChanger.isSelected() && italicFontChanger.isSelected()){
                font = new Font("Sherif", Font.BOLD + Font.ITALIC, 25);
                textField.setText("Bold & Italic Text");
            }else if(boldFontChanger.isSelected()){
                font = new Font("Sherif", Font.BOLD, 25);
                textField.setText("Bold Text");
            }else if(italicFontChanger.isSelected()){
                font = new Font("Sherif", Font.ITALIC, 25);
                textField.setText("Italic Text");
            }else{
                font = new Font("Sherif", Font.PLAIN, 25);
                textField.setText("Plain Text");
            }
            textField.setFont(font);

            if(greenColor.isSelected()){
                textField.setForeground(Color.GREEN);
            }else if(redColor.isSelected()) {
                textField.setForeground(Color.RED);
            }else if(blackColor.isSelected()){
                textField.setForeground(Color.BLACK);
            }
        }
    }
}