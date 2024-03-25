Feature: Ejemplo de uso de la utilería Karate

  Scenario: Modificar valor en CSV
   * def KarateUtils2 = Java.type('utils.KarateUtils2')
    #* def rutaArchivo = 'src/test/java/acceptance/test/recaudoTemplateCaracteresEspeciales.csv'

#    * def campoModificar = 'Fecha de vencimiento'
#    * def nuevoValor = '2024-04-20'
    #* call KarateUtils.modificarArchivo'('Fecha de Vencimiento', '2024-04-20')'
     * call KarateUtils2.modificarArchivo()