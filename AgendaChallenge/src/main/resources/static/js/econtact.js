/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

let params = new URLSearchParams(location.search);
var id = params.get('id');


    async function cargarContact() {
  const request = await fetch('contact/'+id, {
    method: 'GET',
    headers: getHeaders()
  });
  const contact = await request.json();

document.getElementById("validationDefault01").value = contact.name;
document.getElementById("validationDefault02").value = contact.phone;
document.getElementById("validationDefaultUsername").value = contact.email;
document.getElementById("validationDefault03").value = contact.birth;
id=document.getElementById("idcon").value = contact.id;

}
  

async function editContact() {
    let dat = {};
  dat.name = document.getElementById("validationDefault01").value;
  dat.phone = document.getElementById("validationDefault02").value;
  dat.email = document.getElementById("validationDefaultUsername").value;
  dat.birth = document.getElementById("validationDefault03").value;
  
    const request = await fetch('upcontact/'+id, {
        
    method: 'PUT',
    headers: getHeaders(),
    body: JSON.stringify(dat)
  });
  const res = await request.json();
  window.location.href = 'contacts.html';
}

function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json'
   };
}

   




