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
		bsound.src = "sound/Victory.mp3";
	}
	
	if( userAgent.indexOf("Firefox")!=-1)
	{
		bsound.src = "sound/Victory.wav";
	}
	bsound.loop=false;
	startbsound();
});

function startbsound() {
	if(bsoundFlag)
	{
		bsound.volume=0.9;
		bsound.play();
	}
}