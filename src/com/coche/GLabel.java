package com.coche;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

import javax.swing.*;
public class GLabel extends JLabel{
	private static final long serialVersionUID = 1L;
	BufferedImage original;
	BufferedImage rotated;
	int sizeX;
	int sizeY;
	double rot;
	public GLabel(BufferedImage o) {
		super();
		original = o;
		ColorModel cm = original.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = original.copyData(null);
		rotated=new BufferedImage(cm, raster, isAlphaPremultiplied, null);
		rot=0;
	}
	public GLabel() {
		super();
		rot=0;
	}
	public void setSize(int x,int y){
		sizeX=x;
		sizeY=y;
		
		Graphics2D g = rotated.createGraphics();
		g.setBackground(new Color(255, 255, 255, 0));
		g.clearRect(0, 0, original.getWidth(),original.getHeight());
		g.rotate(rot,original.getWidth()/2,original.getHeight()/2);
        g.drawImage(original, 0, 0, null);
        super.setIcon(new ImageIcon(rotated.getScaledInstance(sizeX, sizeY, Image.SCALE_SMOOTH)));
	}
	public void setRotation(double a) {
		rot=a;
		
		Graphics2D g = rotated.createGraphics();
		g.setBackground(new Color(255, 255, 255, 0));
		g.clearRect(0, 0, original.getWidth(),original.getHeight());
		g.rotate(rot,original.getWidth()/2,original.getHeight()/2);
        g.drawImage(original, 0, 0, null);
        super.setIcon(new ImageIcon(rotated.getScaledInstance(sizeX, sizeY, Image.SCALE_SMOOTH)));
	}
	public BufferedImage getOriginal() {
		return original;
	}
	public void setImage(BufferedImage o) {
		original = o;
		ColorModel cm = original.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = original.copyData(null);
		rotated=new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
}