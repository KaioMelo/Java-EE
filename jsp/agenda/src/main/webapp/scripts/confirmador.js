/**
 * Confirmação de exclusão de um contato
 * @author Kaio Melo dos Santos
 * @param idcontato 
 */

 function confirmar(idcontato){
	 let resposta = confirm("Confirma a exclusão deste usuario?");
	 if(resposta === true){
		 window.location.href = "delete?idcontato="+idcontato
	 }
 }