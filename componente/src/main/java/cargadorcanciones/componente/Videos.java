package cargadorcanciones.componente;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Video", propOrder = {
 "url",
 "etiqueta"
})
public class Videos implements Serializable{

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "URL", required = true)
 protected String url;
 protected List<String> etiqueta;
 @XmlAttribute(name = "titulo", required = true)
 protected String titulo;
 
 private boolean cargado=false; //indica si la canción ha sido ya cargada
 private Vector<VideosListener> videosListeners=new Vector<VideosListener>();
 
 public Videos() {
 	
 }
 
 public synchronized void addVideoListener(VideosListener listener) {
	 videosListeners.addElement(listener);
 }
 
 public synchronized void removeVideoListener(VideosListener listener) {
	 videosListeners.removeElement(listener);
 }
 
 
 public void setArchivoVideos() {
	 JFileChooser fichero = new JFileChooser();
	 fichero.showOpenDialog(fichero);
     String ruta = fichero.getSelectedFile().getAbsolutePath();    
     CargadorVideos.cargarVideos(ruta);
     VideosEvent event = new VideosEvent(this);
     
     notificarCargaCanciones(event);
 }
 
 private void notificarCargaCanciones(VideosEvent evento) {
	 Vector<VideosListener> lista;
	 synchronized (this) {
		 lista = (Vector<VideosListener>) videosListeners.clone();
	 }	
	 for(int i=0;i<lista.size();i++) {
		 VideosListener listener=(VideosListener) lista.elementAt(i);
		 listener.enteradoCargaCanciones(evento);
	 }
 }
 
 public String getURL() {
     return url;
 }

 public void setURL(String value) {
     this.url = value;
 }


 public List<String> getEtiqueta() {
     if (etiqueta == null) {
         etiqueta = new ArrayList<String>();
     }
     return this.etiqueta;
 }

 public String getTitulo() {
     return titulo;
 }

 public void setTitulo(String value) {
     this.titulo = value;
 }

}
