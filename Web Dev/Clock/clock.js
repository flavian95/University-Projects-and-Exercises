const container = document.querySelector(".clock-container");
const hour = document.querySelector(".clock-hour");
const min = document.querySelector(".clock-min");
const sec = document.querySelector(".clock-sec");
const date = document.querySelector(".clock-date");
const month = document.querySelector(".clock-month");
const year = document.querySelector(".clock-year");

function updateTime() {
    const now = new Date();
    const timeZone = document.querySelector(".select-time-zone").value;

    let hours = now.getUTCHours();
    let timeZoneOffset = 0;

    if (timeZone === "East USA") {
        timeZoneOffset = -5;
    }

    if (timeZone === "Sydney AUS") {
        timeZoneOffset = 11;
    }

    if (timeZone === "East EU") {
        timeZoneOffset = 2;
    }

    if (timeZone === "Central EU") {
        timeZoneOffset = 1;
    }

    if (timeZone === "West USA") {
        timeZoneOffset = -9;
    }

    hours += timeZoneOffset;

    if (hours < 0) {
        hours += 24; 
    } else if (hours >= 24) {
        hours -= 24;
    }

    hours = hours.toString().padStart(2, '0');
    const minutes = now.getUTCMinutes().toString().padStart(2, '0');
    const seconds = now.getUTCSeconds().toString().padStart(2, '0');

    const adjustedDate = new Date(now.getTime() + timeZoneOffset * 60 * 60 * 1000);
    const dates = adjustedDate.getUTCDate().toString().padStart(2, '0');
    const months = (adjustedDate.getUTCMonth() + 1).toString().padStart(2, '0');
    const years = adjustedDate.getUTCFullYear().toString();

    hour.innerHTML = hours;
    min.innerHTML = minutes;
    sec.innerHTML = seconds;
    date.innerHTML = dates;
    month.innerHTML = months;
    year.innerHTML = years;
}

setInterval(updateTime, 1000);

updateTime();