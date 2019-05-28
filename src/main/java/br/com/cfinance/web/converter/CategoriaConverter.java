package br.com.cfinance.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.*;

import br.com.cfinance.categoria.*;

@FacesConverter(forClass = Categoria.class) 
public class CategoriaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) { 
		if (value != null && value.trim().length() > 0) {
			Integer codigo = Integer.valueOf(value); 
			try {
				CategoriaRN categoriaRN = new CategoriaRN();
				return categoriaRN.carregar(codigo); 
			} catch (Exception e) {
				throw new ConverterException("N�o foi poss�vel encontrar a categoria de c�digo " 
					+ value + ". " + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) { 
		if (value != null) {
			Categoria categoria = (Categoria) value; 
			return categoria.getCodigo().toString(); 
		}
		return "";
	}
}
