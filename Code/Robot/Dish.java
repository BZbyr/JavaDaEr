import java.io.*;
import java.util.*;

/** 
 * The class of dish contains type, dishName, price and stock
 * @author Boyang Zhang
 * @date 2015/05/29
 */
public class Dish {
	private int type;
	private String dishName;
	private double price;
	private int stock;
	
	public Dish() {
		
	}
	
	public Dish(int type, String dishName, double price, int stock) {
		this.type = type;
		this.dishName = dishName;
		this.price = price;
		this.stock = stock;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}
	
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getDishName() {
		return dishName;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStock() {
		return stock;
	}
	public boolean checkStock() {
		if(stock==0)
			return false;
		else
			return true;
	}
	
	public String toString(){
		return this.type + "," + this.dishName + "," + this.price + "," + this.stock;
	}
	
	/**
	 * read data from a specific file according to input filename
	 * @param filename file name to read data
	 * @return ArrayList
	 * @exception Exception
	 */
	public ArrayList<Dish> read(String filename) throws Exception {
		ArrayList<Dish> dishList = new ArrayList<Dish>();
		Scanner reader = new Scanner(new File(filename));
		while (reader.hasNext()) {
			String[] s = reader.nextLine().split(",");
			dishList.add(new Dish(Integer.parseInt(s[0]),s[1],Double.parseDouble(s[2]),
					Integer.parseInt(s[3])));
		}
		reader.close();
		return dishList;
	}
	
	/**
	 * write data into a specific file according to filename
	 * @param filename file name to write data
	 * @param dishList the data waiting to be writen
	 * @param orderNo the type of dish
	 * @return boolean
	 * @exception Exception
	 */
	public boolean write(String filename, ArrayList<Dish> dishList, int orderNo) throws Exception {
		BufferedWriter output = new BufferedWriter(new FileWriter(filename));
		for (int i = 0; i < dishList.size(); i++) {
			if(orderNo-1 == i) {
				dishList.get(i).setStock(dishList.get(i).getStock()-1);
			}
			output.write(dishList.get(i).toString() + "\r\n");
		}
		output.close();
		return true;
	}
}
