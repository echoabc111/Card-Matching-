package a;
/**
 * top area (time recorder)
 * 
 */
import java.awt.*;
import javax.swing.*;
public class Header extends JPanel implements Runnable {
	JLabel jl=null;
	JLabel time=null;
	String tt="";
	JTextField jtf=null;
	
	

	public Header(){	
		jl=new JLabel("Time: ");
		jtf=new JTextField();
		jtf.setEditable(false);
		jtf.setColumns(10);	
		this.add(jl);
		this.add(jtf);
		
	
	
	
	
	
	
}

	@Override
	
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				
				long startTime = System.currentTimeMillis();
		        while (IPanel.SCORE!=8) {
		        	String str = String.format("%1$tM:%1$tS:%1$1tL", System.currentTimeMillis() - startTime);
		        	
		            jtf.setText(str.substring(0, 7));		
			}
		}
		}}
		
		
		
		
		
		
	


