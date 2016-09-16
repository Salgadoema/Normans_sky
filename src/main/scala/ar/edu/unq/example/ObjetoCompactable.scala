package ar.edu.unq.example

/**
  * C
  */
trait ObjetoCompactable extends ObjetoRecolectable{

  val tipo:String = "Compactable"

  override def volumenCompactado(): Int = super.obtenerVolumen()/2


}
