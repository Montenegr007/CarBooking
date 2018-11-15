function showPrice(days){
     for(var i=0; i<7; i++) {
            var headerContent = document.getElementById("CarViewForm:ap" + i + "_header").innerHTML;
            var header = document.getElementById("CarViewForm:ap" + i + "_header");
            var panel = document.getElementById("CarViewForm:ap" + i);
    
       if(headerContent.includes(days)){
            header.style.cssText="background: orange; color: black";
            panel.style.cssText="height: 70px";
            
            }else {
                header.style.cssText="background: orange; opacity: 0.4";
            }
            }
       }



function calculate(price, boxName) {
    
   // var rentPrice = document.getElementById("CarViewForm:rentPrice").innerHTML;
   // var deliveryPrice = document.getElementById("CarViewForm:deliveryPrice").innerHTML;
    var addPrice = document.getElementById("CarViewForm:addPrice").innerHTML;
    var totalPrice = document.getElementById("CarViewForm:totalPrice").innerHTML;
    var checkBox = document.getElementById("CarViewForm:servicePanel:" + boxName + "_input");
                                        
        if(checkBox.checked === true){
               var result = parseInt(addPrice) + parseInt(price);
               document.getElementById("CarViewForm:addPrice").innerHTML=result;
             
        
               var result2 = parseInt(totalPrice) + parseInt(price);    
               document.getElementById("CarViewForm:totalPrice").innerHTML=result2;
        }else {
                var result1 = parseInt(addPrice) - parseInt(price);
                document.getElementById("CarViewForm:addPrice").innerHTML=result1;
                var result2 = parseInt(totalPrice) - parseInt(price);    
                document.getElementById("CarViewForm:totalPrice").innerHTML=result2;
        }
        
           
        
}

