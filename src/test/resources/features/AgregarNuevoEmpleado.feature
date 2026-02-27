@Regression
  Feature: Registro nuevo empleado de manera exitosa

    @RegistroExitoso
    Scenario Outline: Registro exitoso
      Given el usuario se autentica en la aplicacion
      |url|usuario|contrasena|
      |<url>|<usuario>|<contrasena>|
      When agrega un nuevo empleado con datos basicos
      |firstName|middleName|lastName|
      |<firstName>|<middleName>|<lastName>|
      Then valida que se inserte de manera exitosa
      Examples:
      |url|usuario|contrasena|firstName|middleName|lastName|
      |https://opensource-demo.orangehrmlive.com/web/index.php/auth/login|Admin|admin123|kevin|nicolas|vasquez|
