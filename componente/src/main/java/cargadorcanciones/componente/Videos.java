package cargadorcanciones.componente;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
 "video"
})
@XmlRootElement(name = "videos")
public class Videos {

	protected List<Video> videos;

	 public List<Video> getVideo() {
	     if (videos == null) {
	         videos = new ArrayList<Video>();
	     }
	     return this.videos;
	 }
 
}

