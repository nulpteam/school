$(function() {
       $( ".p1" ).draggable({ disabled: false });
       $( ".p2" ).draggable({ disabled: false });
       $( ".p3" ).draggable({ disabled: false });
       $( ".p4" ).draggable({ disabled: false });
       $( ".test_sheep" ).draggable();
        
       
       $( ".test_dr" ).droppable({
        	tolerance : "touch",
            drop: function( event, ui ) {
//                $( this )
//                    .addClass( "ui-state-highlight" )
//                    .find( "p" )
//                        .html( "Dropped!" );
            	console.log(event);
            	console.log(ui);
            	//console.log(b);
            	alert("droped");
            }
        });
       
       
       $( "#X0_Y0" ).droppable({
       	tolerance : "touch",
           drop: function( event, ui ) {
        	   console.log(event);
           	console.log(ui);
           	alert("droped into "+this.id);
           }
       });
       
       $( "#X1_Y0" ).droppable({
          	tolerance : "touch",
              drop: function( event, ui ) {
            	  console.log(event);
              	console.log(ui);
              	alert("droped into "+this.id);
              }
          });
       $( "#X2_Y0" ).droppable({
         	tolerance : "touch",
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
             	alert("droped into "+this.id);
             }
         });
       $( "#X3_Y0" ).droppable({
         	tolerance : "touch",
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
             	alert("droped into "+this.id);
             }
         });
       $( "#X4_Y0" ).droppable({
         	tolerance : "touch",
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
             	alert("droped into "+this.id);
             }
         });
       $( "#X5_Y0" ).droppable({
         	tolerance : "touch",
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
             	alert("droped into "+this.id);
             }
         });
       $( "#X6_Y0" ).droppable({
         	tolerance : "touch",
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
             	alert("droped into "+this.id);
             }
         });
       $( "#X7_Y0" ).droppable({
         	tolerance : "touch",
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
             	alert("droped into "+this.id);
             }
         });
       $( "#X8_Y0" ).droppable({
         	tolerance : "touch",
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
             	alert("droped into "+this.id);
             }
         });
       $( "#X9_Y0" ).droppable({
        	tolerance : "touch",
            drop: function( event, ui ) {
            	console.log(event);
            	console.log(ui);
            	alert("droped into "+this.id);
            }
        });
       
       
       
       
       
       
       
       
       
       
       
       
    });