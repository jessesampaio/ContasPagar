package br.com.enterprise.BEAN;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

//Definimos um nome para essa convers�o
@FacesConverter(value = "converteData")
public class ConverteData implements Converter {
	
	//Para formatar uma data
	SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	
	//Quando o JSF quer o objeto em quest�o, ele sempre quer um objeto
	//M�todo usado para converter uma String em Objeto
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		try {
			//Retorna objeto do tipo Date "arg2" j� com a data formatada
			return df.parse(arg2);
		} catch (Exception e) {
			return "";
		}
	}
	
	//M�todo usado para converter um objeto em String
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		try {
			//Retorna objeto do tipo Date "arg2" j� com a data formatada
			return df.format((Date) arg2);
		} catch (Exception e) {
			return "";
		}
	}
			


}
