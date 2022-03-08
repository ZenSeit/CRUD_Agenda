/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
$(document).ready(function() {
    cargarContacts();
});

async function cargarContacts() {
  const request = await fetch('contacts', {
    method: 'GET',
    headers: getHeaders()
  });
  const contacts = await request.json();

if(!contacts.length==0){
    let listadoHtml = '';
  for (let con of contacts) {

    let conHtml = '<tr><td>'+con.name+'</td><td>' + con.phone +'</td><td>' + con.email+ '</td><td>'
                    + con.birth+'</td><td><a href="econtact.html?id='+con.id+'" class="btn btn-warning">Editar</a> <button type="button" onclick="deleteCon('+con.id+')" class="btn btn-danger">Eliminar</button></td></tr>';
    listadoHtml += conHtml;
}

document.querySelector('#contacts tbody').outerHTML =listadoHtml ;
}else{
    document.querySelector('#contacts tbody').outerHTML ="There aren't contacts yet." ;
}
  

}

function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json'
   };
}

async function deleteCon(id) {
  
    const request = await fetch('deletecontact/'+id, {
        
    method: 'DELETE',
    headers: getHeaders(),
  });
  const res = await request.json();
  window.location.href = 'contacts.html';
}


