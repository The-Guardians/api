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

var count = 0;

function addNotiboxalert() {
    var notiboxalert = document.createElement('div');

    notiboxalert.className = 'alert btn';
    notiboxalert.setAttribute('id', count);
    count++;
    var id = notiboxalert.getAttribute('id');

    var contentalert = document.createTextNode("Error! Your request has a problem.");

    Object.assign(notiboxalert.style,{width:"95%"});

    notiboxalert.innerHTML = notiboxalert.innerHTML + "<span class='closebtn' onclick='removeNotibox(id);decreaseNumber();' >&times;</span>";

    notiboxalert.addEventListener('click', function () {
        removeNotibox(id);
        decreaseNumber();
    });


    notiboxalert.appendChild(contentalert);

    document.getElementById('notimodule').appendChild(notiboxalert);
}

function addNotiboxsucess() {
    var notiboxsuccess = document.createElement('div');

    notiboxsuccess.className = 'alert success btn';
    notiboxsuccess.setAttribute('id', count);
    count++;
    var id = notiboxsuccess.getAttribute('id');

    var contentsuccess = document.createTextNode("Success! job successful.");

    Object.assign(notiboxsuccess.style,{width:"95%"});

    notiboxsuccess.innerHTML = notiboxsuccess.innerHTML + "<span class='closebtn' onclick='removeNotibox(id);decreaseNumber();' >&times;</span>";

    notiboxsuccess.addEventListener('click', function () {
        removeNotibox(id);
        decreaseNumber();
    });

    notiboxsuccess.appendChild(contentsuccess);

    document.getElementById('notimodule').appendChild(notiboxsuccess);
}

function addNotiboxInfo() {
    var notiboxInfo = document.createElement('div');

    notiboxInfo.className = 'alert info btn';
    notiboxInfo.setAttribute('id', count);
    count++;
    var id = notiboxInfo.getAttribute('id');

    var contentInfo = document.createTextNode("Info! User call service at");

    Object.assign(notiboxInfo.style,{width:"95%"});

    notiboxInfo.innerHTML = notiboxInfo.innerHTML + "<span class='closebtn' onclick='removeNotibox(id);decreaseNumber();' >&times;</span>";

    notiboxInfo.addEventListener('click', function () {
        removeNotibox(id);
        decreaseNumber();
    });

    notiboxInfo.appendChild(contentInfo);

    document.getElementById('notimodule').appendChild(notiboxInfo);
}

function addNotiboxWarning() {
    var notiboxWarning = document.createElement('div');

    notiboxWarning.className = 'alert warning btn';
    notiboxWarning.setAttribute('id', count);
    count++;

    var id = notiboxWarning.getAttribute('id');

    var contentWarning = document.createTextNode("Warning! Indicates a warning that might need attention.");

    Object.assign(notiboxWarning.style,{width:"95%"});

    notiboxWarning.innerHTML = notiboxWarning.innerHTML + "<span class='closebtn' onclick='removeNotibox(id);decreaseNumber();' >&times;</span>";

    notiboxWarning.addEventListener('click', function () {
        removeNotibox(id);
        decreaseNumber();
    });

    notiboxWarning.appendChild(contentWarning);

    document.getElementById('notimodule').appendChild(notiboxWarning);
}

function removeNotibox(id) {

    var test = document.getElementById(id);
    test.parentNode.removeChild(test);
}