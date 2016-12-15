package net.ladstatt.sierpinski

import android.graphics.Path.FillType
import android.graphics.{Canvas, Paint, Path}

case class Pos(x: Double, y: Double)

case class Triangle(a: Pos, b: Pos, c: Pos, d: Int, canvas: Canvas, paint: Paint) {
  if (d > 0) {
    Triangle(a, Pos((a.x + c.x) / 2.0, (a.y + c.y) / 2.0), Pos((a.x + b.x) / 2.0, (a.y + b.y) / 2.0), d - 1, canvas, paint)
    Triangle(Pos((a.x + b.x) / 2.0, (a.y + b.y) / 2.0), Pos((b.x + c.x) / 2.0, (b.y + c.y) / 2.0), b, d - 1, canvas, paint)
    Triangle(Pos((a.x + c.x) / 2.0, (a.y + c.y) / 2.0), Pos((b.x + c.x) / 2.0, (b.y + c.y) / 2.0), c, d - 1, canvas, paint)
  } else {
    val path = new Path
    path.setFillType(FillType.EVEN_ODD)
    path.moveTo(a.x.toFloat, a.y.toFloat)
    path.lineTo(b.x.toFloat, b.y.toFloat)
    path.lineTo(c.x.toFloat, c.y.toFloat)
    path.lineTo(a.x.toFloat, a.y.toFloat)
    path.close
    canvas.drawPath(path, paint)
  }
}

