$(function() {
        $( "#sheep_4" ).draggable();
        $( ".test_dr" ).droppable({
            drop: function( event, ui ) {
//                $( this )
//                    .addClass( "ui-state-highlight" )
//                    .find( "p" )
//                        .html( "Dropped!" );
            	console.log(event);
            	alert("droped");
            }
        });
    });