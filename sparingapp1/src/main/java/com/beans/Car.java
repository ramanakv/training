package com.beans;

public class Car {
	
	private Body body;
	private Engine engine;
	private Tyres tyres;
	
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Tyres getTyres() {
		return tyres;
	}
	public void setTyres(Tyres tyres) {
		this.tyres = tyres;
	}
	@Override
	public String toString() {
		return "Car [body=" + body + ", engine=" + engine + ", tyres=" + tyres + "]";
	}
	
	
	

}
