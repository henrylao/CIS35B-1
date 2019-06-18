var tocTimeoutId = null;

function showDelayedTOC()
{
	tocTimeoutId = window.setTimeout("showTOC()", 60 * 5);
}

function cancelShowTOC()
{
	if (tocTimeoutId != null)
	{
		window.clearTimeout(tocTimeoutId);
		tocTimeoutId = null;
	}
}

function showTOC()
{
	if (isIe())
	{
		document.getElementById("toc").style.top = document.getElementById("tocbar").style.top;
	}
	document.getElementById("toc").style.display = "block";
}

function hideTOC()
{
	document.getElementById("toc").style.display = "none";
}


function containsDOM (container, containee) 
{
	var isParent = false;
	do 
	{
		if ((isParent = container == containee)) break;
		containee = containee.parentNode;
	}
	while (containee != null);
	return isParent;
}

function checkMouseEnter (element, evt) 
{
	if (element.contains && evt.fromElement) 
	{
		return !element.contains(evt.fromElement);
	}
	else if (evt.relatedTarget) 
	{
		return !containsDOM(element, evt.relatedTarget);
	}
}

function checkMouseLeave (element, evt) 
{
	if (element.contains && evt.toElement) 
	{
		return !element.contains(evt.toElement);
	}
	else if (evt.relatedTarget) 
	{
		return !containsDOM(element, evt.relatedTarget);
	}
}