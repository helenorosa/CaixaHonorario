
package caixamedico.converter;

import caixamedico.entidade.Pessoa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "pessoaConverter", forClass = Pessoa.class)
public class PessoaConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if(value == null || value.isEmpty()){
                return null;
            }
            Integer id = Integer.parseInt(value);
            Pessoa pessoa = new Pessoa();
            pessoa.setIdPessoa(id);
            return pessoa;
            
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null || value.getClass() != Pessoa.class){
            return null;
        }
        Pessoa pessoa  = (Pessoa) value;
        return pessoa.getIdPessoa().toString();
        
    }
    
}