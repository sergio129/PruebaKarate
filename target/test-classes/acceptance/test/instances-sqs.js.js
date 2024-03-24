// La clase SQSUtil se encuentra en un gestor de librerías externo al proyecto
// Imaginemos que esta clase contiene la configuración y conexión de un cliente a AWS, además los métodos para enviar eventos de SQS utilizando el SDK AWS
function SQSManager() {
    var SQSManager = Java.type('co.cobre.lib.qa.aws.SQSUtil');
    var SQSManagerInstance = new SQSManager();
    return SQSManagerInstance;
}