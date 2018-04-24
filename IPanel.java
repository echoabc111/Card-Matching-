package  a;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class IPanel extends JPanel implements ActionListener,Runnable{
	private Card[] cards;
	private ImageIcon[] icons;
	private int[] ins;
	private Icon iback;
	private Vector turned;
	public static int SCORE=0;
	private Timer t;
	private boolean isWin=false;
	JOptionPane pane;
	JDialog dialog;
	public IPanel(){
		this.setLayout(new GridLayout(4,4,0,0));
		cards=new Card[16];
		icons=new ImageIcon[16];
		ins=new int[16];
		turned=new Vector(2);
		this.getIcons();
		this.shuffle(icons, ins);
		this.makeCard(icons,ins );
	
			
	}
	//generate 16 icons from 4 imageicons and assign to 16 buttons
	  public void getIcons(){
		  ImageIcon[] icon=new ImageIcon[5];
			icon[0]=new ImageIcon("/Users/huichunliu/Documents/workspace/1Headfirst/src/cse115lab10/tileboard/tb1.png");
			icon[1]=new ImageIcon("/Users/huichunliu/Documents/workspace/1Headfirst/src/cse115lab10/tileboard/tb2.png");
			icon[2]=new ImageIcon("/Users/huichunliu/Documents/workspace/1Headfirst/src/cse115lab10/tileboard/tb3.png");
			icon[3]=new ImageIcon("/Users/huichunliu/Documents/workspace/1Headfirst/src/cse115lab10/tileboard/tb4.png");
			icon[4]=new ImageIcon("/Users/huichunliu/Documents/workspace/1Headfirst/src/cse115lab10/tileboard/tb5.png");
			this.iback=icon[4];	
			ImageIcon h[]=new ImageIcon[8];
			int[] helper=new int[8];
			for(int i=0;i<icon.length-1;i++){
				h[2*i]=icon[i];
				h[2*i+1]=icon[i];
				helper[2*i]=i;
			    helper[2*i+1]=i;
				}
			for(int j=0;j<8;j++){
				icons[j]=h[j];
				icons[j+8]=h[j];
				ins[j]=helper[j];
				ins[j+8]=helper[j];
			}
			}
	  
	  public void shuffle(ImageIcon[] a,int[] b){
			Random r=new Random();
			for(int i=a.length-1;i>0;i--){  //15'
				int j=r.nextInt(i);
			    ImageIcon temp=a[j]; 
			    a[j]=a[i]; 
			    a[i]=temp;
			    int temp1=b[j]; 
			    b[j]=b[i]; 
			    b[i]=temp1;		
			}
			}
	  public void makeCard(ImageIcon[] a,int[] b){
		  
			for(int i=0;i<16;i++){
				this.cards[i]=new Card(a[i],this.iback,b[i]);
				this.cards[i].setIcon(this.iback);
				this.cards[i].addActionListener(this);
				this.cards[i].faceup=false;
				this.add(this.cards[i]);
			}	
		}
	  
	 
	  
	  
	  
	  
	  
	  
	  
	  public void check(Card c){
		  if(this.turned.size()<2){
			  
		  }
		  if(this.turned.size()==2){
			  Card pre=(Card) this.turned.get(0);
			  if(c==pre){
				  this.turned.remove(1);
			  }
			  if(c!=pre){
			  if(c.getId()==pre.getId()){
				  
				 
				  c.setIcon(null);
				  pre.setIcon(null);
				  c.setEnabled(false);
				  pre.setEnabled(false);
				  this.turned.clear();
				  this.SCORE++;
				 
			  }
			  else{
				 
				  this.turned.remove(0);
				  this.turned.set(0, c);
				  pre.setIcon(this.iback);
				  
						
				  
			  }
			  }  
		  }	  
	  }
	
	  
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.cards.length;i++){
			if (e.getSource()==cards[i]){	
				Card c=cards[i];
				c.turnup();
				this.turned.add(c);
				this.check(c);
				c.turndown();
				break;
			}
		}
	}
	public void showM1(){
	     pane = new JOptionPane("You win!");
		 dialog = pane.createDialog("");
		dialog.setVisible(true);
	}
	 private ActionListener closeJDialog1 = new ActionListener() {		 
		         public void actionPerformed(ActionEvent e) {		 
		             if (dialog.isShowing()) {	 
		                 dialog.dispose();		 
		             }		 
		         }
		 
	 };
	 
	
	
	public void win(){
		if(this.SCORE==8){
			this.showM1();
			this.isWin=true;
		}
	}
	@Override
	public void run() {
         while (true){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		this.win();
		if(this.isWin){
		break;}
	
	}	}
}
