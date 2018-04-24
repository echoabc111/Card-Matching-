package a;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
public class TB extends JFrame implements ActionListener{
	IPanel ip=null;
	Header header=null;


	JMenuBar jmb=null;
	JMenu jm=null;
	JMenuItem jmi=null;
	JTextField jtf=null;
	Timer t;
	public static void main(String[] args){
		TB t=new TB();
	}
	
public TB()	{

	header=new Header();
	Thread t1=new Thread(header);
	t1.start();
	jmi=new JMenuItem("New Game");
	jmi.addActionListener(this);
	jmi.setActionCommand("new");
	jm=new JMenu("Game");
	jm.add(jmi);
	jmb=new JMenuBar();
	jmb.add(jm);
	ip=new IPanel();	
	Thread t3=new Thread(ip);
    t3.start();
	this.setJMenuBar(jmb);
	this.setTitle("Matching Game");
	this.setLayout(new BorderLayout());
	this.add(header,BorderLayout.NORTH);	
	this.add(ip,BorderLayout.CENTER);
	this.setVisible(true);
	this.setSize(400,400);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getActionCommand().equals("new")){
		  this.getContentPane().removeAll();
		 
		    IPanel ip=new IPanel();
		    this.ip.SCORE=0;
		    Thread t3=new Thread(ip);
		    t3.start();
		    Header header=new Header();
		    this.header.jtf.setText(null);;
		    Thread t1=new Thread(header);
			t1.start();
			this.setTitle("Matching Game");
			this.setLayout(new BorderLayout());
			this.add(header,BorderLayout.NORTH);	
			this.add(ip,BorderLayout.CENTER);
			this.setVisible(true);
			this.setSize(400,400);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

}