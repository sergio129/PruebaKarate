function fn() {

  karate.log("Cargando configuraciones");
  var env = karate.env

  if (!env){
  env = 'uat'
  }

  var config = {
  pathAcceptanceTest:'classpath:acceptance/test/',
  pathRequest:'json/request',
  pathResponse:'json/response',
  pathEvent:'json/event'

  }
  if (env == 'uat'){
  config.baseUrl = 'https://test-container-qa.prueba.co/v1/entity/novelties/',
  config.pathNovelty = '/novelty-details'
  }else

  return config;
}