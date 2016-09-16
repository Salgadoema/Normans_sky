package ar.edu.unq.example.objetosRecolectables

/**
  * C
  */
trait ObjetoCompactable extends ObjetoRecolectable{

  val tipo:String = "Compactable"

  override def volumenCompactado(): Int = super.obtenerVolumen()/2


}
