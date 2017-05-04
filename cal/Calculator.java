package cal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
/**
 * 
 * @author Yastika Kumar
 *
 */
public class Calculator extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	///////*****FONT*****///////
	private final Font FONT = new Font("Times New Roman",Font.PLAIN,20);
	//////******DECLARATIONS******//////// 
	JTextField txt = new JTextField("",12);
	/////****DOUBLES****//////
	double convert = 0;
	double pretotal;
	double total = 0;
	/////****STRINGS****/////
	String key = "";
	String s ="";
	String s1 = "";
	String choice = "";
	String temp = "";
	/////****BOOLEANS****/////
	boolean number = true;
	boolean operator = true;
	boolean cancel = false;
	Calculator(){
		/////////**** FRAME AND ITS SETTINGS ****///////
		JFrame frame = new JFrame();
		frame.setSize(590, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		/////////**** JTEXTFIELD AND ITS SETTINGS ****////////
		txt.setVisible(true);
		txt.setHorizontalAlignment(JTextField.RIGHT);
	    ////////**** BUTTON ORDER STRING ****///////
		String buttonOrder = "123456789"+"0";
		////////**** CREATING PANEL FOR NUMBERS (BUTTONPANEL) AND OPERATIONS (PANEL) & SETTINGS ITS LAYOUT ****////////
		JPanel buttonPanel = new JPanel();
		JPanel pan = new JPanel();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,4,4,4));
		buttonPanel.setLayout(new GridLayout(4,4,4,4));
		//////////**** ADDING ACTION LISTNER TO BUTTONS IN BUTTONPANEL ****////////
		for(int i = 0;i < buttonOrder.length();i++){
			String key = buttonOrder.substring(i, i+1);
			if(key.equals("")){
				buttonPanel.add(new JLabel(""));
			}
			else{
				JButton button = new JButton(key);
				button.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(e.getSource() == button){
							if(txt.getText().length() > 0 &&  number == false){
								StringBuilder sb = new StringBuilder(txt.getText());
								sb.delete(0, txt.getText().length());
								s = sb.toString();
								txt.setText(s);
								number = true;									
						}
							txt.setText(key);
							s += txt.getText();
						}
						else{
							txt.setText(null);
						}
						txt.setText(s);
					}
				});
				button.setFont(FONT);
				buttonPanel.add(button);
			}
		}
		/////////////**** BUTTONS FOR MATHEMATICAL OPERATIONS ****//////////////
		String [] opOrder = {"+","-","*","/","=","sin","cos","tan","log","C","asin","acos","atan","x^2","x^3","1/x","e","+/-","sqrt","."};
		for(int i = 0;i < opOrder.length;i++){
			s1 = opOrder[i];
			JButton buttonOp = new JButton(s1);
			buttonOp.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				if(e.getSource() == buttonOp){
					if(txt.getText().equals("")){
						txt.setText("");
					}
					else{
						if(cancel == true){
							temp = txt.getText();
							cancel = false;
						}
						else{
						convert = Double.parseDouble(txt.getText());}
					 choice = e.getActionCommand();
					if (choice.equals("+") || choice.equals("-") || choice.equals("*") || choice.equals("/")){
					 if(txt.getText().length() > 0){
						StringBuilder sb = new StringBuilder(txt.getText());
						sb.delete(0, txt.getText().length());
	                    s = sb.toString();
	                    txt.setText(s);}
					 if(choice.equals("*") || choice.equals("/")){
						 pretotal = 1;
					 }
					 else if(choice.equals("+") || choice.equals("-")){
						 pretotal = 0;
					 }
					 temp = choice;
					 operator = false;
					}
					//////////////////**** MATHEMATICAL OPERATIONS ****///////////////
					if(choice.equals("x^2")){
						txt.setText("");
						total = convert * convert;
						s += txt.getText();
					}
					else if(choice.equals("x^3")){
						txt.setText("");
						total = convert * convert * convert;
						s += txt.getText();
					}
					else if(choice.equals("e")){
						txt.setText("");
						total = Math.exp(convert);
						s += txt.getText();
					}
					else if(choice.equals("log")){
						txt.setText("");
						total = Math.log(convert);
						s += txt.getText();
					}
					else if(choice.equals("sin")){
						txt.setText("");
						total = Math.sin(convert);
						s += txt.getText();
					}
					else if(choice.equals("asin")){
						txt.setText(null);
						total = Math.asin(convert);
						s += txt.getText();
					}
					else if(choice.equals("cos")){
						txt.setText(null);
						total = Math.cos(convert);
						s += txt.getText();
					}
					else if(choice.equals("acos")){
						txt.setText(null);
						total = Math.acos(convert);
						s += txt.getText();
					}
					else if(choice.equals("tan")){
						txt.setText(null);
						total = Math.tan(convert);
						s += txt.getText();
					}
					else if(choice.equals("atan")){
						txt.setText(null);
						total = Math.atan(convert);
						s += txt.getText();
					}
					else if(choice.equals("sqrt")){
						txt.setText(null);
						total = Math.sqrt(convert);
						s += txt.getText();
					}
					else if(choice.equals("+/-")){
						txt.setText(null);
						total = Math.abs(convert);
						s += txt.getText();
					}
					else if(choice.equals("1/x")){
						txt.setText(null);
						total = 1/convert;
						s += txt.getText();
					}
					else if(choice.equals(".")){
						txt.setText(".");
						s += txt.getText();
					}
					else if(choice.equals("+")){
	                    pretotal = addition (convert,pretotal);
	                    s += txt.getText();
	                    }
					else if(choice.equals("-")){
						pretotal = subtraction(convert,pretotal);
						s +=txt.getText();
					}
					else if(choice.equals("*")){
						pretotal = multiply(convert,pretotal);
						s +=txt.getText();
					}
					else if(choice.equals("/")){
						pretotal = division(convert,pretotal);
						s += txt.getText();
					}
					else if (choice.equals("=")){
						number = false;
						if(operator == true){
						txt.setText("");
						remove();
					s = Double.toString(total);}
						else{
							if(temp.equals("+")){
								remove();
								total = addition(convert,pretotal);
								s=Double.toString(total);
							}
						   if(temp.equals("-")){
							   remove();
							   total = subtraction(pretotal,convert);
							   s = Double.toString(total);
						   }
						   if(temp.equals("*")){
							   remove();
							   total = multiply(convert,pretotal);
							   s = Double.toString(total);
						   }
						   if(temp.equals("/")){
							   remove();
							   total = division(pretotal,convert);
							   s = Double.toString(total);
						   }
						}
						operator = true;
					s += txt.getText();
				}	
					else if(choice.equals("C")){
						cancel = true;
						try{
						if(txt.getText().length()>0){
							StringBuilder str = new StringBuilder(txt.getText());
							str.deleteCharAt(txt.getText().length()-1);
							s = str.toString();
						}}
						catch(NumberFormatException ex){
							ex.printStackTrace();
							System.out.println("Exception caught");
						}
						txt.setText(s);
						}
					}}
				else{
					txt.setText(null);
				}
				txt.setText(s);
				}
			});
			buttonOp.setFont(FONT);
			panel.add(buttonOp);
		}
		pan.setLayout(new BorderLayout(4,4));
		pan.add(txt,BorderLayout.NORTH);
		pan.add(buttonPanel, BorderLayout.CENTER);
		pan.add(panel, BorderLayout.WEST);
		this.setContentPane(pan);
		this.pack();
		this.setTitle("Calculator");
		this.setResizable(false);
		frame.add(pan);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void remove(){
		if(txt.getText().length() > 0){
			StringBuilder sb = new StringBuilder(txt.getText());
			sb.delete(0, txt.getText().length());
			s = sb.toString();
			txt.setText(s);
		}
	}
	public double addition(double a,double b){
		double sum = a + b;
		return sum;
	}
	public double subtraction (double a, double b){
		double sub = a - b;
		return sub;
	}
	public double multiply (double a, double b){
		double mul = a * b;
		return mul;
	}
	public double division (double a, double b){
		double div = a / b;
		return div;
	}
	
	public static void main(String[] args){
		new Calculator();
	}
	
}
