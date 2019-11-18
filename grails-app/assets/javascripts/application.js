// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-3.3.1.min
//= require bootstrap
//= require popper.min
//= require perfect-scrollbar.jquery.min
// --Chart JS
//= require chartjs.mins
//-- Notifications Plugin
//= require bootstrap-notify
//= require jquery.validate
//----------
//= require paper-dashboard.min
//= require_self



function openTab(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}

function filter() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("filter-value");
    filter = input.value.toUpperCase();
    table = document.getElementById("table");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function checkId(event) {
    let model = event.target.name
    let id = event.target.value
    fetch(`${model}/check/${id}`, request)
        .then(response => response.json())
        .then(json => {
            alert(json)
        }).catch((err) => alert("Problems in server" + err));
}