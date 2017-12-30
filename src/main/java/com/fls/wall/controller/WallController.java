package com.fls.wall.controller;

import com.fls.wall.Wall;

/**
 * Created by Marcin on 2017-12-12.
 */
public abstract class WallController {
    private Wall model;
    abstract void initialize();
    abstract void updateModel();
}
