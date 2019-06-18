var siteRootPath = "file:///C:/Documents and Settings/Marty/My Documents/New-Web-Site/www.coreservlets.com";

function isIe()
{
	if (window.navigator.appName == "Microsoft Internet Explorer")
	{
		return true;
	}
	else
	{
		return false;
	}
}

function getSiteRootPath()
{
	if (location.protocol == "file:")
	{
		return siteRootPath;
	}
	else
	{
		return "";
	}
}

function chooseCss()
{
	path = getSiteRootPath();
	ieCssPath = "<link href='" + path + "/styles/ie.css' rel='stylesheet' type='text/css'>";
	otherCssPath = "<link href='" + path + "/styles/otherBrowsers.css' rel='stylesheet' type='text/css'>";
	
	if (isIe())
	{
		window.document.write(ieCssPath);
	}
	else
	{
		window.document.write(otherCssPath);
	}
}

