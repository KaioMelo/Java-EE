/**
 * Validação de formulário
 * @author Kaio Melo
 */

 function validar(){
	 let nome = document.getElementById("nome").value;
	 let fone = document.getElementById("fone").value;
	 if(nome === ""){
		 alert('Preencha o campo Nome')
		 nome.focus()
		 return false
	 }else if(fone === ""){
		 alert('Preencha o campo Telefone')
		 fone.focus()
		 return false
	 }else{
		 document.getElementById("formulario").submit()
	 }
 }