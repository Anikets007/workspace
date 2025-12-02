package com.sparkle;

import java.util.List;

public class PhysicsEngine {

    private final int width;
    private final int height;

    private boolean[][] occupied;

    public PhysicsEngine(int width, int height) {
        this.width = width;
        this.height = height;
        this.occupied = new boolean[width][height];
    }

    public void updateParticles(List<Spark> sparks, double wind) {
        occupied = new boolean[width][height];

        for (Spark s : sparks) {
            updateParticle(s, wind);
            occupied[(int)s.x][(int)s.y] = true;
        }
    }

    private void updateParticle(Spark s, double wind) {

        int x = (int)s.x;
        int y = (int)s.y;

        // apply wind in air
        if (s.dy > 0.1) {
            s.x += wind;
            s.x = Math.max(1, Math.min(width-2, s.x));
        }

        // fall if empty below
        if (y+1 < height && !occupied[x][y+1]) {
            s.dy += 0.3;
            s.y += s.dy;
            if (s.y >= height - 1) s.y = height - 1;
            return;
        }

        // down-left
        if (x > 0 && y+1 < height && !occupied[x-1][y+1]) {
            s.x -= 1; s.y += 1;
            return;
        }

        // down-right
        if (x < width-1 && y+1 < height && !occupied[x+1][y+1]) {
            s.x += 1; s.y += 1;
            return;
        }

        // left (wind assists)
        if (x > 0 && !occupied[x-1][y]) {
            s.x -= (wind < 0 ? 2 : 1);
            return;
        }

        // right (wind assists)
        if (x < width-1 && !occupied[x+1][y]) {
            s.x += (wind > 0 ? 2 : 1);
            return;
        }

        // particle settles
        s.dy = 0;
    }
}

