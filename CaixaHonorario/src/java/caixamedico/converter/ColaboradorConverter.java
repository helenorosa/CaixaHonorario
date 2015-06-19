
package caixamedico.converter;

import caixamedico.entidade.Colaborador;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "colaboradorConverter", forClass = Colaborador.class)
public class ColaboradorConverter implements Converter {
    
     @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if(value == null || value.isEmpty()){
                return null;
            }
            Integer id = Integer.parseInt(value);
            Colaborador colaborador = new Colaborador();
            colaborador.setIdColaborador(id);
            return colaborador;
            
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if(value == null || value.getClass() != Colaborador.class){
            return null;
        }
        Colaborador colaborador  = (Colaborador) value;
        return colaborador.getIdColaborador().toString();
        
    }
}
