function getPageHeight() {
    /*
        페이지의 높이를 계산하는 명령
        - scrollHeight > 스크롤바를 제외한 내용 전체의 높이
        - offsetHeight > 스크롤바를 포함한 내용의 가시적인 높이
        - clientHeight > 스크롤바를 제외한 내용의 가시적인 높이
    */

    var height = Math.max(
        // body 기준
        document.body.scrollHeight,
        document.body.offsetHeight,
        document.body.clientHeight,
        // html의 높이 기준
        document.documentElement.scrollHeight,
        document.documentElement.offsetHeight,
        document.documentElement.clientHeight
    );

    return height;
}

function getScrollPosition() {
    var scroll = Math.max(
        window.pageYOffset,
        window.scrollY
    );
    return scroll;
}

function getScrollRate() {
    return getScrollPosition() / (getPageHeight() - document.documentElement.clientHeight);
}

// 스크롤의 비율을 계산하는 함수(0~100%)

function setSlider() {
    var rate = getScrollRate();
    rate *= 100;

    var slider = document.querySelector(".slider-wrap > .slider");
    slider.style.width = rate + "%";
}

// window 의 스크롤이 움직일 대 setSlider 가 실행되도록 예약
window.onscroll = setSlider;
