const getCurrentOffer = () => {
  return fetch("/api/current-offer")
      .then(response => response.json())
}

const addProduct = (productId) => {
  return fetch(`/api/add-product/${productId}`, {
    method: "POST"
  });
}

const acceptOffer = (acceptOfferRequest) => {
  return fetch("/api/accept-offer", {
    method: "POST",
    headers: {
      "Content-Type" : "application/json"
    },
    body: JSON.stringify(acceptOfferRequest)
  })
      .then(response => response.json());
}


const checkoutForm = document.querySelector(".checkout");
checkoutForm.addEventListener("submit",(event)=>{
  event.preventDefault();

  const acceptOfferRequest = {
      fname: checkoutForm.querySelector('input[name="fname"]').value,
      lname: checkoutForm.querySelector('input[name="lname"]').value,
      email: checkoutForm.querySelector('input[name="email"]').value
  }

  acceptOffer(acceptOfferRequest)
      .then(reservationDetails => console.log(reservationDetails));
});

const refreshOffer = (offer) => {
  const offerTotalEl = document.querySelector("#offerTotal");
  const offerItemsCountEl = document.querySelector("#offerItemsCount");

  offerTotalEl.textContent = offer.total;
  offerItemsCount.textContent = offer.itemsCount;
  getCurrentOffer()
      .then(offer => {
        totalEl.textContent = `${offer.total} PLN`;
        itemsEl.textContent = `${offer.itemsCount} Items`;
      });
}

const getProducts= async()=> {
  return fetch("/api/products")
      .then(response => response.json());
}


const createProductHtmlEl = (productData) => {
  const template = `
        <div class="produkt">
            <h4 class="tekstTlo">${productData.name}</h4>
            <img src="https://gamehag.com/img/rewards/logo/250%20smoczych%20monet.png" height = 200 />
            <div>
                <span>${productData.price}</span>
                <button data-id="${productData.id}">Add to cart</button>
            </div>
        </div>
        `;

  const htmlEl = document.createElement("li");
  htmlEl.innerHTML = template.trim();
  return htmlEl;
}

const initializeCartHandler = (productHtmlEl) => {
  const addToCartBtn = productHtmlEl.querySelector("button");
  addToCartBtn.addEventListener("click", () => {
    const productId = addToCartBtn.getAttribute("data-id");
    addProduct(productId)
        .then(refreshOffer());
  })

  return productHtmlEl;
}

document.addEventListener("DOMContentLoaded", ()=> {
  const productsListEl = document.querySelector('#productsList');

  getProducts()
      .then(productsAsJson => productsAsJson.map(createProductHtmlEl))
      .then(productsAsHtml => productsAsHtml.map(initializeCartHandler))
      .then(productsAsHtml => {
        productsAsHtml.forEach(el => productsListEl.appendChild(el))

      });

  getCurrentOffer()
      .then(offer => refreshOffer(offer));
});