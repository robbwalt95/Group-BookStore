/*##<!--
			Author: Tara McKee
			Source: Telmo Sampaio https://www.youtube.com/watch?v=IY5UN82FZ2Q
			Date: 10/17/2021
			Purpose: BaileyKy Website Cart Functionality

	-->*/



var carts = document.querySelectorAll('.btn-primary');

var products = [
    {
        name: "Fundamentals of Wave",
        tag: "225_fund_wavelets",
        price: 12.88,
        inCart: 0

    },

    {
        name: "Data Smart",
        tag: "226_data_smart",
        price: 59.99,
        inCart: 0

    },

    {
        name: "God Created Integers",
        tag: "227_god_created_integers",
        price: 15.99,
        inCart: 0

    },

    {
        name: "Superfreakonomics",
        tag: "228_super_freak",
        price: 8.99,
        inCart: 0

    },

    {
        name: "Orientalism",
        tag: "229_orientalism",
        price: 12.50,
        inCart: 0

    },

    {
        name: "Nature of Statistical",
        tag: "230_Nature_of_Stat",
        price: 118.27,
        inCart: 0

    },

    {
        name: "Integration of The Indian States",
        tag: "231_integration_indian_states",
        price: 34.50,
        inCart: 0

    },

    {
        name: "The Drunkard's Walk",
        tag: "232_drunkards",
        price: 48.95,
        inCart: 0

    },

    {
        name: "Image Processing",
        tag: "233_image_processing",
        price: 89.95,
        inCart: 0

    },

    {
        name: "How to Think Like Sherlock",
        tag: "234_how_sherlock",
        price: 15.99,
        inCart: 0

    },

    {
        name: "Data Scientists at Work",
        tag: "235_data_scientists",
        price: 37.99,
        inCart: 0

    }


]

function onLoadCartNumbers() {
    productNumbers = localStorage.getItem('cartNumbers');

    if(productNumbers) {
        document.querySelector('.cart span').textContent = productNumbers;
    }
}

for (let i=0; i < carts.length; i++){
    carts[i].addEventListener('click', () => {
        console.log('added to cart');
        cartNumbers(products[i]);
        totalCost(products[i]);

    })

}

function cartNumbers(product) {
    console.log("the product clicked is", product);
    let productNumbers = localStorage.getItem('cartNumbers');
    productNumbers = parseInt(productNumbers);

    if(productNumbers) {
        localStorage.setItem('cartNumbers', productNumbers + 1);
        document.querySelector('.cart span').textContent = productNumbers + 1;
    }
    else {
        localStorage.setItem('cartNumbers', 1);
        document.querySelector('.cart span').textContent = 1;

    }

    setItems(product);

}


function setItems(product){
    let cartItems = localStorage.getItem('productsInCart');
    cartItems = JSON.parse(cartItems);


    if (cartItems != null) {

        if (cartItems[product.tag] == undefined) {
            cartItems = {
                ...cartItems,
                [product.tag]: product
            }
        }

        cartItems[product.tag].inCart += 1;
    }
    else {
        product.inCart = 1;
        cartItems = {
            [product.tag]: product
        }
    }


    localStorage.setItem("productsInCart", JSON.stringify(cartItems));
}

function totalCost(product) {

    let cartCost = localStorage.getItem('totalCost');

    console.log("My Cart Cost is", cartCost);
    console.log(typeof cartCost);

    if(cartCost != null) {
        let num = cartCost;
        cartCost = parseInt(cartCost);
        localStorage.setItem("totalCost", cartCost +  product.price);
        let n = cartCost.toFixed(2);

    } else {
        localStorage.setItem("totalCost", product.price);
    }
}

function displayCart() {
    let cartItems = localStorage.getItem("productsInCart");
    cartItems = JSON.parse(cartItems);
    let productContainer = document.querySelector(".products");
    let cartCost = localStorage.getItem('totalCost');
    if(cartItems && productContainer) {
        productContainer.innerHTML = "";
        Object.values(cartItems).map(item => {
            productContainer.innerHTML += ` 
			<div class="products">
				<ion-icon name="close-circle"></ion-icon>
				<img src= "./images/${item.tag}.jpg" width="75" height="75">
				<span>${item.name}</span>
			</div>
				<div class="price">${item.price}
				</div>
				
				<div class="quantity">
				
					<ion-icon class="decrease" onClick="changeNumberOfUnits('minus', ${item.tag})"
					name="remove-circle-outline"></ion-icon>
					
					<span>${item.inCart}</span>
					
					<ion-icon class="increase" onClick="changeNumberOfUnits('plus', ${item.tag})"
					name="add-circle-outline"></ion-icon>
			</div>
			
			<div class="total">
				<span>${item.inCart * item.price}</span>
			</div>
			
			`



        });

        productContainer.innerHTML += `
			<div class="basketTotalContainer">
				<h4 class="basketTotalTitle">
					Cart SubTotal  
				</h4>
				<h4 class="basketTotal">
				$${cartCost}
				</h4>				
		`

    }

}



displayCart();

