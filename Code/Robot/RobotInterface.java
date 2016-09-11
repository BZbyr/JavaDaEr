import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * the robot interface
 * @author Boyang Zhang
 * @time 2016/06/01
 */
public class RobotInterface extends JFrame {
	int random;
	int typeNo;
	int orderNo;
	int choose;
	String filename;
	JFrame frame;
	JLabel up;
	JPanel mid;
	JButton middle;
	JLabel type[];
	JPanel down;
	JButton bottom;
	JTextField text;
	ArrayList<Dish> menu;
	ArrayList<Message> welMsg;
	ArrayList<Message> jkMsg;
	ArrayList<Message> fwMsg;
	ArrayList<Dish> fishList;
	ArrayList<Dish> meatList;
	ArrayList<Dish> riceList;
	ArrayList<Dish> noodleList;
	ArrayList<Dish> drinkList;
	ArrayList<Dish> order;
	boolean click;
	boolean back;
	Message m;
	Dish d;
	JButton ret;
	/**
	 * initialize the user interface
	 */
	public void init() {
		welMsg = new ArrayList<Message>();
		jkMsg = new ArrayList<Message>();
		fwMsg = new ArrayList<Message>();
		menu = new ArrayList<Dish>();
		fishList = new ArrayList<Dish>();
		meatList = new ArrayList<Dish>();
		riceList = new ArrayList<Dish>();
		noodleList = new ArrayList<Dish>();
		drinkList = new ArrayList<Dish>();
		order = new ArrayList<Dish>();
		m = new Message();
		d = new Dish();
		try {
			welMsg = m.read("WelcomeMessages.txt");
			jkMsg = m.read("JokeMessages.txt");
			fwMsg = m.read("FarewellMessages.txt");
			fishList = d.read("FishDishes.txt");
			meatList = d.read("MeatDishes.txt");
			riceList = d.read("RiceDishes.txt");
			noodleList = d.read("NoodleDishes.txt");
			drinkList = d.read("Drinks.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * the welcome interface to show greeting message, click middle panel to continue ordering
	 */
	public void welcome() {
		choose = 0;
		frame = new JFrame();
		
		frame.setSize(900,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		up = new JLabel("Welcome!",JLabel.CENTER);
		mid = new JPanel();
		mid.setLayout(new BorderLayout());
		middle = new JButton("");
		random = (int)(Math.random()*welMsg.size());
		middle.setText(welMsg.get(random).toString());
		mid.add(middle);
		down = new JPanel();
		bottom = new JButton("");
		down.add(BorderLayout.CENTER,bottom);
		frame.add(BorderLayout.NORTH,up);
		frame.add(BorderLayout.CENTER,mid);
		frame.add(BorderLayout.SOUTH,down);
		frame.setVisible(true);
		bottom.setText("Click to view menu!");
		middle.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				click = true;
				frame.dispose();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	/**
	 * the order interface to show type of dishes
	 */
	public void type() {
		frame = new JFrame();
		
		frame.setSize(900,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLUE);
		up = new JLabel("Please select an option:",JLabel.CENTER);
		up.setBackground(Color.BLUE);
		mid = new JPanel();
		mid.setLayout(new GridLayout(2, 3));
		mid.setBackground(Color.BLUE);
		middle = new JButton("Test");
		type = new JLabel[5];
		for(int i = 0; i<type.length; i++) {
			type[i] = new JLabel("",JLabel.CENTER);
			mid.add(type[i]);
			type[i].setOpaque(true);
			type[i].setBackground(new Color((int)(Math.random()*255),
					(int)(Math.random()*255),(int)(Math.random()*255)));
		}
		type[0].setText("1 fish");
		type[1].setText("2 meat");
		type[2].setText("3 rice");
		type[3].setText("4 noodle");
		type[4].setText("5 drink");
		down = new JPanel();
		bottom = new JButton("");
		text = new JTextField();
		text.setPreferredSize(new java.awt.Dimension(100, 24));
		down.add(BorderLayout.CENTER,bottom);
		down.add(BorderLayout.EAST,text);
		down.setBackground(Color.BLUE);
		frame.add(BorderLayout.NORTH,up);
		frame.add(BorderLayout.CENTER,mid);
		frame.add(BorderLayout.SOUTH,down);
		frame.setVisible(true);
		bottom.setText("Option selected: ");
		text.addKeyListener(new KeyAdapter(){      
		    @Override
		    public void keyReleased(KeyEvent e) {
		        if(e.getKeyCode()==Event.ENTER) {
	        			typeNo = Integer.parseInt(text.getText());
	        			if(typeNo <=5 && typeNo >=1)
	        				frame.dispose();
		        	}
		    }
		});
	}
	
	/**
	 * the order interface to show the dishes under specific type
	 */
	public void order() {
		frame = new JFrame();
		
		frame.setSize(900,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLUE);
		up = new JLabel("Please select a dish to order:",JLabel.CENTER);
		mid = new JPanel();
		switch(typeNo) {
		case 1:
			menu = fishList;
			filename = "FishDishes.txt";
			break;
		case 2:
			menu = meatList;
			filename = "MeatDishes.txt";
			break;
		case 3:
			menu = riceList;
			filename = "RiceDishes.txt";
			break;
		case 4:
			menu = noodleList;
			filename = "NoodleDishes.txt";
			break;
		case 5:
			menu = drinkList;
			filename = "Drinks.txt";
			break;
		}
		int row = (int)Math.pow(menu.size(),0.5);
		if(Math.pow(menu.size(),0.5) - (int)Math.pow(menu.size(),0.5)==0)
			row = (int)Math.pow(menu.size(),0.5);
		else
			row = (int)Math.pow(menu.size(),0.5) + 1;
		mid.setLayout(new GridLayout(row, row));
		mid.setBackground(Color.BLUE);
		type = new JLabel[menu.size()]; 
		for(int i = 0; i<menu.size(); i++) {
			type[i] = new JLabel(i+1+": "+menu.get(i).getDishName()+" is "+
					menu.get(i).getPrice() + ". Remain: "+menu.get(i).getStock(),JLabel.CENTER);
			type[i].setOpaque(true);
			type[i].setBackground(new Color((int)(Math.random()*255),
					(int)(Math.random()*255),(int)(Math.random()*255)));
			mid.add(type[i]);
		}
		down = new JPanel();
		bottom = new JButton("Option selected: ");
		text = new JTextField();
		text.setPreferredSize(new java.awt.Dimension(100, 24));
		text.addKeyListener(new KeyAdapter(){      
		    @Override
		    public void keyReleased(KeyEvent e){
		        if(e.getKeyCode()==Event.ENTER) {
		        		try{
			        		if(menu.get(Integer.parseInt(text.getText())-1).getStock()!=0) {
			        			orderNo = Integer.parseInt(text.getText());
			        			order.add(menu.get(orderNo-1));
				        		try {
								d.write(filename, menu, orderNo);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			        			frame.dispose();
			        			System.out.println("Dispose");
			        		}
			        		else {
			        			up.setText("The choice is not available. Please select again, i think 3 is good");
			        		}
		        		}
		        		catch(Exception e1) {
		        			orderNo = Integer.parseInt(text.getText());
		        		}
		        	}
		    }
		});
		ret = new JButton("BACK");
		ret.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				back = true;
				frame.dispose();
			}
			
		});
		down.add(BorderLayout.WEST,ret);
		down.add(BorderLayout.CENTER,bottom);
		down.add(BorderLayout.EAST,text);
		down.setBackground(Color.BLUE);
		frame.add(BorderLayout.NORTH,up);
		frame.add(BorderLayout.CENTER,mid);
		frame.add(BorderLayout.SOUTH,down);
		frame.setVisible(true);
		typeNo = 0;
	}
	
	/**
	 * the delivery interface to show a joke, customer can stop it joking and leave system
	 */
	public void joke() {
		frame = new JFrame();
		
		frame.setSize(900,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		up = new JLabel(order.get(order.size()-1).getDishName()+" is deliveryed.",JLabel.CENTER);
		mid = new JPanel();
		mid.setLayout(new BorderLayout());
		mid.setBackground(Color.BLUE);
		middle = new JButton("Test");
		mid.add(middle);
		random = (int)(Math.random()*jkMsg.size());
		middle.setText(jkMsg.get(random).toString());
		down = new JPanel();
		bottom = new JButton("");
		text = new JTextField();
		text.setPreferredSize(new java.awt.Dimension(100, 24));
		down.add(BorderLayout.CENTER,bottom);
		down.add(BorderLayout.EAST,text);
		frame.add(BorderLayout.NORTH,up);
		frame.add(BorderLayout.CENTER,mid);
		frame.add(BorderLayout.SOUTH,down);
		frame.setVisible(true);
		bottom.setText("1 for Stop, 2 for Order Again");
		text.addKeyListener(new KeyAdapter(){      
		    @Override
		    public void keyReleased(KeyEvent e){
		        if(e.getKeyCode()==Event.ENTER) {
	        			choose = Integer.parseInt(text.getText());
	        			if(choose == 1 || choose ==2)
	        				frame.dispose();
		        	}
		    }
		});
		orderNo = 0;
	}

	/**
	 * the farewell interface to show a bill, customer can click to pay and leave
	 */
	public void farewell() {
		frame = new JFrame();
		
		frame.setSize(900,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLUE);
		up = new JLabel("Your Bill:",JLabel.CENTER);
		mid = new JPanel();
		mid.setLayout(new BorderLayout());
		mid.setBackground(Color.BLUE);
		down = new JPanel();
		bottom = new JButton("");
		text = new JTextField();
		text.setPreferredSize(new java.awt.Dimension(100, 24));
		down.add(BorderLayout.CENTER,bottom);
		down.add(BorderLayout.EAST,text);
		down.setBackground(Color.BLUE);
		frame.add(BorderLayout.NORTH,up);
		frame.add(BorderLayout.CENTER,mid);
		frame.add(BorderLayout.SOUTH,down);
		frame.setVisible(true);
		double total = 0;
		mid.setLayout(new FlowLayout());
		JLabel type[] = new JLabel[order.size()]; 
		System.out.println(order.size());
		for(int i = 0; i<order.size(); i++) {
			type[i] = new JLabel();
			type[i].setText(i+1+": "+order.get(i).getDishName()+" is "+
					order.get(i).getPrice());
			mid.add(type[i]);
			total = total + order.get(i).getPrice();
		}
		bottom.setText("Pay and Leave");
		bottom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				click = true;
				order = new ArrayList<Dish>();
				frame.dispose();
			}
			
		});
		text.setText(" "+total);
		text.setEditable(false);
		choose = 0;
		click = false;
	}
	
	/**
	 * the sleeping interface to show a count-down message, 
	 * customer can see the remain time to wait it waking up or wake it up by clicking
	 */
	public void sleep() {
		System.out.println(click);
		frame = new JFrame();
		
		frame.setSize(900,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		up = new JLabel("I wanna sleep:",JLabel.CENTER);
		mid = new JPanel();
		mid.setLayout(new GridLayout());
		mid.setBackground(Color.BLUE);
		random = (int)(Math.random()*fwMsg.size());
		middle = new JButton("30 Seconds count down.");
		middle.setText(fwMsg.get(random).toString());
		mid.add(middle);
		JButton time = new JButton();
		mid.add(time);
		Date pre = new Date();
		Date now = new Date();
		Point preMouse = MouseInfo.getPointerInfo().getLocation();
		Point nowMouse = MouseInfo.getPointerInfo().getLocation();
		long second = 30000;
		time.setText((second - (now.getTime() - pre.getTime()))/1000+" seconds!");
		down = new JPanel();
		bottom = new JButton("Wake Up");
		down.add(BorderLayout.CENTER,bottom);
		frame.add(BorderLayout.NORTH,up);
		frame.add(BorderLayout.CENTER,mid);
		frame.add(BorderLayout.SOUTH,down);
		frame.setVisible(true);
		bottom.setEnabled(false);
		while(click == false) {
			now = new Date();
			nowMouse = MouseInfo.getPointerInfo().getLocation();
			time.setText((second - (now.getTime() - pre.getTime()))/1000+" seconds!");
			if(preMouse.equals(nowMouse)==false) {
				System.out.println("Mouse Moved");
				click = true;
				break;
			}
			if(now.getTime() - pre.getTime() >= second) {
				up.setText("Now, I am sleeping!");
				middle.setText("Time's up!");
				time.setText("Time's up!");
				bottom.setEnabled(true);
				break;
			}
		}
		bottom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				click = true;
				frame.dispose();
			}
	
		});
	}

	/**
	 * jump an error message window to show customer should input a valid number
	 */
	public void invalid() {
			JOptionPane.showMessageDialog(null, "Out of range, please enter a valid option",
					"Albert", JOptionPane.ERROR_MESSAGE); 
	}
}
