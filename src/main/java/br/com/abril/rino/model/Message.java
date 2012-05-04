package br.com.abril.rino.model;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String categoria;
    private String action;
    private String label;
    private Date date;
    private Cygnus cygnus;

	public Message() { super(); date = new Date();}

	public Message(String categoria, String action, String label, Cygnus cygnus) {
		super();
		this.categoria = categoria;
		this.action = action;
		this.label = label;
		this.cygnus = cygnus;
		this.date = new Date();
	}
	
	public Message(String categoria, String action, String label) {
		super();
		this.categoria = categoria;
		this.action = action;
		this.label = label;
		this.date = new Date();
	}

	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
    public Date getDate() {
		return date;
	}	
    public Cygnus getCygnus() {
		return cygnus;
	}

    
}