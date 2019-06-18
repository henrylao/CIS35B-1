var trainingTimeoutId = null;
var tutorialsTimeoutId = null;
var resourcesTimeoutId = null;
var booksTimeoutId = null;
var trainingMenu = "submenu_training";
var tutorialsMenu = "submenu_tutorials";
var resourcesMenu = "submenu_resources";
var booksMenu = "submenu_books";


// Display training menu
function showTrainingMenu()
{
	if (trainingTimeoutId != null)
	{
		window.clearTimeout(trainingTimeoutId);
		trainingTimeoutId = null;
	}
	menuElement = document.getElementById(trainingMenu);
	menuElement.style.display = "block";
}

// Set timer to turn off training menu (delayed turn off)
function hideTrainingMenu()
{
	trainingTimeoutId = window.setTimeout("turnOffMenu('" + trainingMenu + "')", 60 * 3);
}


// Display tutorials menu
function showTutorialsMenu()
{
	if (tutorialsTimeoutId != null)
	{
		window.clearTimeout(tutorialsTimeoutId);
		tutorialsTimeoutId = null;
	}
	menuElement = document.getElementById(tutorialsMenu);
	menuElement.style.display = "block";
}

// Set timer to turn off tutorials menu (delayed turn off)
function hideTutorialsMenu()
{
	tutorialsTimeoutId = window.setTimeout("turnOffMenu('" + tutorialsMenu + "')", 60 * 3);
}


// Display resources menu
function showResourcesMenu()
{
	if (resourcesTimeoutId != null)
	{
		window.clearTimeout(resourcesTimeoutId);
		resourcesTimeoutId = null;
	}
	menuElement = document.getElementById(resourcesMenu);
	menuElement.style.display = "block";
}

// Set timer to turn off resources menu (delayed turn off)
function hideResourcesMenu()
{
	resourcesTimeoutId = window.setTimeout("turnOffMenu('" + resourcesMenu + "')", 60 * 3);
}

// Display books menu
function showBooksMenu()
{
	if (booksTimeoutId != null)
	{
		window.clearTimeout(booksTimeoutId);
		booksTimeoutId = null;
	}
	menuElement = document.getElementById(booksMenu);
	menuElement.style.display = "block";
}

// Set timer to turn off books menu (delayed turn off)
function hideBooksMenu()
{
	booksTimeoutId = window.setTimeout("turnOffMenu('" + booksMenu + "')", 60 * 3);
}


// Turns off menu immediately
function turnOffMenu(menuId)
{
	menuElement = document.getElementById(menuId);
	menuElement.style.display = "none";
}


function turnOffAll()
{
	menu1 = document.getElementById("submenu_training");
	menu1.style.display = "none";
}