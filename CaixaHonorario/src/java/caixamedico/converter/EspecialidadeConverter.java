package caixamedico.converter;

import caixamedico.entidade.Especialidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "especialidadeConverter", forClass = Especialidade.class)
public class EspecialidadeConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if(value == null || value.isEmpty()){
                return null;
            }
            Integer id = Integer.parseInt(value);
            Especialidade especialidade = new Especialidade();
            especialidade.setIdEspecialidade(id);
            return especialidade;
            
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null || value.getClass() != Especialidade.class){
            return null;
        }
        Especialidade especialidade  = (Especialidade) value;
        return especialidade.getIdEspecialidade().toString();
    }
}