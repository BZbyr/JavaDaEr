
/**
 * The main class of the GUI
 * @author Boyang Zhang
 * @time 2016/06/01
 */
public class RobotGUI {
	public static void main(String args[]) {
		RobotInterface ri = new RobotInterface();
		ri.init();
		while(true) {
			ri.welcome();
			while(ri.click==false) {
				System.out.print("");
			}
			inner:
			while (ri.back == false) {
				if(ri.click==true) {
					ri.type();
					ri.click=false;
				}
				while(ri.typeNo==0) {
					System.out.print("");
					if(ri.typeNo>5) {
						ri.invalid();
						ri.typeNo = 0;
					}
				}
				ri.order();
				while(ri.orderNo==0) {
					System.out.print("");
					if(ri.back == true) {
						ri.back = false;
						ri.click = true;
						continue inner;
					}
					if(ri.orderNo>ri.menu.size()) {
						ri.invalid();
						ri.orderNo = 0;
					}
					else if(ri.orderNo!=0) {
						System.out.println(ri.orderNo);
						break inner;
					}
				}
			}	
			ri.joke();
			while(ri.choose==0) {
				System.out.print("");
				if(ri.choose>2) {
					ri.invalid();
					ri.choose = 0;
				}
			}
			if(ri.choose==1) {
				ri.farewell();
			}
			else {
				continue;				
			}
			while(ri.click==false) {
				System.out.print("");
			}
			if(ri.click) {
				ri.click = false;
				ri.sleep();			
			}
			while(ri.click==false) {
				System.out.print("");
			}
			if(ri.click) {
				ri.click = false;
				continue;
			}
		}
	}	
}
