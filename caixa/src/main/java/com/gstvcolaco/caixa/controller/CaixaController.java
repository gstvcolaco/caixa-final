package com.gstvcolaco.caixa.controller;

import com.gstvcolaco.caixa.model.Caixa;
import com.gstvcolaco.caixa.model.Localiza;
import com.gstvcolaco.caixa.repository.CaixaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/caixa"})
public class CaixaController {

    @Autowired
    CaixaRepository cxr;

    List<Caixa> listaCaixa;
    List<Caixa> listaLocaliza;

    @GetMapping("/")
    public String listaCaixa(Model model) {
        listaCaixa= cxr.findAll();
        model.addAttribute("listaCaixa", listaCaixa);
        return "/index";
    }

    @GetMapping("/novo")
    public String novoCaixa(Model model) {
        Caixa caixa = new Caixa();
        model.addAttribute("caixa", caixa);
        return "insere";
    }
    @GetMapping("/edita")
    public String editaTransacao(@RequestParam("id") Integer id, Model model){
        Optional<Caixa> caixa=cxr.findById(id);
        if(caixa.isPresent()) {
            model.addAttribute("caixa", caixa.get());
            return "insere";
        }
        return "/caixa/";
    }
    @GetMapping("/exclui")
    public String excluiPrato(@RequestParam("id") Integer id){
        cxr.deleteById(id);
        return "redirect:/caixa/";
    }

    @GetMapping("/novoLocaliza")
    public String novoLocaliza(Model model) {
        Localiza localiza = new Localiza();
        model.addAttribute("localiza", localiza);
        return "pesquisa";
    }

    @PostMapping("/localiza")
    public String montaLocaliza(@ModelAttribute("localiza") Localiza localiza, Model model) {
        // Ajusta as datas se a data inicial for após a data final
        if (localiza.getDataInicial().after(localiza.getDataFinal())) {
            Date temp = localiza.getDataInicial();
            localiza.setDataInicial(localiza.getDataFinal());
            localiza.setDataFinal(temp);
        }

        // Obtém a lista de localizações
        List<Caixa> listaTransacoes = cxr.findByDataBetween(localiza.getDataInicial(), localiza.getDataFinal());

        // Adiciona a lista de localizações ao modelo
        model.addAttribute("listalocaliza", listaTransacoes);

        // Retorna a página de pesquisa
        return "resultado";
    }
    /*@GetMapping("/localiza")
public String montaLocaliza(@ModelAttribute("localiza") Localiza localiza, Model model) {
    // Ajusta as datas se a data inicial for após a data final
    if (localiza.getDataInicial().after(localiza.getDataFinal())) {
        Date temp = localiza.getDataInicial();
        localiza.setDataInicial(localiza.getDataFinal());
        localiza.setDataFinal(temp);
    }

    // Obtém a lista de transações entre as datas
    List<Caixa> listaTransacoes = cxr.findByDataBetween(localiza.getDataInicial(), localiza.getDataFinal());

    // Adiciona a lista de transações ao modelo
    model.addAttribute("listaCaixa", listaTransacoes);
    return "/resultado"; // Retorna a view que exibirá os resultados
}*/

    @PostMapping("/salvar")
    public String salvaCaixa(@ModelAttribute("caixa") Caixa caixa) {
        cxr.save(caixa);
        return "redirect:/caixa/";
    }
}
