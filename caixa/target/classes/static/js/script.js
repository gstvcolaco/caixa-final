//mostrar menu mobile
function menuShow(){
    let menuMobile = document.querySelector('.mobile-menu');
    if (menuMobile.classList.contains('open')){
        menuMobile.classList.remove('open');
    }else{
        menuMobile.classList.add('open')
    }
}

function alterar(){
    var check = document.querySelector("#check")
    var label = document.querySelector(".lboff")
    var input = document.querySelector(".ipoff")
    label.id="lboff"
    input.id="ipoff"
    if(check.checked){
        label.id="on"
        input.id="on"
    } else if(!check.checked){
        label.id="lboff"
        input.id="ipoff"
    }
}

//reload
var btrld = document.querySelector(".rld")
btrld.addEventListener('click', reload)
function reload(){
    window.location.reload()
    console.log("ok")
}
//volta para index
var logo = document.querySelector(".nav-logo")
logo.addEventListener('click', foridx)
function foridx(){
    window.location.href = "/caixa/"
}
// saldo js
document.addEventListener("DOMContentLoaded", function () {
    var saldofinal = 0;
    document.querySelectorAll("table tbody tr").forEach(row => {
        var valorText = row.querySelector("th:nth-child(4)").innerText.replace("R$", "").trim();
        var tipo = row.querySelector("th:nth-child(5)").innerText.trim();
        
        var valor = parseFloat(valorText.replace(",", "."));
        
        if (tipo.toLowerCase() === "entrada") {
            saldofinal += valor;
        } else if (tipo.toLowerCase() === "saida") {
            saldofinal -= valor;
        }
        
    });
    
        var saldotx = document.querySelector("div#saldo")
        saldotx.innerHTML = `<span>R$ ${saldofinal.toFixed(2)}</span>`;
    })


