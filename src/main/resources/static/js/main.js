document.getElementById('popuplogin').style.display = 'block';
document.getElementById('accountbtn').style.display = 'none';
document.getElementById('signoutbtn').style.display = 'none';
document.getElementById('name').style.display = 'none';
document.getElementById('tel').style.display = 'none';
document.getElementById('email').style.display = 'none';
document.getElementById('price').style.display = 'none';
document.getElementById('itemPay').style.display = 'none';
document.getElementById('omise').style.display = 'none';
document.getElementById('select').disabled = true;
document.getElementById('cusNameAndLogo').style.display = 'none';
document.getElementById('call').style.display = 'none';
document.getElementById('wait').style.display = 'none';
document.getElementById('coming').style.display = 'none';
document.getElementById('logoDefault').style.display = 'block';

/*--test--*/
document.getElementById('test').style.display = 'none';
/*----*/

function login() {
    document.getElementById('popuplogin').style.display = 'none';
    document.getElementById('accountbtn').style.display = 'block';
    document.getElementById('signoutbtn').style.display = 'block';
    document.getElementById('name').style.display = 'block';
    document.getElementById('tel').style.display = 'block';
    document.getElementById('email').style.display = 'block';
    document.getElementById('logoDefault').style.display = 'none';
    document.getElementById('cusNameAndLogo').style.display = 'block';
}

// function statusService() {
//         $('#toggle-event').change(function() {
//             $(this).prop('check');
//         })
// }

function callService() {
    document.getElementById('wait').style.display = 'none';
    document.getElementById('coming').style.display = 'none';
    document.getElementById('call').style.display = 'block';
    document.getElementById('price').style.display = 'block';
    document.getElementById('select').disabled = false;
}

function wait() {
    if (document.getElementById('itemPay').style.display == 'none') {
        time();
        document.getElementById('call').style.display = 'none';
        document.getElementById('wait').style.display = 'block';
        document.getElementById('select').disabled = true;

        /*--test--*/
        document.getElementById('test').style.display = 'block';
        /*-----*/
    }
}

function coming() {
    document.getElementById('wait').style.display = 'none';
    document.getElementById('coming').style.display = 'block';
    document.getElementById('itemPay').style.display = 'block';
    document.getElementById('service').disabled = true;
}

function setTextConfirm() {
    if (document.getElementById('itemPay').style.display != 'none') {
        document.getElementById('textConfirm').innerHTML = "You have an outstanding balance. Please pay";
        document.getElementById('conbtn').style.display = 'none';
        document.getElementById('goPaybtn').style.display = 'block';
    } else {
        document.getElementById('textConfirm').innerHTML = "Are you sure ?";
        document.getElementById('goPaybtn').style.display = 'none';
        document.getElementById('conbtn').style.display = 'block';
    }
}

var wait_time = 300; //5 minute
var vela;

function time() {
    wait_time = 300;
    vela = setInterval("decrease_num()", 1000);
}
function decrease_num() {
    if (wait_time > 0) {
        var show_place = document.getElementById('show_text');
        var min = (wait_time / 60)
        var min1 = Math.floor(min);
        var sec = (wait_time % 60);
        show_place.innerHTML = "Wait(" + min1 + ":" + sec + " second)";
        wait_time--;
    } else {
        if (wait_time == 0) {
            clearTime();
            document.getElementById('wait').style.display = 'none';
            document.getElementById('call').style.display = 'block';
        }
    }
}

function clearTime(){
    clearInterval(vela);
}


var HttpClient = function() {
    this.get = function(aUrl, aCallback) {
        var anHttpRequest = new XMLHttpRequest();
        anHttpRequest.onreadystatechange = function() {
            if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
                aCallback(anHttpRequest.responseText);
        };

        anHttpRequest.open( "GET", aUrl, true );
        anHttpRequest.send( null );
    }
};

function getUser() {
    var client = new HttpClient();
    client.get('/users', function(response) {
        console.log(response);

        var users = response;

        console.log(users.id);


    });
}


