/*function showPrice(){
        
       var days = parseInt(document.getElementById("CarViewForm:numOfDays").innerHTML);
       console.log(days);
        
       if(document.getElementById("CarViewForm:ot1") === null ){
            console.log("Значение равно нудд");
            var i;
              
        for(i=2; i<=14; i++){
            var interval = parseInt(document.getElementById("CarViewForm:ot" + i).innerHTML);
            var interval1 = parseInt(document.getElementById("CarViewForm:ot" + (i+1)).innerHTML);
            if(days >= interval && days <= interval1){
                var panelNum = Math.ceil(i/2);
                console.log(panelNum);
                var pricePanel = document.getElementById("CarViewForm:pricePanel" + panelNum);
                var dayPanel = document.getElementById("CarViewForm:dayPanel" + panelNum);
                var price = document.getElementById("CarViewForm:price" + panelNum).innerHTML;
                console.log(price);
                pricePanel.style.cssText="background: orange !important; color: black !important";
                dayPanel.style.cssText="background: orange !important; color: black !important";
                document.getElementById("CarViewForm:rentPrice").innerHTML = parseInt(price) * days;
                document.getElementById("CarViewForm:totalPrice").innerHTML = parseInt(price) * days; 
            }
        }
                
            } else {
            
             console.log("Значение неравно нудд");
             
             var i;
           for( i=1; i<=14; i++){
            var interval = parseInt(document.getElementById("CarViewForm:ot" + i).innerHTML);
            var interval1 = parseInt(document.getElementById("CarViewForm:ot" + (i+1)).innerHTML);
            if(days >= interval && days <= interval1){
                var panelNum = Math.ceil(i/2);
                console.log(panelNum);
                var pricePanel = document.getElementById("CarViewForm:pricePanel" + panelNum);
                var dayPanel = document.getElementById("CarViewForm:dayPanel" + panelNum);
                var price = document.getElementById("CarViewForm:price" + panelNum).innerHTML;
                console.log(price);
                pricePanel.style.cssText="background: orange !important; color: black !important";
                dayPanel.style.cssText="background: orange !important; color: black !important";
                document.getElementById("CarViewForm:rentPrice").innerHTML = parseInt(price) * days;
                document.getElementById("CarViewForm:totalPrice").innerHTML = parseInt(price) * days; 
                
            }
        } 
       
  }
} */
   
function calculate(price, boxName) {
    
    var days = parseInt(document.getElementById("CarViewForm:numOfDays").innerHTML);
    var addPrice = document.getElementById("CarViewForm:addPrice").innerHTML;
    var totalPrice = document.getElementById("CarViewForm:totalPrice").innerHTML;
    var checkBox1 = document.getElementById("CarViewForm:" + boxName + "_input");
    
        if(checkBox1.checked === true){
               var result = parseInt(addPrice) + parseInt(price) * days;
               document.getElementById("CarViewForm:addPrice").innerHTML=result;
               
               var result2 = parseInt(totalPrice) + parseInt(price) * days;    
               document.getElementById("CarViewForm:totalPrice").innerHTML=result2;
        }else {
                var result1 = parseInt(addPrice) - parseInt(price) * days;
                document.getElementById("CarViewForm:addPrice").innerHTML=result1;
                var result2 = parseInt(totalPrice) - parseInt(price) * days;    
                document.getElementById("CarViewForm:totalPrice").innerHTML=result2;
        } 
}

function calculateAddServices(price, boxName) {

    var addPrice = document.getElementById("CarViewForm:addPrice").innerHTML;
    var totalPrice = document.getElementById("CarViewForm:totalPrice").innerHTML;
    var checkBox = document.getElementById("CarViewForm:servicePanel:" + boxName + "_input");
      
    if (checkBox.checked === true) {
        var result = parseInt(addPrice) + parseInt(price);
        document.getElementById("CarViewForm:addPrice").innerHTML = result;

        var result1 = parseInt(totalPrice) + parseInt(price);
        document.getElementById("CarViewForm:totalPrice").innerHTML = result1;
    } else {
        var result2 = parseInt(addPrice) - parseInt(price);
        document.getElementById("CarViewForm:addPrice").innerHTML = result2;
        var result1 = parseInt(totalPrice) - parseInt(price);
        document.getElementById("CarViewForm:totalPrice").innerHTML = result1;
    }
}

