function showPrice(){
        
       var days = parseInt(document.getElementById("CarViewForm:numOfDays").innerHTML);
        
        if(document.getElementById("CarViewForm:ot1") === null ){
            
              
        for(var i=2; i<=14; i++){
            var interval = parseInt(document.getElementById("CarViewForm:ot" + i).innerHTML);
            var interval1 = parseInt(document.getElementById("CarViewForm:ot" + (i+1)).innerHTML);
            if(days >= interval && days <= interval1){
                var panelNum = Math.ceil(i/2);
                var pricePanel = document.getElementById("CarViewForm:pricePanel" + panelNum);
                var dayPanel = document.getElementById("CarViewForm:dayPanel" + panelNum);
                var price = document.getElementById("CarViewForm:price" + panelNum).innerHTML;
                pricePanel.style.cssText="background: orange !important; color: black !important";
                dayPanel.style.cssText="background: orange !important; color: black !important";
                document.getElementById("CarViewForm:rentPrice").innerHTML = parseInt(price) * days;
                document.getElementById("CarViewForm:totalPrice").innerHTML = parseInt(price) * days;
                
            }
        } 
        
        if(document.getElementById("CarViewForm:ot1") !== null ){
            
              
        for(var i=1; i<=14; i++){
            var interval = parseInt(document.getElementById("CarViewForm:ot" + i).innerHTML);
            var interval1 = parseInt(document.getElementById("CarViewForm:ot" + (i+1)).innerHTML);
            if(days >= interval && days <= interval1){
                var panelNum = Math.ceil(i/2);
                var pricePanel = document.getElementById("CarViewForm:pricePanel" + panelNum);
                var dayPanel = document.getElementById("CarViewForm:dayPanel" + panelNum);
                var price = document.getElementById("CarViewForm:price" + panelNum).innerHTML;
                pricePanel.style.cssText="background: orange !important; color: black !important";
                dayPanel.style.cssText="background: orange !important; color: black !important";
                document.getElementById("CarViewForm:rentPrice").innerHTML = parseInt(price) * days;
                document.getElementById("CarViewForm:totalPrice").innerHTML = parseInt(price) * days;
                
            }
        } 
                
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

