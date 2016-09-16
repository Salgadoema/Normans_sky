package ar.edu.unq.example


trait Potenciador extends Personaje{

  var valorAgregado :Int = 0

  def setValorAgregadoDePotenciador(valor :Int) :Unit = {
    valorAgregado = valor
  }

  def potenciar(valor : Int) : Int = {
    valor + valorAgregado
  }

  override def getPoderDeAtaque: Int = {
    potenciar(super.getPoderDeAtaque)
  }
}
