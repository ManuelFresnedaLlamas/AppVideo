package cargadorcanciones.componente;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
public class Video {

    @XmlElement(name = "URL", required = true)
    protected String url;
    protected List<String> etiqueta;
    @XmlAttribute(name = "titulo", required = true)
    protected String titulo;
    
    private Vector<VideoListener> videoListeners= new Vector<>();
    
    public synchronized void addVideoListener(VideoListener listener) {
    	videoListeners.addElement(listener);
    }
    
    public synchronized void removeVideoListener(VideoListener listener) {
    	videoListeners.removeElement(listener);
    }


    public String getURL() {
        return url;
    }

    public void setURL(String value) {
        String anteUrl = url;
        url = value;
        if (anteUrl!=value) {
        	VideoEvent evento = new VideoEvent(this, anteUrl, value);
        	notificarCambio(evento);
        }
    }


    private void notificarCambio(VideoEvent evento) {
		Vector lista;
		synchronized (this) {
			lista=(Vector) videoListeners.clone();
		}
		for(int i=0; i<lista.size(); i++){
			VideoListener listener=(VideoListener)lista.elementAt(i);
			listener.enteradoCambioVideo(evento);
		}
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
