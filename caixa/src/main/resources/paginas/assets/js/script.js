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
    window.location.href = "index.html"
}

