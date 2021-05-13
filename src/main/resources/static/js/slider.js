
const leftSlider = document.querySelector(".pictures__arrow:nth-of-type(1)");
leftSlider.addEventListener('click', leftSlide);

const rightSlider = document.querySelector(".pictures__arrow:nth-of-type(9)");
rightSlider.addEventListener('click', rightSlide);

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