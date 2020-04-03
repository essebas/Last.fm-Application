# Aplicación Android  - Consumiendo [API Last.fm](https://www.last.fm/api/) 

***v.0.1-pre-alpha***

![enter image description here](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/ArwuitecuraV1.png)

La siguiente aplicación consta de una **arquitectura MVVM** y principios arquitectónicos **orientados a componentes**.
Actualmente la versión cuenta con varias inestabilidades ya que no se tuvo presente el manejo de errores en respuesta de los datos consumidos, estos serán explicados mas adelante.

## Tecnologías Utilizadas
- RxJava - RxAndroid (v2.219 - v2.1.1)
- Dagger (v2.26)
- Picasso (v2.71828)
- Lifecycle - View Model y Live Data (v2.0.0)
- Retrofit (v2.8.0)
- OkHttp (v4.4.0)

#### Otras Librerías
- [Country Picker](https://github.com/mukeshsolanki/country-picker-android)
- RecyclerView
- CardView
- Material Design


**Por motivos de seguridad la API KEY no fue expuesta en los codigos, esto se manejo por medio del archivo Grandle Properties para evitar su divulgacion. Para hacer que la aplicacion funcione se debe parametrizar el API key en el archivo antes mencionado**

## Recorrido por la Aplicacion

### Home - Inicio (Fragment Top Artistas)
Al ejecutar la aplicación se cargara por defecto los datos de Colombia, mostrando un top 50 de artistas. Por el momento y cuestiones practicas los datos por defecto son tomados de Strings.xml, sin embargo se puede usar el servicio de geolocalización para que dependiendo de donde se este ejecutando la aplicación se pase el dato del respectivo país.

![Inicio de la aplicacion](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/home.PNG)

#### Collapsing Toolbar Layout on Scroll Down
El objetivo es que se le informe al usuario que datos son los que se le están mostrando, respecto al país e items mostrados. Se incorporo este diseño según la librería y las guías de diseño de material design, obteniendo como resultado un titulo que interactúa con el RecyclerView.

![Inicio de la aplicacion - scroll down](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/home-scroll.PNG)

#### Final del RecyclerView
Como se evidencia, se muestran 50 items, que corresponden a la configuración inicial.

- País : Colombia
- Top : 50

![enter image description here](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/home-bottom.PNG)


#### CardView Actions
Cada CardView es construido por un adaptador que luego es pasado al RecyclerView, esto permite que cada ítem tenga sus respectivos datos. En este caso se agrego un intent implícito para que se pudiera evidenciar la información respectiva, para este caso la web donde se puede encontrar mas información del artista. 

![item press bottom](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/home-pressbottom-information.png)

![inten implicit - information in web browser](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/home-clickbottom-information.PNG)

### Settings Dialog
Se incorporo un filtro de búsqueda para que se permitiera al usuario variar parámetros por un país o numero de top diferente. **La búsqueda es global, afectara tanto a TOP ARTISTAS como a TOP CANCIONES** pero solamente actualiza los datos del fragment que en ese momento se encuentra activo. Cuando el usuario cambie de fragment, se lanza un evento que primero verifica si los parámetros de búsqueda han cambiado, esto para evitar consumo de red innecesarios y búsquedas redundantes. 
El dialogo mostrara siempre los parámetros actuales de búsqueda, como no se han cambiado con anterioridad, este toma los parámetros por defecto al lanzar la aplicación.

![Settings Dialog](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/settingsdialog.PNG)


#### Country Picker
En el input para seleccionar un país, se lanza un bottom frame que contiene todos los países con sus respectivas banderas. Esta funcionalidad es tomada de una librería llamada [Country Picker](https://github.com/mukeshsolanki/country-picker-android).

![Country Picker List](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/settingsdialog-listcountry.PNG)

![Country Picker Search](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/settingsdialog-searchcountry.PNG)


#### Top Input - Errors
Se permite al usuario filtrar su búsqueda por numero de elementos que quiere visualizar del top, permitiendo únicamente valores numéricos positivos y con un limite de hasta 150. 

![Input error 1](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/settingsdialog-items-error1.PNG)

![Input error 2](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/settingsdialog-items-error2.PNG)

#### Top Input - Correct Search
Se mostraran un ejemplo de modificación que el usuario puede realizar para que se pueda ver el resultado en el fragment respectivo.

![Settings Dialog Done](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/settingsdialog-done.PNG)


### Home After Confirm Search Settings (Fragment Top Artistas)
Teniendo en cuenta la imagen anterior, los datos serán actualizados en el fragment conforme a lo parametrizado por el usuario. Como se evidencia, el titulo del  Collapsing Toolbar Layout ha sido actualizado al usuario para mejorar su UX. y el RecyclerView recibe la nueva lista de datos para que sea mostrada.

![enter image description here](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/home-aftersearch.PNG)

#### Final del RecyclerView
Como se evidencia, se muestran 8 items, que corresponden a la nueva configuración que realizo el usuario.

- País : Mexico
- Top : 8

![enter image description here](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/home-aftersearch-bottom.PNG)


### Home After Confirm Search Settings (Fragment Top Canciones)
Como se menciono en **Setting Dialog**, el fragmento se actualizara con los respectivos parametros de configuración solo hasta que este sea llamado, para este caso se atiene la configuración de arriba.
Como se puede ver, el CardView empleado en el fragment de Top Canciones es diferentes, esto para aprovechar las los datos que son consumidos.

![enter image description here](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/track-searchsettigs-saved.PNG)

![enter image description here](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/track-searchsettigs-saved-scroll.PNG)

#### Settings Dialog Open
Cuando abrimos el settings dialog en este fragmento vemos que se muestra siempre la configuración actual.

![enter image description here](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/track-searchsettigs.PNG)

#### CardView Actions
Cada CardView es construido por un adaptador que luego es pasado al RecyclerView, esto permite que cada ítem tenga sus respectivos datos. En este caso se agrego un intent implícito para que se pudiera evidenciar la información respectiva, para este caso la web donde se puede encontrar mas información de la canción. 

![enter image description here](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/track-pressbottom-information.png)

![enter image description here](https://github.com/essebas/Last.fm-Application/blob/master/readme-snaps/track-clickbottom-information.PNG)

