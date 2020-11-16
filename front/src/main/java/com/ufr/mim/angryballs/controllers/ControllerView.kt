package com.ufr.mim.angryballs.controllers

import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.application.Platform
import javafx.event.EventHandler
import javafx.geometry.Bounds
import javafx.scene.layout.AnchorPane
import javafx.scene.shape.Circle
import javafx.util.Duration
import tornadofx.*

class ControllerView : View("AngryBalls developed by Pierre WENZEL and Sebastien PHILIPP") {
    override val root: AnchorPane by fxml("/MyView.fxml")
    private val background : AnchorPane by fxid()
    private val circle : Circle = Circle(200.0, 100.0, 20.0, )
    private var dx : Double = 4.0
    private var dy : Double = 3.0
    private lateinit var timeline : Timeline
    private var timelineOnPause : Boolean = true

    init {
        /*val ball = SimpleBall(100.0, Color.BLUE)
        val pilotBall = Pilot(ball)*/

        this.background.children.addAll(circle)
        circle.onMouseDragged = EventHandler {
            circle.centerX = it.x
            circle.centerY = it.y
        }
    }

    fun lancerBoules() {
        if (timelineOnPause) {
            timelineOnPause = false
            timeline = Timeline(KeyFrame(Duration.millis(20.0), {
                circle.centerX = circle.centerX + dx
                circle.centerY = circle.centerY + dy
                val bounds: Bounds = background.boundsInLocal

                //If the ball reaches the left or right border make the step negative
                if (circle.centerX <= bounds.minX + circle.radius ||
                        circle.centerX >= bounds.maxX - circle.radius) {
                    dx = -dx
                }

                //If the ball reaches the bottom or top border make the step negative
                if (circle.centerY >= bounds.maxY - circle.radius ||
                        circle.centerY <= bounds.minY + circle.radius) {
                    dy = -dy
                }
            })).apply {
                cycleCount = Timeline.INDEFINITE
                play()
            }
        }
    }

    fun arreterBoules() {
        timeline.pause()
        timelineOnPause = true
    }

    fun quitter() {
        Platform.exit()
    }
}
