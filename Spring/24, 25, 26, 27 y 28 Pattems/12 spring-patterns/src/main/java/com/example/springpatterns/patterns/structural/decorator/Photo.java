package com.example.springpatterns.patterns.structural.decorator;

//la idea principal es poder aplicar filtros, esos filtros valdrian dinero

//clase abstracta que representa una foto
// Foto en si la cual tiene brillo, contraste, saturacion y difuminacion
public abstract class Photo {

	// atributos que son los decoradores que van a cambiarlos
	private Integer brightness;
	private Integer contrast;
	private Integer saturation;
	private Integer blur;
	
	//mostrar
	public abstract String show();

	//calcular el coste
	public abstract double cost();
	
	
	public Integer getBrightness() {
		return brightness;
	}
	public Integer getContrast() {
		return contrast;
	}
	public Integer getSaturation() {
		return saturation;
	}
	public Integer getBlur() {
		return blur;
	}
	public void setBrightness(Integer brightness) {
		this.brightness = brightness;
	}
	public void setContrast(Integer contrast) {
		this.contrast = contrast;
	}
	public void setSaturation(Integer saturation) {
		this.saturation = saturation;
	}
	public void setBlur(Integer blur) {
		this.blur = blur;
	}
	
	

}
