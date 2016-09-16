package ar.edu.unq.example

/**
  *
  */
trait SemiRigida extends Mochila {

  var constDeAbsorbcion : Int

  override def proteccionAlGolpeDe(golpe: Int): Int =  golpe - constDeAbsorbcion

}
