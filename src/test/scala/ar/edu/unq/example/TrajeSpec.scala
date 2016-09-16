package ar.edu.unq.example

/**
  * Created by user on 02/09/2016.
  */
class TrajeSpec extends BaseSpec{

  "creo un Traje Liviano y cuando le pido su capacidad Maxima " should "1500" in{

    val unTrajeLiviano = new TrajeLiviano
    unTrajeLiviano.capacidadMaxima shouldBe 1500
  }

  "creo un Traje Liviano y cuando le pido su oxigeno disponible " should "1500" in{

    val unTrajeLiviano = new TrajeLiviano
    unTrajeLiviano.oxigenoDisponible shouldBe 1500
  }

  "creo un Traje Pesado y cuando le pido su capacidad Maxima " should "4000" in{

    val unTrajeLiviano = new TrajePesado
    unTrajeLiviano.capacidadMaxima shouldBe 4000
  }

  "creo un Traje Liviano y cuando le pido la capacidad total luego de recorrer 100km " should "1490" in{

    val unTrajeLiviano = new TrajeLiviano
    unTrajeLiviano.oxigenoDisponible shouldBe 1500
    unTrajeLiviano.caminar(100, 0)
    unTrajeLiviano.oxigenoDisponible shouldBe 1490
  }

  "creo un Traje Liviano y cuando le pido la capacidad total luego de recorrer 60km " should "1490" in{

    val unTrajeLiviano = new TrajeLiviano
    unTrajeLiviano.oxigenoDisponible shouldBe 1500
    unTrajeLiviano.caminar(60, 0)
    unTrajeLiviano.oxigenoDisponible shouldBe 1491
  }

  "creo un Traje Pesadp y cuando le pido la capacidad total luego de recorrer 50km " should "4000" in{

    val unTrajePesado = new TrajePesado
    unTrajePesado.oxigenoDisponible shouldBe 4000
    unTrajePesado.caminar(50, 0)
    unTrajePesado.oxigenoDisponible shouldBe 4000
  }

  "creo un Traje Pesado y cuando le pido la capacidad total luego de recorrer 120km " should "3982" in{

    val unTrajePesado = new TrajePesado
    unTrajePesado.oxigenoDisponible shouldBe 4000
    unTrajePesado.caminar(120, 0)
    unTrajePesado.oxigenoDisponible shouldBe 3982
  }




}
