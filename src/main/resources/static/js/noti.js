var n = 0;

function increaseNumber() {
    n = n + 1;
    document.getElementById('number').innerHTML = n;
    numnoti = n;
    zeroNumber();

}

function zeroNumber() {
    if (document.getElementById('number').innerHTML == 0) {
        document.getElementById('notiminibox').style.display = 'none';

    }
    else {
        document.getElementById('notiminibox').style.display = 'block';
    }
}

function decreaseNumber() {
    if (n >= 1)
        n = n - 1;
    document.getElementById('number').innerHTML = n;
    numnoti = n;
    zeroNumber();

}


function alertPopup() {
    alert("You have " + numnoti + " message in notify.");
}


function addNotiboxalert() {
    var notiboxalert = document.createElement('div');

    notiboxalert.className = 'alert btn';
    notiboxalert.setAttribute('id', '1');

    var contentalert = document.createTextNode("Error! Your request has a problem.");

    notiboxalert.innerHTML = notiboxalert.innerHTML + "<span class='closebtn' onclick='removeNotibox();decreaseNumber();' >&times;</span>";

    notiboxalert.appendChild(contentalert);

    document.getElementById('notimodule').appendChild(notiboxalert);
}

function addNotiboxsucess() {
    var notiboxsuccess = document.createElement('div');

    notiboxsuccess.className = 'alert success btn';
    notiboxsuccess.setAttribute('id', '1');

    var contentsuccess = document.createTextNode("Success! job successful.");

    notiboxsuccess.innerHTML = notiboxsuccess.innerHTML + "<span class='closebtn' onclick='removeNotibox();decreaseNumber();' >&times;</span>";

    notiboxsuccess.appendChild(contentsuccess);

    document.getElementById('notimodule').appendChild(notiboxsuccess);
}

function addNotiboxInfo() {
    var notiboxInfo = document.createElement('div');

    notiboxInfo.className = 'alert info btn';
    notiboxInfo.setAttribute('id', '1');

    var contentInfo = document.createTextNode("Info! User call service at");

    notiboxInfo.innerHTML = notiboxInfo.innerHTML + "<span class='closebtn' onclick='removeNotibox();decreaseNumber();' >&times;</span>";

    notiboxInfo.appendChild(contentInfo);

    document.getElementById('notimodule').appendChild(notiboxInfo);
}

function addNotiboxWarning() {
    var notiboxWarning = document.createElement('div');

    notiboxWarning.className = 'alert warning btn';
    notiboxWarning.setAttribute('id', '1');

    var contentWarning = document.createTextNode("Warning! Indicates a warning that might need attention.");

    notiboxWarning.innerHTML = notiboxWarning.innerHTML + "<span class='closebtn' onclick='removeNotibox();decreaseNumber();' >&times;</span>";

    notiboxWarning.appendChild(contentWarning);

    document.getElementById('notimodule').appendChild(notiboxWarning);
}

function removeNotibox() {

    var test = document.getElementById('1');
    test.parentNode.removeChild(test);
    // var test2 = document.getElementById('2');
    // test2.parentNode.removeChild(test2);
    // var test3 = document.getElementById('3');
    // test3.parentNode.removeChild(test3);
    // var test4 = document.getElementById('4');
    // test4.parentNode.removeChild(test4);

}

// var close = document.getElementsByClassName("closebtn");
// var i;
//
// for (i = 0; i < close.length; i++) {
//     close[i].onclick = function(){
//         var div = this.parentElement;
//         div.style.opacity = "0";
//         setTimeout(function(){ sss.style.display = "none"; }, 600);
//     }
// }


    
