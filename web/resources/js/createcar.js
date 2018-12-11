

function enableElement(elem, elem1){
    
   var checkedElement = document.getElementById("CarCreateForm:dataPanel:" + elem + "_input");
   var enabledElement = document.getElementById("CarCreateForm:dataPanel:" + elem1);
    
   if(checkedElement.checked){
       
       enabledElement.classList.add("ui-state-disabled"); 
        
       
       
   
}else {
       
       enabledElement.classList.remove("ui-state-disabled"); 
     }
}

function disableElement(elem, elem1){
    
   var checkedElement = document.getElementById("CarCreateForm:dataPanel:" + elem);
   var enabledElement = document.getElementById("CarCreateForm:dataPanel:" + elem1);
   
   if(enabledElement.focus){
        
        checkedElement.children[1].classList.add("ui-state-disabled"); 
  
   
}
}

function enableCheckbox(elem, elem1){
    
   var checkedElement = document.getElementById("CarCreateForm:dataPanel:" + elem);
   var enabledElement = document.getElementById("CarCreateForm:dataPanel:" + elem1);
   
   if(enabledElement.blur){
        
        checkedElement.children[1].classList.remove("ui-state-disabled"); 
       
   
}
}


