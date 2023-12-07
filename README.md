
# BOLD Api weather by CiroDev

Utilizando la API de WeatherApi visualizar el clima actual de una ubicación ingresada junto el pronóstico de esta para los siguientes 2 días.

## Authors

- [@CiroDev-Git](https://github.com/CiroDev-Git)

## Features

- CLEAN architecture
- Hilt
- Either, Result, Failure & State
- Multimodule (Layers)
- Multilanguage for API & Locale
- Light/Dark toggle
- Orientation handling
- Query params (key-lang) via Interceptor
- Jetpack Datastore
- Jetpack Compose
- Jetpack Navigation
- Custom UI
- Lottie Splash
- Retrofit
- Flow
- Mappers

## Documentation

[API Documentation](https://www.weatherapi.com/docs/)

## About API

#### No se puede mostrar la imagen “https://api.weatherapi.com//cdn.weatherapi.com/weather/64x64/day/113.png” porque contiene errores.

Las imágenes provistas por la Forecast API no funcionan, así que se está cargado el recurso asignado para el callback de error en Coil.

#### { "error": { "code": 1006, "message": "No matching location found." } }

La Forecast API no recibe el ID de la locación, se debe enviar el nombre, pero pueden existir muchas ubicaciones con el mismo nombre (Ej: Los Angeles), así que se está enviando el nombre junto a la región para obtener un resultado más preciso. 

## Run Locally

Hecho en Android Studio

```bash
  Giraffe | 2022.3.1 Patch 4
```

Con Gradle JDK

```bash
  jbr-17
```

Configs de compilación

```bash
    minSdk = 21
    targetSdk = 34
    compileSdk = 34
    gradle = '8.1.4'
    kotlin = '1.8.20'
    kotlinCompilerExtension = '1.4.6'
```

## Screenshots

![App Screenshot](https://github.com/CiroDev-Git/kt-bold-weather/assets/32694941/60e0b8b7-349f-4eb9-9215-f68b117abdc3)

![App Screenshot](https://github.com/CiroDev-Git/kt-bold-weather/assets/32694941/2706e7cc-9a95-4198-8413-5edd9cb78286)

![App Screenshot](https://github.com/CiroDev-Git/kt-bold-weather/assets/32694941/1d40442d-9b86-4b29-b31d-ab6bcd8d3937)

![App Screenshot](https://github.com/CiroDev-Git/kt-bold-weather/assets/32694941/4be94360-bb31-40e5-85d0-bc825ea1a938)

![App Screenshot](https://github.com/CiroDev-Git/kt-bold-weather/assets/32694941/8585e83b-dd47-43d1-a7b3-bd01646bffd8)

![App Screenshot](https://github.com/CiroDev-Git/kt-bold-weather/assets/32694941/add2522c-2076-466a-8c86-d8c2c27e15a9)


