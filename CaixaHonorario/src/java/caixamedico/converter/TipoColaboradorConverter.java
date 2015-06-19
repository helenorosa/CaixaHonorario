package caixamedico.converter;

import caixamedico.entidade.Especialidade;
import caixamedico.entidade.TipoColaborador;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "tipoColaboradorConverter", forClass = Especialidade.class)
public class TipoColaboradorConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if(value == null || value.isEmpty()){
                return null;
            }
            
            Integer id = Integer.parseInt(value);
            TipoColaborador tipoColaborador = new TipoColaborador();
            tipoColaborador.setIdTipoColaborador(id);
            return tipoColaborador;
            
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if(value == null || value.getClass() != TipoColaborador.class){
            return null;
        }
        
        TipoColaborador tipoColaborador  = (TipoColaborador) value;
        
        return tipoColaborador.getIdTipoColaborador().toString();
        
    }
    
}
