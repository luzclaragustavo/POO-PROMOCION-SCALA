@main def principal(): Unit =
  println("== 1. Encapsulamiento ==")
  val sala = Sala(1, 5, 10)
  println(s"Reservar 0-3: ${sala.reservar(0, 3)}")
  println(s"Reservar 0-3 otra vez: ${sala.reservar(0, 3)}")

  println("\n== 2. Herencia y clases abstractas ==")
  val entradas = List(
    Entrada2D("Dune", "A1", 5000),
    Entrada3D("Avatar", "B4", 5000),
    EntradaVIP("Oppenheimer", "C2", 5000, conCena = true),
    Entrada.crear("2D", "Coco", "D7", 4000)
  )
  for e <- entradas do println(e.descripcion)

  println("\n== 3. Polimorfismo y Strategy ==")
  val boleteria = Boleteria(SinPromocion())
  println(s"Total sin promocion: $$${boleteria.totalVendido(entradas)}")
  boleteria.cambiarPromocion(MartesMitadDePrecio())
  println(s"Total un martes: $$${boleteria.totalVendido(entradas)}")
  boleteria.cambiarPromocion(DescuentoEstudiante(20))
  println(s"Total con descuento estudiante: $$${boleteria.totalVendido(entradas)}")

  println("\n== 4. Traits ==")
  val vip = EntradaVIP("Barbie", "E1", 6000, conCena = false)
  val combo = Combo("Pochoclos grandes + gaseosa", 7000)
  println(s"Devuelto: $$${boleteria.reembolsarTodo(List(vip, combo))}")
  println(s"Reembolsar el combo otra vez: ${combo.reembolsar()}")

  println("\n== 5. Herencia multiple y linealizacion ==")
  println(s"Estreno: ${FuncionEstreno().anuncios}")
  println(s"Matine: ${FuncionMatine().anuncios}")

  println("\n== 6. Singleton ==")
  println(s"Ventas registradas: ${RegistroVentas.total}")

  println("\n== 7. Concurrencia ==")
  Concurrencia.ejecutar()
