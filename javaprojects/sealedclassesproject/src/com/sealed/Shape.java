package com.sealed;

public sealed interface Shape  permits Rectangle, Circle{
	public abstract double getArea();
	public abstract double getPerimeter();
	
}
