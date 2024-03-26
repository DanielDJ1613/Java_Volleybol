package com.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Floor {
    private ShapeRenderer shapeRenderer;
    private float lineWidth = 1;
    private float floorHeight = 0;

    public Floor(float lineWidth, float floorHeight) {
        this.lineWidth = lineWidth;
        this.floorHeight = floorHeight;
        shapeRenderer = new ShapeRenderer();
    }

    public void render() {
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(Color.WHITE); // Define a cor da linha como branca

        // Desenha a linha do chão
        shapeRenderer.line(0, floorHeight, 1000, floorHeight);

        shapeRenderer.end();
    }

    public void dispose() {
        shapeRenderer.dispose();
    }

    public float getHeight() {
        return floorHeight;
    }
}
