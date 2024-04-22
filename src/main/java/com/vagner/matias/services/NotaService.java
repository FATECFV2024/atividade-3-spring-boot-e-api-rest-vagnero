package com.vagner.matias.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vagner.matias.models.Nota;
import com.vagner.matias.repositories.NotaRepository;

@Component
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;


    public Nota insert(Nota obj) {
        return notaRepository.save(obj);
    }

    public List<Nota> findAll() {
        return notaRepository.findAll();
    }

    public Nota findById(Integer id) {
        Optional<Nota> nota = notaRepository.findById(id);
        return nota.get();
    }

    public void delete(Integer id) {
        notaRepository.deleteById(id);
    }

    public Nota update(Integer id, Nota obj) {
        Nota notas = notaRepository.getReferenceById(id);
        updateData(notas, obj);
        return notaRepository.save(notas);
    }


    private void updateData(Nota notas, Nota obj){
        notas.setBanco_de_Dados(obj.getBanco_de_Dados());
        notas.setDesenv_Web(obj.getDesenv_Web());
        notas.setLogica_e_Programacao(obj.getLogica_e_Programacao());
     
    }



}
