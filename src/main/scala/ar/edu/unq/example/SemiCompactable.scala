package ar.edu.unq.example

/**
  *
  */
trait SemiCompactable extends ObjetoRecolectable{

  val tipo:String = "Semi-Compactable"
  var _valorDeCompactacion : Int=0

  def setValorDecompacatacion(valor: Int) = _valorDeCompactacion = valor

  override def obtenerVolumen(): Int = super.obtenerVolumen()- _valorDeCompactacion

}
