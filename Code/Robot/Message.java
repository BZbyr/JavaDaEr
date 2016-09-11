import java.io.*;
import java.util.*;

/** 
 * The class of message contains content
 * @author Boyang Zhang
 * @date 2015/05/29
 */
public class Message {
	private String content;
	
	public Message() {
		
	}
	
	public Message(String content) {
		this.content = content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
		
	public String toString(){
		return this.content;
	}
	
	/**
	 * read data from a specific file according to input filename
	 * @param filename file name to read data
	 * @return ArrayList
	 * @exception Exception
	 */
	public ArrayList<Message> read(String filename) throws Exception {
		ArrayList<Message> msgList = new ArrayList<Message>();
		Scanner reader = new Scanner(new File(filename));
		while (reader.hasNext()) {
			String[] s = reader.nextLine().split(",");
			msgList.add(new Message(s[0]));
		}
		reader.close();
		return msgList;
	}
	
	/**
	 * write data into a specific file according to filename
	 * @param filename file name to write data
	 * @param msgList the data waiting to be writen
	 * @return boolean
	 * @exception Exception
	 */
	public boolean write(String filename, ArrayList<Message> msgList) throws Exception {
		BufferedWriter output = new BufferedWriter(new FileWriter(filename));
		for (int i = 0; i < msgList.size(); i++) {
			output.write(msgList.get(i).toString() + "\r\n");
		}
		output.close();
		return true;
	}
}
