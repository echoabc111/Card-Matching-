package a;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Card extends JButton {
      Icon face;
      Icon back;
      int id;
      boolean faceup=false;
   
	public Card(Icon face, Icon back, int id) {
		super();
		this.face = face;
		this.back = back;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id= id;
	}
	public Card() {
		super();
	}
	public Icon getFace() {
		return face;
	}
	public void setFace(Icon face) {
		this.face = face;
	}
	public Icon getBack() {
		return back;
	}
	public void setBack(Icon back) {
		this.back = back;
	} 
      
    public void turnup(){// 
    	
    	 
    	if (this.faceup==false){
    		this.setIcon(this.face);
    	}
    	if(this.faceup==true)
    		return;
    }
	public void turndown(){
		if(this.faceup==false) 
			return;
	    if(this.faceup==true){
	    	this.setIcon(this.back);
	    	this.faceup=false;
	    }
	}
	

}
