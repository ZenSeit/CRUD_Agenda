/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

async function addContact() {
    let dat = {};
  dat.name = document.getElementById("validationDefault01").value;
  dat.phone = document.getElementById("validationDefault02").value;
  dat.email = document.getElementById("validationDefaultUsername").value;
  dat.birth = document.getElementById("validationDefault03").value;
  
  console.log(JSON.stringify(dat));
    const request = await fetch('createcontact', {
        
    method: 'POST',
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

