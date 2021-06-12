# DataCrmAppKotlin
Prueba Tecnica Data Crm en Kotlin

Realizado bajo Clean Architecture y Patron MVVM

Kotlin

Ktx

ViewBinding 

MaterialComponent (CardView,RecyclerView)

Corrutinas

Clean Architecture

Retrofit

LiveData

Dagger 2

# Clean Architecture
Capas
- UI : Se encuentra toda la logica correspondiente a las vistas ,en este caso las actividades con sus respectivos ViewModels

- Framework:  En esta capa se encontrara todo lo correspondiente al framework de Android,en este caso la libreria de Retrofit y la inyeccion de Dependencias con Dagger 2 sus Modulos y Componente 

- Data :Correspondiente a los datos de la aplicacion,repositorios y source(Intefaces),en este caso los repositorios de Login y Contacts con sus respectivos DataSource

- domain:Principalmente encontraremos el modelado de los objetos que se utilizaran en la aplicacion como por ejemplo Contact ,LoginUser ....

# Dagger 2 
La inyeccion de los repositorios y todas sus dependencias y despues estos eran pasados como parametro al ViewModel

#Comunicacion
Se utilizo la implementacion de una Sealed Class  "DataResult" y "LoginResult "que nos ayudo en el estado de los datos de consulta del login y contactos



