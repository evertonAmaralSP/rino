package br.com.abril.rino.model;

import java.io.Serializable;

public class Message implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String categoria;
    private String action;
    private String label;
	
    public Message() { super(); }
    
	public Message(String categoria, String action, String label) {
		super();
		this.categoria = categoria;
		this.action = action;
		this.label = label;
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

    
}