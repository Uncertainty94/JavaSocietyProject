package ru.vsu.cs.java.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by max on 12.12.2014.
 */
public class StartRenderer {

    private float widthRatio;
    private float heightRatio;

    private BitmapFont font;

    public StartRenderer() {
        widthRatio  = Gdx.graphics.getWidth();
        heightRatio = Gdx.graphics.getHeight();

        font = new BitmapFont() {{
            setColor(Color.NAVY);
        }};

    }

    public void render(SpriteBatch batch) {
        batch.draw(new Texture(Gdx.files.internal("gfx/backgroundStart.png")),0,0);
        font.draw(batch, "Start Screen", 50, heightRatio-50);
    }

}
