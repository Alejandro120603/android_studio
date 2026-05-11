# Plantilla de GitHub Issue para recrear módulos API Android/Kotlin

## 1. Recon del repo actual

Package base real:

```text
com.example.actividad1am
```

Ubicación de `MainActivity`:

```text
app/src/main/java/com/example/actividad1am/MainActivity.kt
```

Estructura relevante del proyecto actual:

```text
app/src/main/java/com/example/actividad1am/
├── MainActivity.kt
├── api/
│   ├── API.kt
│   ├── Apilnterface.kt
│   ├── DogVIew.kt
│   ├── DogViewModel.kt
│   ├── ImagenRandom.kt
│   └── retrofithelper.kt
└── pokemonapi/
    ├── PokemonAPI.kt
    ├── PokemonApiInterface.kt
    ├── PokemonResponse.kt
    ├── PokemonRetrofitHelper.kt
    ├── PokemonView.kt
    └── PokemonViewModel.kt
```

Módulos API existentes:

| Módulo | Carpeta | API externa | Flujo principal |
|---|---|---|---|
| Dog API | `app/src/main/java/com/example/actividad1am/api` | `https://dog.ceo/api/` | Consulta `breeds/image/random` y muestra una imagen con `AsyncImage`. |
| PokéAPI | `app/src/main/java/com/example/actividad1am/pokemonapi` | `https://pokeapi.co/api/v2/` | Genera un ID aleatorio `1..151`, consulta `pokemon/{id}` y muestra nombre, altura, peso e imagen. |

Dependencias relevantes detectadas en `app/build.gradle.kts`:

```kotlin
implementation(libs.androidx.core.ktx)
implementation(libs.androidx.lifecycle.runtime.ktx)
implementation(libs.androidx.activity.compose)
implementation(platform(libs.androidx.compose.bom))
implementation(libs.androidx.compose.ui)
implementation(libs.androidx.compose.ui.graphics)
implementation(libs.androidx.compose.ui.tooling.preview)
implementation(libs.androidx.compose.material3)
implementation("androidx.compose.material:material-icons-extended:1.6.7")
implementation("androidx.navigation:navigation-compose:2.9.7")
implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
implementation("androidx.datastore:datastore-preferences:1.1.2")
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
implementation("io.coil-kt.coil3:coil-compose:3.4.0")
implementation("io.coil-kt.coil3:coil-network-okhttp:3.4.0")
```

Permiso de internet detectado en `app/src/main/AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

Cómo se monta actualmente una pantalla:

```kotlin
setContent {
    Actividad1AMTheme {
        PokemonView(PokemonViewModel())
    }
}
```

`MainActivity` usa una conexión temporal directa para probar la pantalla. En el estado actual importa `PokemonView` y `PokemonViewModel`, crea el ViewModel manualmente y muestra `PokemonView`.

Patrón repetido entre perros y Pokémon:

- Una pantalla Compose muestra textos, botón e imagen.
- El botón llama una función del ViewModel.
- El ViewModel lanza una corrutina con `viewModelScope.launch`.
- La llamada de red se hace con `Dispatchers.IO`.
- Una clase API intermedia llama al servicio Retrofit.
- `ApiInterface` define el endpoint con anotaciones Retrofit.
- `RetrofitHelper` configura `baseUrl`, Gson y `retrofit.create(...)`.
- El modelo `Response` representa solo los campos necesarios del JSON.

## 2. Arquitectura estándar detectada

```text
[Nombre]View
-> [Nombre]ViewModel
-> [Nombre]API
-> [Nombre]ApiInterface
-> [Nombre]RetrofitHelper
-> API externa
-> [Nombre]Response/model
-> [Nombre]View
```

Responsabilidad de cada capa:

| Capa | Responsabilidad |
|---|---|
| `[Nombre]View` | Pantalla Jetpack Compose. Muestra estado, botón, loading, error, textos e imagen con `AsyncImage` si aplica. |
| `[Nombre]ViewModel` | Guarda estado con `mutableStateOf`, ejecuta corrutinas con `viewModelScope.launch`, usa `Dispatchers.IO`, maneja `isLoading`, `error` y excepciones. |
| `[Nombre]API` | Capa intermedia entre ViewModel y Retrofit. Llama al servicio, revisa `response.isSuccessful` y devuelve datos simples o `null`. |
| `[Nombre]ApiInterface` | Define endpoints Retrofit con `@GET`, `@Path`, `@Query` o `@Body` según la API. Devuelve `Response<[Nombre]Response>`. |
| `[Nombre]RetrofitHelper` | Configura `Retrofit.Builder()`, `baseUrl`, `GsonConverterFactory.create()` y `retrofit.create(...)`. |
| API externa | Servicio HTTP remoto. Ejemplos actuales: Dog CEO API y PokéAPI. |
| `[Nombre]Response/model` | Data classes que representan el JSON necesario. No modelar campos que no se usan. |
| `MainActivity` | Conexión temporal para probar la pantalla nueva dentro de `setContent`. |

## 3. Convenciones actuales del proyecto

Convenciones a respetar en un repo nuevo:

- Usar el package base real del repo nuevo y crear una subcarpeta por API.
- Para módulos nuevos, preferir nombres consistentes:
  - `[Nombre]Response.kt`
  - `[Nombre]ApiInterface.kt`
  - `[Nombre]RetrofitHelper.kt`
  - `[Nombre]API.kt`
  - `[Nombre]ViewModel.kt`
  - `[Nombre]View.kt`
- Mantener el package igual a la ruta. Ejemplo actual: `package com.example.actividad1am.pokemonapi`.
- Usar Retrofit con `Response<T>` y funciones `suspend`.
- Usar `GsonConverterFactory.create()` para convertir JSON a data classes.
- Usar `mutableStateOf` para estados visibles por Compose.
- Usar `viewModelScope.launch` para iniciar corrutinas desde el ViewModel.
- Usar `Dispatchers.IO` para llamadas a internet.
- Usar `try/catch/finally` cuando haya riesgo de fallo de red.
- Usar `isLoading` y `error` en módulos didácticos nuevos.
- Usar `AsyncImage` de Coil cuando exista un campo de imagen.
- Si un campo del JSON puede venir `null`, declararlo con `?`.
- Si el JSON es grande, modelar solo los campos que se muestran.
- Mantener comentarios cortos y didácticos, estilo:

```kotlin
// Paso 1: Modelo de respuesta
// Paso 2: Interface de Retrofit
// Paso 3: Helper de Retrofit
```

- Evitar comentarios largos tipo manual dentro del código. Dejar explicaciones más largas en issues o documentos.
- No crear capas extra si no hacen falta.
- No renombrar módulos existentes salvo que sea estrictamente necesario.

Notas de nombres actuales:

- Dog API usa nombres históricos con algunos detalles no ideales: `Apilnterface.kt`, `DogVIew.kt`, `retrofithelper.kt`, clase `API`.
- Para módulos nuevos conviene usar nombres más claros como el módulo Pokémon: `PokemonApiInterface.kt`, `PokemonRetrofitHelper.kt`, `PokemonAPI.kt`.

## 4. Dependencias mínimas para un repo nuevo

Dependencias mínimas para recrear esta arquitectura:

```kotlin
implementation(libs.androidx.activity.compose)
implementation(platform(libs.androidx.compose.bom))
implementation(libs.androidx.compose.ui)
implementation(libs.androidx.compose.ui.graphics)
implementation(libs.androidx.compose.ui.tooling.preview)
implementation(libs.androidx.compose.material3)
implementation(libs.androidx.lifecycle.runtime.ktx)

implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
implementation("io.coil-kt.coil3:coil-compose:3.4.0")
implementation("io.coil-kt.coil3:coil-network-okhttp:3.4.0")
```

Si el repo nuevo no usa catálogo `libs.versions.toml`, usar coordenadas directas equivalentes para Compose, Activity Compose y Lifecycle.

Permiso requerido en `app/src/main/AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

## 5. Estructura estándar que debe crear Codex

Para cada API nueva, crear:

```text
app/src/main/java/[PACKAGE_BASE]/[folder]/
```

Dentro de esa carpeta:

```text
[Nombre]Response.kt
[Nombre]ApiInterface.kt
[Nombre]RetrofitHelper.kt
[Nombre]API.kt
[Nombre]ViewModel.kt
[Nombre]View.kt
```

Función de cada archivo:

| Archivo | Para qué sirve |
|---|---|
| `[Nombre]Response.kt` | Data classes con los campos necesarios del JSON. |
| `[Nombre]ApiInterface.kt` | Interface Retrofit con endpoint, método HTTP y parámetros. |
| `[Nombre]RetrofitHelper.kt` | Objeto que construye Retrofit con base URL y Gson. |
| `[Nombre]API.kt` | Capa intermedia que llama al endpoint y devuelve datos al ViewModel. |
| `[Nombre]ViewModel.kt` | Estado de pantalla, corrutinas, loading, error y llamada a `[Nombre]API`. |
| `[Nombre]View.kt` | Pantalla Compose con botón, textos, loading, error e imagen si aplica. |

## 6. Plantilla de GitHub Issue reutilizable

Copiar y pegar en GitHub Issues:

```markdown
## Task

Task number:

Nombre del módulo:

Package/folder:

Base URL:

Endpoint:

Método HTTP:

¿Usa Path?:

¿Usa Query?:

¿Usa Body?:

¿Debe ser random?:

Lógica random:

Campos a mostrar:

Campo de imagen:

Componentes UI:

Título de pantalla:

Texto del botón:

## Objetivo

Crear un módulo API completo siguiendo la arquitectura detectada:

[Nombre]View
-> [Nombre]ViewModel
-> [Nombre]API
-> [Nombre]ApiInterface
-> [Nombre]RetrofitHelper
-> API externa
-> [Nombre]Response/model
-> [Nombre]View

## Archivos esperados

- [Nombre]Response.kt
- [Nombre]ApiInterface.kt
- [Nombre]RetrofitHelper.kt
- [Nombre]API.kt
- [Nombre]ViewModel.kt
- [Nombre]View.kt

## Reglas

- No salirse de la arquitectura.
- No crear capas extra.
- No usar librerías nuevas si no hacen falta.
- No romper MainActivity.
- Conectar temporalmente la nueva pantalla para prueba.
- Si la API trae JSON grande, modelar solo campos necesarios.
- Si un campo puede venir null, usar `?`.
- Si hay imagen, usar AsyncImage.
- Si es random y la API no tiene endpoint random, generar random desde Kotlin.
- Manejar loading/error.
- Usar corrutinas.
- Usar comentarios cortos por pasos.

## Validación esperada

- Compilar el proyecto.
- Verificar que MainActivity carga la pantalla nueva.
- Presionar el botón y confirmar que consulta la API.
- Confirmar que se muestran los campos solicitados.
- Confirmar que se muestra imagen si aplica.
- Confirmar que no se rompieron módulos existentes.
```

## 7. Prompt operativo para Codex

Prompt corto para usar después de crear la issue:

```text
Haz la task #X. Lee la issue, analiza el repo nuevo, crea la estructura completa siguiendo la arquitectura definida, agrega dependencias si faltan, agrega permiso de internet si falta, implementa los archivos, conecta MainActivity y valida compilación.
```

## 8. Ejemplo lleno usando PokéAPI

```markdown
## Task

Task number:
#1

Nombre del módulo:
Pokemon

Package/folder:
pokemonapi

Base URL:
https://pokeapi.co/api/v2/

Endpoint:
pokemon/{id}

Método HTTP:
GET

¿Usa Path?:
Sí, id

¿Usa Query?:
No

¿Usa Body?:
No

¿Debe ser random?:
Sí

Lógica random:
Generar un ID aleatorio entre 1 y 151.

Campos a mostrar:
- name
- height
- weight
- sprites.front_default

Campo de imagen:
sprites.front_default

Componentes UI:
- Column
- Text
- Button
- AsyncImage
- Loading
- Error

Título de pantalla:
Pokémon del día

Texto del botón:
Mostrar Pokémon aleatorio
```

## 9. Checklist de validación

```markdown
- [ ] Compila
- [ ] Tiene permiso de internet
- [ ] Tiene dependencias necesarias
- [ ] Existe Response
- [ ] Existe ApiInterface
- [ ] Existe RetrofitHelper
- [ ] Existe API
- [ ] Existe ViewModel
- [ ] Existe View
- [ ] MainActivity carga la pantalla
- [ ] Botón consulta API
- [ ] Muestra campos solicitados
- [ ] Muestra imagen si aplica
- [ ] Random funciona si aplica
- [ ] No se rompieron módulos existentes
```

## 10. Resumen corto copiable

```text
Haz la task #X creando un módulo API Android/Kotlin con Compose, Retrofit, Gson, ViewModel, corrutinas y Coil. Sigue esta arquitectura: [Nombre]View -> [Nombre]ViewModel -> [Nombre]API -> [Nombre]ApiInterface -> [Nombre]RetrofitHelper -> API externa -> [Nombre]Response/model -> [Nombre]View. Crea los 6 archivos estándar en app/src/main/java/[PACKAGE_BASE]/[folder]/, modela solo los campos necesarios del JSON, usa AsyncImage si hay imagen, maneja loading/error, agrega permiso INTERNET y dependencias si faltan, conecta temporalmente MainActivity para probar y valida compilación.
```
