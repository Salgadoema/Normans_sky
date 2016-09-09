package ar.edu.unq.example

/**
  * Created by user on 30/08/2016.
  */
trait ObjetoCompactable extends ObjetoRecolectable{
  val tipo:String = "Compactable"

  override def volumenCompactado(): Int = super.obtenerVolumen()/2


}
