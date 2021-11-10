package dominio;

import java.util.HashSet;

public class Video {

	private String titulo;
	private HashSet<Etiqueta> etiquetas;
	private String url;
	private String id;
	private int numReproducciones;

	public Video(String titulo, HashSet<Etiqueta> etiquetas, String url, String id) {
		this.titulo=titulo;
		this.etiquetas=new HashSet<Etiqueta>();
		this.url=url;
		this.id=id;
		setNumReproducciones(0);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public HashSet<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(HashSet<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumReproducciones() {
		return numReproducciones;
	}

	public void setNumReproducciones(int numReproducciones) {
		this.numReproducciones = numReproducciones;
	}
	
	

}
