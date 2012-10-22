$(function() {

		//матриця розташування кораблів(XY) координати
		var Mat  = createMatrix();
		console.log(Mat);
       
		//кораблі
		$( "#sheep_1" ).draggable();
		$( "#sheep_2" ).draggable();
		$( "#sheep_3" ).draggable();
		$( "#sheep_4" ).draggable();
      
      
		//this.id - ідентифікатор комірки
     	//ui.draggable.context.id - тип корабля (витягується з id корабля)
       /*+++++++-Y0-+++++++*/
       $( "#X0_Y0" ).droppable({
       	tolerance : "touch",
       	hoverClass: 'hover',
       		drop: function( event, ui ) {
        	   console.log(event);
           	console.log(ui);
//           alert("droped into "+this.id);
           	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
           	$("#"+ui.draggable.context.id).draggable('disable');
           },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
      });
       
       $( "#X1_Y0" ).droppable({
          	tolerance : "touch",
          	hoverClass: 'hover',
              drop: function( event, ui ) {
            	  console.log(event);
              	console.log(ui);
//              	alert("droped into "+this.id);
              	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
              	$("#"+ui.draggable.context.id).draggable('disable');
              },
     			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
          });
       $( "#X2_Y0" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X3_Y0" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X4_Y0" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X5_Y0" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X6_Y0" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X7_Y0" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X8_Y0" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X9_Y0" ).droppable({
        	tolerance : "touch",
        	hoverClass: 'hover',
        	drop: function( event, ui ) {
            	console.log(event);
            	console.log(ui);
//            	alert("droped into "+this.id);
            	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
            	$("#"+ui.draggable.context.id).draggable('disable');
            },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
        });
       
       /*+++++++-Y1-+++++++*/
       $( "#X0_Y1" ).droppable({
       	tolerance : "touch",
       	hoverClass: 'hover',   
       	drop: function( event, ui ) {
        	   console.log(event);
           	console.log(ui);
//           	alert("droped into "+this.id);
           	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
           	$("#"+ui.draggable.context.id).draggable('disable');
           },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
       });
       
       $( "#X1_Y1" ).droppable({
          	tolerance : "touch",
          	hoverClass: 'hover',
              drop: function( event, ui ) {
            	  console.log(event);
              	console.log(ui);
//              	alert("droped into "+this.id);
              	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
              	$("#"+ui.draggable.context.id).draggable('disable');
              },
     			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
          });
       $( "#X2_Y1" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X3_Y1" ).droppable({
         tolerance : "touch",
         hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X4_Y1" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover', 
         	drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X5_Y1" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
         	drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X6_Y1" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X7_Y1" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X8_Y1" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X9_Y1" ).droppable({
        	tolerance : "touch",
        	hoverClass: 'hover',
            drop: function( event, ui ) {
            	console.log(event);
            	console.log(ui);
//            	alert("droped into "+this.id);
            	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
            	$("#"+ui.draggable.context.id).draggable('disable');
            },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
        });
       
       /*+++++++-Y2-+++++++*/
       $( "#X0_Y2" ).droppable({
       	tolerance : "touch",
       	hoverClass: 'hover',
           drop: function( event, ui ) {
        	   console.log(event);
           	console.log(ui);
//           	alert("droped into "+this.id);
           	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
           	$("#"+ui.draggable.context.id).draggable('disable');
           },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
       });
       
       $( "#X1_Y2" ).droppable({
          	tolerance : "touch",
          	hoverClass: 'hover',
              drop: function( event, ui ) {
            	  console.log(event);
              	console.log(ui);
//              	alert("droped into "+this.id);
              	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
              	$("#"+ui.draggable.context.id).draggable('disable');
              },
     			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
          });
       $( "#X2_Y2" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X3_Y2" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X4_Y2" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X5_Y2" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X6_Y2" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X7_Y2" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X8_Y2" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X9_Y2" ).droppable({
        	tolerance : "touch",
        	hoverClass: 'hover',
            drop: function( event, ui ) {
            	console.log(event);
            	console.log(ui);
//            	alert("droped into "+this.id);
            	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
            	$("#"+ui.draggable.context.id).draggable('disable');
            },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
        });
       /*+++++++-Y3-+++++++*/
       $( "#X0_Y3" ).droppable({
       	tolerance : "touch",
       	hoverClass: 'hover',
           drop: function( event, ui ) {
        	   console.log(event);
           	console.log(ui);
//           	alert("droped into "+this.id);
           	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
           	$("#"+ui.draggable.context.id).draggable('disable');
           },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
       });
       
       $( "#X1_Y3" ).droppable({
          	tolerance : "touch",
          	hoverClass: 'hover',
              drop: function( event, ui ) {
            	  console.log(event);
              	console.log(ui);
//              	alert("droped into "+this.id);
              	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
              	$("#"+ui.draggable.context.id).draggable('disable');
              },
     			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
          });
       $( "#X2_Y3" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X3_Y3" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X4_Y3" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X5_Y3" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X6_Y3" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X7_Y3" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X8_Y3" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X9_Y3" ).droppable({
        	tolerance : "touch",
        	hoverClass: 'hover',
            drop: function( event, ui ) {
            	console.log(event);
            	console.log(ui);
//            	alert("droped into "+this.id);
            	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
            	$("#"+ui.draggable.context.id).draggable('disable');
            },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
        });
       /*+++++++-Y4-+++++++*/
       $( "#X0_Y4" ).droppable({
       	tolerance : "touch",
       	hoverClass: 'hover',
           drop: function( event, ui ) {
        	   console.log(event);
           	console.log(ui);
//           	alert("droped into "+this.id);
           	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
           	$("#"+ui.draggable.context.id).draggable('disable');
           },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
       });
       
       $( "#X1_Y4" ).droppable({
          	tolerance : "touch",
          	hoverClass: 'hover',
              drop: function( event, ui ) {
            	  console.log(event);
              	console.log(ui);
//              	alert("droped into "+this.id);
              	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
              	$("#"+ui.draggable.context.id).draggable('disable');
              },
     			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
          });
       $( "#X2_Y4" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X3_Y4" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X4_Y4" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X5_Y4" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X6_Y4" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X7_Y4" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X8_Y4" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X9_Y4" ).droppable({
        	tolerance : "touch",
        	hoverClass: 'hover',
            drop: function( event, ui ) {
            	console.log(event);
            	console.log(ui);
//            	alert("droped into "+this.id);
            	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
            	$("#"+ui.draggable.context.id).draggable('disable');
            },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
        });
       /*+++++++-Y5-+++++++*/
       $( "#X0_Y5" ).droppable({
       	tolerance : "touch",
       	hoverClass: 'hover',
           drop: function( event, ui ) {
        	   console.log(event);
           	console.log(ui);
//           	alert("droped into "+this.id);
           	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
           	$("#"+ui.draggable.context.id).draggable('disable');
           },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
       });
       
       $( "#X1_Y5" ).droppable({
          	tolerance : "touch",
          	hoverClass: 'hover',
              drop: function( event, ui ) {
            	  console.log(event);
              	console.log(ui);
//              	alert("droped into "+this.id);
              	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
              	$("#"+ui.draggable.context.id).draggable('disable');
              },
     			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
          });
       $( "#X2_Y5" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X3_Y5" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X4_Y5" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X5_Y5" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X6_Y5" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X7_Y5" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X8_Y5" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X9_Y5" ).droppable({
        	tolerance : "touch",
        	hoverClass: 'hover',
            drop: function( event, ui ) {
            	console.log(event);
            	console.log(ui);
//            	alert("droped into "+this.id);
            	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
            	$("#"+ui.draggable.context.id).draggable('disable');
            },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
        });
       /*+++++++-Y6-+++++++*/
       $( "#X0_Y6" ).droppable({
       	tolerance : "touch",
       	hoverClass: 'hover',
           drop: function( event, ui ) {
        	   console.log(event);
           	console.log(ui);
//           	alert("droped into "+this.id);
           	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
           	$("#"+ui.draggable.context.id).draggable('disable');
           },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
       });
       
       $( "#X1_Y6" ).droppable({
          	tolerance : "touch",
          	hoverClass: 'hover',
              drop: function( event, ui ) {
            	  console.log(event);
              	console.log(ui);
//              	alert("droped into "+this.id);
              	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
              	$("#"+ui.draggable.context.id).draggable('disable');
              },
     			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
          });
       $( "#X2_Y6" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X3_Y6" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X4_Y6" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X5_Y6" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X6_Y6" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X7_Y6" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X8_Y6" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X9_Y6" ).droppable({
        	tolerance : "touch",
        	hoverClass: 'hover',
            drop: function( event, ui ) {
            	console.log(event);
            	console.log(ui);
//            	alert("droped into "+this.id);
            	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
            	$("#"+ui.draggable.context.id).draggable('disable');
            },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
        });
       /*+++++++-Y7-+++++++*/
       $( "#X0_Y7" ).droppable({
       	tolerance : "touch",
       	hoverClass: 'hover',
           drop: function( event, ui ) {
        	   console.log(event);
           	console.log(ui);
//           	alert("droped into "+this.id);
           	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
           	$("#"+ui.draggable.context.id).draggable('disable');
           },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
       });
       
       $( "#X1_Y7" ).droppable({
          	tolerance : "touch",
          	hoverClass: 'hover',
              drop: function( event, ui ) {
            	  console.log(event);
              	console.log(ui);
//              	alert("droped into "+this.id);
              	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
              	$("#"+ui.draggable.context.id).draggable('disable');
              },
     			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
          });
       $( "#X2_Y7" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X3_Y7" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X4_Y7" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X5_Y7" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X6_Y7" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X7_Y7" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X8_Y7" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X9_Y7" ).droppable({
        	tolerance : "touch",
        	hoverClass: 'hover',
            drop: function( event, ui ) {
            	console.log(event);
            	console.log(ui);
//            	alert("droped into "+this.id);
            	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
            	$("#"+ui.draggable.context.id).draggable('disable');
            },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
        });
       /*+++++++-Y8-+++++++*/
       $( "#X0_Y8" ).droppable({
       	tolerance : "touch",
       	hoverClass: 'hover',
           drop: function( event, ui ) {
        	   console.log(event);
           	console.log(ui);
//           	alert("droped into "+this.id);
           	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
           	$("#"+ui.draggable.context.id).draggable('disable');
           },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
       });
       
       $( "#X1_Y8" ).droppable({
          	tolerance : "touch",
          	hoverClass: 'hover',
              drop: function( event, ui ) {
            	  console.log(event);
              	console.log(ui);
//              	alert("droped into "+this.id);
              	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
              	$("#"+ui.draggable.context.id).draggable('disable');
              },
     			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
          });
       $( "#X2_Y8" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X3_Y8" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X4_Y8" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X5_Y8" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X6_Y8" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X7_Y8" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X8_Y8" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X9_Y8" ).droppable({
        	tolerance : "touch",
        	hoverClass: 'hover',
            drop: function( event, ui ) {
            	console.log(event);
            	console.log(ui);
//            	alert("droped into "+this.id);
            	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
            	$("#"+ui.draggable.context.id).draggable('disable');
            },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
        });
       /*+++++++-Y9-+++++++*/
       $( "#X0_Y9" ).droppable({
       	tolerance : "touch",
       	hoverClass: 'hover',
           drop: function( event, ui ) {
        	   console.log(event);
           	console.log(ui);
//           	alert("droped into "+this.id);
           	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
           	$("#"+ui.draggable.context.id).draggable('disable');
           },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
       });
       
       $( "#X1_Y9" ).droppable({
          	tolerance : "touch",
          	hoverClass: 'hover',
              drop: function( event, ui ) {
            	  console.log(event);
              	console.log(ui);
//              	alert("droped into "+this.id);
              	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
              	$("#"+ui.draggable.context.id).draggable('disable');
              },
     			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
          });
       $( "#X2_Y9" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X3_Y9" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X4_Y9" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X5_Y9" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X6_Y9" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X7_Y9" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X8_Y9" ).droppable({
         	tolerance : "touch",
         	hoverClass: 'hover',
             drop: function( event, ui ) {
            	 console.log(event);
             	console.log(ui);
//             	alert("droped into "+this.id);
             	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
             	$("#"+ui.draggable.context.id).draggable('disable');
             },
    			out: function(event, ui)
       	        {
       				clearOldCoordsInM(this.id, ui.draggable.context.id);
       	        }
         });
       $( "#X9_Y9" ).droppable({
        	tolerance : "touch",
        	hoverClass: 'hover',
            drop: function( event, ui ) {
            	console.log(event);
            	console.log(ui);
//            	alert("droped into "+this.id);
            	saveCoords(this.id, ui.draggable.context.id,ui.draggable.context.className);
            	$("#"+ui.draggable.context.id).draggable('disable');
            },
   			out: function(event, ui)
   	        {
   				clearOldCoordsInM(this.id, ui.draggable.context.id);
   	        }
        });
    });