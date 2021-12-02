/*
 * Author: Neil Brooks
 * Date: 9/24/21
 * Purpose: BaileyKy front-end functionality
*/

var newDiv = "<div></div>"; // used to create new divs in jQuery

// Give a button a login functionality. Do this in JS so that it can be
// identical on all pages without the risk of updating it on one page
// and forgetting to update it on others.
var newLoginButton = function () {
	if (! $) return;    // If we don't have jQuery, give up
	var myButton = $("#loginButton");   // Find the login button

	// Build out a login form
	var loginForm = $("<form></form>");
	loginForm.append(newDiv).addClass("form-group");
	loginForm.children(0).append('<label for="email">Email address:</label>');
	loginForm.children(0).append('<input type="email" class="form-control" placeholder="Enter email" id="email"></input>');
	loginForm.children(0).append('<label for="pwd">Password:</label>');
	loginForm.children(0).append('<input type="password" class="form-control" placeholder="Enter password" id="pwd"></input>');
	loginForm.children(0).append('<button id="loginSubmit" type="submit" class="btn btn-primary">Submit</button>');
	// Build out a modal to hold the form
	var myModal = $(newDiv);
	myModal.addClass("modal")
		.append(newDiv).children(0).addClass("modal-dialog")
		.append(newDiv).children(0).addClass("modal-content")
		.append(newDiv).children(0).addClass("modal-body")
		.append(newDiv).children(0).append(loginForm);
	// loginForm.children('button').click(signInButtonClick);
	// loginForm.submit(signInButtonClick);
	var signInButtonClick = function (e) {
		e.preventDefault();
		console.log('click');
		myButton.html('Sign out');
		myButton.off('click');
		myButton.click(signOut);
		myModal.modal('hide');
	};
	var signOut = function (e) {
		e.preventDefault();
		location.reload();
	};
	myButton.click(function() {
		$("body").prepend(myModal);
		myModal.modal('show');
		console.log($("#loginSubmit").length);
		$("#loginSubmit").click(signInButtonClick);
	});
	return {
		activate : function () {
			console.log('activate');
			console.log($("#loginSubmit").length);
			$("#loginSubmit").click(signInButtonClick);
		}
	}
};

// Use this object to notify an admin that they need to order more books.
// merchantNotification.showMyAlert('Tor Books') pops up a warning that says
// "Warning! Order more books from Tor Books!"
var merchantNotification = (function () {
	var myAlert = $(newDiv);
	myAlert.addClass(['alert','alert-warning','alert-dismissible','fade']);
	myButton = ('<button type="button" class="btn-close" data-bs-dismiss="alert"></button>');
	showMyAlert = function (merchant) {
		myAlert.text('Warning! Order more books from ' + merchant + '!');
		// myAlert.append(myButton);
		// Button looks ugly right now - missing a class? TODO
		$(document.body).prepend(myAlert);
		myAlert.addClass('show');
	};
	return {
		showMyAlert : showMyAlert
	};
}());