/**
 * 
 * @author SergiyManko
 *
 */

$(document).ready(function() {
	userAgent = navigator.userAgent;
	//
	bsound = new Audio;
	if( userAgent.indexOf("Chrome")!=-1 )
	{
		bsound.src = "sound/Loose.mp3";
	}
	
	if( userAgent.indexOf("Firefox")!=-1)
	{
		bsound.src = "sound/Loose.wav";
	}
	bsound.loop=false;
	startbsound();
});

function startbsound() {
	bsound.volume=0.9;
	bsound.play();
}