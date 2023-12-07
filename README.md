
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

![288626489-4be94360-bb31-40e5-85d0-bc825ea1a938](https://github.com/CiroDev-Git/kt-bold-weather/assets/32694941/2cd2221d-5615-4f84-a402-a365dc424402)

![288626219-2706e7cc-9a95-4198-8413-5edd9cb78286](https://github.com/CiroDev-Git/kt-bold-weather/assets/32694941/95bc946c-940a-4887-8168-6ff02458d684)

![288626712-add2522c-2076-466a-8c86-d8c2c27e15a9](https://github.com/CiroDev-Git/kt-bold-weather/assets/32694941/2d116267-1f15-48db-bc70-cad80b7aa728)

![288626275-1d40442d-9b86-4b29-b31d-ab6bcd8d3937](https://github.com/CiroDev-Git/kt-bold-weather/assets/32694941/65be8932-0bb7-4ee8-8f5b-cee0c53170a3)

![288626582-8585e83b-dd47-43d1-a7b3-bd01646bffd8](https://github.com/CiroDev-Git/kt-bold-weather/assets/32694941/ecd72da3-39a5-40a1-935a-1ffd8063d09a)

![288625706-60e0b8b7-349f-4eb9-9215-f68b117abdc3](https://github.com/CiroDev-Git/kt-bold-weather/assets/32694941/1069ce85-6af4-4b51-aa46-a79feb32551b)








