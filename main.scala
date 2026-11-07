@main def probarSala(): Unit =
  val sala = new Sala(1, 5, 10)
  println(sala.reservar(0, 3))  
  println(sala.reservar(0, 3))   