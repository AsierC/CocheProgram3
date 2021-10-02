package com.coche;


public class CocheFisicas extends GLabel{
	private static final long serialVersionUID = 1L;
	
	double posX,posY,velX,velY,dir;
	double dirInertia;
	double dt=1./120.;
	double frontFriction=0.2; //deceleracion base
	double lateralFriction=2.; //derrape
	
	public CocheFisicas() {
		posX=0;posY=0;
		velX=0;velY=0;
		dir=0;
	}
	public CocheFisicas(double f1,double f2,double timeStep) {
		super();
		frontFriction=f1;
		lateralFriction=f2;
		dt=timeStep;
		posX=0;posY=0;
		velX=0;velY=0;
		dir=0;
	}
	public CocheFisicas(double f1,double f2) {
		frontFriction=f1;
		lateralFriction=f2;
		posX=0;posY=0;
		velX=0;velY=0;
		dir=0;
	}
	
	public void update(double acc, double rot) {
		double dirX=Math.sin(dir);
		double dirY=-Math.cos(dir);
		
		dirInertia+=((velY*dirY+velX*dirX)*rot-dirInertia*2.*lateralFriction)*dt;
		dir+=dirInertia*dt;
		dir=dir%(2.*Math.PI);
		
		double velFront=velX*dirX+velY*dirY;
		double velLateral=velX*dirY-velY*dirX;
		
		velFront+=(acc-velFront*frontFriction)*dt;//esta friccion no es correcta (creo, al menos no es friccion solida)
		velLateral+=-velLateral*lateralFriction*dt;//creo que es friccion de fluido
		
		velX=velFront*dirX+velLateral*dirY;
		velY=velFront*dirY-velLateral*dirX;
		
		posX+=velX*dt;
		posY+=velY*dt;
	}
	
	public int getX() {
		return (int) posX;
	}
	public int getY() {
		return (int) posY;
	}
	public double getDir() {
		return dir;	
	}
	public void draw() {
		setLocation(getX(),getY());
		setRotation(dir);
	}
}
