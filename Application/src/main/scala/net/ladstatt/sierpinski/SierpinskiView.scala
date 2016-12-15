package net.ladstatt.sierpinski

import android.content.Context
import android.graphics._
import android.util.AttributeSet
import android.view.View

class SierpinskiView(val context: Context, val attrs: AttributeSet) extends View(context, attrs) {

  override protected def onDraw(canvas: Canvas): Unit = {
    super.onDraw(canvas)

    val paint = new Paint
    val w = getWidth
    val h = getHeight

    val tw = w - 40
    val th = Math.sqrt(tw * tw - (tw / 2) * (tw / 2))
    val tt = h / 2 - th / 2
    val tb = tt + th

    val a = Pos(20, tb)
    val b = Pos(w - 20, tb)
    val c = Pos(tw / 2, tt)

    paint.setAntiAlias(true)
    paint.setColor(android.graphics.Color.BLACK)
    paint.setStyle(Paint.Style.STROKE)
    paint.setStrokeWidth(2)

    Triangle(a, b, c, 4, canvas, paint)
  }

}
