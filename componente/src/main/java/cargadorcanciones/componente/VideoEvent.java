package cargadorcanciones.componente;

import java.util.EventObject;

@SuppressWarnings("serial")
public class VideoEvent extends EventObject{
	protected String anteriorUrl, nuevoUrl;
	public VideoEvent(Object fuente, String anteUrl, String nuUrl) {
		super(fuente);
		nuevoUrl=nuUrl;
		anteriorUrl=anteUrl;
	}
	
	public String getNuevaUrl() { 
		return nuevoUrl;
	}
	
	public String getAnteriorUrl() { 
		return anteriorUrl;
	}
	
}
