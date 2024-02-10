const cityInput = document.querySelector('.search-input');
const searchButton = document.querySelector('.search-btn-top');
const weatherCardsDiv = document.querySelector('.forecast-body');

const API_KEY = "472aed6ce7b4f966596b593f995577d4";

const createWeatherCard = (weatherItem) =>{
    return `<div class="forecast-body">
    <h4 class="text-white forecast-body-header">(${weatherItem.dt_text.split(" ")[0]})</h4>
    <img src="https://openweathermap.org/img/wn/${weatherItem.weather[0].icon}@2x.png" class="icon icon-forecast">
    <p class="text-white text">Temp: ${(weatherItem.main.temp - 273.15).toFixed(2)}°C</p>
    <p class="text-white text">Wind: ${weatherItem.wind.speed} M/S</p>
    <p class="text-white text">Humidity: ${weatherItem.main.humidity}%</p>
</div>`;
};

const getWeatherDetails = (cityName, lat, lon) =>{
    const WEATHER_API_KEY = `http://api.openweathermap.org/data/2.5/forecast?lat=${lat}&lon=${lon}&appid=${API_KEY}`;

    fetch(WEATHER_API_KEY).then(res => res.json()).then(data => {
        const uniqueForecastDays = [];

        const fiveDaysForecast = data.list.filter(forecast =>{
            const forecastDate = new Date(forecast.dt_text).getDate();
            if(!uniqueForecastDays.includes(forecastDate)) {
                return uniqueForecastDays.push(forecastDate);
            }
        });

        console.log(fiveDaysForecast);
        fiveDaysForecast.forEach(weatherItem => {
            weatherCardsDiv.insertAdjacentHTML('beforeend, createWeatherCard(weatherItem)');
        })
    }).catch(() => {
        alert('An error has occured while fetching the weather forecast!');
   });
}

const getCityCoordinates = () =>{
    const cityName = cityInput.value.trim()
    if(!cityName) return;
    const GEOCODING_API_URL = `http://api.openweathermap.org/geo/1.0/direct?q=${cityName}&limit=1&appid=${API_KEY}`;

    fetch(GEOCODING_API_URL).then(res => res.json()).then(data => {
        if(!data.length) return alert('No coordinates found for ${cityName}');
        const {name, lat, lon} = data[0];
        getWeatherDetails(name, lat, lon);
    }).catch(() => {
         alert('An error has occured while fetching the coordinates!');
    });
}

searchButton.addEventListener('click', getCityCoordinates);