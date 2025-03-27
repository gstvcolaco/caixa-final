package com.gstvcolaco.caixa.controller;

import com.gstvcolaco.caixa.model.Caixa;
import com.gstvcolaco.caixa.model.Localiza;
import com.gstvcolaco.caixa.model.Saldo;
import com.gstvcolaco.caixa.repository.CaixaRepository;
import com.gstvcolaco.caixa.repository.SaldoRepository;
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
    @Autowired
    SaldoRepository sldr;

    @GetMapping("/")
    public String listarCaixa(Model model) {
        listaCaixa = cxr.findAll();
        model.addAttribute("listacaixa", listaCaixa);
        return "paginas/index.html";
    }

    @GetMapping("/novo")
    public String novoCaixa(Model model) {
        Caixa caixa = new Caixa();
        model.addAttribute("caixa", caixa);
        return "paginas/insere.html";
    }
    @GetMapping("/edita")
    public String editaPrato(@RequestParam("id") Integer id, Model model){
        Optional<Caixa> caixa=cxr.findById(id);
        if(caixa.isPresent()) {
            model.addAttribute("caixa", caixa.get());
            return "paginas/insere.html";
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
        return "paginas/pesquisa.html";
    }

    @PostMapping("/Localiza")
    public String montaLocaliza(@ModelAttribute("Localiza") Localiza localiza, Model model) {
        Date di = localiza.getDataInicial();
        Date df = localiza.getDataFinal();
        if (localiza.getDataInicial().after(localiza.getDataFinal())) {
            localiza.setDataFinal(di);
            localiza.setDataInicial(df);
        }
        if (!localiza.getTipo()) {
            localiza.setDataFinal(localiza.getDataInicial());
        } else {
            localiza.setDataFinal(localiza.getDataFinal());
        }
        Caixa saldoI = new Caixa();
        Caixa saldoF = new Caixa();
        saldoI.setData(localiza.getDataInicial());
        saldoI.setDescricao("Saldo Inicial");
        saldoI.setTipo(1);
        saldoI.setValor(sldr.pegaValorAnterior(localiza.getDataInicial()).getLast());
        Double valorF = saldoI.getValor();
        saldoF.setData(localiza.getDataFinal());
        saldoF.setDescricao("Saldo Final");
        System.out.println(valorF);
        saldoF.setTipo(1);
        listaLocaliza = cxr.listaLocaliza(localiza.getDataInicial(), localiza.getDataFinal());
        saldoF.setValor(sldr.pegaValorFinal(localiza.getDataFinal()).getLast());

        listaLocaliza.addFirst(saldoI);
        listaLocaliza.addLast(saldoF);

        model.addAttribute("listalocaliza", listaLocaliza);
        return "paginas/pesquisa.html";
    }

    @PostMapping("/salvar")
    public String salvaCaixa(@ModelAttribute("Caixa") Caixa caixa) {
        Saldo saldo = new Saldo();
        cxr.save(caixa);
        if (sldr.findByData(caixa.getData()).isEmpty()) {
            saldo.setData(caixa.getData());
            saldo.setValor(sldr.pegaValorAnterior(caixa.getData()).getLast());
            sldr.save(saldo);
            if (caixa.getTipo() == 0) {
                sldr.atualizaSaldo(-caixa.getValor(), caixa.getData());
            } else {
                sldr.atualizaSaldo(caixa.getValor(), caixa.getData());
            }
        } else {
            if (caixa.getTipo() == 0) {
                sldr.atualizaSaldo(-caixa.getValor(), caixa.getData());
            } else {
                sldr.atualizaSaldo(caixa.getValor(), caixa.getData());
            }
        }
        return "redirect:/caixa/";
    }
}
