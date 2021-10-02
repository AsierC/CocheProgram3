package com.coche;

import java.awt.event.*;
 
public class KeyHandler extends KeyAdapter implements KeyListener{
	boolean keyUp=false;
	boolean keyDown=false;
	boolean keyRight=false;
	boolean keyLeft=false;
	boolean keyW=false;
	boolean keyS=false;
	boolean keyD=false;
	boolean keyA=false;
	
	
	public KeyHandler() {
		super();
	}
	
	public void keyPressed(KeyEvent e) {
    	     if(e.getKeyCode()==37)keyLeft=true;
    	else if(e.getKeyCode()==38)keyUp=true;
    	else if(e.getKeyCode()==39)keyRight=true;
    	else if(e.getKeyCode()==40)keyDown=true; 
    	else if(e.getKeyCode()==87)keyW=true;
    	else if(e.getKeyCode()==83)keyS=true;
    	else if(e.getKeyCode()==68)keyD=true;
    	else if(e.getKeyCode()==65)keyA=true;
    	//System.out.println(e.getKeyCode());
	}
    public void keyReleased(KeyEvent e) {
    	     if(e.getKeyCode()==37)keyLeft=false;
    	else if(e.getKeyCode()==38)keyUp=false;
    	else if(e.getKeyCode()==39)keyRight=false;
    	else if(e.getKeyCode()==40)keyDown=false;
    	else if(e.getKeyCode()==87)keyW=false;
    	else if(e.getKeyCode()==83)keyS=false;
    	else if(e.getKeyCode()==68)keyD=false;
    	else if(e.getKeyCode()==65)keyA=false;
    }
	public boolean keyUp() {
		return keyUp|keyW;
	}
	public boolean keyDown() {
		return keyDown|keyS;
	}
	public boolean keyRight() {
		return keyRight|keyD;
	}
	public boolean keyLeft() {
		return keyLeft|keyA;
	}
}