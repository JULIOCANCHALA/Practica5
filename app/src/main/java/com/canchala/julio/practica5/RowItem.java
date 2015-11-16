package com.canchala.julio.practica5;

public class RowItem {

	private String nombre;
	private String tipo;
	private String direc;
	private String telefono;
	private int icon;

	public RowItem(String nombre, String tipo, String direc, String telefono, int icon) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.direc = direc;
		this.telefono = telefono;
		this.icon = icon;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDirec() {
		return direc;
	}

	public void setDirec(String direc) {
		this.direc = direc;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}
}
