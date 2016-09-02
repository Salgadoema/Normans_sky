package ar.edu.unq.example

/**
  * Created by user on 02/09/2016.
  */
abstract class Traje {

  def calcularConsumoAlRecorrerKms(kilometros: Double)
  var capacidadMaxima: Double
  var capacidadFinal: Double
  var consumoPorKm: Double

}
