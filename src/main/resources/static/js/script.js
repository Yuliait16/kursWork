const contentLogo = document.querySelector(".content__logo");
const modal = document.querySelector(".modal");

const modalDimmer = document.querySelector(".modal__dimmer");

const modalClose = document.querySelector(".modal__close");

//const leftSlider = document.querySelector(".pictures__arrow:nth-of-type(1)");
//leftSlider.addEventListener('click', leftSlide);

//const rightSlider = document.querySelector(".pictures__arrow:nth-of-type(9)");
//rightSlider.addEventListener('click', rightSlide);

contentLogo.addEventListener('click', openModal);
modalDimmer.addEventListener('click', closeModal);
modalClose.addEventListener('click', closeModal);

let order = [2,3,4,5,6,7,8];

const orderRight = {
    0: 1,
    1: 2,
    2: 3,
    3: 4,
    4: 5,
    5: 6,
    6: 7,
};

let slideIndex = 6;

const picturesItem = document.querySelectorAll(".pictures__item");

function openModal() {
    modal.classList.add("is_open");
}

function closeModal() {
    modal.classList.add("is_closing");
    setTimeout(() => {
        modal.classList.remove("is_closing");
        modal.classList.remove("is_open");
    }, 300);
}

function leftSlide(){

    setTimeout(() => {
        for(let item in orderRight){
            if(orderRight[item]!==1){
                orderRight[item]--;

            } else{
                orderRight[item]=7;
            }
            picturesItem[item].style.zIndex=orderRight[item];
        }


        if(slideIndex!==6){
            slideIndex++;
        } else{
            slideIndex=0;
        }


    }, 300);
}

function rightSlide(){


    setTimeout(() => {
        for(let item in orderRight){
            if(orderRight[item]!==7){
                orderRight[item]++;

            } else{
                orderRight[item]=1;
            }
            picturesItem[item].style.zIndex=orderRight[item];
        }


        if(slideIndex!==6){
            slideIndex++;
        } else{
            slideIndex=0;
        }


    }, 300);
}