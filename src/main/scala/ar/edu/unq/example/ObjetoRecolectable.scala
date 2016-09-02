package ar.edu.unq.example

/**
  * Created by user on 30/08/2016.
  */
class ObjetoRecolectable(capacidadObjeto: Int, nombre: String  ) {


  def volumenCompactado(): Int = volumen
  def volumenDeshidratado(): Int =volumen

  def compactarObjeto(unObjeto: ObjetoRecolectable): Unit = {
    unObjeto.volumen= unObjeto.volumenCompactado()

  }
  def deshidratarObjeto(unObjeto: ObjetoRecolectable) : Unit = {
    unObjeto.volumen= unObjeto.volumenDeshidratado()

  }

  var volumen=capacidadObjeto
  val miNombre=nombre
  var porcentajeDeAgua=0
  def obtenerVolumen(): Int = volumen
  var energia = 1000//por default todos los objetos tienen 1000 de energia

def recibeDanio(valor: Int):Unit ={
  energia=energia-valor
}



}
