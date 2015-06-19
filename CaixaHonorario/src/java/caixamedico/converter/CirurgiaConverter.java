
package caixamedico.converter;

import caixamedico.entidade.Cirurgia;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cirurgiaConverter", forClass = Cirurgia.class)
public class CirurgiaConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if(value == null || value.isEmpty()){
                return null;
            }
            
            Integer id = Integer.parseInt(value);
            Cirurgia cirurgia = new Cirurgia();
            cirurgia.setIdCirurgia(id);
            return cirurgia;
            
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if(value == null || value.getClass() != Cirurgia.class){
            return null;
        }
        
        Cirurgia cirurgia  = (Cirurgia) value;
        
        return cirurgia.getIdCirurgia().toString();
        
    }
}
