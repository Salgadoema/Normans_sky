package ar.edu.unq.example

/**
  *
  */
class ObjetoRecolectable(capacidadObjeto: Int, nombre: String, masa: Int) {

  val miNombre=nombre
  var volumen=capacidadObjeto
  var _peso=0
  var porcentajeDeAgua=0
  var energia = 1000//por default todos los objetos tienen 1000 de energia


  def volumenCompactado(): Int = volumen

  def volumenDeshidratado(): Int =volumen

  def obtenerVolumen(): Int = volumen

  def compactarObjeto(unObjeto: ObjetoRecolectable): Unit = unObjeto.volumen= unObjeto.volumenCompactado()

  def deshidratarObjeto(unObjeto: ObjetoRecolectable) : Unit = unObjeto.volumen= unObjeto.volumenDeshidratado()

  def recibeDanio(valor: Int):Unit =  energia = energia-valor

  def peso(gravedad : Int) : Int = {
    _peso= masa * gravedad
    return _peso
  }

}
